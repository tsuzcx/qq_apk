package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.b.a;

public abstract interface b
{
  @Deprecated
  public abstract a Vb(int paramInt);
  
  public abstract void Vc(int paramInt);
  
  public abstract void Vd(int paramInt);
  
  public abstract void Ve(int paramInt);
  
  @Deprecated
  public abstract void a(SurfaceTexture paramSurfaceTexture, d paramd);
  
  @Deprecated
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void aFb(String paramString);
  
  public abstract void co(int paramInt, String paramString);
  
  public abstract void dhQ();
  
  public abstract void dtu();
  
  @Deprecated
  public abstract void eCp();
  
  public abstract Context eCq();
  
  public abstract void eCr();
  
  public abstract void eCs();
  
  public abstract void eyV();
  
  @Deprecated
  public abstract void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  @Deprecated
  public abstract void iv(int paramInt1, int paramInt2);
  
  public abstract void iy(int paramInt1, int paramInt2);
  
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
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  @Deprecated
  public abstract void setVoipBeauty(int paramInt);
  
  public abstract void ty(boolean paramBoolean);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */