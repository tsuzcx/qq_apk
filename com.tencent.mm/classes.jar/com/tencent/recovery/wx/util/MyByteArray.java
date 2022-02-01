package com.tencent.recovery.wx.util;

class MyByteArray
{
  public byte[] array;
  public int begin;
  
  public MyByteArray()
  {
    this.begin = 0;
    this.array = new byte[256];
  }
  
  public MyByteArray(byte paramByte)
  {
    this.begin = 0;
    this.array = new byte[] { paramByte };
  }
  
  public MyByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    this.begin = paramInt;
    this.array = paramArrayOfByte;
  }
  
  public MyByteArray(MyByteArray paramMyByteArray)
  {
    this.begin = paramMyByteArray.begin;
    this.array = paramMyByteArray.array;
  }
  
  public MyByteArray(byte[] paramArrayOfByte)
  {
    this.begin = 0;
    this.array = paramArrayOfByte;
  }
  
  public MyByteArray copy()
  {
    return new MyByteArray(this.begin, this.array);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.wx.util.MyByteArray
 * JD-Core Version:    0.7.0.1
 */