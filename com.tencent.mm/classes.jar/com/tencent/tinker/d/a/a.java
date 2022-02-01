package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public final class a
  extends DeflaterOutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final byte[] MEz = { 0 };
  private byte[] MEA = EMPTY_BYTE_ARRAY;
  private final HashSet<String> MEB = new HashSet();
  private int MEC = 8;
  private ByteArrayOutputStream MED = new ByteArrayOutputStream();
  private ZipEntry MEE;
  private long MEF = 0L;
  private int MEG;
  private byte[] MEH;
  private final int MEI = 4;
  private boolean bWS = false;
  private boolean closed = false;
  private int compressionLevel = -1;
  private final CRC32 crc = new CRC32();
  private int offset = 0;
  private int padding = 0;
  
  public a(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private a(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream, new Deflater(-1, true));
  }
  
  private static long c(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private static void c(OutputStream paramOutputStream, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      while (i > 0)
      {
        paramOutputStream.write(0);
        i -= 1;
      }
    }
  }
  
  private static int d(OutputStream paramOutputStream, int paramInt)
  {
    if (paramInt > 65535) {
      throw new IllegalArgumentException("value " + paramInt + " is too large for type 'short'.");
    }
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private void gdc()
  {
    if (this.closed) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void close()
  {
    if (!this.closed)
    {
      finish();
      this.def.end();
      this.out.close();
      this.out = null;
      this.closed = true;
    }
  }
  
  public final void closeEntry()
  {
    gdc();
    if (this.MEE == null) {
      return;
    }
    if (this.MEE.getMethod() == 8) {
      super.finish();
    }
    if (this.MEE.getMethod() == 0)
    {
      if (this.crc.getValue() != this.MEE.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.MEE.getSize() != this.MEF) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.MEE.getMethod() != 0)
    {
      i = 46;
      c(this.out, 134695760L);
      this.MEE.setCrc(this.crc.getValue());
      c(this.out, this.MEE.getCrc());
      this.MEE.setCompressedSize(this.def.getTotalOut());
      c(this.out, this.MEE.getCompressedSize());
      this.MEE.setSize(this.def.getTotalIn());
      c(this.out, this.MEE.getSize());
    }
    int j;
    if (this.MEE.getMethod() == 0)
    {
      j = 0;
      c(this.MED, 33639248L);
      d(this.MED, 20);
      d(this.MED, 20);
      d(this.MED, j | 0x800);
      d(this.MED, this.MEE.getMethod());
      d(this.MED, 0);
      d(this.MED, 33);
      c(this.MED, this.crc.getValue());
      if (this.MEE.getMethod() != 8) {
        break label587;
      }
      i = (int)(i + c(this.MED, this.def.getTotalOut()));
      c(this.MED, this.def.getTotalIn());
      label360:
      i += d(this.MED, this.MEG);
      if (this.MEE.getExtra() == null) {
        break label618;
      }
      i += d(this.MED, this.MEE.getExtra().length);
    }
    for (;;)
    {
      String str = this.MEE.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.MED, arrayOfByte.length);
      d(this.MED, 0);
      d(this.MED, 0);
      c(this.MED, 0L);
      c(this.MED, this.offset);
      this.MED.write(this.MEH);
      this.MEH = null;
      if (this.MEE.getExtra() != null) {
        this.MED.write(this.MEE.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.MED.write(arrayOfByte);
      }
      this.MEE = null;
      this.crc.reset();
      this.MEF = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label587:
      i = (int)(i + c(this.MED, this.MEF));
      c(this.MED, this.MEF);
      break label360;
      label618:
      d(this.MED, 0);
    }
  }
  
  public final void finish()
  {
    gdc();
    if (this.bWS) {
      return;
    }
    if (this.MEB.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.MEE != null) {
      closeEntry();
    }
    int i = this.MED.size();
    c(this.MED, 101010256L);
    d(this.MED, 0);
    d(this.MED, 0);
    d(this.MED, this.MEB.size());
    d(this.MED, this.MEB.size());
    c(this.MED, i);
    c(this.MED, this.offset + this.padding);
    d(this.MED, this.MEA.length);
    if (this.MEA.length > 0) {
      this.MED.write(this.MEA);
    }
    this.MED.writeTo(this.out);
    this.MED = null;
    this.bWS = true;
  }
  
  public final void putNextEntry(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.MEE != null) {
      closeEntry();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.MEC;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramZipEntry.getCompressedSize() == -1L) {
          paramZipEntry.setCompressedSize(paramZipEntry.getSize());
        }
        while (paramZipEntry.getCrc() == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramZipEntry.getSize() == -1L) {
            paramZipEntry.setSize(paramZipEntry.getCompressedSize());
          }
        }
        if (paramZipEntry.getSize() == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramZipEntry.getSize() != paramZipEntry.getCompressedSize()) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      gdc();
      if (this.MEB.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.MEB.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.MEH = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.MEG = this.MEH.length;
      if (this.MEG > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.MEG + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.MEE = paramZipEntry;
      this.MEB.add(this.MEE.getName());
      int j;
      label454:
      int m;
      int n;
      if (i == 0)
      {
        j = 0;
        c(this.out, 67324752L);
        d(this.out, 20);
        d(this.out, j | 0x800);
        d(this.out, i);
        if (this.MEE.getTime() == -1L) {
          this.MEE.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label609;
        }
        c(this.out, this.MEE.getCrc());
        c(this.out, this.MEE.getSize());
        c(this.out, this.MEE.getSize());
        d(this.out, this.MEG);
        m = this.offset;
        n = this.MEG;
        if (this.MEE.getExtra() == null) {
          break label639;
        }
        i = this.MEE.getExtra().length;
        label497:
        j = k;
        if (this.MEE.getMethod() == 0)
        {
          if (this.MEI != 0) {
            break label644;
          }
          j = k;
        }
        label520:
        this.padding = j;
        if (this.MEE.getExtra() == null) {
          break label672;
        }
        d(this.out, this.MEE.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.MEH);
        if (this.MEE.getExtra() != null) {
          this.out.write(this.MEE.getExtra());
        }
        c(this.out, this.padding);
        return;
        j = 8;
        break;
        label609:
        c(this.out, 0L);
        c(this.out, 0L);
        c(this.out, 0L);
        break label454;
        label639:
        i = 0;
        break label497;
        label644:
        j = this.MEI;
        j = (j - (i + (n + (m + 30))) % j) % this.MEI;
        break label520;
        label672:
        d(this.out, this.padding);
      }
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = MEz;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.MEE == null) {
      throw new ZipException("No active entry");
    }
    if (this.MEE.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.MEF += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */