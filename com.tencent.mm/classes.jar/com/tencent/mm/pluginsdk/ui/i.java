package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;

public abstract interface i
{
  public abstract boolean G(double paramDouble);
  
  public abstract void b(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean b(double paramDouble, boolean paramBoolean);
  
  public abstract boolean bM(float paramFloat);
  
  public abstract void eLM();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract boolean isLive();
  
  public abstract boolean isPlaying();
  
  public abstract void onUIDestroy();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract boolean pause();
  
  public abstract void setCover(Bitmap paramBitmap);
  
  public abstract void setFullDirection(int paramInt);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setLoopCompletionCallback(d paramd);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(e parame);
  
  public abstract void setVideoFooterView(h paramh);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void bd(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void e(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void el(String paramString1, String paramString2);
    
    public abstract void em(String paramString1, String paramString2);
    
    public abstract void en(String paramString1, String paramString2);
    
    public abstract void eo(String paramString1, String paramString2);
    
    public abstract void ep(String paramString1, String paramString2);
    
    public abstract void eq(String paramString1, String paramString2);
    
    public abstract void gE(String paramString1, String paramString2);
    
    public abstract void onSeekComplete(ITPPlayer paramITPPlayer);
  }
  
  public static abstract interface c
  {
    public abstract void Du(String paramString);
    
    public abstract void hp(long paramLong);
  }
  
  public static abstract interface d
  {
    public abstract void hay();
  }
  
  public static enum e
  {
    static
    {
      AppMethodBeat.i(134008);
      XYK = new e("DEFAULT", 0);
      XYL = new e("FILL", 1);
      XYM = new e("CONTAIN", 2);
      XYN = new e("COVER", 3);
      XYO = new e("CROP", 4);
      XYP = new e[] { XYK, XYL, XYM, XYN, XYO };
      AppMethodBeat.o(134008);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */