package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class g
  implements Cloneable
{
  String FxH;
  long MhO = -1L;
  int MhP = -1;
  int MhQ = -1;
  byte[] MhR;
  long MhS = -1L;
  long MhT = -1L;
  public long crc = -1L;
  int hbR = -1;
  public String name;
  long size = -1L;
  
  public g(g paramg)
  {
    this.name = paramg.name;
    this.FxH = paramg.FxH;
    this.hbR = paramg.hbR;
    this.size = paramg.size;
    this.MhO = paramg.MhO;
    this.crc = paramg.crc;
    this.MhP = paramg.MhP;
    this.MhQ = paramg.MhQ;
    this.MhR = paramg.MhR;
    this.MhS = paramg.MhS;
    this.MhT = paramg.MhT;
  }
  
  public g(String paramString)
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
    this.MhP = (paramArrayOfByte.readShort() & 0xFFFF);
    this.hbR = (paramArrayOfByte.readShort() & 0xFFFF);
    this.MhQ = (paramArrayOfByte.readShort() & 0xFFFF);
    this.crc = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.MhO = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort() & 0xFFFF;
    int k = paramArrayOfByte.readShort() & 0xFFFF;
    paramArrayOfByte.seek(42);
    this.MhS = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[i & 0xFFFF];
    f.b(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (cT(paramArrayOfByte)) {
      throw new ZipException("Filename contains NUL byte: " + Arrays.toString(paramArrayOfByte));
    }
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    if (j > 0)
    {
      this.MhR = new byte[j];
      f.b(paramInputStream, this.MhR, 0, j);
    }
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      f.b(paramInputStream, paramArrayOfByte, 0, k);
      this.FxH = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    }
  }
  
  private static boolean cT(byte[] paramArrayOfByte)
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
    //   1: invokespecial 179	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/tinker/d/a/g
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 50	com/tencent/tinker/d/a/g:MhR	[B
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 50	com/tencent/tinker/d/a/g:MhR	[B
    //   19: invokevirtual 181	[B:clone	()Ljava/lang/Object;
    //   22: checkcast 180	[B
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: putfield 50	com/tencent/tinker/d/a/g:MhR	[B
    //   31: aload_2
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -9 -> 26
    //   38: astore_1
    //   39: new 183	java/lang/AssertionError
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 186	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
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
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final void setMethod(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 8)) {
      throw new IllegalArgumentException("Bad method: ".concat(String.valueOf(paramInt)));
    }
    this.MhP = paramInt;
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
    localStringBuffer.append("\ncomment:" + this.FxH);
    localStringBuffer.append("\ntime:" + this.hbR);
    localStringBuffer.append("\nsize:" + this.size);
    localStringBuffer.append("\ncompressedSize:" + this.MhO);
    localStringBuffer.append("\ncrc:" + this.crc);
    localStringBuffer.append("\ncompressionMethod:" + this.MhP);
    localStringBuffer.append("\nmodDate:" + this.MhQ);
    localStringBuffer.append("\nextra length:" + this.MhR.length);
    localStringBuffer.append("\nlocalHeaderRelOffset:" + this.MhS);
    localStringBuffer.append("\ndataOffset:" + this.MhT);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.g
 * JD-Core Version:    0.7.0.1
 */