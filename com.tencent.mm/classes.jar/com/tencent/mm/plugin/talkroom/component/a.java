package com.tencent.mm.plugin.talkroom.component;

import android.os.IInterface;

public abstract interface a
  extends IInterface
{
  public abstract int Close();
  
  public abstract int SetCurrentMicId(int paramInt);
  
  public abstract int a(b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt4);
  
  public abstract e a(c paramc);
  
  public abstract int cHn();
  
  public abstract d cHo();
  
  public abstract byte[] e(int[] paramArrayOfInt, String paramString);
  
  public abstract int uninitLive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.a
 * JD-Core Version:    0.7.0.1
 */