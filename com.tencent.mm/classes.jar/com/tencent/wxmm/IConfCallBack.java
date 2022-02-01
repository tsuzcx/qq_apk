package com.tencent.wxmm;

public abstract interface IConfCallBack
{
  public abstract byte[] callBackFromConf(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void callbackWriteLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxmm.IConfCallBack
 * JD-Core Version:    0.7.0.1
 */