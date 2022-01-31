package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile
  implements Closeable
{
  private final FileInputStream wYu;
  private final Map<String, SectionHeader> wYv = new HashMap();
  public ElfHeader wYw = null;
  public ProgramHeader[] wYx = null;
  public SectionHeader[] wYy = null;
  
  public ShareElfFile(File paramFile)
  {
    this.wYu = new FileInputStream(paramFile);
    Object localObject = this.wYu.getChannel();
    this.wYw = new ElfHeader((FileChannel)localObject, (byte)0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.wYw.wYI);
    if (this.wYw.wYz[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.wYw.wYE);
      this.wYx = new ProgramHeader[this.wYw.wYJ];
      i = 0;
      while (i < this.wYx.length)
      {
        a((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.wYx[i] = new ProgramHeader(localByteBuffer, this.wYw.wYz[4], 0);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.wYw.wYF);
    localByteBuffer.limit(this.wYw.wYK);
    this.wYy = new SectionHeader[this.wYw.wYL];
    int i = 0;
    while (i < this.wYy.length)
    {
      a((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.wYy[i] = new SectionHeader(localByteBuffer, this.wYw.wYz[4], 0);
      i += 1;
    }
    if (this.wYw.wYM > 0)
    {
      localObject = this.wYy[this.wYw.wYM];
      paramFile = ByteBuffer.allocate((int)((SectionHeader)localObject).wZa);
      this.wYu.getChannel().position(((SectionHeader)localObject).wYZ);
      a(this.wYu.getChannel(), paramFile, "failed to read section: " + ((SectionHeader)localObject).wZf);
      localObject = this.wYy;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.wYV);
        localByteBuffer.wZf = D(paramFile);
        this.wYv.put(localByteBuffer.wZf, localByteBuffer);
        i += 1;
      }
    }
  }
  
  private static String D(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  /* Error */
  public static int ac(File paramFile)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: astore_3
    //   4: new 46	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_3
    //   15: invokevirtual 226	java/io/InputStream:read	([B)I
    //   18: pop
    //   19: aload_3
    //   20: iconst_0
    //   21: baload
    //   22: bipush 100
    //   24: if_icmpne +35 -> 59
    //   27: aload_3
    //   28: iconst_1
    //   29: baload
    //   30: bipush 101
    //   32: if_icmpne +27 -> 59
    //   35: aload_3
    //   36: iconst_2
    //   37: baload
    //   38: bipush 121
    //   40: if_icmpne +19 -> 59
    //   43: aload_3
    //   44: iconst_3
    //   45: baload
    //   46: istore_1
    //   47: iload_1
    //   48: bipush 10
    //   50: if_icmpne +9 -> 59
    //   53: aload_2
    //   54: invokevirtual 229	java/io/InputStream:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_3
    //   60: iconst_0
    //   61: baload
    //   62: bipush 127
    //   64: if_icmpne +33 -> 97
    //   67: aload_3
    //   68: iconst_1
    //   69: baload
    //   70: bipush 69
    //   72: if_icmpne +25 -> 97
    //   75: aload_3
    //   76: iconst_2
    //   77: baload
    //   78: bipush 76
    //   80: if_icmpne +17 -> 97
    //   83: aload_3
    //   84: iconst_3
    //   85: baload
    //   86: bipush 70
    //   88: if_icmpne +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 229	java/io/InputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 229	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 229	java/io/InputStream:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: goto -25 -> 95
    //   123: astore_0
    //   124: goto -23 -> 101
    //   127: astore_2
    //   128: goto -14 -> 114
    //   131: astore_0
    //   132: goto -26 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   46	5	1	i	int
    //   12	99	2	localFileInputStream	FileInputStream
    //   127	1	2	localThrowable	java.lang.Throwable
    //   3	81	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	13	103	finally
    //   53	57	116	java/lang/Throwable
    //   91	95	119	java/lang/Throwable
    //   97	101	123	java/lang/Throwable
    //   110	114	127	java/lang/Throwable
    //   13	19	131	finally
  }
  
  public void close()
  {
    this.wYu.close();
    this.wYv.clear();
    this.wYx = null;
    this.wYy = null;
  }
  
  public static class ElfHeader
  {
    public final short wYA;
    public final short wYB;
    public final int wYC;
    public final long wYD;
    public final long wYE;
    public final long wYF;
    public final int wYG;
    public final short wYH;
    public final short wYI;
    public final short wYJ;
    public final short wYK;
    public final short wYL;
    public final short wYM;
    public final byte[] wYz = new byte[16];
    
    private ElfHeader(FileChannel paramFileChannel)
    {
      paramFileChannel.position(0L);
      paramFileChannel.read(ByteBuffer.wrap(this.wYz));
      if ((this.wYz[0] != 127) || (this.wYz[1] != 69) || (this.wYz[2] != 76) || (this.wYz[3] != 70)) {
        throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.wYz[0]), Byte.valueOf(this.wYz[1]), Byte.valueOf(this.wYz[2]), Byte.valueOf(this.wYz[3]) }));
      }
      ShareElfFile.z(this.wYz[4], 2, "bad elf class: " + this.wYz[4]);
      ShareElfFile.z(this.wYz[5], 2, "bad elf data encoding: " + this.wYz[5]);
      int i;
      label214:
      ByteBuffer localByteBuffer;
      if (this.wYz[4] == 1)
      {
        i = 36;
        localByteBuffer = ByteBuffer.allocate(i);
        if (this.wYz[5] != 1) {
          break label367;
        }
      }
      label367:
      for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
      {
        localByteBuffer.order(localByteOrder);
        ShareElfFile.a(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
        this.wYA = localByteBuffer.getShort();
        this.wYB = localByteBuffer.getShort();
        this.wYC = localByteBuffer.getInt();
        ShareElfFile.z(this.wYC, 1, "bad elf version: " + this.wYC);
        switch (this.wYz[4])
        {
        default: 
          throw new IOException("Unexpected elf class: " + this.wYz[4]);
          i = 48;
          break label214;
        }
      }
      this.wYD = localByteBuffer.getInt();
      this.wYE = localByteBuffer.getInt();
      for (this.wYF = localByteBuffer.getInt();; this.wYF = localByteBuffer.getLong())
      {
        this.wYG = localByteBuffer.getInt();
        this.wYH = localByteBuffer.getShort();
        this.wYI = localByteBuffer.getShort();
        this.wYJ = localByteBuffer.getShort();
        this.wYK = localByteBuffer.getShort();
        this.wYL = localByteBuffer.getShort();
        this.wYM = localByteBuffer.getShort();
        return;
        this.wYD = localByteBuffer.getLong();
        this.wYE = localByteBuffer.getLong();
      }
    }
  }
  
  public static class ProgramHeader
  {
    public final int wYN;
    public final int wYO;
    public final long wYP;
    public final long wYQ;
    public final long wYR;
    public final long wYS;
    public final long wYT;
    public final long wYU;
    
    private ProgramHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.wYN = paramByteBuffer.getInt();
        this.wYP = paramByteBuffer.getInt();
        this.wYQ = paramByteBuffer.getInt();
        this.wYR = paramByteBuffer.getInt();
        this.wYS = paramByteBuffer.getInt();
        this.wYT = paramByteBuffer.getInt();
        this.wYO = paramByteBuffer.getInt();
        this.wYU = paramByteBuffer.getInt();
        return;
      }
      this.wYN = paramByteBuffer.getInt();
      this.wYO = paramByteBuffer.getInt();
      this.wYP = paramByteBuffer.getLong();
      this.wYQ = paramByteBuffer.getLong();
      this.wYR = paramByteBuffer.getLong();
      this.wYS = paramByteBuffer.getLong();
      this.wYT = paramByteBuffer.getLong();
      this.wYU = paramByteBuffer.getLong();
    }
  }
  
  public static class SectionHeader
  {
    public final int wYV;
    public final int wYW;
    public final long wYX;
    public final long wYY;
    public final long wYZ;
    public final long wZa;
    public final int wZb;
    public final int wZc;
    public final long wZd;
    public final long wZe;
    public String wZf;
    
    private SectionHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.wYV = paramByteBuffer.getInt();
        this.wYW = paramByteBuffer.getInt();
        this.wYX = paramByteBuffer.getInt();
        this.wYY = paramByteBuffer.getInt();
        this.wYZ = paramByteBuffer.getInt();
        this.wZa = paramByteBuffer.getInt();
        this.wZb = paramByteBuffer.getInt();
        this.wZc = paramByteBuffer.getInt();
        this.wZd = paramByteBuffer.getInt();
      }
      for (this.wZe = paramByteBuffer.getInt();; this.wZe = paramByteBuffer.getLong())
      {
        this.wZf = null;
        return;
        this.wYV = paramByteBuffer.getInt();
        this.wYW = paramByteBuffer.getInt();
        this.wYX = paramByteBuffer.getLong();
        this.wYY = paramByteBuffer.getLong();
        this.wYZ = paramByteBuffer.getLong();
        this.wZa = paramByteBuffer.getLong();
        this.wZb = paramByteBuffer.getInt();
        this.wZc = paramByteBuffer.getInt();
        this.wZd = paramByteBuffer.getLong();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareElfFile
 * JD-Core Version:    0.7.0.1
 */