package com.tencent.thumbplayer.a;

import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPVideoInfo;
import java.util.Map;

public abstract interface a
  extends com.tencent.thumbplayer.a.a.b
{
  public abstract void a(e parame);
  
  public abstract void a(e parame, int paramInt, long paramLong);
  
  public abstract void a(e parame, Map<String, String> paramMap);
  
  public abstract void a(TPVideoInfo paramTPVideoInfo);
  
  public abstract int getCurrentPlayClipNo();
  
  public abstract int getCurrentState();
  
  public abstract int getPlayerType();
  
  public abstract b hmK();
  
  public abstract boolean isPlaying();
  
  public abstract void setOnPlayerStateChangeListener(c.h paramh);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a
 * JD-Core Version:    0.7.0.1
 */