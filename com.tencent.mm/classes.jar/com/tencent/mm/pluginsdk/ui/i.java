package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface i
{
  public abstract boolean aE(float paramFloat);
  
  public abstract boolean bip();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract void cOS();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract boolean isPlaying();
  
  public abstract boolean o(double paramDouble);
  
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
    public abstract void aM(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void ds(String paramString1, String paramString2);
    
    public abstract void dt(String paramString1, String paramString2);
    
    public abstract void du(String paramString1, String paramString2);
    
    public abstract void dv(String paramString1, String paramString2);
    
    public abstract void dw(String paramString1, String paramString2);
    
    public abstract void dx(String paramString1, String paramString2);
    
    public abstract void eX(String paramString1, String paramString2);
  }
  
  public static abstract interface c
  {
    public abstract void rd(long paramLong);
    
    public abstract void vG(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void eaX();
  }
  
  public static enum e
  {
    static
    {
      AppMethodBeat.i(134008);
      Flh = new e("DEFAULT", 0);
      Fli = new e("FILL", 1);
      Flj = new e("CONTAIN", 2);
      Flk = new e("COVER", 3);
      Fll = new e[] { Flh, Fli, Flj, Flk };
      AppMethodBeat.o(134008);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */