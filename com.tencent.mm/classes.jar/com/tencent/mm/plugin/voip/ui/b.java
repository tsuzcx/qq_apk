package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;

public abstract interface b
{
  @Deprecated
  public abstract void a(SurfaceTexture paramSurfaceTexture, d paramd);
  
  @Deprecated
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void aUB(String paramString);
  
  @Deprecated
  public abstract a adw(int paramInt);
  
  public abstract void adx(int paramInt);
  
  public abstract void ady(int paramInt);
  
  public abstract void adz(int paramInt);
  
  public abstract void cF(int paramInt, String paramString);
  
  public abstract void ebH();
  
  public abstract void enR();
  
  @Deprecated
  public abstract void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void fFL();
  
  @Deprecated
  public abstract void fJj();
  
  @Deprecated
  public abstract com.tencent.mm.plugin.voip.video.d.b fJk();
  
  public abstract Context fJl();
  
  public abstract void fJm();
  
  public abstract void fJn();
  
  @Deprecated
  public abstract void jA(int paramInt1, int paramInt2);
  
  public abstract void jD(int paramInt1, int paramInt2);
  
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
  
  public abstract void xi(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */