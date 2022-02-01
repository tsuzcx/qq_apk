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
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener;
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
  private int currentState;
  private Looper eventLooper;
  private CorePlayer mAudioPlayer;
  private int mBufferPercentage;
  private final ListPlayerListenerCallback mCallback;
  private long mDuration;
  private final QMThreadExecutor mExecutor;
  private String mLocalPlayPath;
  private boolean mPreferMediaCodecDecode;
  private Float mSpeedToSet;
  private OpenedResources openedResources;
  
  public CommonPlayer()
  {
    this(null, null, false, new QMThreadExecutor()
    {
      public void execute(Runnable paramAnonymousRunnable, Thread.UncaughtExceptionHandler paramAnonymousUncaughtExceptionHandler)
      {
        AppMethodBeat.i(76676);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, "decoder");
        paramAnonymousRunnable.setUncaughtExceptionHandler(paramAnonymousUncaughtExceptionHandler);
        paramAnonymousRunnable.start();
        AppMethodBeat.o(76676);
      }
    });
    AppMethodBeat.i(76433);
    AppMethodBeat.o(76433);
  }
  
  public CommonPlayer(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this(paramPlayerListenerCallback, null, false, new QMThreadExecutor()
    {
      public void execute(Runnable paramAnonymousRunnable, Thread.UncaughtExceptionHandler paramAnonymousUncaughtExceptionHandler)
      {
        AppMethodBeat.i(76598);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, "decoder");
        paramAnonymousRunnable.setUncaughtExceptionHandler(paramAnonymousUncaughtExceptionHandler);
        paramAnonymousRunnable.start();
        AppMethodBeat.o(76598);
      }
    });
    AppMethodBeat.i(76434);
    AppMethodBeat.o(76434);
  }
  
  public CommonPlayer(PlayerListenerCallback paramPlayerListenerCallback, Looper paramLooper, boolean paramBoolean, QMThreadExecutor paramQMThreadExecutor)
  {
    AppMethodBeat.i(76435);
    this.mCallback = new ListPlayerListenerCallback();
    this.mAudioPlayer = null;
    this.currentState = 0;
    this.mSpeedToSet = null;
    this.mPreferMediaCodecDecode = false;
    this.mLocalPlayPath = null;
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
    this.mExecutor = paramQMThreadExecutor;
    reset();
    AppMethodBeat.o(76435);
  }
  
  private String auxiliary(String paramString)
  {
    AppMethodBeat.i(76474);
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (this.mPreferMediaCodecDecode) {}
    for (String str = "[MediaCodec]"; localCorePlayer == null; str = "")
    {
      AppMethodBeat.o(76474);
      return "null";
    }
    paramString = "[" + localCorePlayer + "]" + str + paramString;
    AppMethodBeat.o(76474);
    return paramString;
  }
  
  private Looper insureEventLooper()
  {
    AppMethodBeat.i(76470);
    if (this.eventLooper == null)
    {
      localObject = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
      ((HandlerThread)localObject).start();
      this.eventLooper = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = this.eventLooper;
    AppMethodBeat.o(76470);
    return localObject;
  }
  
  private void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76471);
    onError(paramInt1, paramInt2, 0);
    AppMethodBeat.o(76471);
  }
  
  private void onError(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76472);
    TransferStateTo(9);
    Logger.e("CommonPlayer", "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
    this.mCallback.onError(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(76472);
  }
  
  private void resetInternal()
  {
    AppMethodBeat.i(76473);
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
        break label96;
      }
      this.eventLooper.quitSafely();
    }
    for (;;)
    {
      this.eventLooper = null;
      this.mDuration = 0L;
      this.mBufferPercentage = 0;
      this.mSpeedToSet = null;
      AppMethodBeat.o(76473);
      return;
      label96:
      this.eventLooper.quit();
    }
  }
  
  private void setDataSourceInternal(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(76475);
    TransferStateTo(1);
    if (this.mPreferMediaCodecDecode) {}
    for (Object localObject = new MediaCodecDecoder();; localObject = new NativeDecoder())
    {
      CorePlayerCallback localCorePlayerCallback = new CorePlayerCallback(null, paramIDataSource, null);
      this.mAudioPlayer = new CorePlayer(new TracerDataSource(paramIDataSource), null, localCorePlayerCallback, insureEventLooper(), (BaseDecoder)localObject, this.mExecutor);
      this.mAudioPlayer.setThreadName(paramIDataSource.toString());
      setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
      AppMethodBeat.o(76475);
      return;
    }
  }
  
  private void setSpeedToCorePlayerIfNeeded(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(175615);
    if (this.mSpeedToSet != null)
    {
      paramCorePlayer.setSpeed(this.mSpeedToSet.floatValue());
      this.mSpeedToSet = null;
    }
    AppMethodBeat.o(175615);
  }
  
  protected void TransferStateTo(int paramInt)
  {
    AppMethodBeat.i(76469);
    Logger.i("StateRunner", this.currentState + " -> " + paramInt);
    this.currentState = paramInt;
    if (this.mCallback != null) {
      this.mCallback.onStateChanged(this, paramInt);
    }
    AppMethodBeat.o(76469);
  }
  
  public void addAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76466);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.addAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(76466);
  }
  
  public void addPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    AppMethodBeat.i(76451);
    this.mCallback.add(paramPlayerListenerCallback);
    AppMethodBeat.o(76451);
  }
  
  public SeekTable createSeekTable()
  {
    AppMethodBeat.i(76468);
    Object localObject = this.mAudioPlayer;
    if (localObject == null)
    {
      localObject = new IllegalStateException("not initialized!");
      AppMethodBeat.o(76468);
      throw ((Throwable)localObject);
    }
    localObject = ((CorePlayer)localObject).createSeekTable();
    AppMethodBeat.o(76468);
    return localObject;
  }
  
  public void flush()
  {
    AppMethodBeat.i(76453);
    if (this.mAudioPlayer == null)
    {
      Logger.e("CommonPlayer", "[getCurrentFrame] mAudioPlayer is null!");
      AppMethodBeat.o(76453);
      return;
    }
    this.mAudioPlayer.flush();
    AppMethodBeat.o(76453);
  }
  
  public int getBufferedPercentage()
  {
    return this.mBufferPercentage;
  }
  
  public AudioInformation getCurrentAudioInformation()
  {
    AppMethodBeat.i(76462);
    if (this.mAudioPlayer != null)
    {
      AudioInformation localAudioInformation = this.mAudioPlayer.getCurrentAudioInformation();
      AppMethodBeat.o(76462);
      return localAudioInformation;
    }
    AppMethodBeat.o(76462);
    return null;
  }
  
  public long getCurrentPosition()
  {
    AppMethodBeat.i(76452);
    if (this.mAudioPlayer != null)
    {
      long l = this.mAudioPlayer.getCurPosition();
      AppMethodBeat.o(76452);
      return l;
    }
    Logger.e("CommonPlayer", "getCurrentPosition() mAudioPlayer is null!");
    AppMethodBeat.o(76452);
    return 0L;
  }
  
  public long getCurrentPositionFromFile()
  {
    return 0L;
  }
  
  public long getDecodePosition()
  {
    AppMethodBeat.i(76454);
    if (this.mAudioPlayer != null)
    {
      long l = this.mAudioPlayer.getCurPositionByDecoder();
      AppMethodBeat.o(76454);
      return l;
    }
    Logger.e("CommonPlayer", "getDecodePosition() ERROR : mAudioPlayer is null!");
    AppMethodBeat.o(76454);
    return 0L;
  }
  
  public int getDecoderType()
  {
    if (this.mPreferMediaCodecDecode) {
      return 2;
    }
    return 1;
  }
  
  public int getDuration()
  {
    long l = 0L;
    AppMethodBeat.i(76436);
    if (this.mAudioPlayer != null)
    {
      this.mDuration = this.mAudioPlayer.getDuration();
      i = (int)this.mDuration;
      AppMethodBeat.o(76436);
      return i;
    }
    Logger.e("CommonPlayer", "getDuration() mAudioPlayer is null!");
    if (this.mDuration > 0L) {
      l = this.mDuration;
    }
    int i = (int)l;
    AppMethodBeat.o(76436);
    return i;
  }
  
  int getPlayerMode()
  {
    AppMethodBeat.i(76465);
    if (this.mAudioPlayer != null)
    {
      int i = this.mAudioPlayer.getPlayerMode();
      AppMethodBeat.o(76465);
      return i;
    }
    AppMethodBeat.o(76465);
    return 0;
  }
  
  public int getPlayerState()
  {
    return this.currentState;
  }
  
  public int getSessionId()
  {
    AppMethodBeat.i(76463);
    if (this.mAudioPlayer != null)
    {
      int i = this.mAudioPlayer.getSessionId();
      AppMethodBeat.o(76463);
      return i;
    }
    AppMethodBeat.o(76463);
    return 0;
  }
  
  public float getSpeed()
  {
    AppMethodBeat.i(190286);
    float f = 1.0F;
    if (this.mAudioPlayer != null) {
      f = this.mAudioPlayer.getSpeed();
    }
    for (;;)
    {
      AppMethodBeat.o(190286);
      return f;
      if (this.mSpeedToSet != null) {
        f = this.mSpeedToSet.floatValue();
      }
    }
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(76437);
    if (this.mAudioPlayer != null)
    {
      if (this.mAudioPlayer.getPlayerState() == 4)
      {
        AppMethodBeat.o(76437);
        return true;
      }
      AppMethodBeat.o(76437);
      return false;
    }
    Logger.e("CommonPlayer", "isPlaying() mAudioPlayer is null!");
    AppMethodBeat.o(76437);
    return false;
  }
  
  public void pause()
  {
    AppMethodBeat.i(76438);
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pause]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.pause(false);
    }
    for (;;)
    {
      notifyPauseSong();
      AppMethodBeat.o(76438);
      return;
      Logger.e("CommonPlayer", "pause() mAudioPlayer is null!");
    }
  }
  
  public void pauseRealTime()
  {
    AppMethodBeat.i(76439);
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pauseRealTime]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.pause(true);
    }
    for (;;)
    {
      notifyPauseSong();
      AppMethodBeat.o(76439);
      return;
      Logger.e("CommonPlayer", "pauseRealTime() mAudioPlayer is null!");
    }
  }
  
  public void prepare()
  {
    AppMethodBeat.i(76440);
    TransferStateTo(3);
    Logger.i("CommonPlayer", auxiliary("[prepare]"));
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.prepare();
      AppMethodBeat.o(76440);
      return;
    }
    Logger.e("CommonPlayer", "prepare() null mAudioPlayer!");
    AppMethodBeat.o(76440);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(76441);
    UnSupportMethodException localUnSupportMethodException = new UnSupportMethodException("Soft decode player cannot support prepareAsync");
    AppMethodBeat.o(76441);
    throw localUnSupportMethodException;
  }
  
  public void release()
  {
    AppMethodBeat.i(76442);
    TransferStateTo(8);
    Logger.i("CommonPlayer", auxiliary("[release]"));
    resetInternal();
    this.mCallback.clear();
    AppMethodBeat.o(76442);
  }
  
  public void removeAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76467);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.removeAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(76467);
  }
  
  public void reset()
  {
    AppMethodBeat.i(76443);
    TransferStateTo(0);
    Logger.i("CommonPlayer", auxiliary("[reset]"));
    resetInternal();
    AppMethodBeat.o(76443);
  }
  
  public void seekTo(int paramInt)
  {
    AppMethodBeat.i(76444);
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.seek(paramInt);
      AppMethodBeat.o(76444);
      return;
    }
    Logger.e("CommonPlayer", "seekTo() mAudioPlayer is null!");
    AppMethodBeat.o(76444);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(76460);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setAudioStreamType(paramInt);
    }
    AppMethodBeat.o(76460);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(76455);
    paramContext = paramUri.getScheme();
    if (TextUtils.isEmpty(paramContext))
    {
      setDataSource(paramUri.toString());
      AppMethodBeat.o(76455);
      return;
    }
    if ((paramContext.equalsIgnoreCase("http")) || (paramContext.equalsIgnoreCase("https")))
    {
      setDataSource(new DefaultMediaHTTPService(), paramUri);
      AppMethodBeat.o(76455);
      return;
    }
    if (!paramContext.equalsIgnoreCase("content")) {
      paramContext.equalsIgnoreCase("file");
    }
    AppMethodBeat.o(76455);
  }
  
  public void setDataSource(Context paramContext, final UriLoader paramUriLoader)
  {
    AppMethodBeat.i(76459);
    setDataSource(new IDataSourceFactory()
    {
      public IDataSource createDataSource()
      {
        AppMethodBeat.i(76575);
        CacheDataSource localCacheDataSource = CacheDataSource.Factory.createFromUriLoader(paramUriLoader);
        AppMethodBeat.o(76575);
        return localCacheDataSource;
      }
      
      public INativeDataSource createNativeDataSource()
      {
        return null;
      }
    });
    AppMethodBeat.o(76459);
  }
  
  public void setDataSource(TrackInfo paramTrackInfo)
  {
    AppMethodBeat.i(76458);
    TransferStateTo(1);
    Logger.i("CommonPlayer", "setDataSource, trackInfo.getUri: " + paramTrackInfo.getUri());
    Logger.i("CommonPlayer", "setDataSource, trackInfo.range: " + paramTrackInfo.getRange().toString());
    this.mBufferPercentage = 100;
    paramTrackInfo = new TrackDataSource(paramTrackInfo);
    Object localObject = this.mCallback.toCollection();
    this.mCallback.clear();
    this.mCallback.add(paramTrackInfo);
    this.mCallback.addAll((List)localObject);
    TransferStateTo(1);
    localObject = new TracerDataSource(paramTrackInfo);
    this.mAudioPlayer = new TrackCorePlayer((IDataSource)localObject, new CorePlayerCallback(null, (IDataSource)localObject, null), insureEventLooper(), this.mExecutor);
    paramTrackInfo.setTrackStateCallback((TrackCorePlayer)this.mAudioPlayer);
    this.mAudioPlayer.setThreadName(paramTrackInfo.toString());
    setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
    AppMethodBeat.o(76458);
  }
  
  public void setDataSource(IMediaHTTPService paramIMediaHTTPService, Uri paramUri)
  {
    AppMethodBeat.i(76456);
    File localFile;
    try
    {
      localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      localFile.delete();
      if (!localFile.createNewFile())
      {
        onError(90, 103, 0);
        AppMethodBeat.o(76456);
        return;
      }
    }
    catch (IOException paramIMediaHTTPService)
    {
      onError(90, 103, 0);
      AppMethodBeat.o(76456);
      return;
    }
    String str = localFile.getAbsolutePath();
    paramIMediaHTTPService = new CacheDataSource(new HttpDataSource(paramUri, null, paramIMediaHTTPService), new FileDataSource(str), new FileDataSink(str), insureEventLooper());
    this.openedResources = new OpenedResources(null);
    OpenedResources.access$602(this.openedResources, localFile);
    OpenedResources.access$702(this.openedResources, paramIMediaHTTPService);
    paramIMediaHTTPService.setListener(new BufferListener(null));
    setDataSourceInternal(paramIMediaHTTPService);
    AppMethodBeat.o(76456);
  }
  
  public void setDataSource(IDataSourceFactory paramIDataSourceFactory)
  {
    AppMethodBeat.i(76457);
    if (paramIDataSourceFactory == null)
    {
      paramIDataSourceFactory = new IllegalArgumentException("dataSourceFactory is null!");
      AppMethodBeat.o(76457);
      throw paramIDataSourceFactory;
    }
    TransferStateTo(1);
    CorePlayerCallback localCorePlayerCallback = new CorePlayerCallback(paramIDataSourceFactory, null, null);
    if (this.mPreferMediaCodecDecode) {
      this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, localCorePlayerCallback, insureEventLooper(), new MediaCodecDecoder(), this.mExecutor);
    }
    for (;;)
    {
      this.mAudioPlayer.setThreadName(paramIDataSourceFactory.toString());
      setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
      if (this.mLocalPlayPath != null) {
        this.mAudioPlayer.setPlayPath(this.mLocalPlayPath);
      }
      AppMethodBeat.o(76457);
      return;
      INativeDataSource localINativeDataSource = paramIDataSourceFactory.createNativeDataSource();
      if (localINativeDataSource != null) {
        this.mAudioPlayer = new CorePlayer(null, localINativeDataSource, localCorePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
      } else {
        this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, localCorePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
      }
    }
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(76446);
    paramFileDescriptor = new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
    AppMethodBeat.o(76446);
    throw paramFileDescriptor;
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(76445);
    if (paramString == null)
    {
      Logger.e("CommonPlayer", "setDataSource() ERROR:the path is null!");
      paramString = new IllegalArgumentException("the path is null!");
      AppMethodBeat.o(76445);
      throw paramString;
    }
    TransferStateTo(1);
    Logger.i("CommonPlayer", "setDataSource, path: ".concat(String.valueOf(paramString)));
    this.mBufferPercentage = 100;
    setDataSourceInternal(new FileDataSource(paramString));
    AppMethodBeat.o(76445);
  }
  
  public void setLeastCommonMultiple(int paramInt)
  {
    AppMethodBeat.i(175616);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setLeastCommonMultiple(paramInt);
    }
    AppMethodBeat.o(175616);
  }
  
  public void setPlayLocalPath(String paramString)
  {
    AppMethodBeat.i(76476);
    this.mLocalPlayPath = paramString;
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setPlayPath(this.mLocalPlayPath);
    }
    AppMethodBeat.o(76476);
  }
  
  public void setPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    AppMethodBeat.i(76450);
    this.mCallback.clear();
    this.mCallback.add(paramPlayerListenerCallback);
    AppMethodBeat.o(76450);
  }
  
  void setPlayerMode(int paramInt)
  {
    AppMethodBeat.i(76464);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setPlayerMode(paramInt);
    }
    AppMethodBeat.o(76464);
  }
  
  public void setSpeed(float paramFloat)
  {
    AppMethodBeat.i(175614);
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.setSpeed(paramFloat);
      AppMethodBeat.o(175614);
      return;
    }
    this.mSpeedToSet = Float.valueOf(paramFloat);
    AppMethodBeat.o(175614);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76447);
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setVolume(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76447);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(76461);
    paramContext = new UnSupportMethodException("Soft decode player cannot support setWakeMode");
    AppMethodBeat.o(76461);
    throw paramContext;
  }
  
  public void start()
  {
    AppMethodBeat.i(76448);
    TransferStateTo(4);
    Logger.i("CommonPlayer", auxiliary("[start]"));
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.play();
    }
    for (;;)
    {
      notifyStartPlaySong();
      AppMethodBeat.o(76448);
      return;
      Logger.e("CommonPlayer", "start() mAudioPlayer is null!");
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(76449);
    try
    {
      TransferStateTo(6);
      Logger.i("CommonPlayer", auxiliary("[stop]"));
      if (this.mAudioPlayer != null)
      {
        this.mAudioPlayer.stop();
        AppMethodBeat.o(76449);
        return;
      }
      Logger.e("CommonPlayer", "stop() mAudioPlayer is null!");
      AppMethodBeat.o(76449);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("CommonPlayer", localException);
      AppMethodBeat.o(76449);
    }
  }
  
  class BufferListener
    implements CacheDataSource.Listener
  {
    private BufferListener() {}
    
    public void onBufferEnded()
    {
      AppMethodBeat.i(76417);
      Logger.i("CommonPlayer", CommonPlayer.access$1000(CommonPlayer.this, "buffer ended."));
      AppMethodBeat.o(76417);
    }
    
    public void onBufferStarted(long paramLong)
    {
      AppMethodBeat.i(76416);
      Logger.i("CommonPlayer", CommonPlayer.access$1000(CommonPlayer.this, "buffer started."));
      AppMethodBeat.o(76416);
    }
    
    public void onBytesTransferError(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void onBytesTransferred(long paramLong1, long paramLong2) {}
    
    public void onBytesTransferring(long paramLong1, long paramLong2) {}
    
    public long onStreamingError(IOException paramIOException)
    {
      AppMethodBeat.i(76419);
      Logger.e("CommonPlayer", CommonPlayer.access$1000(CommonPlayer.this, "streaming error!"), paramIOException);
      AppMethodBeat.o(76419);
      return -1L;
    }
    
    public void onStreamingFinished()
    {
      AppMethodBeat.i(76420);
      CommonPlayer.access$1102(CommonPlayer.this, 100);
      Logger.i("CommonPlayer", CommonPlayer.access$1000(CommonPlayer.this, "streaming finished"));
      AppMethodBeat.o(76420);
    }
    
    public void onTransferEnd() {}
    
    public void onTransferStart() {}
    
    public void onUpStreamTransfer(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(76418);
      if ((CommonPlayer.this.getPlayerState() != 2) && (CommonPlayer.this.getPlayerState() != 4))
      {
        AppMethodBeat.o(76418);
        return;
      }
      int i = (int)Math.round(paramLong1 / paramLong2 * 100.0D);
      if (i == CommonPlayer.this.mBufferPercentage)
      {
        AppMethodBeat.o(76418);
        return;
      }
      CommonPlayer.access$1102(CommonPlayer.this, i);
      CommonPlayer.this.mCallback.onBufferingUpdate(CommonPlayer.this, CommonPlayer.this.mBufferPercentage);
      AppMethodBeat.o(76418);
    }
  }
  
  class CorePlayerCallback
    implements PlayerCallback
  {
    private final IDataSource mDataSource;
    private final IDataSourceFactory mFactory;
    
    private CorePlayerCallback(IDataSourceFactory paramIDataSourceFactory, IDataSource paramIDataSource)
    {
      this.mFactory = paramIDataSourceFactory;
      this.mDataSource = paramIDataSource;
    }
    
    public void playThreadStart(CorePlayer paramCorePlayer) {}
    
    public void playerEnded(CorePlayer paramCorePlayer)
    {
      AppMethodBeat.i(76597);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerEnded() callback ended");
        CommonPlayer.this.TransferStateTo(7);
        CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
        AppMethodBeat.o(76597);
        return;
      }
      Logger.i("CommonPlayer", "different playerEnded");
      AppMethodBeat.o(76597);
    }
    
    public void playerException(CorePlayer paramCorePlayer, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(76596);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.e("CommonPlayer", "playerException() callback exception what = " + paramInt1 + ",extra = " + paramInt2 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
        if (CommonPlayer.this.mAudioPlayer != null)
        {
          Logger.e("CommonPlayer", "handleMessage state = ".concat(String.valueOf(CommonPlayer.this.mAudioPlayer.getPlayerState())));
          Logger.e("CommonPlayer", "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
        }
        if ((CommonPlayer.this.mPreferMediaCodecDecode) && (paramInt1 == 91))
        {
          CommonPlayer.access$202(CommonPlayer.this, false);
          if (this.mFactory != null) {
            try
            {
              CommonPlayer.this.setDataSource(this.mFactory);
              CommonPlayer.this.prepare();
              AppMethodBeat.o(76596);
              return;
            }
            catch (Exception paramCorePlayer)
            {
              Logger.e("CommonPlayer", "retry nativeDecoder", paramCorePlayer);
              CommonPlayer.access$300(CommonPlayer.this, paramInt1, paramInt2, paramInt3);
              AppMethodBeat.o(76596);
              return;
            }
          }
          if (this.mDataSource != null)
          {
            CommonPlayer.access$400(CommonPlayer.this, this.mDataSource);
            CommonPlayer.this.prepare();
            AppMethodBeat.o(76596);
            return;
          }
          CommonPlayer.access$300(CommonPlayer.this, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(76596);
          return;
        }
        CommonPlayer.access$300(CommonPlayer.this, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(76596);
        return;
      }
      Logger.i("CommonPlayer", "different playerException");
      AppMethodBeat.o(76596);
    }
    
    public void playerPaused(CorePlayer paramCorePlayer)
    {
      AppMethodBeat.i(76595);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerPaused() callback paused");
        AppMethodBeat.o(76595);
        return;
      }
      Logger.i("CommonPlayer", "different playerPaused");
      AppMethodBeat.o(76595);
    }
    
    public void playerPrepared(CorePlayer paramCorePlayer)
    {
      AppMethodBeat.i(76591);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerPrepared() callback prepared");
        CommonPlayer.this.TransferStateTo(2);
        CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
        AppMethodBeat.o(76591);
        return;
      }
      Logger.i("CommonPlayer", "different playerPrepared");
      AppMethodBeat.o(76591);
    }
    
    public void playerSeekCompletion(CorePlayer paramCorePlayer, int paramInt)
    {
      AppMethodBeat.i(76594);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerSeekCompletion() callback seek completion");
        CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this, paramInt);
        AppMethodBeat.o(76594);
        return;
      }
      Logger.i("CommonPlayer", "different playerSeekCompletion");
      AppMethodBeat.o(76594);
    }
    
    public void playerStarted(CorePlayer paramCorePlayer)
    {
      AppMethodBeat.i(76593);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerStarted() callback started");
        CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
        AppMethodBeat.o(76593);
        return;
      }
      Logger.i("CommonPlayer", "different playerStarted");
      AppMethodBeat.o(76593);
    }
    
    public void playerStopped(CorePlayer paramCorePlayer)
    {
      AppMethodBeat.i(76592);
      if (CommonPlayer.this.mAudioPlayer == paramCorePlayer)
      {
        Logger.i("CommonPlayer", "playerStopped() callback stopped");
        AppMethodBeat.o(76592);
        return;
      }
      Logger.i("CommonPlayer", "different playerStopped");
      AppMethodBeat.o(76592);
    }
  }
  
  static class OpenedResources
  {
    private File bufferFile;
    private CacheDataSource dataSource;
    
    void release()
    {
      AppMethodBeat.i(76722);
      if ((this.bufferFile != null) && (!this.bufferFile.delete())) {
        Logger.w("CommonPlayer", "[release] failed to delete buffer file: " + this.bufferFile);
      }
      if (this.dataSource != null)
      {
        this.dataSource.setListener(null);
        this.dataSource.releaseLock();
      }
      AppMethodBeat.o(76722);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer
 * JD-Core Version:    0.7.0.1
 */