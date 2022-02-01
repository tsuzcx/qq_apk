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
import java.util.Map;

public class RefCountedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<RefCountedFileSystem> CREATOR;
  protected final FileSystem YBI;
  
  static
  {
    AppMethodBeat.i(236748);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(236748);
  }
  
  protected RefCountedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(236727);
    ad.a(paramParcel, RefCountedFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.YBI == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(236727);
      throw paramParcel;
    }
    AppMethodBeat.o(236727);
  }
  
  public RefCountedFileSystem(FileSystem paramFileSystem)
  {
    this.YBI = paramFileSystem;
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236729);
    paramMap = this.YBI.cp(paramMap);
    if (paramMap == NullFileSystem.ifq())
    {
      AppMethodBeat.o(236729);
      return paramMap;
    }
    paramMap = new c(paramMap);
    AppMethodBeat.o(236729);
    return paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236736);
    if (((paramObject instanceof RefCountedFileSystem)) && (this.YBI.equals(((RefCountedFileSystem)paramObject).YBI)))
    {
      AppMethodBeat.o(236736);
      return true;
    }
    AppMethodBeat.o(236736);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236733);
    int i = RefCountedFileSystem.class.hashCode();
    int j = this.YBI.hashCode();
    AppMethodBeat.o(236733);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(236732);
    String str = "RefCount [" + this.YBI.toString() + "]";
    AppMethodBeat.o(236732);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(236731);
    ad.b(paramParcel, RefCountedFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    AppMethodBeat.o(236731);
  }
  
  static final class a
  {
    static long i(RandomAccessFile paramRandomAccessFile)
    {
      AppMethodBeat.i(236598);
      try
      {
        long l = Os.fstat(paramRandomAccessFile.getFD()).st_ino;
        AppMethodBeat.o(236598);
        return l;
      }
      catch (ErrnoException paramRandomAccessFile)
      {
        paramRandomAccessFile = new IOException(paramRandomAccessFile);
        AppMethodBeat.o(236598);
        throw paramRandomAccessFile;
      }
    }
  }
  
  static final class b
  {
    ArrayList<RandomAccessFile> YDF;
    final FileLock YDG;
    int YDH;
    
    b(RandomAccessFile paramRandomAccessFile, boolean paramBoolean)
    {
      AppMethodBeat.i(236602);
      int i;
      if (paramBoolean)
      {
        i = -1;
        this.YDH = i;
        paramRandomAccessFile = paramRandomAccessFile.getChannel();
        if (paramBoolean) {
          break label59;
        }
      }
      label59:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.YDG = paramRandomAccessFile.lock(0L, 9223372036854775807L, paramBoolean);
        AppMethodBeat.o(236602);
        return;
        i = 1;
        break;
      }
    }
  }
  
  protected final class c
    extends a
  {
    protected final FileSystem.b YBJ;
    
    protected c(FileSystem.b paramb)
    {
      AppMethodBeat.i(236630);
      this.YBJ = paramb;
      if ((this.YBJ.ieY() & 0x2) == 0)
      {
        this$1 = new IllegalArgumentException("The wrapped filesystem must have CAP_DIRECT_ACCESS.");
        AppMethodBeat.o(236630);
        throw RefCountedFileSystem.this;
      }
      this.YBJ.bBD(".ref/d/");
      this.YBJ.bBD(".ref/c/");
      AppMethodBeat.o(236630);
    }
    
    private f b(String paramString, f paramf)
    {
      AppMethodBeat.i(236655);
      Object localObject = bBJ(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(236655);
        return null;
      }
      f localf = this.YBJ.bBC(RefCountedFileSystem.access$000((String)localObject));
      if (localf == null)
      {
        AppMethodBeat.o(236655);
        return null;
      }
      localObject = this.YBJ.bBC(RefCountedFileSystem.access$100((String)localObject));
      if ((localObject != null) && (((f)localObject).size != 0L)) {}
      for (int i = (int)((f)localObject).size;; i = 1)
      {
        paramString = new f(this, paramString, paramf.name.substring(0, paramf.name.length() - 1), localf.size, paramf.YCh + (localf.YCh + 4096L) / i, localf.YCi, localf.YCj);
        AppMethodBeat.o(236655);
        return paramString;
      }
    }
    
    /* Error */
    private String bBJ(String paramString)
    {
      // Byte code:
      //   0: ldc 119
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   9: new 121	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   16: aload_1
      //   17: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: sipush 8982
      //   23: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   26: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: iconst_1
      //   30: invokeinterface 137 3 0
      //   35: astore 4
      //   37: aload 4
      //   39: ifnonnull +10 -> 49
      //   42: ldc 119
      //   44: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   47: aconst_null
      //   48: areturn
      //   49: new 139	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   52: dup
      //   53: aload 4
      //   55: iconst_0
      //   56: invokespecial 142	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
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
      //   85: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   88: aload 6
      //   90: iload_2
      //   91: bipush 64
      //   93: iload_2
      //   94: isub
      //   95: invokevirtual 152	java/io/RandomAccessFile:read	([BII)I
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
      //   115: new 92	java/lang/String
      //   118: dup
      //   119: aload 6
      //   121: iconst_0
      //   122: iload_2
      //   123: invokespecial 155	java/lang/String:<init>	([BII)V
      //   126: astore 6
      //   128: aload 5
      //   130: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   133: ldc 119
      //   135: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload 6
      //   140: areturn
      //   141: astore_1
      //   142: aconst_null
      //   143: astore_1
      //   144: aload_1
      //   145: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   148: ldc 119
      //   150: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   153: aconst_null
      //   154: areturn
      //   155: astore 6
      //   157: aconst_null
      //   158: astore 5
      //   160: aload 5
      //   162: astore 4
      //   164: ldc 163
      //   166: aload 6
      //   168: ldc 165
      //   170: aload_1
      //   171: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   174: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   177: invokestatic 178	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
      //   180: aload 5
      //   182: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   185: ldc 119
      //   187: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aconst_null
      //   191: areturn
      //   192: astore_1
      //   193: aconst_null
      //   194: astore 4
      //   196: aload 4
      //   198: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   201: ldc 119
      //   203: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    private boolean bBK(String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: iconst_0
      //   3: istore_2
      //   4: ldc 180
      //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: aload_1
      //   11: invokespecial 70	com/tencent/mm/vfs/RefCountedFileSystem$c:bBJ	(Ljava/lang/String;)Ljava/lang/String;
      //   14: astore 6
      //   16: aload 6
      //   18: ifnonnull +10 -> 28
      //   21: ldc 180
      //   23: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_0
      //   29: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   32: new 121	java/lang/StringBuilder
      //   35: dup
      //   36: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   39: aload_1
      //   40: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: sipush 8982
      //   46: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   49: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokeinterface 183 2 0
      //   57: ifne +10 -> 67
      //   60: ldc 180
      //   62: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   65: iconst_0
      //   66: ireturn
      //   67: aload 6
      //   69: invokestatic 80	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   72: astore 7
      //   74: aload_0
      //   75: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   78: aload 7
      //   80: iconst_1
      //   81: invokeinterface 137 3 0
      //   86: astore_1
      //   87: aload_1
      //   88: ifnull +64 -> 152
      //   91: aconst_null
      //   92: astore 5
      //   94: new 185	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   97: dup
      //   98: aload_1
      //   99: invokespecial 186	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   102: astore_1
      //   103: aload_1
      //   104: iconst_m1
      //   105: invokevirtual 190	com/tencent/mm/vfs/RefCountedFileSystem$e:aza	(I)I
      //   108: istore 4
      //   110: iload 4
      //   112: ifne +5 -> 117
      //   115: iconst_1
      //   116: istore_2
      //   117: aload_1
      //   118: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   121: iload_2
      //   122: ifeq +30 -> 152
      //   125: aload_0
      //   126: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   129: aload 7
      //   131: invokeinterface 183 2 0
      //   136: pop
      //   137: aload_0
      //   138: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   141: aload 6
      //   143: invokestatic 73	com/tencent/mm/vfs/RefCountedFileSystem:access$000	(Ljava/lang/String;)Ljava/lang/String;
      //   146: invokeinterface 183 2 0
      //   151: pop
      //   152: ldc 180
      //   154: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   157: iconst_1
      //   158: ireturn
      //   159: astore_1
      //   160: aconst_null
      //   161: astore_1
      //   162: aload_1
      //   163: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   166: iload_3
      //   167: istore_2
      //   168: goto -47 -> 121
      //   171: astore_1
      //   172: aload 5
      //   174: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   177: ldc 180
      //   179: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    private void ol(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 193
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   9: new 121	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   16: aload_1
      //   17: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: sipush 8982
      //   23: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   26: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: iconst_1
      //   30: invokeinterface 137 3 0
      //   35: astore 5
      //   37: aload_0
      //   38: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   41: new 121	java/lang/StringBuilder
      //   44: dup
      //   45: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   48: aload_2
      //   49: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: sipush 8982
      //   55: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   58: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: iconst_1
      //   62: invokeinterface 137 3 0
      //   67: astore 10
      //   69: aload 5
      //   71: ifnull +8 -> 79
      //   74: aload 10
      //   76: ifnonnull +43 -> 119
      //   79: new 118	java/io/IOException
      //   82: dup
      //   83: new 121	java/lang/StringBuilder
      //   86: dup
      //   87: ldc 195
      //   89: invokespecial 196	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   92: aload_1
      //   93: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: ldc 198
      //   98: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: aload_2
      //   102: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   111: astore_1
      //   112: ldc 193
      //   114: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   117: aload_1
      //   118: athrow
      //   119: new 139	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   122: dup
      //   123: aload 5
      //   125: iconst_1
      //   126: invokespecial 142	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
      //   129: astore 8
      //   131: aload 8
      //   133: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   136: invokevirtual 202	java/io/RandomAccessFile:length	()J
      //   139: lconst_0
      //   140: lcmp
      //   141: ifne +460 -> 601
      //   144: aload_0
      //   145: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   148: aload_1
      //   149: invokeinterface 206 2 0
      //   154: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   157: invokestatic 212	java/util/UUID:randomUUID	()Ljava/util/UUID;
      //   160: invokevirtual 213	java/util/UUID:toString	()Ljava/lang/String;
      //   163: astore 7
      //   165: aload 7
      //   167: invokestatic 73	com/tencent/mm/vfs/RefCountedFileSystem:access$000	(Ljava/lang/String;)Ljava/lang/String;
      //   170: astore 11
      //   172: aload_0
      //   173: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   176: aload 7
      //   178: invokestatic 80	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   181: iconst_1
      //   182: invokeinterface 137 3 0
      //   187: astore 5
      //   189: aload 5
      //   191: ifnonnull +257 -> 448
      //   194: new 118	java/io/IOException
      //   197: dup
      //   198: new 121	java/lang/StringBuilder
      //   201: dup
      //   202: ldc 215
      //   204: invokespecial 196	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   207: aload 7
      //   209: invokestatic 80	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   212: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   215: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   218: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   221: astore 5
      //   223: ldc 193
      //   225: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   228: aload 5
      //   230: athrow
      //   231: astore 7
      //   233: aconst_null
      //   234: astore 5
      //   236: aconst_null
      //   237: astore 6
      //   239: aload 6
      //   241: ifnull +70 -> 311
      //   244: aload 5
      //   246: astore 9
      //   248: aload 6
      //   250: astore 10
      //   252: aload 8
      //   254: astore 11
      //   256: aload 6
      //   258: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   261: invokevirtual 202	java/io/RandomAccessFile:length	()J
      //   264: lconst_0
      //   265: lcmp
      //   266: ifne +45 -> 311
      //   269: aload 5
      //   271: astore 9
      //   273: aload 6
      //   275: astore 10
      //   277: aload 8
      //   279: astore 11
      //   281: aload_0
      //   282: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   285: new 121	java/lang/StringBuilder
      //   288: dup
      //   289: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   292: aload_2
      //   293: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: sipush 8982
      //   299: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   302: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   305: invokeinterface 183 2 0
      //   310: pop
      //   311: aload 8
      //   313: ifnull +70 -> 383
      //   316: aload 5
      //   318: astore 9
      //   320: aload 6
      //   322: astore 10
      //   324: aload 8
      //   326: astore 11
      //   328: aload 8
      //   330: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   333: invokevirtual 202	java/io/RandomAccessFile:length	()J
      //   336: lconst_0
      //   337: lcmp
      //   338: ifne +45 -> 383
      //   341: aload 5
      //   343: astore 9
      //   345: aload 6
      //   347: astore 10
      //   349: aload 8
      //   351: astore 11
      //   353: aload_0
      //   354: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   357: new 121	java/lang/StringBuilder
      //   360: dup
      //   361: invokespecial 122	java/lang/StringBuilder:<init>	()V
      //   364: aload_1
      //   365: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   368: sipush 8982
      //   371: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   374: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   377: invokeinterface 183 2 0
      //   382: pop
      //   383: aload 5
      //   385: astore 9
      //   387: aload 6
      //   389: astore 10
      //   391: aload 8
      //   393: astore 11
      //   395: ldc 193
      //   397: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   400: aload 5
      //   402: astore 9
      //   404: aload 6
      //   406: astore 10
      //   408: aload 8
      //   410: astore 11
      //   412: aload 7
      //   414: athrow
      //   415: astore_1
      //   416: aload 11
      //   418: astore 8
      //   420: aload 10
      //   422: astore 5
      //   424: aload 9
      //   426: astore_2
      //   427: aload 5
      //   429: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   432: aload_2
      //   433: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   436: aload 8
      //   438: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   441: ldc 193
      //   443: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   446: aload_1
      //   447: athrow
      //   448: new 185	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   451: dup
      //   452: aload 5
      //   454: invokespecial 186	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   457: astore 5
      //   459: aload 5
      //   461: astore 6
      //   463: aload 5
      //   465: astore 9
      //   467: aload 5
      //   469: iconst_1
      //   470: invokevirtual 190	com/tencent/mm/vfs/RefCountedFileSystem$e:aza	(I)I
      //   473: pop
      //   474: aload 5
      //   476: astore 6
      //   478: aload 5
      //   480: astore 9
      //   482: aload 8
      //   484: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   487: aload 7
      //   489: invokevirtual 219	java/lang/String:getBytes	()[B
      //   492: invokevirtual 223	java/io/RandomAccessFile:write	([B)V
      //   495: aload 5
      //   497: astore 6
      //   499: aload 5
      //   501: astore 9
      //   503: aload_0
      //   504: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   507: aload 11
      //   509: aload_0
      //   510: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   513: aload_1
      //   514: invokeinterface 226 4 0
      //   519: pop
      //   520: aload 5
      //   522: astore 6
      //   524: aload 5
      //   526: astore 9
      //   528: aload 5
      //   530: iconst_1
      //   531: invokevirtual 190	com/tencent/mm/vfs/RefCountedFileSystem$e:aza	(I)I
      //   534: pop
      //   535: aload 5
      //   537: astore 6
      //   539: aload 5
      //   541: astore 9
      //   543: new 139	com/tencent/mm/vfs/RefCountedFileSystem$d
      //   546: dup
      //   547: aload 10
      //   549: iconst_1
      //   550: invokespecial 142	com/tencent/mm/vfs/RefCountedFileSystem$d:<init>	(Ljava/lang/String;Z)V
      //   553: astore 12
      //   555: aload 5
      //   557: astore 9
      //   559: aload 12
      //   561: astore 10
      //   563: aload 8
      //   565: astore 11
      //   567: aload 12
      //   569: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   572: aload 7
      //   574: invokevirtual 219	java/lang/String:getBytes	()[B
      //   577: invokevirtual 223	java/io/RandomAccessFile:write	([B)V
      //   580: aload 12
      //   582: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   585: aload 5
      //   587: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   590: aload 8
      //   592: invokestatic 161	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
      //   595: ldc 193
      //   597: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   600: return
      //   601: bipush 64
      //   603: newarray byte
      //   605: astore 5
      //   607: iconst_0
      //   608: istore_3
      //   609: iload_3
      //   610: bipush 64
      //   612: if_icmpge +34 -> 646
      //   615: aload 8
      //   617: getfield 146	com/tencent/mm/vfs/RefCountedFileSystem$d:YDM	Ljava/io/RandomAccessFile;
      //   620: aload 5
      //   622: iload_3
      //   623: bipush 64
      //   625: iload_3
      //   626: isub
      //   627: invokevirtual 152	java/io/RandomAccessFile:read	([BII)I
      //   630: istore 4
      //   632: iload 4
      //   634: iconst_m1
      //   635: if_icmpeq +11 -> 646
      //   638: iload 4
      //   640: iload_3
      //   641: iadd
      //   642: istore_3
      //   643: goto -34 -> 609
      //   646: new 92	java/lang/String
      //   649: dup
      //   650: aload 5
      //   652: iconst_0
      //   653: iload_3
      //   654: invokespecial 155	java/lang/String:<init>	([BII)V
      //   657: astore 7
      //   659: aload_0
      //   660: getfield 33	com/tencent/mm/vfs/RefCountedFileSystem$c:YBJ	Lcom/tencent/mm/vfs/FileSystem$b;
      //   663: aload 7
      //   665: invokestatic 80	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   668: iconst_1
      //   669: invokeinterface 137 3 0
      //   674: astore 5
      //   676: aload 5
      //   678: ifnonnull +40 -> 718
      //   681: new 118	java/io/IOException
      //   684: dup
      //   685: new 121	java/lang/StringBuilder
      //   688: dup
      //   689: ldc 215
      //   691: invokespecial 196	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   694: aload 7
      //   696: invokestatic 80	com/tencent/mm/vfs/RefCountedFileSystem:access$100	(Ljava/lang/String;)Ljava/lang/String;
      //   699: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   702: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   705: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   708: astore 5
      //   710: ldc 193
      //   712: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   715: aload 5
      //   717: athrow
      //   718: new 185	com/tencent/mm/vfs/RefCountedFileSystem$e
      //   721: dup
      //   722: aload 5
      //   724: invokespecial 186	com/tencent/mm/vfs/RefCountedFileSystem$e:<init>	(Ljava/lang/String;)V
      //   727: astore 5
      //   729: goto -209 -> 520
      //   732: astore_1
      //   733: aconst_null
      //   734: astore_2
      //   735: aconst_null
      //   736: astore 5
      //   738: aconst_null
      //   739: astore 8
      //   741: goto -314 -> 427
      //   744: astore_1
      //   745: aconst_null
      //   746: astore 5
      //   748: aload 6
      //   750: astore_2
      //   751: goto -324 -> 427
      //   754: astore 7
      //   756: aconst_null
      //   757: astore 5
      //   759: aconst_null
      //   760: astore 6
      //   762: aconst_null
      //   763: astore 8
      //   765: goto -526 -> 239
      //   768: astore 7
      //   770: aconst_null
      //   771: astore 6
      //   773: aload 9
      //   775: astore 5
      //   777: goto -538 -> 239
      //   780: astore 7
      //   782: aload 12
      //   784: astore 6
      //   786: goto -547 -> 239
      //   789: astore_1
      //   790: aconst_null
      //   791: astore_2
      //   792: aconst_null
      //   793: astore 5
      //   795: goto -368 -> 427
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	798	0	this	c
      //   0	798	1	paramString1	String
      //   0	798	2	paramString2	String
      //   608	46	3	i	int
      //   630	12	4	j	int
      //   35	759	5	localObject1	Object
      //   237	548	6	localObject2	Object
      //   163	45	7	str1	String
      //   231	342	7	localIOException1	IOException
      //   657	38	7	str2	String
      //   754	1	7	localIOException2	IOException
      //   768	1	7	localIOException3	IOException
      //   780	1	7	localIOException4	IOException
      //   129	635	8	localObject3	Object
      //   246	528	9	localObject4	Object
      //   67	495	10	localObject5	Object
      //   170	396	11	localObject6	Object
      //   553	230	12	locald	RefCountedFileSystem.d
      // Exception table:
      //   from	to	target	type
      //   131	189	231	java/io/IOException
      //   194	231	231	java/io/IOException
      //   448	459	231	java/io/IOException
      //   601	607	231	java/io/IOException
      //   615	632	231	java/io/IOException
      //   646	676	231	java/io/IOException
      //   681	718	231	java/io/IOException
      //   718	729	231	java/io/IOException
      //   256	269	415	finally
      //   281	311	415	finally
      //   328	341	415	finally
      //   353	383	415	finally
      //   395	400	415	finally
      //   412	415	415	finally
      //   567	580	415	finally
      //   119	131	732	finally
      //   467	474	744	finally
      //   482	495	744	finally
      //   503	520	744	finally
      //   528	535	744	finally
      //   543	555	744	finally
      //   119	131	754	java/io/IOException
      //   467	474	768	java/io/IOException
      //   482	495	768	java/io/IOException
      //   503	520	768	java/io/IOException
      //   528	535	768	java/io/IOException
      //   543	555	768	java/io/IOException
      //   567	580	780	java/io/IOException
      //   131	189	789	finally
      //   194	231	789	finally
      //   448	459	789	finally
      //   601	607	789	finally
      //   615	632	789	finally
      //   646	676	789	finally
      //   681	718	789	finally
      //   718	729	789	finally
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(236636);
      try
      {
        InputStream localInputStream = this.YBJ.Tf(paramString);
        AppMethodBeat.o(236636);
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString = bBJ(paramString);
        if (paramString != null)
        {
          paramString = this.YBJ.Tf(RefCountedFileSystem.access$000(paramString));
          AppMethodBeat.o(236636);
          return paramString;
        }
        AppMethodBeat.o(236636);
        throw localFileNotFoundException;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(236681);
      if ((paramBoolean) && (paramb == this))
      {
        f localf = bBC(paramString2);
        if ((localf != null) && (!localf.YCj) && (localf.size > 16384L)) {
          try
          {
            ol(paramString2, paramString1);
            l = localf.size;
            AppMethodBeat.o(236681);
            return l;
          }
          catch (IOException localIOException)
          {
            Log.w("VFS.RefCountedFileSystem", localIOException, "Cannot create link, fallback to plain copy.");
          }
        }
      }
      long l = ad.a(paramb, paramString2, this, paramString1);
      AppMethodBeat.o(236681);
      return l;
    }
    
    final f b(f paramf)
    {
      AppMethodBeat.i(236652);
      paramf = new f(this, paramf.UUr, paramf.name, paramf.size, paramf.YCh, paramf.YCi, paramf.YCj);
      AppMethodBeat.o(236652);
      return paramf;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(236679);
      if (bBJ(paramString2) == null)
      {
        bool = this.YBJ.a(paramString1, paramb, paramString2);
        AppMethodBeat.o(236679);
        return bool;
      }
      if (paramb != this)
      {
        AppMethodBeat.o(236679);
        return false;
      }
      ol(paramString2, paramString1);
      boolean bool = bBK(paramString2);
      AppMethodBeat.o(236679);
      return bool;
    }
    
    public final FileSystem.a bBA(String paramString)
    {
      AppMethodBeat.i(236633);
      paramString = this.YBJ.bBA(paramString);
      AppMethodBeat.o(236633);
      return paramString;
    }
    
    public final boolean bBB(String paramString)
    {
      AppMethodBeat.i(236650);
      if ((this.YBJ.bBB(paramString)) || (this.YBJ.bBB(paramString + '⌖')))
      {
        AppMethodBeat.o(236650);
        return true;
      }
      AppMethodBeat.o(236650);
      return false;
    }
    
    public final f bBC(String paramString)
    {
      AppMethodBeat.i(236657);
      f localf = this.YBJ.bBC(paramString);
      if (localf != null)
      {
        paramString = b(localf);
        AppMethodBeat.o(236657);
        return paramString;
      }
      localf = this.YBJ.bBC(paramString + '⌖');
      if (localf == null)
      {
        AppMethodBeat.o(236657);
        return null;
      }
      paramString = b(paramString, localf);
      AppMethodBeat.o(236657);
      return paramString;
    }
    
    public final boolean bBD(String paramString)
    {
      AppMethodBeat.i(236672);
      boolean bool = this.YBJ.bBD(paramString);
      AppMethodBeat.o(236672);
      return bool;
    }
    
    public final ReadableByteChannel bBy(String paramString)
    {
      AppMethodBeat.i(236638);
      try
      {
        ReadableByteChannel localReadableByteChannel = this.YBJ.bBy(paramString);
        AppMethodBeat.o(236638);
        return localReadableByteChannel;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString = bBJ(paramString);
        if (paramString != null)
        {
          paramString = this.YBJ.bBy(RefCountedFileSystem.access$000(paramString));
          AppMethodBeat.o(236638);
          return paramString;
        }
        AppMethodBeat.o(236638);
        throw localFileNotFoundException;
      }
    }
    
    public final ByteChannel bBz(String paramString)
    {
      AppMethodBeat.i(236645);
      if (bBJ(paramString) != null)
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(236645);
        throw paramString;
      }
      paramString = this.YBJ.bBz(paramString);
      AppMethodBeat.o(236645);
      return paramString;
    }
    
    public final boolean ct(String paramString, long paramLong)
    {
      AppMethodBeat.i(236659);
      boolean bool1 = false;
      String str = bBJ(paramString);
      if (str != null) {
        bool1 = this.YBJ.ct(RefCountedFileSystem.access$000(str), paramLong);
      }
      boolean bool2 = this.YBJ.ct(paramString, paramLong);
      AppMethodBeat.o(236659);
      return bool1 | bool2;
    }
    
    public final WritableByteChannel dH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236643);
      if ((paramBoolean) && (bBJ(paramString) != null))
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(236643);
        throw paramString;
      }
      WritableByteChannel localWritableByteChannel = this.YBJ.dH(paramString, paramBoolean);
      if (!paramBoolean) {
        bBK(paramString);
      }
      AppMethodBeat.o(236643);
      return localWritableByteChannel;
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236640);
      if ((paramBoolean) && (bBJ(paramString) != null))
      {
        paramString = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(236640);
        throw paramString;
      }
      OutputStream localOutputStream = this.YBJ.dI(paramString, paramBoolean);
      bBK(paramString);
      AppMethodBeat.o(236640);
      return localOutputStream;
    }
    
    public final Iterable<f> dJ(String paramString, final boolean paramBoolean)
    {
      AppMethodBeat.i(236670);
      paramString = ad.r(paramString, true, true);
      if (paramString.isEmpty())
      {
        paramString = this.YBJ.dJ("", false);
        if (paramString == null) {
          paramString = null;
        }
      }
      while (paramString == null)
      {
        AppMethodBeat.o(236670);
        return null;
        paramString = new com.tencent.mm.vfs.a.a(paramString, new a.a() {});
        continue;
        if (".ref".equals(paramString)) {
          paramString = null;
        } else {
          paramString = this.YBJ.dJ(paramString, paramBoolean);
        }
      }
      paramString = new com.tencent.mm.vfs.a.f(paramString, new f.a() {});
      AppMethodBeat.o(236670);
      return paramString;
    }
    
    public final boolean dK(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236674);
      if (!paramBoolean)
      {
        paramBoolean = this.YBJ.dK(paramString, false);
        AppMethodBeat.o(236674);
        return paramBoolean;
      }
      if (dJ(paramString, false) != null)
      {
        Iterator localIterator = new com.tencent.mm.vfs.a.a(dJ(paramString, false), new a.a() {}).iterator();
        for (boolean bool1 = true;; bool1 = ((f)localIterator.next()).HT(false) & bool1)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      boolean bool2 = true;
      if ((this.YBJ.dK(paramString, false)) && (bool2))
      {
        AppMethodBeat.o(236674);
        return true;
      }
      AppMethodBeat.o(236674);
      return false;
    }
    
    public final String dL(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236677);
      String str = this.YBJ.dL(paramString, paramBoolean);
      if (this.YBJ.bBB(paramString))
      {
        AppMethodBeat.o(236677);
        return str;
      }
      paramString = bBJ(paramString);
      if (paramString != null)
      {
        paramString = this.YBJ.dL(RefCountedFileSystem.access$000(paramString), paramBoolean);
        AppMethodBeat.o(236677);
        return paramString;
      }
      AppMethodBeat.o(236677);
      return str;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236684);
      if (((paramObject instanceof c)) && (this.YBJ.equals(((c)paramObject).YBJ)))
      {
        AppMethodBeat.o(236684);
        return true;
      }
      AppMethodBeat.o(236684);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(236682);
      int i = RefCountedFileSystem.class.hashCode();
      int j = this.YBJ.hashCode();
      AppMethodBeat.o(236682);
      return i ^ j;
    }
    
    public final boolean ho(String paramString)
    {
      AppMethodBeat.i(236669);
      boolean bool1 = bBK(paramString);
      boolean bool2 = this.YBJ.ho(paramString);
      AppMethodBeat.o(236669);
      return bool1 | bool2;
    }
    
    public final int ieY()
    {
      AppMethodBeat.i(236632);
      int i = this.YBJ.ieY();
      AppMethodBeat.o(236632);
      return i;
    }
    
    public final ParcelFileDescriptor oh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(236648);
      int i = -1;
      switch (paramString2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramString2 = this.YBJ.oh(paramString1, paramString2);
          bBK(paramString1);
          AppMethodBeat.o(236648);
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
        ParcelFileDescriptor localParcelFileDescriptor = this.YBJ.oh(paramString1, paramString2);
        AppMethodBeat.o(236648);
        return localParcelFileDescriptor;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramString1 = bBJ(paramString1);
        if (paramString1 != null)
        {
          paramString1 = this.YBJ.oh(RefCountedFileSystem.access$000(paramString1), paramString2);
          AppMethodBeat.o(236648);
          return paramString1;
        }
        AppMethodBeat.o(236648);
        throw localFileNotFoundException;
      }
      if (bBJ(paramString1) != null)
      {
        paramString1 = new RuntimeException("Appending a reference counting file is not supported!");
        AppMethodBeat.o(236648);
        throw paramString1;
      }
      paramString1 = this.YBJ.oh(paramString1, paramString2);
      AppMethodBeat.o(236648);
      return paramString1;
    }
  }
  
  static class d
    implements Closeable
  {
    private static final HashMap<Long, RefCountedFileSystem.b> YDL;
    final RandomAccessFile YDM;
    private final long YDN;
    private final boolean YDO;
    private boolean YDP;
    
    static
    {
      AppMethodBeat.i(236710);
      YDL = new HashMap();
      AppMethodBeat.o(236710);
    }
    
    d(String arg1, boolean paramBoolean)
    {
      AppMethodBeat.i(236700);
      Object localObject1;
      long l;
      if (paramBoolean)
      {
        localObject1 = "rw";
        localObject1 = new RandomAccessFile(???, (String)localObject1);
        this.YDO = paramBoolean;
        if (Build.VERSION.SDK_INT < 21) {
          break label126;
        }
        l = RefCountedFileSystem.a.i((RandomAccessFile)localObject1);
      }
      for (;;)
      {
        synchronized (YDL)
        {
          RefCountedFileSystem.b localb = (RefCountedFileSystem.b)YDL.get(Long.valueOf(l));
          if (localb == null)
          {
            YDL.put(Long.valueOf(l), new RefCountedFileSystem.b((RandomAccessFile)localObject1, paramBoolean));
            this.YDM = ((RandomAccessFile)localObject1);
            this.YDN = l;
            this.YDP = true;
            AppMethodBeat.o(236700);
            return;
            localObject1 = "r";
            break;
            label126:
            l = ???.hashCode() | ???.length() << 32;
            continue;
          }
          if ((!paramBoolean) && (localb.YDH > 0)) {
            localb.YDH += 1;
          }
        }
        try
        {
          YDL.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          IOException localIOException = new IOException(localInterruptedException);
          AppMethodBeat.o(236700);
          throw localIOException;
        }
      }
    }
    
    public void close()
    {
      AppMethodBeat.i(236704);
      if (!this.YDP)
      {
        AppMethodBeat.o(236704);
        return;
      }
      for (;;)
      {
        synchronized (YDL)
        {
          RefCountedFileSystem.b localb = (RefCountedFileSystem.b)YDL.get(Long.valueOf(this.YDN));
          if (localb == null)
          {
            this.YDM.close();
            this.YDP = false;
            AppMethodBeat.o(236704);
            return;
          }
          if (!this.YDO)
          {
            int i = localb.YDH - 1;
            localb.YDH = i;
            if (i != 0)
            {
              if (localb.YDF == null) {
                localb.YDF = new ArrayList(4);
              }
              localb.YDF.add(this.YDM);
            }
          }
        }
        if (localObject.YDG != null) {
          localObject.YDG.release();
        }
        if (localObject.YDF != null)
        {
          Iterator localIterator = localObject.YDF.iterator();
          while (localIterator.hasNext()) {
            ((RandomAccessFile)localIterator.next()).close();
          }
        }
        this.YDM.close();
        YDL.remove(Long.valueOf(this.YDN));
        YDL.notifyAll();
      }
    }
    
    protected void finalize()
    {
      AppMethodBeat.i(236708);
      close();
      AppMethodBeat.o(236708);
    }
  }
  
  static final class e
    extends RefCountedFileSystem.d
  {
    e(String paramString)
    {
      super(true);
    }
    
    final int aza(int paramInt)
    {
      AppMethodBeat.i(236720);
      long l = Math.max(this.YDM.length() + paramInt, 0L);
      this.YDM.setLength(l);
      paramInt = (int)l;
      AppMethodBeat.o(236720);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.RefCountedFileSystem
 * JD-Core Version:    0.7.0.1
 */