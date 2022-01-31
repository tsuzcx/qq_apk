package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f
  implements Cloneable
{
  public String name;
  long size = -1L;
  String tIg;
  int time = -1;
  public long wZD = -1L;
  long wZN = -1L;
  int wZO = -1;
  int wZP = -1;
  byte[] wZQ;
  long wZR = -1L;
  long wZS = -1L;
  
  public f(f paramf)
  {
    this.name = paramf.name;
    this.tIg = paramf.tIg;
    this.time = paramf.time;
    this.size = paramf.size;
    this.wZN = paramf.wZN;
    this.wZD = paramf.wZD;
    this.wZO = paramf.wZO;
    this.wZP = paramf.wZP;
    this.wZQ = paramf.wZQ;
    this.wZR = paramf.wZR;
    this.wZS = paramf.wZS;
  }
  
  public f(f paramf, String paramString)
  {
    this.name = paramString;
    this.tIg = paramf.tIg;
    this.time = paramf.time;
    this.size = paramf.size;
    this.wZN = paramf.wZN;
    this.wZD = paramf.wZD;
    this.wZO = paramf.wZO;
    this.wZP = paramf.wZP;
    this.wZQ = paramf.wZQ;
    this.wZR = paramf.wZR;
    this.wZS = paramf.wZS;
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
      throw new ZipException("Invalid General Purpose Bit Flag: " + i);
    }
    if ((i & 0x800) != 0) {
      paramCharset = Charset.forName("UTF-8");
    }
    this.wZO = (paramArrayOfByte.readShort() & 0xFFFF);
    this.time = (paramArrayOfByte.readShort() & 0xFFFF);
    this.wZP = (paramArrayOfByte.readShort() & 0xFFFF);
    this.wZD = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.wZN = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort() & 0xFFFF;
    int k = paramArrayOfByte.readShort() & 0xFFFF;
    paramArrayOfByte.seek(42);
    this.wZR = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[i & 0xFFFF];
    e.b(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (bT(paramArrayOfByte)) {
      throw new ZipException("Filename contains NUL byte: " + Arrays.toString(paramArrayOfByte));
    }
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    if (j > 0)
    {
      this.wZQ = new byte[j];
      e.b(paramInputStream, this.wZQ, 0, j);
    }
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      e.b(paramInputStream, paramArrayOfByte, 0, k);
      this.tIg = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    }
  }
  
  private static boolean bT(byte[] paramArrayOfByte)
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
    //   1: invokespecial 172	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/tinker/d/a/f
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 50	com/tencent/tinker/d/a/f:wZQ	[B
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 50	com/tencent/tinker/d/a/f:wZQ	[B
    //   19: invokevirtual 174	[B:clone	()Ljava/lang/Object;
    //   22: checkcast 173	[B
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: putfield 50	com/tencent/tinker/d/a/f:wZQ	[B
    //   31: aload_2
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -9 -> 26
    //   38: astore_1
    //   39: new 176	java/lang/AssertionError
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 179	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
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
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final void setMethod(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 8)) {
      throw new IllegalArgumentException("Bad method: " + paramInt);
    }
    this.wZO = paramInt;
  }
  
  public final void setSize(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bad size: " + paramLong);
    }
    this.size = paramLong;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name:" + this.name);
    localStringBuffer.append("\ncomment:" + this.tIg);
    localStringBuffer.append("\ntime:" + this.time);
    localStringBuffer.append("\nsize:" + this.size);
    localStringBuffer.append("\ncompressedSize:" + this.wZN);
    localStringBuffer.append("\ncrc:" + this.wZD);
    localStringBuffer.append("\ncompressionMethod:" + this.wZO);
    localStringBuffer.append("\nmodDate:" + this.wZP);
    localStringBuffer.append("\nextra length:" + this.wZQ.length);
    localStringBuffer.append("\nlocalHeaderRelOffset:" + this.wZR);
    localStringBuffer.append("\ndataOffset:" + this.wZS);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.f
 * JD-Core Version:    0.7.0.1
 */