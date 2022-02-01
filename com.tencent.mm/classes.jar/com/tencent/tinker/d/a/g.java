package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class g
  implements Cloneable
{
  long ZNu = -1L;
  int ZNv = -1;
  int ZNw = -1;
  byte[] ZNx;
  long ZNy = -1L;
  long ZNz = -1L;
  String comment;
  long crc = -1L;
  String name;
  long size = -1L;
  int time = -1;
  
  public g(g paramg)
  {
    this.name = paramg.name;
    this.comment = paramg.comment;
    this.time = paramg.time;
    this.size = paramg.size;
    this.ZNu = paramg.ZNu;
    this.crc = paramg.crc;
    this.ZNv = paramg.ZNv;
    this.ZNw = paramg.ZNw;
    this.ZNx = paramg.ZNx;
    this.ZNy = paramg.ZNy;
    this.ZNz = paramg.ZNz;
  }
  
  g(byte[] paramArrayOfByte, InputStream paramInputStream, Charset paramCharset)
  {
    f.b(paramInputStream, paramArrayOfByte, 0, 46);
    paramArrayOfByte = d.a(paramArrayOfByte, 46, ByteOrder.LITTLE_ENDIAN);
    int i = paramArrayOfByte.readInt();
    if (i != 33639248L) {
      h.a("unknown", paramInputStream.available(), "unknown", 0L, "Central Directory Entry", i);
    }
    paramArrayOfByte.seek(8);
    i = paramArrayOfByte.readShort() & 0xFFFF;
    if ((i & 0x1) != 0) {
      throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(i)));
    }
    if ((i & 0x800) != 0) {
      paramCharset = Charset.forName("UTF-8");
    }
    this.ZNv = (paramArrayOfByte.readShort() & 0xFFFF);
    this.time = (paramArrayOfByte.readShort() & 0xFFFF);
    this.ZNw = (paramArrayOfByte.readShort() & 0xFFFF);
    this.crc = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.ZNu = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort() & 0xFFFF;
    int k = paramArrayOfByte.readShort() & 0xFFFF;
    paramArrayOfByte.seek(42);
    this.ZNy = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[i & 0xFFFF];
    f.b(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (dy(paramArrayOfByte)) {
      throw new ZipException("Filename contains NUL byte: " + Arrays.toString(paramArrayOfByte));
    }
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    if (j > 0)
    {
      this.ZNx = new byte[j];
      f.b(paramInputStream, this.ZNx, 0, j);
    }
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      f.b(paramInputStream, paramArrayOfByte, 0, k);
      this.comment = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    }
  }
  
  private static boolean dy(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfByte[i] == 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void aCi(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 8)) {
      throw new IllegalArgumentException("Bad method: ".concat(String.valueOf(paramInt)));
    }
    this.ZNv = paramInt;
  }
  
  /* Error */
  public final Object clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 165	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/tinker/d/a/g
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 50	com/tencent/tinker/d/a/g:ZNx	[B
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 50	com/tencent/tinker/d/a/g:ZNx	[B
    //   19: invokevirtual 167	[B:clone	()Ljava/lang/Object;
    //   22: checkcast 166	[B
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: putfield 50	com/tencent/tinker/d/a/g:ZNx	[B
    //   31: aload_2
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -9 -> 26
    //   38: astore_1
    //   39: new 169	java/lang/AssertionError
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 172	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	g
    //   25	10	1	arrayOfByte	byte[]
    //   38	6	1	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    //   7	25	2	localg	g
    // Exception table:
    //   from	to	target	type
    //   0	26	38	java/lang/CloneNotSupportedException
    //   26	31	38	java/lang/CloneNotSupportedException
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {
      return false;
    }
    return this.name.equals(((g)paramObject).name);
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final long isO()
  {
    return this.crc;
  }
  
  public final void setSize(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bad size: ".concat(String.valueOf(paramLong)));
    }
    this.size = paramLong;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name:" + this.name);
    localStringBuffer.append("\ncomment:" + this.comment);
    localStringBuffer.append("\ntime:" + this.time);
    localStringBuffer.append("\nsize:" + this.size);
    localStringBuffer.append("\ncompressedSize:" + this.ZNu);
    localStringBuffer.append("\ncrc:" + this.crc);
    localStringBuffer.append("\ncompressionMethod:" + this.ZNv);
    localStringBuffer.append("\nmodDate:" + this.ZNw);
    localStringBuffer.append("\nextra length:" + this.ZNx.length);
    localStringBuffer.append("\nlocalHeaderRelOffset:" + this.ZNy);
    localStringBuffer.append("\ndataOffset:" + this.ZNz);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.g
 * JD-Core Version:    0.7.0.1
 */