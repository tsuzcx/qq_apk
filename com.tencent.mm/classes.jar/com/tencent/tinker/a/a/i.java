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
  static final short[] Bpi = new short[0];
  public final t Bpj = new t();
  private final i.f Bpk = new i.f(this, (byte)0);
  private final i.g Bpl = new i.g(this, (byte)0);
  private final i.h Bpm = new i.h(this, (byte)0);
  private final i.d Bpn = new i.d(this, (byte)0);
  private final i.b Bpo = new i.b(this, (byte)0);
  private final i.c Bpp = new i.c(this, (byte)0);
  private final i.a Bpq = new i.a(this, (byte)0);
  private int Bpr = 0;
  public ByteBuffer aAS;
  private byte[] okn = null;
  
  public i(int paramInt)
  {
    this.aAS = ByteBuffer.wrap(new byte[paramInt]);
    this.aAS.order(ByteOrder.LITTLE_ENDIAN);
    this.Bpj.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aAS = ByteBuffer.wrap(d.c(paramInputStream, 0));
    this.aAS.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.Bpj;
    i.e locale = a(paramInputStream.BpD);
    byte[] arrayOfByte = locale.Sw(8);
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
    paramInputStream.gaG = locale.aAS.getInt();
    paramInputStream.okn = locale.Sw(20);
    paramInputStream.fileSize = locale.aAS.getInt();
    i = locale.aAS.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aAS.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.BpW = locale.aAS.getInt();
    paramInputStream.BpX = locale.aAS.getInt();
    paramInputStream.BpK.off = locale.aAS.getInt();
    if (paramInputStream.BpK.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.BpE.size = locale.aAS.getInt();
    paramInputStream.BpE.off = locale.aAS.getInt();
    paramInputStream.BpF.size = locale.aAS.getInt();
    paramInputStream.BpF.off = locale.aAS.getInt();
    paramInputStream.BpG.size = locale.aAS.getInt();
    paramInputStream.BpG.off = locale.aAS.getInt();
    paramInputStream.BpH.size = locale.aAS.getInt();
    paramInputStream.BpH.off = locale.aAS.getInt();
    paramInputStream.BpI.size = locale.aAS.getInt();
    paramInputStream.BpI.off = locale.aAS.getInt();
    paramInputStream.BpJ.size = locale.aAS.getInt();
    paramInputStream.BpJ.off = locale.aAS.getInt();
    paramInputStream.lsT = locale.aAS.getInt();
    paramInputStream.BpY = locale.aAS.getInt();
    paramInputStream.a(Sr(paramInputStream.BpK.off));
    paramInputStream.dWl();
  }
  
  private static void in(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final i.e Sr(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aAS.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aAS.capacity());
    }
    ByteBuffer localByteBuffer = this.aAS.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aAS.capacity());
    return new i.e(this, "temp-section", localByteBuffer, (byte)0);
  }
  
  public final int Ss(int paramInt)
  {
    in(paramInt, this.Bpj.BpF.size);
    int i = this.Bpj.BpF.off;
    return this.aAS.getInt(i + paramInt * 4);
  }
  
  public final i.e a(t.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aAS.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aAS.capacity());
    }
    ByteBuffer localByteBuffer = this.aAS.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new i.e(this, "section", localByteBuffer, (byte)0);
  }
  
  public final void dVM()
  {
    Sr(12).write(rY(true));
    i.e locale = Sr(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aAS.duplicate();
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
  
  public final byte[] rY(boolean paramBoolean)
  {
    if ((this.okn != null) && (!paramBoolean)) {
      return this.okn;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aAS.duplicate();
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
    this.okn = arrayOfByte1;
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */