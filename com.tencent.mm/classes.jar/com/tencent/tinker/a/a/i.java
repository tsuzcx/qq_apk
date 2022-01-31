package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.Adler32;

public final class i
{
  static final short[] wSB = new short[0];
  public ByteBuffer ayD;
  private byte[] lMU = null;
  public final t wSC = new t();
  private final i.f wSD = new i.f(this, (byte)0);
  private final i.g wSE = new i.g(this, (byte)0);
  private final i.h wSF = new i.h(this, (byte)0);
  private final i.d wSG = new i.d(this, (byte)0);
  private final i.b wSH = new i.b(this, (byte)0);
  private final i.c wSI = new i.c(this, (byte)0);
  private final i.a wSJ = new i.a(this, (byte)0);
  private int wSK = 0;
  
  public i(int paramInt)
  {
    this.ayD = ByteBuffer.wrap(new byte[paramInt]);
    this.ayD.order(ByteOrder.LITTLE_ENDIAN);
    this.wSC.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.ayD = ByteBuffer.wrap(d.c(paramInputStream, 0));
    this.ayD.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.wSC;
    i.e locale = a(paramInputStream.wSW);
    byte[] arrayOfByte = locale.JB(8);
    int i = j;
    if (arrayOfByte.length == 8)
    {
      i = j;
      if (arrayOfByte[0] == 100)
      {
        i = j;
        if (arrayOfByte[1] == 101)
        {
          i = j;
          if (arrayOfByte[2] == 120)
          {
            i = j;
            if (arrayOfByte[3] == 10)
            {
              if (arrayOfByte[7] == 0) {
                break label263;
              }
              i = j;
            }
          }
        }
      }
    }
    while (i != 13)
    {
      throw new j("Unexpected magic: " + Arrays.toString(arrayOfByte));
      label263:
      String str = (char)arrayOfByte[4] + (char)arrayOfByte[5] + (char)arrayOfByte[6];
      if (str.equals("036"))
      {
        i = 14;
      }
      else
      {
        i = j;
        if (str.equals("035")) {
          i = 13;
        }
      }
    }
    paramInputStream.eKZ = locale.ayD.getInt();
    paramInputStream.lMU = locale.JB(20);
    paramInputStream.fileSize = locale.ayD.getInt();
    i = locale.ayD.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.ayD.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.wTp = locale.ayD.getInt();
    paramInputStream.wTq = locale.ayD.getInt();
    paramInputStream.wTd.off = locale.ayD.getInt();
    if (paramInputStream.wTd.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.wSX.size = locale.ayD.getInt();
    paramInputStream.wSX.off = locale.ayD.getInt();
    paramInputStream.wSY.size = locale.ayD.getInt();
    paramInputStream.wSY.off = locale.ayD.getInt();
    paramInputStream.wSZ.size = locale.ayD.getInt();
    paramInputStream.wSZ.off = locale.ayD.getInt();
    paramInputStream.wTa.size = locale.ayD.getInt();
    paramInputStream.wTa.off = locale.ayD.getInt();
    paramInputStream.wTb.size = locale.ayD.getInt();
    paramInputStream.wTb.off = locale.ayD.getInt();
    paramInputStream.wTc.size = locale.ayD.getInt();
    paramInputStream.wTc.off = locale.ayD.getInt();
    paramInputStream.wTr = locale.ayD.getInt();
    paramInputStream.wTs = locale.ayD.getInt();
    paramInputStream.a(Jw(paramInputStream.wTd.off));
    paramInputStream.cQx();
  }
  
  private static void gf(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final i.e Jw(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ayD.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.ayD.capacity());
    }
    ByteBuffer localByteBuffer = this.ayD.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.ayD.capacity());
    return new i.e(this, "temp-section", localByteBuffer, (byte)0);
  }
  
  public final int Jx(int paramInt)
  {
    gf(paramInt, this.wSC.wSY.size);
    int i = this.wSC.wSY.off;
    return this.ayD.getInt(i + paramInt * 4);
  }
  
  public final i.e a(t.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.ayD.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.ayD.capacity());
    }
    ByteBuffer localByteBuffer = this.ayD.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.wTv);
    return new i.e(this, "section", localByteBuffer, (byte)0);
  }
  
  public final void cPY()
  {
    Jw(12).write(om(true));
    i.e locale = Jw(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.ayD.duplicate();
    localByteBuffer.limit(localByteBuffer.capacity());
    localByteBuffer.position(12);
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(8192, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      localAdler32.update(arrayOfByte, 0, i);
    }
    locale.writeInt((int)localAdler32.getValue());
  }
  
  public final byte[] om(boolean paramBoolean)
  {
    if ((this.lMU != null) && (!paramBoolean)) {
      return this.lMU;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.ayD.duplicate();
      localByteBuffer.limit(localByteBuffer.capacity());
      localByteBuffer.position(32);
      while (localByteBuffer.hasRemaining())
      {
        int i = Math.min(8192, localByteBuffer.remaining());
        localByteBuffer.get(arrayOfByte2, 0, i);
        localMessageDigest.update(arrayOfByte2, 0, i);
      }
      arrayOfByte1 = localNoSuchAlgorithmException.digest();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
    byte[] arrayOfByte1;
    this.lMU = arrayOfByte1;
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */