package com.tencent.recovery.wx.util;

class MyByteArray
{
  public byte[] bVo;
  public int bVp = 0;
  
  public MyByteArray()
  {
    this.bVo = new byte[256];
  }
  
  public MyByteArray(byte paramByte)
  {
    this.bVo = new byte[] { paramByte };
  }
  
  public MyByteArray(byte[] paramArrayOfByte)
  {
    this.bVo = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.MyByteArray
 * JD-Core Version:    0.7.0.1
 */