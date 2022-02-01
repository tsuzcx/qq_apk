package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class g
  implements Cloneable
{
  String CzS;
  long IFC = -1L;
  int IFD = -1;
  int IFE = -1;
  byte[] IFF;
  long IFG = -1L;
  long IFH = -1L;
  public long crc = -1L;
  public String name;
  long size = -1L;
  int tGD = -1;
  
  public g(g paramg)
  {
    this.name = paramg.name;
    this.CzS = paramg.CzS;
    this.tGD = paramg.tGD;
    this.size = paramg.size;
    this.IFC = paramg.IFC;
    this.crc = paramg.crc;
    this.IFD = paramg.IFD;
    this.IFE = paramg.IFE;
    this.IFF = paramg.IFF;
    this.IFG = paramg.IFG;
    this.IFH = paramg.IFH;
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
    this.IFD = (paramArrayOfByte.readShort() & 0xFFFF);
    this.tGD = (paramArrayOfByte.readShort() & 0xFFFF);
    this.IFE = (paramArrayOfByte.readShort() & 0xFFFF);
    this.crc = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.IFC = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort() & 0xFFFF;
    int k = paramArrayOfByte.readShort() & 0xFFFF;
    paramArrayOfByte.seek(42);
    this.IFG = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[i & 0xFFFF];
    f.b(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (cN(paramArrayOfByte)) {
      throw new ZipException("Filename contains NUL byte: " + Arrays.toString(paramArrayOfByte));
    }
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    if (j > 0)
    {
      this.IFF = new byte[j];
      f.b(paramInputStream, this.IFF, 0, j);
    }
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      f.b(paramInputStream, paramArrayOfByte, 0, k);
      this.CzS = new String(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharset);
    }
  }
  
  private static boolean cN(byte[] paramArrayOfByte)
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
    //   9: getfield 50	com/tencent/tinker/d/a/g:IFF	[B
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 50	com/tencent/tinker/d/a/g:IFF	[B
    //   19: invokevirtual 181	[B:clone	()Ljava/lang/Object;
    //   22: checkcast 180	[B
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: putfield 50	com/tencent/tinker/d/a/g:IFF	[B
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
    this.IFD = paramInt;
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
    localStringBuffer.append("\ncomment:" + this.CzS);
    localStringBuffer.append("\ntime:" + this.tGD);
    localStringBuffer.append("\nsize:" + this.size);
    localStringBuffer.append("\ncompressedSize:" + this.IFC);
    localStringBuffer.append("\ncrc:" + this.crc);
    localStringBuffer.append("\ncompressionMethod:" + this.IFD);
    localStringBuffer.append("\nmodDate:" + this.IFE);
    localStringBuffer.append("\nextra length:" + this.IFF.length);
    localStringBuffer.append("\nlocalHeaderRelOffset:" + this.IFG);
    localStringBuffer.append("\ndataOffset:" + this.IFH);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.g
 * JD-Core Version:    0.7.0.1
 */