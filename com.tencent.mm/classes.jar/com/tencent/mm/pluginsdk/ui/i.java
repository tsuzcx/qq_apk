package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface i
{
  public abstract boolean aE(float paramFloat);
  
  public abstract boolean bhH();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract void cMk();
  
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
    public abstract void aK(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void qQ(long paramLong);
    
    public abstract void vk(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void dXu();
  }
  
  public static enum e
  {
    static
    {
      AppMethodBeat.i(134008);
      ESM = new e("DEFAULT", 0);
      ESN = new e("FILL", 1);
      ESO = new e("CONTAIN", 2);
      ESP = new e("COVER", 3);
      ESQ = new e[] { ESM, ESN, ESO, ESP };
      AppMethodBeat.o(134008);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */