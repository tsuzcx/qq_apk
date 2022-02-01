package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class TXLivePlayer
{
  public static final int PLAY_TYPE_LIVE_FLV = 1;
  public static final int PLAY_TYPE_LIVE_RTMP = 0;
  public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
  public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
  public static final int PLAY_TYPE_VOD_FLV = 2;
  public static final int PLAY_TYPE_VOD_HLS = 3;
  public static final int PLAY_TYPE_VOD_MP4 = 4;
  public static final String TAG = "TXLivePlayer";
  private a mTXLivePlayerImpl;
  
  public TXLivePlayer(Context paramContext)
  {
    AppMethodBeat.i(14009);
    this.mTXLivePlayerImpl = new a(paramContext);
    AppMethodBeat.o(14009);
  }
  
  public boolean addVideoRawData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14034);
    boolean bool = this.mTXLivePlayerImpl.a(paramArrayOfByte);
    AppMethodBeat.o(14034);
    return bool;
  }
  
  public void callExperimentalAPI(String paramString)
  {
    AppMethodBeat.i(14029);
    this.mTXLivePlayerImpl.b(paramString);
    AppMethodBeat.o(14029);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(14028);
    this.mTXLivePlayerImpl.e(paramInt);
    AppMethodBeat.o(14028);
  }
  
  public boolean enableHardwareDecode(boolean paramBoolean)
  {
    AppMethodBeat.i(14022);
    paramBoolean = this.mTXLivePlayerImpl.b(paramBoolean);
    AppMethodBeat.o(14022);
    return paramBoolean;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(14015);
    boolean bool = this.mTXLivePlayerImpl.a();
    AppMethodBeat.o(14015);
    return bool;
  }
  
  public void pause()
  {
    AppMethodBeat.i(14016);
    this.mTXLivePlayerImpl.b();
    AppMethodBeat.o(14016);
  }
  
  public int prepareLiveSeek(String paramString, int paramInt)
  {
    AppMethodBeat.i(14037);
    paramInt = this.mTXLivePlayerImpl.b(paramString, paramInt);
    AppMethodBeat.o(14037);
    return paramInt;
  }
  
  public void resume()
  {
    AppMethodBeat.i(14017);
    this.mTXLivePlayerImpl.c();
    AppMethodBeat.o(14017);
  }
  
  public int resumeLive()
  {
    AppMethodBeat.i(14039);
    int i = this.mTXLivePlayerImpl.e();
    AppMethodBeat.o(14039);
    return i;
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(14038);
    this.mTXLivePlayerImpl.g(paramInt);
    AppMethodBeat.o(14038);
  }
  
  public void setAudioRawDataListener(ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(14036);
    this.mTXLivePlayerImpl.a(paramITXAudioRawDataListener);
    AppMethodBeat.o(14036);
  }
  
  public void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(14025);
    this.mTXLivePlayerImpl.d(paramInt);
    AppMethodBeat.o(14025);
  }
  
  public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(14027);
    this.mTXLivePlayerImpl.a(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(14027);
  }
  
  @Deprecated
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(14040);
    this.mTXLivePlayerImpl.d(paramBoolean);
    AppMethodBeat.o(14040);
  }
  
  public void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(14010);
    this.mTXLivePlayerImpl.a(paramTXLivePlayConfig);
    AppMethodBeat.o(14010);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(14023);
    this.mTXLivePlayerImpl.c(paramBoolean);
    AppMethodBeat.o(14023);
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14011);
    this.mTXLivePlayerImpl.a(paramITXLivePlayListener);
    AppMethodBeat.o(14011);
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14012);
    this.mTXLivePlayerImpl.a(paramTXCloudVideoView);
    AppMethodBeat.o(14012);
  }
  
  @Deprecated
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(14041);
    this.mTXLivePlayerImpl.a(paramFloat);
    AppMethodBeat.o(14041);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(14020);
    this.mTXLivePlayerImpl.a(paramInt);
    AppMethodBeat.o(14020);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(14021);
    this.mTXLivePlayerImpl.b(paramInt);
    AppMethodBeat.o(14021);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(14018);
    this.mTXLivePlayerImpl.a(paramSurface);
    AppMethodBeat.o(14018);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14019);
    this.mTXLivePlayerImpl.a(paramInt1, paramInt2);
    AppMethodBeat.o(14019);
  }
  
  public void setVideoRawDataListener(ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    AppMethodBeat.i(14035);
    this.mTXLivePlayerImpl.a(paramITXVideoRawDataListener);
    AppMethodBeat.o(14035);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(14030);
    this.mTXLivePlayerImpl.a(paramITXVideoRecordListener);
    AppMethodBeat.o(14030);
  }
  
  public int setVideoRenderListener(ITXLivePlayVideoRenderListener paramITXLivePlayVideoRenderListener, Object paramObject)
  {
    AppMethodBeat.i(218495);
    int i = this.mTXLivePlayerImpl.a(paramITXLivePlayVideoRenderListener, paramObject);
    AppMethodBeat.o(218495);
    return i;
  }
  
  public void setVolume(int paramInt)
  {
    AppMethodBeat.i(14024);
    this.mTXLivePlayerImpl.c(paramInt);
    AppMethodBeat.o(14024);
  }
  
  public void snapshot(ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14033);
    this.mTXLivePlayerImpl.a(paramITXSnapshotListener);
    AppMethodBeat.o(14033);
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(14013);
    paramInt = this.mTXLivePlayerImpl.a(paramString, paramInt);
    AppMethodBeat.o(14013);
    return paramInt;
  }
  
  public int startRecord(int paramInt)
  {
    AppMethodBeat.i(14031);
    paramInt = this.mTXLivePlayerImpl.f(paramInt);
    AppMethodBeat.o(14031);
    return paramInt;
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(14014);
    int i = this.mTXLivePlayerImpl.a(paramBoolean);
    AppMethodBeat.o(14014);
    return i;
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(14032);
    int i = this.mTXLivePlayerImpl.d();
    AppMethodBeat.o(14032);
    return i;
  }
  
  public int switchStream(String paramString)
  {
    AppMethodBeat.i(14026);
    int i = this.mTXLivePlayerImpl.a(paramString);
    AppMethodBeat.o(14026);
    return i;
  }
  
  public static abstract interface ITXAudioRawDataListener
  {
    public abstract void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onPcmDataAvailable(byte[] paramArrayOfByte, long paramLong);
  }
  
  public static abstract interface ITXAudioVolumeEvaluationListener
  {
    public abstract void onAudioVolumeEvaluationNotify(int paramInt);
  }
  
  public static abstract interface ITXLivePlayVideoRenderListener
  {
    public abstract void onRenderVideoFrame(TXLivePlayer.TXLiteAVTexture paramTXLiteAVTexture);
  }
  
  public static abstract interface ITXSnapshotListener
  {
    public abstract void onSnapshot(Bitmap paramBitmap);
  }
  
  public static abstract interface ITXVideoRawDataListener
  {
    public abstract void onVideoRawDataAvailable(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static class TXLiteAVTexture
  {
    public Object eglContext;
    public int height;
    public int textureId;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer
 * JD-Core Version:    0.7.0.1
 */