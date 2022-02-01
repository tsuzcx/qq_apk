package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface h
{
  public abstract boolean aB(float paramFloat);
  
  public abstract boolean bed();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract void cDR();
  
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
  
  public abstract void setLoopCompletionCallback(h.d paramd);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(e parame);
  
  public abstract void setVideoFooterView(g paramg);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void aI(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void jdMethod_do(String paramString1, String paramString2);
    
    public abstract void dp(String paramString1, String paramString2);
    
    public abstract void dq(String paramString1, String paramString2);
    
    public abstract void dr(String paramString1, String paramString2);
    
    public abstract void ds(String paramString1, String paramString2);
    
    public abstract void dt(String paramString1, String paramString2);
    
    public abstract void eJ(String paramString1, String paramString2);
  }
  
  public static enum e
  {
    static
    {
      AppMethodBeat.i(134008);
      DnH = new e("DEFAULT", 0);
      DnI = new e("FILL", 1);
      DnJ = new e("CONTAIN", 2);
      DnK = new e("COVER", 3);
      DnL = new e[] { DnH, DnI, DnJ, DnK };
      AppMethodBeat.o(134008);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.h
 * JD-Core Version:    0.7.0.1
 */