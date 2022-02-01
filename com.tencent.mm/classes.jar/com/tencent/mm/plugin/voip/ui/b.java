package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;

public abstract interface b
{
  public abstract void Ba(boolean paramBoolean);
  
  public abstract void XB(int paramInt);
  
  @Deprecated
  public abstract void a(SurfaceTexture paramSurfaceTexture, d paramd);
  
  @Deprecated
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void akB(int paramInt);
  
  @Deprecated
  public abstract a alh(int paramInt);
  
  public abstract void ali(int paramInt);
  
  public abstract void alj(int paramInt);
  
  public abstract void alk(int paramInt);
  
  public abstract void bgj(String paramString);
  
  public abstract void cG(int paramInt, String paramString);
  
  public abstract void eIO();
  
  public abstract void eKF();
  
  public abstract void eXH();
  
  @Deprecated
  public abstract void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  @Deprecated
  public abstract void gBG();
  
  @Deprecated
  public abstract com.tencent.mm.plugin.voip.video.d.b gBH();
  
  public abstract Context gBI();
  
  public abstract void gBJ();
  
  public abstract void gBK();
  
  @Deprecated
  public abstract void kN(int paramInt1, int paramInt2);
  
  public abstract void kR(int paramInt1, int paramInt2);
  
  @Deprecated
  public abstract void releaseSurfaceTexture();
  
  @Deprecated
  public abstract void requestRender();
  
  @Deprecated
  public abstract void setCaptureView(CaptureView paramCaptureView);
  
  public abstract void setConnectSec(long paramLong);
  
  @Deprecated
  public abstract void setHWDecMode(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScreenEnable(boolean paramBoolean);
  
  @Deprecated
  public abstract void setSpatiotemporalDenosing(int paramInt);
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public abstract void setVoipBeauty(int paramInt);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */