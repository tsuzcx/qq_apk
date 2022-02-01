package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.b.a;

public abstract interface b
{
  @Deprecated
  public abstract a SD(int paramInt);
  
  public abstract void SE(int paramInt);
  
  public abstract void SF(int paramInt);
  
  @Deprecated
  public abstract void a(SurfaceTexture paramSurfaceTexture, d paramd);
  
  @Deprecated
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void ayA(String paramString);
  
  public abstract void cVN();
  
  public abstract void cg(int paramInt, String paramString);
  
  public abstract void dgi();
  
  @Deprecated
  public abstract void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  @Deprecated
  public abstract void ekW();
  
  public abstract Context ekX();
  
  public abstract void ekY();
  
  public abstract void ekZ();
  
  public abstract void ela();
  
  @Deprecated
  public abstract void ie(int paramInt1, int paramInt2);
  
  public abstract void ih(int paramInt1, int paramInt2);
  
  @Deprecated
  public abstract void releaseSurfaceTexture();
  
  @Deprecated
  public abstract void requestRender();
  
  public abstract void sI(boolean paramBoolean);
  
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
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */