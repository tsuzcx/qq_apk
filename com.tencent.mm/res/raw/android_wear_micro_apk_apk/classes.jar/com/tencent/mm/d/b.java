package com.tencent.mm.d;

public final class b
{
  private byte[] Xf;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.Xf = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.Xf, 0, paramInt2);
  }
  
  public final byte[] getBytes()
  {
    return this.Xf;
  }
  
  public final int size()
  {
    return this.Xf.length;
  }
  
  public final byte[] toByteArray()
  {
    int i = this.Xf.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.Xf, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.d.b
 * JD-Core Version:    0.7.0.1
 */