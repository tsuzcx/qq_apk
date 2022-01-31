package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.crypto.HexUtil;
import java.nio.ByteBuffer;

public class be
{
  int a = 0;
  byte[] b;
  int c;
  at d;
  ju e;
  
  private be(int paramInt, byte[] paramArrayOfByte)
  {
    this.c = paramInt;
    a(paramArrayOfByte);
  }
  
  public static be a(int paramInt1, int paramInt2)
  {
    be localbe = new be(paramInt2, new byte[0]);
    ju localju = new ju();
    localju.e = paramInt1;
    localju.c = paramInt2;
    localbe.e = localju;
    return localbe;
  }
  
  public static be a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    localByteBuffer.putInt(localByteBuffer.capacity()).put(paramArrayOfByte).flip();
    return new be(paramInt, localByteBuffer.array());
  }
  
  public void a(at paramat)
  {
    this.d = paramat;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    this.a = paramArrayOfByte.length;
  }
  
  public String toString()
  {
    return "seq:" + this.c + " " + HexUtil.bytes2HexStr(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.be
 * JD-Core Version:    0.7.0.1
 */