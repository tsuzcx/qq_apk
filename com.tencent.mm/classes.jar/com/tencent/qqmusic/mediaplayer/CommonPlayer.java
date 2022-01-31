package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;

public class CommonPlayer
  extends BaseMediaPlayer
{
  private static final int INIT_STATE_CHECK_TIME = 5000;
  private static final String TAG = "CommonPlayer";
  private PlayerCallback callback;
  private int currentState;
  private Looper eventLooper;
  private CorePlayer mAudioPlayer;
  private int mBufferPercentage;
  private final ListPlayerListenerCallback mCallback;
  private long mDuration;
  private final boolean mPreferMediaCodecDecode;
  private CommonPlayer.OpenedResources openedResources;
  
  public CommonPlayer()
  {
    this(null, null, false);
  }
  
  public CommonPlayer(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this(paramPlayerListenerCallback, null, false);
  }
  
  public CommonPlayer(PlayerListenerCallback paramPlayerListenerCallback, Looper paramLooper, boolean paramBoolean)
  {
    AppMethodBeat.i(104596);
    this.mCallback = new ListPlayerListenerCallback();
    this.mAudioPlayer = null;
    this.currentState = 0;
    this.callback = new CommonPlayer.1(this);
    if (paramPlayerListenerCallback != null) {
      this.mCallback.add(paramPlayerListenerCallback);
    }
    this.eventLooper = paramLooper;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    this.mPreferMediaCodecDecode = bool1;
    reset();
    AppMethodBeat.o(104596);
  }
  
  private String auxiliary(String paramString)
  {
    AppMethodBeat.i(104634);
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (this.mPreferMediaCodecDecode) {}
    for (String str = "[MediaCodec]"; localCorePlayer == null; str = "")
    {
      AppMethodBeat.o(104634);
      return "null";
    }
    paramString = "[" + localCorePlayer + "]" + str + paramString;
    AppMethodBeat.o(104634);
    return paramString;
  }
  
  private Looper insureEventLooper()
  {
    AppMethodBeat.i(104630);
    if (this.eventLooper == null)
    {
      localObject = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
      ((HandlerThread)localObject).start();
      this.eventLooper = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = this.eventLooper;
    AppMethodBeat.o(104630);
    return localObject;
  }
  
  private void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104631);
    onError(paramInt1, paramInt2, 0);
    AppMethodBeat.o(104631);
  }
  
  private void onError(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104632);
    TransferStateTo(9);
    Logger.e("CommonPlayer", "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
    this.mCallback.onError(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(104632);
  }
  
  private void resetInternal()
  {
    AppMethodBeat.i(104633);
    if (this.openedResources != null) {
      this.openedResources.release();
    }
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.release();
      this.mAudioPlayer = null;
    }
    if ((this.eventLooper != null) && (this.eventLooper != Looper.getMainLooper()))
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label91;
      }
      this.eventLooper.quitSafely();
    }
    for (;;)
    {
      this.eventLooper = null;
      this.mDuration = 0L;
      this.mBufferPercentage = 0;
      AppMethodBeat.o(104633);
      return;
      label91:
      this.eventLooper.quit();
    }
  }
  
  private void setDataSourceInternal(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(104635);
    TransferStateTo(1);
    if (this.mPreferMediaCodecDecode) {}
    for (Object localObject = new MediaCodecDecoder();; localObject = new NativeDecoder())
    {
      this.mAudioPlayer = new CorePlayer(new TracerDataSource(paramIDataSource), null, this.callback, insureEventLooper(), (BaseDecoder)localObject);
      this.mAudioPlayer.setThreadName(paramIDataSource.toString());
      AppMethodBeat.o(104635);
      return;
    }
  }
  
  protected void TransferStateTo(int paramInt)
  {
    AppMethodBeat.i(104629);
    Logger.i("StateRunner", this.currentState + " -> " + paramInt);
    this.currentState = paramInt;
    if (this.mCallback != null) {
      this.mCallback.onStateChanged(this, paramInt);
    }
    AppMethodBeat.o(104629);
  }
  
  public void addAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(104626);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.addAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(104626);
  }
  
  public void addPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    AppMethodBeat.i(104611);
    this.mCallback.add(paramPlayerListenerCallback);
    AppMethodBeat.o(104611);
  }
  
  public SeekTable createSeekTable()
  {
    AppMethodBeat.i(104628);
    Object localObject = this.mAudioPlayer;
    if (localObject == null)
    {
      localObject = new IllegalStateException("not initialized!");
      AppMethodBeat.o(104628);
      throw ((Throwable)localObject);
    }
    localObject = ((CorePlayer)localObject).createSeekTable();
    AppMethodBeat.o(104628);
    return localObject;
  }
  
  public void flush()
  {
    AppMethodBeat.i(104613);
    if (this.mAudioPlayer == null)
    {
      Logger.e("CommonPlayer", "[getCurrentFrame] mAudioPlayer is null!");
      AppMethodBeat.o(104613);
      return;
    }
    this.mAudioPlayer.flush();
    AppMethodBeat.o(104613);
  }
  
  public int getBufferedPercentage()
  {
    return this.mBufferPercentage;
  }
  
  public AudioInformation getCurrentAudioInformation()
  {
    AppMethodBeat.i(104622);
    if (this.mAudioPlayer != null)
    {
      AudioInformation localAudioInformation = this.mAudioPlayer.getCurrentAudioInformation();
      AppMethodBeat.o(104622);
      return localAudioInformation;
    }
    AppMethodBeat.o(104622);
    return null;
  }
  
  public long getCurrentPosition()
  {
    AppMethodBeat.i(104612);
    if (this.mAudioPlayer != null)
    {
      long l = this.mAudioPlayer.getCurPosition();
      AppMethodBeat.o(104612);
      return l;
    }
    Logger.e("CommonPlayer", "getCurrentPosition() mAudioPlayer is null!");
    AppMethodBeat.o(104612);
    return 0L;
  }
  
  public long getCurrentPositionFromFile()
  {
    return 0L;
  }
  
  public long getDecodePosition()
  {
    AppMethodBeat.i(104614);
    if (this.mAudioPlayer != null)
    {
      long l = this.mAudioPlayer.getCurPositionByDecoder();
      AppMethodBeat.o(104614);
      return l;
    }
    Logger.e("CommonPlayer", "getDecodePosition() ERROR : mAudioPlayer is null!");
    AppMethodBeat.o(104614);
    return 0L;
  }
  
  public int getDuration()
  {
    long l = 0L;
    AppMethodBeat.i(104597);
    if (this.mAudioPlayer != null)
    {
      this.mDuration = this.mAudioPlayer.getDuration();
      i = (int)this.mDuration;
      AppMethodBeat.o(104597);
      return i;
    }
    Logger.e("CommonPlayer", "getDuration() mAudioPlayer is null!");
    if (this.mDuration > 0L) {
      l = this.mDuration;
    }
    int i = (int)l;
    AppMethodBeat.o(104597);
    return i;
  }
  
  int getPlayerMode()
  {
    AppMethodBeat.i(104625);
    if (this.mAudioPlayer != null)
    {
      int i = this.mAudioPlayer.getPlayerMode();
      AppMethodBeat.o(104625);
      return i;
    }
    AppMethodBeat.o(104625);
    return 0;
  }
  
  public int getPlayerState()
  {
    return this.currentState;
  }
  
  public int getSessionId()
  {
    AppMethodBeat.i(104623);
    if (this.mAudioPlayer != null)
    {
      int i = this.mAudioPlayer.getSessionId();
      AppMethodBeat.o(104623);
      return i;
    }
    AppMethodBeat.o(104623);
    return 0;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(104598);
    if (this.mAudioPlayer != null)
    {
      if (this.mAudioPlayer.getPlayerState() == 4)
      {
        AppMethodBeat.o(104598);
        return true;
      }
      AppMethodBeat.o(104598);
      return false;
    }
    Logger.e("CommonPlayer", "isPlaying() mAudioPlayer is null!");
    AppMethodBeat.o(104598);
    return false;
  }
  
  public boolean isSoftDecoder()
  {
    return true;
  }
  
  public void pause()
  {
    AppMethodBeat.i(104599);
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pause]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.pause();
    }
    for (;;)
    {
      notifyPauseSong();
      AppMethodBeat.o(104599);
      return;
      Logger.e("CommonPlayer", "pause() mAudioPlayer is null!");
    }
  }
  
  public void prepare()
  {
    AppMethodBeat.i(104600);
    TransferStateTo(3);
    Logger.i("CommonPlayer", auxiliary("[prepare]"));
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.prepare();
      AppMethodBeat.o(104600);
      return;
    }
    Logger.e("CommonPlayer", "prepare() null mAudioPlayer!");
    AppMethodBeat.o(104600);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(104601);
    UnSupportMethodException localUnSupportMethodException = new UnSupportMethodException("Soft decode player cannot support prepareAsync");
    AppMethodBeat.o(104601);
    throw localUnSupportMethodException;
  }
  
  public void release()
  {
    AppMethodBeat.i(104602);
    TransferStateTo(8);
    Logger.i("CommonPlayer", auxiliary("[release]"));
    resetInternal();
    this.mCallback.clear();
    AppMethodBeat.o(104602);
  }
  
  public void removeAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(104627);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.removeAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(104627);
  }
  
  public void reset()
  {
    AppMethodBeat.i(104603);
    TransferStateTo(0);
    Logger.i("CommonPlayer", auxiliary("[reset]"));
    resetInternal();
    AppMethodBeat.o(104603);
  }
  
  public void seekTo(int paramInt)
  {
    AppMethodBeat.i(104604);
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.seek(paramInt);
      AppMethodBeat.o(104604);
      return;
    }
    Logger.e("CommonPlayer", "seekTo() mAudioPlayer is null!");
    AppMethodBeat.o(104604);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(104620);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setAudioStreamType(paramInt);
    }
    AppMethodBeat.o(104620);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(104615);
    paramContext = paramUri.getScheme();
    if (TextUtils.isEmpty(paramContext))
    {
      setDataSource(paramUri.toString());
      AppMethodBeat.o(104615);
      return;
    }
    if ((paramContext.equalsIgnoreCase("http")) || (paramContext.equalsIgnoreCase("https")))
    {
      setDataSource(new DefaultMediaHTTPService(), paramUri);
      AppMethodBeat.o(104615);
      return;
    }
    if (!paramContext.equalsIgnoreCase("content")) {
      paramContext.equalsIgnoreCase("file");
    }
    AppMethodBeat.o(104615);
  }
  
  public void setDataSource(Context paramContext, UriLoader paramUriLoader)
  {
    AppMethodBeat.i(104619);
    setDataSource(new CommonPlayer.2(this, paramUriLoader));
    AppMethodBeat.o(104619);
  }
  
  public void setDataSource(TrackInfo paramTrackInfo)
  {
    AppMethodBeat.i(104618);
    TransferStateTo(1);
    Logger.i("CommonPlayer", "setDataSource, trackInfo.getUri: " + paramTrackInfo.getUri());
    Logger.i("CommonPlayer", "setDataSource, trackInfo.range: " + paramTrackInfo.getRange().toString());
    this.mBufferPercentage = 100;
    paramTrackInfo = new TrackDataSource(paramTrackInfo);
    List localList = this.mCallback.toCollection();
    this.mCallback.clear();
    this.mCallback.add(paramTrackInfo);
    this.mCallback.addAll(localList);
    TransferStateTo(1);
    this.mAudioPlayer = new TrackCorePlayer(new TracerDataSource(paramTrackInfo), this.callback, insureEventLooper());
    paramTrackInfo.setTrackStateCallback((TrackCorePlayer)this.mAudioPlayer);
    this.mAudioPlayer.setThreadName(paramTrackInfo.toString());
    AppMethodBeat.o(104618);
  }
  
  public void setDataSource(IMediaHTTPService paramIMediaHTTPService, Uri paramUri)
  {
    AppMethodBeat.i(104616);
    File localFile;
    try
    {
      localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      localFile.delete();
      if (!localFile.createNewFile())
      {
        onError(90, 103, 0);
        AppMethodBeat.o(104616);
        return;
      }
    }
    catch (IOException paramIMediaHTTPService)
    {
      onError(90, 103, 0);
      AppMethodBeat.o(104616);
      return;
    }
    String str = localFile.getAbsolutePath();
    paramIMediaHTTPService = new CacheDataSource(new HttpDataSource(paramUri, null, paramIMediaHTTPService), new FileDataSource(str), new FileDataSink(str), insureEventLooper());
    this.openedResources = new CommonPlayer.OpenedResources(null);
    CommonPlayer.OpenedResources.access$402(this.openedResources, localFile);
    CommonPlayer.OpenedResources.access$502(this.openedResources, paramIMediaHTTPService);
    paramIMediaHTTPService.setListener(new CommonPlayer.BufferListener(this, null));
    setDataSourceInternal(paramIMediaHTTPService);
    AppMethodBeat.o(104616);
  }
  
  public void setDataSource(IDataSourceFactory paramIDataSourceFactory)
  {
    AppMethodBeat.i(104617);
    if (paramIDataSourceFactory == null)
    {
      paramIDataSourceFactory = new IllegalArgumentException("dataSourceFactory is null!");
      AppMethodBeat.o(104617);
      throw paramIDataSourceFactory;
    }
    TransferStateTo(1);
    if (this.mPreferMediaCodecDecode) {
      this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, this.callback, insureEventLooper(), new MediaCodecDecoder());
    }
    for (;;)
    {
      this.mAudioPlayer.setThreadName(paramIDataSourceFactory.toString());
      AppMethodBeat.o(104617);
      return;
      INativeDataSource localINativeDataSource = paramIDataSourceFactory.createNativeDataSource();
      if (localINativeDataSource != null) {
        this.mAudioPlayer = new CorePlayer(null, localINativeDataSource, this.callback, insureEventLooper(), new NativeDecoder());
      } else {
        this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, this.callback, insureEventLooper(), new NativeDecoder());
      }
    }
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(104606);
    paramFileDescriptor = new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
    AppMethodBeat.o(104606);
    throw paramFileDescriptor;
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(104605);
    if (paramString == null)
    {
      Logger.e("CommonPlayer", "setDataSource() ERROR:the path is null!");
      paramString = new IllegalArgumentException("the path is null!");
      AppMethodBeat.o(104605);
      throw paramString;
    }
    TransferStateTo(1);
    Logger.i("CommonPlayer", "setDataSource, path: ".concat(String.valueOf(paramString)));
    this.mBufferPercentage = 100;
    setDataSourceInternal(new FileDataSource(paramString));
    AppMethodBeat.o(104605);
  }
  
  public void setPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    AppMethodBeat.i(104610);
    this.mCallback.clear();
    this.mCallback.add(paramPlayerListenerCallback);
    AppMethodBeat.o(104610);
  }
  
  void setPlayerMode(int paramInt)
  {
    AppMethodBeat.i(104624);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setPlayerMode(paramInt);
    }
    AppMethodBeat.o(104624);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(104607);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setVolume(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(104607);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(104621);
    paramContext = new UnSupportMethodException("Soft decode player cannot support setWakeMode");
    AppMethodBeat.o(104621);
    throw paramContext;
  }
  
  public void start()
  {
    AppMethodBeat.i(104608);
    TransferStateTo(4);
    Logger.i("CommonPlayer", auxiliary("[start]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.play();
    }
    for (;;)
    {
      notifyStartPlaySong();
      AppMethodBeat.o(104608);
      return;
      Logger.e("CommonPlayer", "start() mAudioPlayer is null!");
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(104609);
    try
    {
      TransferStateTo(6);
      Logger.i("CommonPlayer", auxiliary("[stop]"));
      if (this.mAudioPlayer != null)
      {
        this.mAudioPlayer.stop();
        AppMethodBeat.o(104609);
        return;
      }
      Logger.e("CommonPlayer", "stop() mAudioPlayer is null!");
      AppMethodBeat.o(104609);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("CommonPlayer", localException);
      AppMethodBeat.o(104609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer
 * JD-Core Version:    0.7.0.1
 */