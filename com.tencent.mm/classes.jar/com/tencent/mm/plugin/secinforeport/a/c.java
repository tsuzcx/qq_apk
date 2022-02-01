package com.tencent.mm.plugin.secinforeport.a;

import android.content.Intent;

public abstract interface c
{
  public abstract void C(String paramString, byte[] paramArrayOfByte);
  
  public abstract boolean aZ(int paramInt, long paramLong);
  
  public abstract void aiL(int paramInt);
  
  public abstract void aiM(int paramInt);
  
  public abstract void asyncReportNewInstallAppThroughCgi(Intent paramIntent);
  
  public abstract void asyncReportPaySecurityInfoThroughCgi();
  
  public abstract void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte);
  
  public abstract void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte);
  
  public abstract boolean ba(int paramInt, long paramLong);
  
  public abstract void br(Intent paramIntent);
  
  public abstract void cs(byte[] paramArrayOfByte);
  
  public abstract void gUC();
  
  public abstract void kY(int paramInt1, int paramInt2);
  
  public abstract void kZ(int paramInt1, int paramInt2);
  
  public abstract void t(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.c
 * JD-Core Version:    0.7.0.1
 */