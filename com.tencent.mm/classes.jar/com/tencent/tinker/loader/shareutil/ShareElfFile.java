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
  public static final int FILE_TYPE_ELF = 1;
  public static final int FILE_TYPE_ODEX = 0;
  public static final int FILE_TYPE_OTHERS = -1;
  public ElfHeader elfHeader = null;
  private final FileInputStream fis;
  public ProgramHeader[] programHeaders = null;
  public SectionHeader[] sectionHeaders = null;
  private final Map<String, SectionHeader> sectionNameToHeaderMap = new HashMap();
  
  public ShareElfFile(File paramFile)
  {
    this.fis = new FileInputStream(paramFile);
    Object localObject = this.fis.getChannel();
    this.elfHeader = new ElfHeader((FileChannel)localObject, null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.elfHeader.ePhEntSize);
    if (this.elfHeader.eIndent[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.elfHeader.ePhOff);
      this.programHeaders = new ProgramHeader[this.elfHeader.ePhNum];
      i = 0;
      while (i < this.programHeaders.length)
      {
        readUntilLimit((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.programHeaders[i] = new ProgramHeader(localByteBuffer, this.elfHeader.eIndent[4], null);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.elfHeader.eShOff);
    localByteBuffer.limit(this.elfHeader.eShEntSize);
    this.sectionHeaders = new SectionHeader[this.elfHeader.eShNum];
    int i = 0;
    while (i < this.sectionHeaders.length)
    {
      readUntilLimit((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.sectionHeaders[i] = new SectionHeader(localByteBuffer, this.elfHeader.eIndent[4], null);
      i += 1;
    }
    if (this.elfHeader.eShStrNdx > 0)
    {
      paramFile = getSection(this.sectionHeaders[this.elfHeader.eShStrNdx]);
      localObject = this.sectionHeaders;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.shName);
        localByteBuffer.shNameStr = readCString(paramFile);
        this.sectionNameToHeaderMap.put(localByteBuffer.shNameStr, localByteBuffer);
        i += 1;
      }
    }
  }
  
  private static void assertInRange(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new IOException(paramString);
    }
  }
  
  /* Error */
  public static int getFileTypeByMagic(File paramFile)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: astore_3
    //   4: new 53	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_3
    //   15: invokevirtual 174	java/io/InputStream:read	([B)I
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
    //   54: invokevirtual 177	java/io/InputStream:close	()V
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
    //   92: invokevirtual 177	java/io/InputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 177	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 177	java/io/InputStream:close	()V
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
    //   127	1	2	localObject	Object
    //   3	81	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	13	103	finally
    //   53	57	116	finally
    //   91	95	119	finally
    //   97	101	123	finally
    //   110	114	127	finally
    //   13	19	131	finally
  }
  
  public static String readCString(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void readUntilLimit(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  public void close()
  {
    this.fis.close();
    this.sectionNameToHeaderMap.clear();
    this.programHeaders = null;
    this.sectionHeaders = null;
  }
  
  public FileChannel getChannel()
  {
    return this.fis.getChannel();
  }
  
  public ByteOrder getDataOrder()
  {
    if (this.elfHeader.eIndent[5] == 1) {
      return ByteOrder.LITTLE_ENDIAN;
    }
    return ByteOrder.BIG_ENDIAN;
  }
  
  public ByteBuffer getSection(SectionHeader paramSectionHeader)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramSectionHeader.shSize);
    this.fis.getChannel().position(paramSectionHeader.shOffset);
    readUntilLimit(this.fis.getChannel(), localByteBuffer, "failed to read section: " + paramSectionHeader.shNameStr);
    return localByteBuffer;
  }
  
  public SectionHeader getSectionHeaderByName(String paramString)
  {
    return (SectionHeader)this.sectionNameToHeaderMap.get(paramString);
  }
  
  public ByteBuffer getSegment(ProgramHeader paramProgramHeader)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramProgramHeader.pFileSize);
    this.fis.getChannel().position(paramProgramHeader.pOffset);
    readUntilLimit(this.fis.getChannel(), localByteBuffer, "failed to read segment (type: " + paramProgramHeader.pType + ").");
    return localByteBuffer;
  }
  
  public boolean is32BitElf()
  {
    return this.elfHeader.eIndent[4] == 1;
  }
  
  public static class ElfHeader
  {
    public static final int EI_CLASS = 4;
    public static final int EI_DATA = 5;
    private static final int EI_NINDENT = 16;
    public static final int EI_VERSION = 6;
    public static final int ELFCLASS32 = 1;
    public static final int ELFCLASS64 = 2;
    public static final int ELFDATA2LSB = 1;
    public static final int ELFDATA2MSB = 2;
    public static final int ET_CORE = 4;
    public static final int ET_DYN = 3;
    public static final int ET_EXEC = 2;
    public static final int ET_HIPROC = 65535;
    public static final int ET_LOPROC = 65280;
    public static final int ET_NONE = 0;
    public static final int ET_REL = 1;
    public static final int EV_CURRENT = 1;
    public final short eEhSize;
    public final long eEntry;
    public final int eFlags;
    public final byte[] eIndent = new byte[16];
    public final short eMachine;
    public final short ePhEntSize;
    public final short ePhNum;
    public final long ePhOff;
    public final short eShEntSize;
    public final short eShNum;
    public final long eShOff;
    public final short eShStrNdx;
    public final short eType;
    public final int eVersion;
    
    private ElfHeader(FileChannel paramFileChannel)
    {
      paramFileChannel.position(0L);
      paramFileChannel.read(ByteBuffer.wrap(this.eIndent));
      if ((this.eIndent[0] != 127) || (this.eIndent[1] != 69) || (this.eIndent[2] != 76) || (this.eIndent[3] != 70)) {
        throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.eIndent[0]), Byte.valueOf(this.eIndent[1]), Byte.valueOf(this.eIndent[2]), Byte.valueOf(this.eIndent[3]) }));
      }
      ShareElfFile.assertInRange(this.eIndent[4], 1, 2, "bad elf class: " + this.eIndent[4]);
      ShareElfFile.assertInRange(this.eIndent[5], 1, 2, "bad elf data encoding: " + this.eIndent[5]);
      int i;
      label216:
      ByteBuffer localByteBuffer;
      if (this.eIndent[4] == 1)
      {
        i = 36;
        localByteBuffer = ByteBuffer.allocate(i);
        if (this.eIndent[5] != 1) {
          break label371;
        }
      }
      label371:
      for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
      {
        localByteBuffer.order(localByteOrder);
        ShareElfFile.readUntilLimit(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
        this.eType = localByteBuffer.getShort();
        this.eMachine = localByteBuffer.getShort();
        this.eVersion = localByteBuffer.getInt();
        ShareElfFile.assertInRange(this.eVersion, 1, 1, "bad elf version: " + this.eVersion);
        switch (this.eIndent[4])
        {
        default: 
          throw new IOException("Unexpected elf class: " + this.eIndent[4]);
          i = 48;
          break label216;
        }
      }
      this.eEntry = localByteBuffer.getInt();
      this.ePhOff = localByteBuffer.getInt();
      for (this.eShOff = localByteBuffer.getInt();; this.eShOff = localByteBuffer.getLong())
      {
        this.eFlags = localByteBuffer.getInt();
        this.eEhSize = localByteBuffer.getShort();
        this.ePhEntSize = localByteBuffer.getShort();
        this.ePhNum = localByteBuffer.getShort();
        this.eShEntSize = localByteBuffer.getShort();
        this.eShNum = localByteBuffer.getShort();
        this.eShStrNdx = localByteBuffer.getShort();
        return;
        this.eEntry = localByteBuffer.getLong();
        this.ePhOff = localByteBuffer.getLong();
      }
    }
  }
  
  public static class ProgramHeader
  {
    public static final int PF_R = 4;
    public static final int PF_W = 2;
    public static final int PF_X = 1;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_HIPROC = 2147483647;
    public static final int PT_INTERP = 3;
    public static final int PT_LOAD = 1;
    public static final int PT_LOPROC = 1879048192;
    public static final int PT_NOTE = 4;
    public static final int PT_NULL = 0;
    public static final int PT_PHDR = 6;
    public static final int PT_SHLIB = 5;
    public final long pAlign;
    public final long pFileSize;
    public final int pFlags;
    public final long pMemSize;
    public final long pOffset;
    public final long pPddr;
    public final int pType;
    public final long pVddr;
    
    private ProgramHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: ".concat(String.valueOf(paramInt)));
      case 1: 
        this.pType = paramByteBuffer.getInt();
        this.pOffset = paramByteBuffer.getInt();
        this.pVddr = paramByteBuffer.getInt();
        this.pPddr = paramByteBuffer.getInt();
        this.pFileSize = paramByteBuffer.getInt();
        this.pMemSize = paramByteBuffer.getInt();
        this.pFlags = paramByteBuffer.getInt();
        this.pAlign = paramByteBuffer.getInt();
        return;
      }
      this.pType = paramByteBuffer.getInt();
      this.pFlags = paramByteBuffer.getInt();
      this.pOffset = paramByteBuffer.getLong();
      this.pVddr = paramByteBuffer.getLong();
      this.pPddr = paramByteBuffer.getLong();
      this.pFileSize = paramByteBuffer.getLong();
      this.pMemSize = paramByteBuffer.getLong();
      this.pAlign = paramByteBuffer.getLong();
    }
  }
  
  public static class SectionHeader
  {
    public static final int SHF_ALLOC = 2;
    public static final int SHF_EXECINSTR = 4;
    public static final int SHF_MASKPROC = -268435456;
    public static final int SHF_WRITE = 1;
    public static final int SHN_ABS = 65521;
    public static final int SHN_COMMON = 65522;
    public static final int SHN_HIPROC = 65311;
    public static final int SHN_HIRESERVE = 65535;
    public static final int SHN_LOPROC = 65280;
    public static final int SHN_LORESERVE = 65280;
    public static final int SHN_UNDEF = 0;
    public static final int SHT_DYNAMIC = 6;
    public static final int SHT_DYNSYM = 11;
    public static final int SHT_HASH = 5;
    public static final int SHT_HIPROC = 2147483647;
    public static final int SHT_HIUSER = -1;
    public static final int SHT_LOPROC = 1879048192;
    public static final int SHT_LOUSER = -2147483648;
    public static final int SHT_NOBITS = 8;
    public static final int SHT_NOTE = 7;
    public static final int SHT_NULL = 0;
    public static final int SHT_PROGBITS = 1;
    public static final int SHT_REL = 9;
    public static final int SHT_RELA = 4;
    public static final int SHT_SHLIB = 10;
    public static final int SHT_STRTAB = 3;
    public static final int SHT_SYMTAB = 2;
    public final long shAddr;
    public final long shAddrAlign;
    public final long shEntSize;
    public final long shFlags;
    public final int shInfo;
    public final int shLink;
    public final int shName;
    public String shNameStr;
    public final long shOffset;
    public final long shSize;
    public final int shType;
    
    private SectionHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: ".concat(String.valueOf(paramInt)));
      case 1: 
        this.shName = paramByteBuffer.getInt();
        this.shType = paramByteBuffer.getInt();
        this.shFlags = paramByteBuffer.getInt();
        this.shAddr = paramByteBuffer.getInt();
        this.shOffset = paramByteBuffer.getInt();
        this.shSize = paramByteBuffer.getInt();
        this.shLink = paramByteBuffer.getInt();
        this.shInfo = paramByteBuffer.getInt();
        this.shAddrAlign = paramByteBuffer.getInt();
      }
      for (this.shEntSize = paramByteBuffer.getInt();; this.shEntSize = paramByteBuffer.getLong())
      {
        this.shNameStr = null;
        return;
        this.shName = paramByteBuffer.getInt();
        this.shType = paramByteBuffer.getInt();
        this.shFlags = paramByteBuffer.getLong();
        this.shAddr = paramByteBuffer.getLong();
        this.shOffset = paramByteBuffer.getLong();
        this.shSize = paramByteBuffer.getLong();
        this.shLink = paramByteBuffer.getInt();
        this.shInfo = paramByteBuffer.getInt();
        this.shAddrAlign = paramByteBuffer.getLong();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareElfFile
 * JD-Core Version:    0.7.0.1
 */