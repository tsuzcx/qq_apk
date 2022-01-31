package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class lc
{
  public final Rect a = new Rect();
  public int[] b;
  public int[] c;
  public int[] d;
  
  public static lc a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder());
    if (paramArrayOfByte.get() == 0) {
      return null;
    }
    lc locallc = new lc();
    locallc.b = new int[paramArrayOfByte.get()];
    locallc.c = new int[paramArrayOfByte.get()];
    locallc.d = new int[paramArrayOfByte.get()];
    a(locallc.b.length);
    a(locallc.c.length);
    paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    locallc.a.left = paramArrayOfByte.getInt();
    locallc.a.right = paramArrayOfByte.getInt();
    locallc.a.top = paramArrayOfByte.getInt();
    locallc.a.bottom = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    a(locallc.b, paramArrayOfByte);
    a(locallc.c, paramArrayOfByte);
    a(locallc.d, paramArrayOfByte);
    return locallc;
  }
  
  private static void a(int paramInt)
  {
    if ((paramInt == 0) || ((paramInt & 0x1) != 0)) {
      throw new RuntimeException("invalid nine-patch: " + paramInt);
    }
  }
  
  private static void a(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lc
 * JD-Core Version:    0.7.0.1
 */