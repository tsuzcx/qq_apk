package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f
  implements Cloneable
{
  public long Bwi = -1L;
  long Bwt = -1L;
  int Bwu = -1;
  int Bwv = -1;
  byte[] Bww;
  long Bwx = -1L;
  long Bwy = -1L;
  public String name;
  int oLs = -1;
  long size = -1L;
  String wqH;
  
  public f(f paramf)
  {
    this.name = paramf.name;
    this.wqH = paramf.wqH;
    this.oLs = paramf.oLs;
    this.size = paramf.size;
    this.Bwt = paramf.Bwt;
    this.Bwi = paramf.Bwi;
    this.Bwu = paramf.Bwu;
    this.Bwv = paramf.Bwv;
    this.Bww = paramf.Bww;
    this.Bwx = paramf.Bwx;
    this.Bwy = paramf.Bwy;
  }
  
  public f(f paramf, String paramString)
  {
    this.name = paramString;
    this.wqH = paramf.wqH;
    this.oLs = paramf.oLs;
    this.size = paramf.size;
    this.Bwt = paramf.Bwt;
    this.Bwi = paramf.Bwi;
    this.Bwu = paramf.Bwu;
    this.Bwv = paramf.Bwv;
    this.Bww = paramf.Bww;
    this.Bwx = paramf.Bwx;
    this.Bwy = paramf.Bwy;
  }
  
  public f(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    byte[] arrayOfByte = paramString.getBytes(Charset.forName("UTF-8"));
    if (arrayOfByte.length > 65535) {
      throw new IllegalArgumentException("Name" + " too long: " + arrayOfByte.length);
    }
    this.name = paramString;
  }
  
  f(byte[] paramArrayOfByte, InputStream paramInputStream, Charset paramCharset)
  {
    e.b(paramInputStream, paramArrayOfByte, 0, 46);
    paramArrayOfByte = c.a(paramArrayOfByte, 46, ByteOrder.LITTLE_ENDIAN);
    int i = paramArrayOfByte.readInt();
    if (i != 33639248L) {
      g.a("unknown", paramInputStream.available(), "unknown", 0L, "Central Directory Entry", i);
    }
    paramArrayOfByte.seek(8);
    i = paramArrayOfByte.readShort() & 0xFFFF;
    if ((i & 0x1) != 0) {
      throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(i)));
    }
    if ((i & 0x800) != 0) {
      paramCharset = Charset.forName("UTF-8");
    }
    this.Bwu = (paramArrayOfByte.readShort() & 0xFFFF);
    this.oLs = (paramArrayOfByte.readShort() & 0xFFFF);
    this.Bwv = (paramArrayOfByte.readShort() & 0xFFFF);
    this.Bwi = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.Bwt = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort() & 0xFFFF;
    int k = paramArrayOfByte.readShort() & 0xFFFF;
    paramArrayOfByte.seek(42);
    this.Bwx = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[i & 0xFFFF];
    e.b(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (cu(paramArrayOfByte)) {
      throw new ZipException("Filename contains NUL byte: " + Arrays.toString(paramArrayOfByte));
    }
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    if (j > 0)
    {
      this.Bww = new byte[j];
      e.b(paramInputStream, this.Bww, 0, j);
    }
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      e.b(paramInputStream, paramArrayOfByte, 0, k);
      this.wqH = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    }
  }
  
  private static boolean cu(byte[] paramArrayOfByte)
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
  
  /* Error */
  public final Object clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 180	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/tinker/d/a/f
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 50	com/tencent/tinker/d/a/f:Bww	[B
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 50	com/tencent/tinker/d/a/f:Bww	[B
    //   19: invokevirtual 182	[B:clone	()Ljava/lang/Object;
    //   22: checkcast 181	[B
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: putfield 50	com/tencent/tinker/d/a/f:Bww	[B
    //   31: aload_2
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -9 -> 26
    //   38: astore_1
    //   39: new 184	java/lang/AssertionError
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 187	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	f
    //   25	10	1	arrayOfByte	byte[]
    //   38	6	1	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    //   7	25	2	localf	f
    // Exception table:
    //   from	to	target	type
    //   0	26	38	java/lang/CloneNotSupportedException
    //   26	31	38	java/lang/CloneNotSupportedException
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    return this.name.equals(((f)paramObject).name);
  }
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final void setMethod(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 8)) {
      throw new IllegalArgumentException("Bad method: ".concat(String.valueOf(paramInt)));
    }
    this.Bwu = paramInt;
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
    localStringBuffer.append("\ncomment:" + this.wqH);
    localStringBuffer.append("\ntime:" + this.oLs);
    localStringBuffer.append("\nsize:" + this.size);
    localStringBuffer.append("\ncompressedSize:" + this.Bwt);
    localStringBuffer.append("\ncrc:" + this.Bwi);
    localStringBuffer.append("\ncompressionMethod:" + this.Bwu);
    localStringBuffer.append("\nmodDate:" + this.Bwv);
    localStringBuffer.append("\nextra length:" + this.Bww.length);
    localStringBuffer.append("\nlocalHeaderRelOffset:" + this.Bwx);
    localStringBuffer.append("\ndataOffset:" + this.Bwy);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.f
 * JD-Core Version:    0.7.0.1
 */