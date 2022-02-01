package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer
{
  private p a = null;
  
  public TbsMediaPlayer(p paramp)
  {
    this.a = paramp;
  }
  
  public void audio(int paramInt)
  {
    AppMethodBeat.i(55158);
    this.a.b(paramInt);
    AppMethodBeat.o(55158);
  }
  
  public void close()
  {
    AppMethodBeat.i(55162);
    this.a.e();
    AppMethodBeat.o(55162);
  }
  
  public float getVolume()
  {
    AppMethodBeat.i(55154);
    float f = this.a.b();
    AppMethodBeat.o(55154);
    return f;
  }
  
  public boolean isAvailable()
  {
    AppMethodBeat.i(55151);
    boolean bool = this.a.a();
    AppMethodBeat.o(55151);
    return bool;
  }
  
  public void pause()
  {
    AppMethodBeat.i(55159);
    this.a.c();
    AppMethodBeat.o(55159);
  }
  
  public void play()
  {
    AppMethodBeat.i(55160);
    this.a.d();
    AppMethodBeat.o(55160);
  }
  
  public void seek(long paramLong)
  {
    AppMethodBeat.i(55161);
    this.a.a(paramLong);
    AppMethodBeat.o(55161);
  }
  
  public void setPlayerListener(TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(55153);
    this.a.a(paramTbsMediaPlayerListener);
    AppMethodBeat.o(55153);
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(55152);
    this.a.a(paramSurfaceTexture);
    AppMethodBeat.o(55152);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(55155);
    this.a.a(paramFloat);
    AppMethodBeat.o(55155);
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(55156);
    this.a.a(paramString, paramBundle);
    AppMethodBeat.o(55156);
  }
  
  public void subtitle(int paramInt)
  {
    AppMethodBeat.i(55157);
    this.a.a(paramInt);
    AppMethodBeat.o(55157);
  }
  
  public static abstract interface TbsMediaPlayerListener
  {
    public static final int MEDIA_EXTRA_AUDIOTRACK_INDEX = 104;
    public static final int MEDIA_EXTRA_AUDIOTRACK_TITLES = 103;
    public static final int MEDIA_EXTRA_SUBTITLE_COUNT = 101;
    public static final int MEDIA_EXTRA_SUBTITLE_INDEX = 102;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 790;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
    public static final int MEDIA_INFO_HAVE_VIDEO_DATA = 752;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_NO_VIDEO_DATA = 751;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int ROTATE_ACTION_HASROTATE = 3;
    public static final int ROTATE_ACTION_NOTHING = 1;
    public static final int ROTATE_ACTION_SETDEGREE = 2;
    public static final int ROTATE_ACTION_UNKNOWN = 0;
    
    public abstract void onBufferingUpdate(float paramFloat);
    
    public abstract void onPlayerCompleted();
    
    public abstract void onPlayerError(String paramString, int paramInt1, int paramInt2, Throwable paramThrowable);
    
    public abstract void onPlayerExtra(int paramInt, Object paramObject);
    
    public abstract void onPlayerInfo(int paramInt1, int paramInt2);
    
    public abstract void onPlayerPaused();
    
    public abstract void onPlayerPlaying();
    
    public abstract void onPlayerPrepared(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onPlayerProgress(long paramLong);
    
    public abstract void onPlayerSeeked(long paramLong);
    
    public abstract void onPlayerSubtitle(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */