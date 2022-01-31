package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.b.a.a;

public abstract interface b
{
  public abstract void HF(int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, int paramInt);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void aeH(String paramString);
  
  public abstract void bKF();
  
  public abstract void br(int paramInt, String paramString);
  
  public abstract void cNc();
  
  public abstract Context cOO();
  
  public abstract void cOP();
  
  public abstract void cOQ();
  
  public abstract byte[] cOR();
  
  public abstract a.a cOS();
  
  public abstract void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void gj(int paramInt1, int paramInt2);
  
  public abstract void gl(int paramInt1, int paramInt2);
  
  public abstract void mY(boolean paramBoolean);
  
  public abstract void requestRender();
  
  public abstract void setCaptureView(CaptureView paramCaptureView);
  
  public abstract void setConnectSec(long paramLong);
  
  public abstract void setHWDecMode(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScreenEnable(boolean paramBoolean);
  
  public abstract void setVoipBeauty(int paramInt);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */