package com.tencent.ttpic.util;

public abstract interface TexSaveProcess
{
  public abstract void clear();
  
  public abstract void init();
  
  public abstract boolean retrieveData(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public abstract byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.TexSaveProcess
 * JD-Core Version:    0.7.0.1
 */