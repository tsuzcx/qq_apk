package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
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
  private PlayerCallback callback = new CommonPlayer.1(this);
  private final StateRunner<Integer> currentState = new StateRunner(Integer.valueOf(0));
  private Looper eventLooper;
  private CorePlayer mAudioPlayer = null;
  private int mBufferPercentage;
  private final ListPlayerListenerCallback mCallback = new ListPlayerListenerCallback();
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
  }
  
  private String auxiliary(String paramString)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (this.mPreferMediaCodecDecode) {}
    for (String str = "[MediaCodec]"; localCorePlayer == null; str = "") {
      return "null";
    }
    return "[" + localCorePlayer + "]" + str + paramString;
  }
  
  private Looper insureEventLooper()
  {
    if (this.eventLooper == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
      localHandlerThread.start();
      this.eventLooper = localHandlerThread.getLooper();
    }
    return this.eventLooper;
  }
  
  private void onError(int paramInt1, int paramInt2)
  {
    onError(paramInt1, paramInt2, 0);
  }
  
  private void onError(int paramInt1, int paramInt2, int paramInt3)
  {
    TransferStateTo(9);
    Logger.e("CommonPlayer", "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
    this.mCallback.onError(this, paramInt1, paramInt2, paramInt3);
  }
  
  private void resetInternal()
  {
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
        break label81;
      }
      this.eventLooper.quitSafely();
    }
    for (;;)
    {
      this.eventLooper = null;
      this.mDuration = 0L;
      this.mBufferPercentage = 0;
      return;
      label81:
      this.eventLooper.quit();
    }
  }
  
  private void setDataSourceInternal(IDataSource paramIDataSource)
  {
    TransferStateTo(1);
    if (this.mPreferMediaCodecDecode) {}
    for (Object localObject = new MediaCodecDecoder();; localObject = new NativeDecoder())
    {
      this.mAudioPlayer = new CorePlayer(new TracerDataSource(paramIDataSource), null, this.callback, insureEventLooper(), (BaseDecoder)localObject);
      this.mAudioPlayer.setThreadName(paramIDataSource.toString());
      return;
    }
  }
  
  protected void TransferStateTo(int paramInt)
  {
    this.currentState.transfer(Integer.valueOf(paramInt));
    if (this.mCallback != null) {
      this.mCallback.onStateChanged(this, paramInt);
    }
    Logger.d("CommonPlayer", "TransferStateTo() CURSTATE:" + paramInt);
  }
  
  public void addAudioListener(IAudioListener paramIAudioListener)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.addAudioListener(paramIAudioListener);
    }
  }
  
  public void addPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this.mCallback.add(paramPlayerListenerCallback);
  }
  
  public SeekTable createSeekTable()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer == null) {
      throw new IllegalStateException("not initialized!");
    }
    return localCorePlayer.createSeekTable();
  }
  
  public void flush()
  {
    if (this.mAudioPlayer == null)
    {
      Logger.e("CommonPlayer", "[getCurrentFrame] mAudioPlayer is null!");
      return;
    }
    this.mAudioPlayer.flush();
  }
  
  public int getBufferedPercentage()
  {
    return this.mBufferPercentage;
  }
  
  public AudioInformation getCurrentAudioInformation()
  {
    if (this.mAudioPlayer != null) {
      return this.mAudioPlayer.getCurrentAudioInformation();
    }
    return null;
  }
  
  public long getCurrentPosition()
  {
    if (this.mAudioPlayer != null) {
      return this.mAudioPlayer.getCurPosition();
    }
    Logger.e("CommonPlayer", "getCurrentPosition() mAudioPlayer is null!");
    return 0L;
  }
  
  public long getCurrentPositionFromFile()
  {
    return 0L;
  }
  
  public long getDecodePosition()
  {
    if (this.mAudioPlayer != null) {
      return this.mAudioPlayer.getCurPositionByDecoder();
    }
    Logger.e("CommonPlayer", "getDecodePosition() ERROR : mAudioPlayer is null!");
    return 0L;
  }
  
  public int getDuration()
  {
    long l = 0L;
    if (this.mAudioPlayer != null)
    {
      this.mDuration = this.mAudioPlayer.getDuration();
      return (int)this.mDuration;
    }
    Logger.e("CommonPlayer", "getDuration() mAudioPlayer is null!");
    if (this.mDuration > 0L) {
      l = this.mDuration;
    }
    return (int)l;
  }
  
  int getPlayerMode()
  {
    if (this.mAudioPlayer != null) {
      return this.mAudioPlayer.getPlayerMode();
    }
    return 0;
  }
  
  public int getPlayerState()
  {
    return ((Integer)this.currentState.get()).intValue();
  }
  
  public int getSessionId()
  {
    if (this.mAudioPlayer != null) {
      return this.mAudioPlayer.getSessionId();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    boolean bool = false;
    if (this.mAudioPlayer != null)
    {
      if (this.mAudioPlayer.getPlayerState() == 4) {
        bool = true;
      }
      return bool;
    }
    Logger.e("CommonPlayer", "isPlaying() mAudioPlayer is null!");
    return false;
  }
  
  public boolean isSoftDecoder()
  {
    return true;
  }
  
  public void pause()
  {
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pause]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.pause();
    }
    for (;;)
    {
      notifyPauseSong();
      return;
      Logger.e("CommonPlayer", "pause() mAudioPlayer is null!");
    }
  }
  
  public void prepare()
  {
    TransferStateTo(3);
    Logger.i("CommonPlayer", auxiliary("[prepare]"));
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.prepare();
      return;
    }
    Logger.e("CommonPlayer", "prepare() null mAudioPlayer!");
  }
  
  public void prepareAsync()
  {
    throw new UnSupportMethodException("Soft decode player cannot support prepareAsync");
  }
  
  public void release()
  {
    TransferStateTo(8);
    Logger.i("CommonPlayer", auxiliary("[release]"));
    resetInternal();
    this.mCallback.clear();
  }
  
  public void removeAudioListener(IAudioListener paramIAudioListener)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.removeAudioListener(paramIAudioListener);
    }
  }
  
  public void reset()
  {
    TransferStateTo(0);
    Logger.i("CommonPlayer", auxiliary("[reset]"));
    resetInternal();
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.seek(paramInt);
      return;
    }
    Logger.e("CommonPlayer", "seekTo() mAudioPlayer is null!");
  }
  
  public void setAudioStreamType(int paramInt)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setAudioStreamType(paramInt);
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    paramContext = paramUri.getScheme();
    if (TextUtils.isEmpty(paramContext)) {
      setDataSource(paramUri.toString());
    }
    do
    {
      return;
      if ((paramContext.equalsIgnoreCase("http")) || (paramContext.equalsIgnoreCase("https")))
      {
        setDataSource(new DefaultMediaHTTPService(), paramUri);
        return;
      }
    } while (paramContext.equalsIgnoreCase("content"));
    paramContext.equalsIgnoreCase("file");
  }
  
  public void setDataSource(Context paramContext, UriLoader paramUriLoader)
  {
    setDataSource(new CommonPlayer.2(this, paramUriLoader));
  }
  
  public void setDataSource(TrackInfo paramTrackInfo)
  {
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
  }
  
  public void setDataSource(IMediaHTTPService paramIMediaHTTPService, Uri paramUri)
  {
    File localFile;
    try
    {
      localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      localFile.delete();
      if (!localFile.createNewFile())
      {
        onError(90, 103, 0);
        return;
      }
    }
    catch (IOException paramIMediaHTTPService)
    {
      onError(90, 103, 0);
      return;
    }
    String str = localFile.getAbsolutePath();
    paramIMediaHTTPService = new CacheDataSource(new HttpDataSource(paramUri, null, paramIMediaHTTPService), new FileDataSource(str), new FileDataSink(str), insureEventLooper());
    this.openedResources = new CommonPlayer.OpenedResources(null);
    CommonPlayer.OpenedResources.access$402(this.openedResources, localFile);
    CommonPlayer.OpenedResources.access$502(this.openedResources, paramIMediaHTTPService);
    paramIMediaHTTPService.setListener(new CommonPlayer.BufferListener(this, null));
    setDataSourceInternal(paramIMediaHTTPService);
  }
  
  public void setDataSource(IDataSourceFactory paramIDataSourceFactory)
  {
    if (paramIDataSourceFactory == null) {
      throw new IllegalArgumentException("dataSourceFactory is null!");
    }
    TransferStateTo(1);
    if (this.mPreferMediaCodecDecode) {
      this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, this.callback, insureEventLooper(), new MediaCodecDecoder());
    }
    for (;;)
    {
      this.mAudioPlayer.setThreadName(paramIDataSourceFactory.toString());
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
    throw new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
  }
  
  public void setDataSource(String paramString)
  {
    if (paramString == null)
    {
      Logger.e("CommonPlayer", "setDataSource() ERROR:the path is null!");
      throw new IllegalArgumentException("the path is null!");
    }
    TransferStateTo(1);
    Logger.i("CommonPlayer", "setDataSource, path: " + paramString);
    this.mBufferPercentage = 100;
    setDataSourceInternal(new FileDataSource(paramString));
  }
  
  public void setPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this.mCallback.clear();
    this.mCallback.add(paramPlayerListenerCallback);
  }
  
  void setPlayerMode(int paramInt)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setPlayerMode(paramInt);
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    throw new UnSupportMethodException("Soft decode player cannot support setWakeMode");
  }
  
  public void start()
  {
    TransferStateTo(4);
    Logger.i("CommonPlayer", auxiliary("[start]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.play();
    }
    for (;;)
    {
      notifyStartPlaySong();
      return;
      Logger.e("CommonPlayer", "start() mAudioPlayer is null!");
    }
  }
  
  public void stop()
  {
    try
    {
      TransferStateTo(6);
      Logger.i("CommonPlayer", auxiliary("[stop]"));
      if (this.mAudioPlayer != null)
      {
        this.mAudioPlayer.stop();
        return;
      }
      Logger.e("CommonPlayer", "stop() mAudioPlayer is null!");
      return;
    }
    catch (Exception localException)
    {
      Logger.e("CommonPlayer", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer
 * JD-Core Version:    0.7.0.1
 */