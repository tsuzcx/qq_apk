package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public abstract interface b
{
  public abstract void Ap(int paramInt);
  
  public abstract void Qa(String paramString);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void aN(int paramInt, String paramString);
  
  public abstract void bQK();
  
  public abstract Context bRR();
  
  public abstract void bRS();
  
  public abstract void bRT();
  
  public abstract byte[] bRU();
  
  public abstract void bdl();
  
  public abstract void c(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public abstract void en(int paramInt1, int paramInt2);
  
  public abstract void setCaptureView(CaptureView paramCaptureView);
  
  public abstract void setConnectSec(long paramLong);
  
  public abstract void setHWDecMode(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScreenEnable(boolean paramBoolean);
  
  public abstract void setVoipBeauty(int paramInt);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.b
 * JD-Core Version:    0.7.0.1
 */