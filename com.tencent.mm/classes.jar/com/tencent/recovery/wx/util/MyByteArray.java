package com.tencent.recovery.wx.util;

class MyByteArray
{
  public byte[] buc;
  public int bud = 0;
  
  public MyByteArray()
  {
    this.buc = new byte[256];
  }
  
  public MyByteArray(byte paramByte)
  {
    this.buc = new byte[] { paramByte };
  }
  
  public MyByteArray(byte[] paramArrayOfByte)
  {
    this.buc = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.MyByteArray
 * JD-Core Version:    0.7.0.1
 */