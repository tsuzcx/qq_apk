package com.tencent.mm.vfs;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.mm.vfs.a.f;
import com.tencent.mm.vfs.a.f.a;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RefCountedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<RefCountedFileSystem> CREATOR;
  protected final FileSystem agvG;
  
  static
  {
    AppMethodBeat.i(238319);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238319);
  }
  
  protected RefCountedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238303);
    ah.a(paramParcel, RefCountedFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(238303);
      throw paramParcel;
    }
    AppMethodBeat.o(238303);
  }
  
  public RefCountedFileSystem(FileSystem paramFileSystem)
  {
    this.agvG = paramFileSystem;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238340);
    if (((paramObject instanceof RefCountedFileSystem)) && (this.agvG.equals(((RefCountedFileSystem)paramObject).agvG)))
    {
      AppMethodBeat.o(238340);
      return true;
    }
    AppMethodBeat.o(238340);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238337);
    int i = RefCountedFileSystem.class.hashCode();
    int j = this.agvG.hashCode();
    AppMethodBeat.o(238337);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238331);
    String str = "RefCount [" + this.agvG.toString() + "]";
    AppMethodBeat.o(238331);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238324);
    ah.b(paramParcel, RefCountedFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    AppMethodBeat.o(238324);
  }
  
  static final class a
  {
    static long i(RandomAccessFile paramRandomAccessFile)
    {
      AppMethodBeat.i(238494);
      try
      {
        long l = Os.fstat(paramRandomAccessFile.getFD()).st_ino;
        AppMethodBeat.o(238494);
        return l;
      }
      catch (ErrnoException paramRandomAccessFile)
      {
        paramRandomAccessFile = new IOException(paramRandomAccessFile);
        AppMethodBeat.o(238494);
        throw paramRandomAccessFile;
      }
    }
  }
  
  static final class b
  {
    ArrayList<RandomAccessFile> agza;
    final FileLock agzb;
    int agzc;
    
    b(RandomAccessFile paramRandomAccessFile, boolean paramBoolean)
    {
      AppMethodBeat.i(238489);
      int i;
      if (paramBoolean)
      {
        i = -1;
        this.agzc = i;
        paramRandomAccessFile = paramRandomAccessFile.getChannel();
        if (paramBoolean) {
          break label59;
        }
      }
      label59:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.agzb = paramRandomAccessFile.lock(0L, 9223372036854775807L, paramBoolean);
        AppMethodBeat.o(238489);
        return;
        i = 1;
        break;
      }
    }
  }
  
  protected final class c
    extends a
  {
    protected final FileSystem.b agwv;
    private boolean agzd;
    
    protected c(FileSystem.b paramb)
    {
      AppMethodBeat.i(238495);
      this.agzd = false;
      this.agwv = paramb;
      if ((this.agwv.jKc() & 0x2) == 0)
      {
        this$1 = new IllegalArgumentException("The wrapped filesystem must have CAP_DIRECT_ACCESS.");
        AppMethodBeat.o(238495);
        throw RefCountedFileSystem.this;
      }
      AppMethodBeat.o(238495);
    }
    
    private j b(String paramString, j paramj)
    {
      AppMethodBeat.i(238515);
      Object localObject = bEf(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(238515);
        return null;
      }
      j localj = this.agwv.bDV(RefCountedFileSystem.access$000((String)localObject));
      if (localj == null)
      {
        AppMethodBeat.o(238515);
        return null;
      }
      localObject = this.agwv.bDV(RefCountedFileSystem.access$100((String)localObject));
      if ((localObject != null) && (((j)localObject).size != 0L)) {}
      for (int i = (int)((j)localObject).size;; i = 1)
      {
        paramString = new j(this, paramString, paramj.name.substring(0, paramj.name.length() - 1), localj.size, paramj.agxf + (localj.agxf + 4096L) / i, localj.agxg, localj.agxh);
        AppMethodBeat.o(238515);
        return paramString;
      }
    }
    
    /* Error */
    private String bEf(String paramString)
    {
      // Byte code:
      //   0: ldc 112
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   9: new 114	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   16: aload_1
      //   17: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: sipush 8982
      //   23: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   26: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: iconst_1
      //   30: invokeinterface 130 3 0
      //   35: astore 4
      //   37: aload 4
      //   39: ifnonnull +10 -> 49
      //   42: ldc 112
      //   44: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   47: aconst_null
      //   48: areturn
      //   49: new 132	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   52: dup
      //   53: aload 4
      //   55: iconst_0
      //   56: invokespecial 135	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
      //   59: astore 5
      //   61: aload 5
      //   63: astore 4
      //   65: bipush 64
      //   67: newarray byte
      //   69: astore 6
      //   71: iconst_0
      //   72: istore_2
      //   73: iload_2
      //   74: bipush 64
      //   76: if_icmpge +35 -> 111
      //   79: aload 5
      //   81: astore 4
      //   83: aload 5
      //   85: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   88: aload 6
      //   90: iload_2
      //   91: bipush 64
      //   93: iload_2
      //   94: isub
      //   95: invokevirtual 145	java/io/RandomAccessFile:read	([BII)I
      //   98: istore_3
      //   99: iload_3
      //   100: iconst_m1
      //   101: if_icmpeq +10 -> 111
      //   104: iload_3
      //   105: iload_2
      //   106: iadd
      //   107: istore_2
      //   108: goto -35 -> 73
      //   111: aload 5
      //   113: astore 4
      //   115: new 86	java/lang/String
      //   118: dup
      //   119: aload 6
      //   121: iconst_0
      //   122: iload_2
      //   123: invokespecial 148	java/lang/String:<init>	([BII)V
      //   126: astore 6
      //   128: aload 5
      //   130: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   133: ldc 112
      //   135: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload 6
      //   140: areturn
      //   141: astore_1
      //   142: aconst_null
      //   143: astore_1
      //   144: aload_1
      //   145: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   148: ldc 112
      //   150: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   153: aconst_null
      //   154: areturn
      //   155: astore 6
      //   157: aconst_null
      //   158: astore 5
      //   160: aload 5
      //   162: astore 4
      //   164: ldc 156
      //   166: aload 6
      //   168: ldc 158
      //   170: aload_1
      //   171: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   174: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   177: invokestatic 171	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
      //   180: aload 5
      //   182: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   185: ldc 112
      //   187: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aconst_null
      //   191: areturn
      //   192: astore_1
      //   193: aconst_null
      //   194: astore 4
      //   196: aload 4
      //   198: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   201: ldc 112
      //   203: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: aload_1
      //   207: athrow
      //   208: astore_1
      //   209: goto -13 -> 196
      //   212: astore 6
      //   214: goto -54 -> 160
      //   217: astore_1
      //   218: aload 5
      //   220: astore_1
      //   221: goto -77 -> 144
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	224	0	this	c
      //   0	224	1	paramString	String
      //   72	51	2	i	int
      //   98	9	3	j	int
      //   35	162	4	localObject1	Object
      //   59	160	5	locald	RefCountedFileSystem.d
      //   69	70	6	localObject2	Object
      //   155	12	6	localIOException1	IOException
      //   212	1	6	localIOException2	IOException
      // Exception table:
      //   from	to	target	type
      //   49	61	141	java/io/FileNotFoundException
      //   49	61	155	java/io/IOException
      //   49	61	192	finally
      //   65	71	208	finally
      //   83	99	208	finally
      //   115	128	208	finally
      //   164	180	208	finally
      //   65	71	212	java/io/IOException
      //   83	99	212	java/io/IOException
      //   115	128	212	java/io/IOException
      //   65	71	217	java/io/FileNotFoundException
      //   83	99	217	java/io/FileNotFoundException
      //   115	128	217	java/io/FileNotFoundException
    }
    
    /* Error */
    private boolean bEg(String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: iconst_0
      //   3: istore_2
      //   4: ldc 174
      //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: aload_1
      //   11: invokespecial 64	com/tencent/mm/vfs/RefCountedFileSystem$c:bEf	(Ljava/lang/String;)Ljava/lang/String;
      //   14: astore 6
      //   16: aload 6
      //   18: ifnonnull +10 -> 28
      //   21: ldc 174
      //   23: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_0
      //   29: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   32: new 114	java/lang/StringBuilder
      //   35: dup
      //   36: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   39: aload_1
      //   40: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: sipush 8982
      //   46: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   49: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokeinterface 177 2 0
      //   57: ifne +10 -> 67
      //   60: ldc 174
      //   62: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   65: iconst_0
      //   66: ireturn
      //   67: aload 6
      //   69: invokestatic 74	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   72: astore 7
      //   74: aload_0
      //   75: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   78: aload 7
      //   80: iconst_1
      //   81: invokeinterface 130 3 0
      //   86: astore_1
      //   87: aload_1
      //   88: ifnull +64 -> 152
      //   91: aconst_null
      //   92: astore 5
      //   94: new 179	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   97: dup
      //   98: aload_1
      //   99: invokespecial 180	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   102: astore_1
      //   103: aload_1
      //   104: iconst_m1
      //   105: invokevirtual 184	com/tencent/mm/vfs/RefCountedFileSystem$e:aFF	(I)I
      //   108: istore 4
      //   110: iload 4
      //   112: ifne +5 -> 117
      //   115: iconst_1
      //   116: istore_2
      //   117: aload_1
      //   118: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   121: iload_2
      //   122: ifeq +30 -> 152
      //   125: aload_0
      //   126: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   129: aload 7
      //   131: invokeinterface 177 2 0
      //   136: pop
      //   137: aload_0
      //   138: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   141: aload 6
      //   143: invokestatic 67	com/tencent/mm/vfs/RefCountedFileSystem:access$000	(Ljava/lang/String;)Ljava/lang/String;
      //   146: invokeinterface 177 2 0
      //   151: pop
      //   152: ldc 174
      //   154: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   157: iconst_1
      //   158: ireturn
      //   159: astore_1
      //   160: aconst_null
      //   161: astore_1
      //   162: aload_1
      //   163: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   166: iload_3
      //   167: istore_2
      //   168: goto -47 -> 121
      //   171: astore_1
      //   172: aload 5
      //   174: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   177: ldc 174
      //   179: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   182: aload_1
      //   183: athrow
      //   184: astore 6
      //   186: aload_1
      //   187: astore 5
      //   189: aload 6
      //   191: astore_1
      //   192: goto -20 -> 172
      //   195: astore 5
      //   197: goto -35 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	200	0	this	c
      //   0	200	1	paramString	String
      //   3	165	2	i	int
      //   1	166	3	j	int
      //   108	3	4	k	int
      //   92	96	5	localObject1	Object
      //   195	1	5	localIOException	IOException
      //   14	128	6	str1	String
      //   184	6	6	localObject2	Object
      //   72	58	7	str2	String
      // Exception table:
      //   from	to	target	type
      //   94	103	159	java/io/IOException
      //   94	103	171	finally
      //   103	110	184	finally
      //   103	110	195	java/io/IOException
    }
    
    /* Error */
    private void qj(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 187
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   9: new 114	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   16: aload_1
      //   17: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: sipush 8982
      //   23: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   26: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: iconst_1
      //   30: invokeinterface 130 3 0
      //   35: astore 5
      //   37: aload_0
      //   38: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   41: new 114	java/lang/StringBuilder
      //   44: dup
      //   45: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   48: aload_2
      //   49: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: sipush 8982
      //   55: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   58: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: iconst_1
      //   62: invokeinterface 130 3 0
      //   67: astore 10
      //   69: aload 5
      //   71: ifnull +8 -> 79
      //   74: aload 10
      //   76: ifnonnull +43 -> 119
      //   79: new 111	java/io/IOException
      //   82: dup
      //   83: new 114	java/lang/StringBuilder
      //   86: dup
      //   87: ldc 189
      //   89: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   92: aload_1
      //   93: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: ldc 192
      //   98: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: aload_2
      //   102: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   111: astore_1
      //   112: ldc 187
      //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   117: aload_1
      //   118: athrow
      //   119: aload_0
      //   120: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:agzd	Z
      //   123: ifne +32 -> 155
      //   126: aload_0
      //   127: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   130: ldc 195
      //   132: invokeinterface 198 2 0
      //   137: pop
      //   138: aload_0
      //   139: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   142: ldc 200
      //   144: invokeinterface 198 2 0
      //   149: pop
      //   150: aload_0
      //   151: iconst_1
      //   152: putfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:agzd	Z
      //   155: new 132	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   158: dup
      //   159: aload 5
      //   161: iconst_1
      //   162: invokespecial 135	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
      //   165: astore 8
      //   167: aload 8
      //   169: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   172: invokevirtual 203	java/io/RandomAccessFile:length	()J
      //   175: lconst_0
      //   176: lcmp
      //   177: ifne +460 -> 637
      //   180: aload_0
      //   181: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   184: aload_1
      //   185: invokeinterface 207 2 0
      //   190: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   193: invokestatic 213	java/util/UUID:randomUUID	()Ljava/util/UUID;
      //   196: invokevirtual 214	java/util/UUID:toString	()Ljava/lang/String;
      //   199: astore 7
      //   201: aload 7
      //   203: invokestatic 67	com/tencent/mm/vfs/RefCountedFileSystem:access$000	(Ljava/lang/String;)Ljava/lang/String;
      //   206: astore 11
      //   208: aload_0
      //   209: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   212: aload 7
      //   214: invokestatic 74	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   217: iconst_1
      //   218: invokeinterface 130 3 0
      //   223: astore 5
      //   225: aload 5
      //   227: ifnonnull +257 -> 484
      //   230: new 111	java/io/IOException
      //   233: dup
      //   234: new 114	java/lang/StringBuilder
      //   237: dup
      //   238: ldc 216
      //   240: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   243: aload 7
      //   245: invokestatic 74	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   248: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   251: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   254: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   257: astore 5
      //   259: ldc 187
      //   261: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   264: aload 5
      //   266: athrow
      //   267: astore 7
      //   269: aconst_null
      //   270: astore 5
      //   272: aconst_null
      //   273: astore 6
      //   275: aload 6
      //   277: ifnull +70 -> 347
      //   280: aload 5
      //   282: astore 9
      //   284: aload 6
      //   286: astore 10
      //   288: aload 8
      //   290: astore 11
      //   292: aload 6
      //   294: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   297: invokevirtual 203	java/io/RandomAccessFile:length	()J
      //   300: lconst_0
      //   301: lcmp
      //   302: ifne +45 -> 347
      //   305: aload 5
      //   307: astore 9
      //   309: aload 6
      //   311: astore 10
      //   313: aload 8
      //   315: astore 11
      //   317: aload_0
      //   318: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   321: new 114	java/lang/StringBuilder
      //   324: dup
      //   325: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   328: aload_2
      //   329: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   332: sipush 8982
      //   335: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   338: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   341: invokeinterface 177 2 0
      //   346: pop
      //   347: aload 8
      //   349: ifnull +70 -> 419
      //   352: aload 5
      //   354: astore 9
      //   356: aload 6
      //   358: astore 10
      //   360: aload 8
      //   362: astore 11
      //   364: aload 8
      //   366: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   369: invokevirtual 203	java/io/RandomAccessFile:length	()J
      //   372: lconst_0
      //   373: lcmp
      //   374: ifne +45 -> 419
      //   377: aload 5
      //   379: astore 9
      //   381: aload 6
      //   383: astore 10
      //   385: aload 8
      //   387: astore 11
      //   389: aload_0
      //   390: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   393: new 114	java/lang/StringBuilder
      //   396: dup
      //   397: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   400: aload_1
      //   401: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   404: sipush 8982
      //   407: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   410: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   413: invokeinterface 177 2 0
      //   418: pop
      //   419: aload 5
      //   421: astore 9
      //   423: aload 6
      //   425: astore 10
      //   427: aload 8
      //   429: astore 11
      //   431: ldc 187
      //   433: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   436: aload 5
      //   438: astore 9
      //   440: aload 6
      //   442: astore 10
      //   444: aload 8
      //   446: astore 11
      //   448: aload 7
      //   450: athrow
      //   451: astore_1
      //   452: aload 11
      //   454: astore 8
      //   456: aload 10
      //   458: astore 5
      //   460: aload 9
      //   462: astore_2
      //   463: aload 5
      //   465: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   468: aload_2
      //   469: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   472: aload 8
      //   474: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   477: ldc 187
      //   479: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   482: aload_1
      //   483: athrow
      //   484: new 179	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   487: dup
      //   488: aload 5
      //   490: invokespecial 180	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   493: astore 5
      //   495: aload 5
      //   497: astore 6
      //   499: aload 5
      //   501: astore 9
      //   503: aload 5
      //   505: iconst_1
      //   506: invokevirtual 184	com/tencent/mm/vfs/RefCountedFileSystem$e:aFF	(I)I
      //   509: pop
      //   510: aload 5
      //   512: astore 6
      //   514: aload 5
      //   516: astore 9
      //   518: aload 8
      //   520: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   523: aload 7
      //   525: invokevirtual 220	java/lang/String:getBytes	()[B
      //   528: invokevirtual 224	java/io/RandomAccessFile:write	([B)V
      //   531: aload 5
      //   533: astore 6
      //   535: aload 5
      //   537: astore 9
      //   539: aload_0
      //   540: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   543: aload 11
      //   545: aload_0
      //   546: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   549: aload_1
      //   550: invokeinterface 227 4 0
      //   555: pop
      //   556: aload 5
      //   558: astore 6
      //   560: aload 5
      //   562: astore 9
      //   564: aload 5
      //   566: iconst_1
      //   567: invokevirtual 184	com/tencent/mm/vfs/RefCountedFileSystem$e:aFF	(I)I
      //   570: pop
      //   571: aload 5
      //   573: astore 6
      //   575: aload 5
      //   577: astore 9
      //   579: new 132	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   582: dup
      //   583: aload 10
      //   585: iconst_1
      //   586: invokespecial 135	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
      //   589: astore 12
      //   591: aload 5
      //   593: astore 9
      //   595: aload 12
      //   597: astore 10
      //   599: aload 8
      //   601: astore 11
      //   603: aload 12
      //   605: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   608: aload 7
      //   610: invokevirtual 220	java/lang/String:getBytes	()[B
      //   613: invokevirtual 224	java/io/RandomAccessFile:write	([B)V
      //   616: aload 12
      //   618: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   621: aload 5
      //   623: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   626: aload 8
      //   628: invokestatic 154	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   631: ldc 187
      //   633: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   636: return
      //   637: bipush 64
      //   639: newarray byte
      //   641: astore 5
      //   643: iconst_0
      //   644: istore_3
      //   645: iload_3
      //   646: bipush 64
      //   648: if_icmpge +34 -> 682
      //   651: aload 8
      //   653: getfield 139	com/tencent/mm/vfs/RefCountedFileSystem$d:eTT	Ljava/io/RandomAccessFile;
      //   656: aload 5
      //   658: iload_3
      //   659: bipush 64
      //   661: iload_3
      //   662: isub
      //   663: invokevirtual 145	java/io/RandomAccessFile:read	([BII)I
      //   666: istore 4
      //   668: iload 4
      //   670: iconst_m1
      //   671: if_icmpeq +11 -> 682
      //   674: iload 4
      //   676: iload_3
      //   677: iadd
      //   678: istore_3
      //   679: goto -34 -> 645
      //   682: new 86	java/lang/String
      //   685: dup
      //   686: aload 5
      //   688: iconst_0
      //   689: iload_3
      //   690: invokespecial 148	java/lang/String:<init>	([BII)V
      //   693: astore 7
      //   695: aload_0
      //   696: getfield 35	com/tencent/mm/vfs/RefCountedFileSystem$c:agwv	Lcom/tencent/mm/vfs/FileSystem$b;
      //   699: aload 7
      //   701: invokestatic 74	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   704: iconst_1
      //   705: invokeinterface 130 3 0
      //   710: astore 5
      //   712: aload 5
      //   714: ifnonnull +40 -> 754
      //   717: new 111	java/io/IOException
      //   720: dup
      //   721: new 114	java/lang/StringBuilder
      //   724: dup
      //   725: ldc 216
      //   727: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   730: aload 7
      //   732: invokestatic 74	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   735: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   738: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   741: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   744: astore 5
      //   746: ldc 187
      //   748: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   751: aload 5
      //   753: athrow
      //   754: new 179	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   757: dup
      //   758: aload 5
      //   760: invokespecial 180	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   763: astore 5
      //   765: goto -209 -> 556
      //   768: astore_1
      //   769: aconst_null
      //   770: astore_2
      //   771: aconst_null
      //   772: astore 5
      //   774: aconst_null
      //   775: astore 8
      //   777: goto -314 -> 463
      //   780: astore_1
      //   781: aconst_null
      //   782: astore 5
      //   784: aload 6
      //   786: astore_2
      //   787: goto -324 -> 463
      //   790: astore 7
      //   792: aconst_null
      //   793: astore 5
      //   795: aconst_null
      //   796: astore 6
      //   798: aconst_null
      //   799: astore 8
      //   801: goto -526 -> 275
      //   804: astore 7
      //   806: aconst_null
      //   807: astore 6
      //   809: aload 9
      //   811: astore 5
      //   813: goto -538 -> 275
      //   816: astore 7
      //   818: aload 12
      //   820: astore 6
      //   822: goto -547 -> 275
      //   825: astore_1
      //   826: aconst_null
      //   827: astore_2
      //   828: aconst_null
      //   829: astore 5
      //   831: goto -368 -> 463
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	834	0	this	c
      //   0	834	1	paramString1	String
      //   0	834	2	paramString2	String
      //   644	46	3	i	int
      //   666	12	4	j	int
      //   35	795	5	localObject1	Object
      //   273	548	6	localObject2	Object
      //   199	45	7	str1	String
      //   267	342	7	localIOException1	IOException
      //   693	38	7	str2	String
      //   790	1	7	localIOException2	IOException
      //   804	1	7	localIOException3	IOException
      //   816	1	7	localIOException4	IOException
      //   165	635	8	localObject3	Object
      //   282	528	9	localObject4	Object
      //   67	531	10	localObject5	Object
      //   206	396	11	localObject6	Object
      //   589	230	12	locald	RefCountedFileSystem.d
      // Exception table:
      //   from	to	target	type
      //   167	225	267	java/io/IOException
      //   230	267	267	java/io/IOException
      //   484	495	267	java/io/IOException
      //   637	643	267	java/io/IOException
      //   651	668	267	java/io/IOException
      //   682	712	267	java/io/IOException
      //   717	754	267	java/io/IOException
      //   754	765	267	java/io/IOException
      //   292	305	451	finally
      //   317	347	451	finally
      //   364	377	451	finally
      //   389	419	451	finally
      //   431	436	451	finally
      //   448	451	451	finally
      //   603	616	451	finally
      //   155	167	768	finally
      //   503	510	780	finally
      //   518	531	780	finally
      //   539	556	780	finally
      //   564	571	780	finally
      //   579	591	780	finally
      //   155	167	790	java/io/IOException
      //   503	510	804	java/io/IOException
      //   518	531	804	java/io/IOException
      //   539	556	804	java/io/IOException
      //   564	571	804	java/io/IOException
      //   579	591	804	java/io/IOException
      //   603	616	816	java/io/IOException
      //   167	225	825	finally
      //   230	267	825	finally
      //   484	495	825	finally
      //   637	643	825	finally
      //   651	668	825	finally
      //   682	712	825	finally
      //   717	754	825	finally
      //   754	765	825	finally
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238555);
      try
      {
        InputStream localInputStream = this.agwv.Lh(paramString);
        AppMethodBeat.o(238555);
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString = bEf(paramString);
        if (paramString != null)
        {
          paramString = this.agwv.Lh(RefCountedFileSystem.access$000(paramString));
          AppMethodBeat.o(238555);
          return paramString;
        }
        AppMethodBeat.o(238555);
        throw localFileNotFoundException;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(238613);
      if ((paramBoolean) && (paramb == this))
      {
        j localj = bDV(paramString2);
        if ((localj != null) && (!localj.agxh) && (localj.size > 16384L)) {
          try
          {
            qj(paramString2, paramString1);
            l = localj.size;
            AppMethodBeat.o(238613);
            return l;
          }
          catch (IOException localIOException)
          {
            Log.w("VFS.RefCountedFileSystem", localIOException, "Cannot create link, fallback to plain copy.");
          }
        }
      }
      long l = ah.a(paramb, paramString2, this, paramString1);
      AppMethodBeat.o(238613);
      return l;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(238608);
      if (bEf(paramString2) == null)
      {
        bool = this.agwv.a(paramString1, paramb, paramString2);
        AppMethodBeat.o(238608);
        return bool;
      }
      if (paramb != this)
      {
        AppMethodBeat.o(238608);
        return false;
      }
      qj(paramString2, paramString1);
      boolean bool = bEg(paramString2);
      AppMethodBeat.o(238608);
      return bool;
    }
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238560);
      try
      {
        ReadableByteChannel localReadableByteChannel = this.agwv.bDS(paramString);
        AppMethodBeat.o(238560);
        return localReadableByteChannel;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString = bEf(paramString);
        if (paramString != null)
        {
          paramString = this.agwv.bDS(RefCountedFileSystem.access$000(paramString));
          AppMethodBeat.o(238560);
          return paramString;
        }
        AppMethodBeat.o(238560);
        throw localFileNotFoundException;
      }
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(238572);
      if (bEf(paramString) != null)
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(238572);
        throw paramString;
      }
      paramString = this.agwv.bDT(paramString);
      AppMethodBeat.o(238572);
      return paramString;
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(238580);
      if ((this.agwv.bDU(paramString)) || (this.agwv.bDU(paramString + '⌖')))
      {
        AppMethodBeat.o(238580);
        return true;
      }
      AppMethodBeat.o(238580);
      return false;
    }
    
    public final j bDV(String paramString)
    {
      AppMethodBeat.i(238585);
      j localj = this.agwv.bDV(paramString);
      if (localj != null)
      {
        paramString = c(localj);
        AppMethodBeat.o(238585);
        return paramString;
      }
      localj = this.agwv.bDV(paramString + '⌖');
      if (localj == null)
      {
        AppMethodBeat.o(238585);
        return null;
      }
      paramString = b(paramString, localj);
      AppMethodBeat.o(238585);
      return paramString;
    }
    
    public final Iterable<j> bDW(String paramString)
    {
      AppMethodBeat.i(238593);
      paramString = ah.v(paramString, true, true);
      if (paramString.isEmpty())
      {
        paramString = this.agwv.bDW("");
        if (paramString == null) {
          paramString = null;
        }
      }
      while (paramString == null)
      {
        AppMethodBeat.o(238593);
        return null;
        paramString = new com.tencent.mm.vfs.a.a(paramString, new a.a() {});
        continue;
        if (".ref".equals(paramString)) {
          paramString = null;
        } else {
          paramString = this.agwv.bDW(paramString);
        }
      }
      paramString = new f(paramString, new f.a() {});
      AppMethodBeat.o(238593);
      return paramString;
    }
    
    public final boolean bDX(String paramString)
    {
      AppMethodBeat.i(238595);
      boolean bool = this.agwv.bDX(paramString);
      AppMethodBeat.o(238595);
      return bool;
    }
    
    public final FileSystem.a bDY(String paramString)
    {
      AppMethodBeat.i(238548);
      paramString = this.agwv.bDY(paramString);
      AppMethodBeat.o(238548);
      return paramString;
    }
    
    final j c(j paramj)
    {
      AppMethodBeat.i(238582);
      paramj = new j(this, paramj.acpB, paramj.name, paramj.size, paramj.agxf, paramj.agxg, paramj.agxh);
      AppMethodBeat.o(238582);
      return paramj;
    }
    
    public final boolean cF(String paramString, long paramLong)
    {
      AppMethodBeat.i(238588);
      boolean bool1 = false;
      String str = bEf(paramString);
      if (str != null) {
        bool1 = this.agwv.cF(RefCountedFileSystem.access$000(str), paramLong);
      }
      boolean bool2 = this.agwv.cF(paramString, paramLong);
      AppMethodBeat.o(238588);
      return bool1 | bool2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238622);
      if (((paramObject instanceof c)) && (this.agwv.equals(((c)paramObject).agwv)))
      {
        AppMethodBeat.o(238622);
        return true;
      }
      AppMethodBeat.o(238622);
      return false;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238568);
      if ((paramBoolean) && (bEf(paramString) != null))
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(238568);
        throw paramString;
      }
      WritableByteChannel localWritableByteChannel = this.agwv.et(paramString, paramBoolean);
      if (!paramBoolean) {
        bEg(paramString);
      }
      AppMethodBeat.o(238568);
      return localWritableByteChannel;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238564);
      if ((paramBoolean) && (bEf(paramString) != null))
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(238564);
        throw paramString;
      }
      OutputStream localOutputStream = this.agwv.ev(paramString, paramBoolean);
      bEg(paramString);
      AppMethodBeat.o(238564);
      return localOutputStream;
    }
    
    public final boolean ew(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238600);
      if (!paramBoolean)
      {
        paramBoolean = this.agwv.ew(paramString, false);
        AppMethodBeat.o(238600);
        return paramBoolean;
      }
      Object localObject = ah.b(this, paramString);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        for (boolean bool1 = true;; bool1 = ((j)((Iterator)localObject).next()).NP(false) & bool1)
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        }
      }
      boolean bool2 = true;
      if ((this.agwv.ew(paramString, false)) && (bool2))
      {
        AppMethodBeat.o(238600);
        return true;
      }
      AppMethodBeat.o(238600);
      return false;
    }
    
    public final String ex(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238603);
      String str = this.agwv.ex(paramString, paramBoolean);
      if (this.agwv.bDU(paramString))
      {
        AppMethodBeat.o(238603);
        return str;
      }
      paramString = bEf(paramString);
      if (paramString != null)
      {
        paramString = this.agwv.ex(RefCountedFileSystem.access$000(paramString), paramBoolean);
        AppMethodBeat.o(238603);
        return paramString;
      }
      AppMethodBeat.o(238603);
      return str;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(238620);
      int i = RefCountedFileSystem.class.hashCode();
      int j = this.agwv.hashCode();
      AppMethodBeat.o(238620);
      return i ^ j;
    }
    
    public final boolean iP(String paramString)
    {
      AppMethodBeat.i(238590);
      boolean bool1 = bEg(paramString);
      boolean bool2 = this.agwv.iP(paramString);
      AppMethodBeat.o(238590);
      return bool1 | bool2;
    }
    
    public final int jKc()
    {
      AppMethodBeat.i(238544);
      int i = this.agwv.jKc();
      AppMethodBeat.o(238544);
      return i;
    }
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238578);
      int i = -1;
      switch (paramString2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramString2 = this.agwv.qf(paramString1, paramString2);
          bEg(paramString1);
          AppMethodBeat.o(238578);
          return paramString2;
          if (paramString2.equals("r"))
          {
            i = 0;
            continue;
            if (paramString2.equals("wa"))
            {
              i = 1;
              continue;
              if (paramString2.equals("rw")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      try
      {
        ParcelFileDescriptor localParcelFileDescriptor = this.agwv.qf(paramString1, paramString2);
        AppMethodBeat.o(238578);
        return localParcelFileDescriptor;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString1 = bEf(paramString1);
        if (paramString1 != null)
        {
          paramString1 = this.agwv.qf(RefCountedFileSystem.access$000(paramString1), paramString2);
          AppMethodBeat.o(238578);
          return paramString1;
        }
        AppMethodBeat.o(238578);
        throw localFileNotFoundException;
      }
      if (bEf(paramString1) != null)
      {
        paramString1 = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(238578);
        throw paramString1;
      }
      paramString1 = this.agwv.qf(paramString1, paramString2);
      AppMethodBeat.o(238578);
      return paramString1;
    }
  }
  
  static class d
    implements Closeable
  {
    private static final HashMap<Long, RefCountedFileSystem.b> agzg;
    private final long agzh;
    private final boolean agzi;
    private boolean agzj;
    final RandomAccessFile eTT;
    
    static
    {
      AppMethodBeat.i(238496);
      agzg = new HashMap();
      AppMethodBeat.o(238496);
    }
    
    d(String arg1, boolean paramBoolean)
    {
      AppMethodBeat.i(238491);
      Object localObject1;
      long l;
      if (paramBoolean)
      {
        localObject1 = "rw";
        localObject1 = new RandomAccessFile(???, (String)localObject1);
        this.agzi = paramBoolean;
        if (Build.VERSION.SDK_INT < 21) {
          break label126;
        }
        l = RefCountedFileSystem.a.i((RandomAccessFile)localObject1);
      }
      for (;;)
      {
        synchronized (agzg)
        {
          RefCountedFileSystem.b localb = (RefCountedFileSystem.b)agzg.get(Long.valueOf(l));
          if (localb == null)
          {
            agzg.put(Long.valueOf(l), new RefCountedFileSystem.b((RandomAccessFile)localObject1, paramBoolean));
            this.eTT = ((RandomAccessFile)localObject1);
            this.agzh = l;
            this.agzj = true;
            AppMethodBeat.o(238491);
            return;
            localObject1 = "r";
            break;
            label126:
            l = ???.hashCode() | ???.length() << 32;
            continue;
          }
          if ((!paramBoolean) && (localb.agzc > 0)) {
            localb.agzc += 1;
          }
        }
        try
        {
          agzg.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          IOException localIOException = new IOException(localInterruptedException);
          AppMethodBeat.o(238491);
          throw localIOException;
        }
      }
    }
    
    public void close()
    {
      AppMethodBeat.i(238507);
      if (!this.agzj)
      {
        AppMethodBeat.o(238507);
        return;
      }
      for (;;)
      {
        synchronized (agzg)
        {
          RefCountedFileSystem.b localb = (RefCountedFileSystem.b)agzg.get(Long.valueOf(this.agzh));
          if (localb == null)
          {
            this.eTT.close();
            this.agzj = false;
            AppMethodBeat.o(238507);
            return;
          }
          if (!this.agzi)
          {
            int i = localb.agzc - 1;
            localb.agzc = i;
            if (i != 0)
            {
              if (localb.agza == null) {
                localb.agza = new ArrayList(4);
              }
              localb.agza.add(this.eTT);
            }
          }
        }
        if (localObject.agzb != null) {
          localObject.agzb.release();
        }
        if (localObject.agza != null)
        {
          Iterator localIterator = localObject.agza.iterator();
          while (localIterator.hasNext()) {
            ((RandomAccessFile)localIterator.next()).close();
          }
        }
        this.eTT.close();
        agzg.remove(Long.valueOf(this.agzh));
        agzg.notifyAll();
      }
    }
    
    protected void finalize()
    {
      AppMethodBeat.i(238511);
      close();
      AppMethodBeat.o(238511);
    }
  }
  
  static final class e
    extends RefCountedFileSystem.d
  {
    e(String paramString)
    {
      super(true);
    }
    
    final int aFF(int paramInt)
    {
      AppMethodBeat.i(238484);
      long l = Math.max(this.eTT.length() + paramInt, 0L);
      this.eTT.setLength(l);
      paramInt = (int)l;
      AppMethodBeat.o(238484);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.RefCountedFileSystem
 * JD-Core Version:    0.7.0.1
 */