package com.tencent.wxmm;

public abstract interface IVoipCallBack
{
  public abstract void callBackFromVoip1(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract byte[] callBackFromVoip2(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wxmm.IVoipCallBack
 * JD-Core Version:    0.7.0.1
 */