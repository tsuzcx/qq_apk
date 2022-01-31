package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public class om
{
  private int a;
  private int b;
  private int c;
  private byte[] d = new byte[4];
  
  public int a()
  {
    return this.a;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Arrays.fill(this.d, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.d, 0, 4);
    this.a = la.a(this.d);
    System.arraycopy(paramArrayOfByte, 4, this.d, 0, 4);
    this.b = la.a(this.d);
    System.arraycopy(paramArrayOfByte, 8, this.d, 0, 4);
    this.c = la.a(this.d);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.om
 * JD-Core Version:    0.7.0.1
 */