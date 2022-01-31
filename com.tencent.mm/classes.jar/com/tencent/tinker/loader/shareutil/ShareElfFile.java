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
  private final FileInputStream BuY;
  private final Map<String, SectionHeader> BuZ = new HashMap();
  public ElfHeader Bva = null;
  public ProgramHeader[] Bvb = null;
  public SectionHeader[] Bvc = null;
  
  public ShareElfFile(File paramFile)
  {
    this.BuY = new FileInputStream(paramFile);
    Object localObject = this.BuY.getChannel();
    this.Bva = new ElfHeader((FileChannel)localObject, (byte)0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.Bva.Bvm);
    if (this.Bva.Bvd[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.Bva.Bvi);
      this.Bvb = new ProgramHeader[this.Bva.Bvn];
      i = 0;
      while (i < this.Bvb.length)
      {
        a((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.Bvb[i] = new ProgramHeader(localByteBuffer, this.Bva.Bvd[4], 0);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.Bva.Bvj);
    localByteBuffer.limit(this.Bva.Bvo);
    this.Bvc = new SectionHeader[this.Bva.Bvp];
    int i = 0;
    while (i < this.Bvc.length)
    {
      a((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.Bvc[i] = new SectionHeader(localByteBuffer, this.Bva.Bvd[4], 0);
      i += 1;
    }
    if (this.Bva.Bvq > 0)
    {
      localObject = this.Bvc[this.Bva.Bvq];
      paramFile = ByteBuffer.allocate((int)((SectionHeader)localObject).BvE);
      this.BuY.getChannel().position(((SectionHeader)localObject).BvD);
      a(this.BuY.getChannel(), paramFile, "failed to read section: " + ((SectionHeader)localObject).BvJ);
      localObject = this.Bvc;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.Bvz);
        localByteBuffer.BvJ = G(paramFile);
        this.BuZ.put(localByteBuffer.BvJ, localByteBuffer);
        i += 1;
      }
    }
  }
  
  private static String G(ByteBuffer paramByteBuffer)
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
  public static int al(File paramFile)
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
    //   15: invokevirtual 227	java/io/InputStream:read	([B)I
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
    //   54: invokevirtual 230	java/io/InputStream:close	()V
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
    //   92: invokevirtual 230	java/io/InputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 230	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 230	java/io/InputStream:close	()V
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
    this.BuY.close();
    this.BuZ.clear();
    this.Bvb = null;
    this.Bvc = null;
  }
  
  public static class ElfHeader
  {
    public final byte[] Bvd = new byte[16];
    public final short Bve;
    public final short Bvf;
    public final int Bvg;
    public final long Bvh;
    public final long Bvi;
    public final long Bvj;
    public final int Bvk;
    public final short Bvl;
    public final short Bvm;
    public final short Bvn;
    public final short Bvo;
    public final short Bvp;
    public final short Bvq;
    
    private ElfHeader(FileChannel paramFileChannel)
    {
      paramFileChannel.position(0L);
      paramFileChannel.read(ByteBuffer.wrap(this.Bvd));
      if ((this.Bvd[0] != 127) || (this.Bvd[1] != 69) || (this.Bvd[2] != 76) || (this.Bvd[3] != 70)) {
        throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.Bvd[0]), Byte.valueOf(this.Bvd[1]), Byte.valueOf(this.Bvd[2]), Byte.valueOf(this.Bvd[3]) }));
      }
      ShareElfFile.G(this.Bvd[4], 2, "bad elf class: " + this.Bvd[4]);
      ShareElfFile.G(this.Bvd[5], 2, "bad elf data encoding: " + this.Bvd[5]);
      int i;
      label214:
      ByteBuffer localByteBuffer;
      if (this.Bvd[4] == 1)
      {
        i = 36;
        localByteBuffer = ByteBuffer.allocate(i);
        if (this.Bvd[5] != 1) {
          break label367;
        }
      }
      label367:
      for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
      {
        localByteBuffer.order(localByteOrder);
        ShareElfFile.a(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
        this.Bve = localByteBuffer.getShort();
        this.Bvf = localByteBuffer.getShort();
        this.Bvg = localByteBuffer.getInt();
        ShareElfFile.G(this.Bvg, 1, "bad elf version: " + this.Bvg);
        switch (this.Bvd[4])
        {
        default: 
          throw new IOException("Unexpected elf class: " + this.Bvd[4]);
          i = 48;
          break label214;
        }
      }
      this.Bvh = localByteBuffer.getInt();
      this.Bvi = localByteBuffer.getInt();
      for (this.Bvj = localByteBuffer.getInt();; this.Bvj = localByteBuffer.getLong())
      {
        this.Bvk = localByteBuffer.getInt();
        this.Bvl = localByteBuffer.getShort();
        this.Bvm = localByteBuffer.getShort();
        this.Bvn = localByteBuffer.getShort();
        this.Bvo = localByteBuffer.getShort();
        this.Bvp = localByteBuffer.getShort();
        this.Bvq = localByteBuffer.getShort();
        return;
        this.Bvh = localByteBuffer.getLong();
        this.Bvi = localByteBuffer.getLong();
      }
    }
  }
  
  public static class ProgramHeader
  {
    public final int Bvr;
    public final int Bvs;
    public final long Bvt;
    public final long Bvu;
    public final long Bvv;
    public final long Bvw;
    public final long Bvx;
    public final long Bvy;
    
    private ProgramHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: ".concat(String.valueOf(paramInt)));
      case 1: 
        this.Bvr = paramByteBuffer.getInt();
        this.Bvt = paramByteBuffer.getInt();
        this.Bvu = paramByteBuffer.getInt();
        this.Bvv = paramByteBuffer.getInt();
        this.Bvw = paramByteBuffer.getInt();
        this.Bvx = paramByteBuffer.getInt();
        this.Bvs = paramByteBuffer.getInt();
        this.Bvy = paramByteBuffer.getInt();
        return;
      }
      this.Bvr = paramByteBuffer.getInt();
      this.Bvs = paramByteBuffer.getInt();
      this.Bvt = paramByteBuffer.getLong();
      this.Bvu = paramByteBuffer.getLong();
      this.Bvv = paramByteBuffer.getLong();
      this.Bvw = paramByteBuffer.getLong();
      this.Bvx = paramByteBuffer.getLong();
      this.Bvy = paramByteBuffer.getLong();
    }
  }
  
  public static class SectionHeader
  {
    public final int BvA;
    public final long BvB;
    public final long BvC;
    public final long BvD;
    public final long BvE;
    public final int BvF;
    public final int BvG;
    public final long BvH;
    public final long BvI;
    public String BvJ;
    public final int Bvz;
    
    private SectionHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: ".concat(String.valueOf(paramInt)));
      case 1: 
        this.Bvz = paramByteBuffer.getInt();
        this.BvA = paramByteBuffer.getInt();
        this.BvB = paramByteBuffer.getInt();
        this.BvC = paramByteBuffer.getInt();
        this.BvD = paramByteBuffer.getInt();
        this.BvE = paramByteBuffer.getInt();
        this.BvF = paramByteBuffer.getInt();
        this.BvG = paramByteBuffer.getInt();
        this.BvH = paramByteBuffer.getInt();
      }
      for (this.BvI = paramByteBuffer.getInt();; this.BvI = paramByteBuffer.getLong())
      {
        this.BvJ = null;
        return;
        this.Bvz = paramByteBuffer.getInt();
        this.BvA = paramByteBuffer.getInt();
        this.BvB = paramByteBuffer.getLong();
        this.BvC = paramByteBuffer.getLong();
        this.BvD = paramByteBuffer.getLong();
        this.BvE = paramByteBuffer.getLong();
        this.BvF = paramByteBuffer.getInt();
        this.BvG = paramByteBuffer.getInt();
        this.BvH = paramByteBuffer.getLong();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareElfFile
 * JD-Core Version:    0.7.0.1
 */