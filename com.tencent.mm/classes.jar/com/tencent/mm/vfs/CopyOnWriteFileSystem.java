package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Map;

public class CopyOnWriteFileSystem
  extends WrapperFileSystem<NativeFileSystem>
  implements Handler.Callback
{
  public static final Parcelable.Creator<CopyOnWriteFileSystem> CREATOR;
  private final long HRn;
  private volatile String HRo;
  private final HashSet<String> HRp;
  private final HashSet<String> HRq;
  private final Handler HRr;
  
  static
  {
    AppMethodBeat.i(13090);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13090);
  }
  
  protected CopyOnWriteFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(13068);
    this.HRo = null;
    this.HRp = new HashSet();
    this.HRq = new HashSet();
    q.a(paramParcel, CopyOnWriteFileSystem.class, 1);
    this.HRn = paramParcel.readLong();
    this.HRr = new Handler(a.gap().LDp.getLooper(), this);
    AppMethodBeat.o(13068);
  }
  
  /* Error */
  private String aMG(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: sipush 13071
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/tencent/mm/vfs/CopyOnWriteFileSystem:HRo	Ljava/lang/String;
    //   12: ifnonnull +11 -> 23
    //   15: sipush 13071
    //   18: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 100	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: getfield 105	com/tencent/mm/vfs/CopyOnWriteFileSystem:HRw	Lcom/tencent/mm/vfs/FileSystem;
    //   34: checkcast 107	com/tencent/mm/vfs/NativeFileSystem
    //   37: aload_1
    //   38: iconst_0
    //   39: invokevirtual 111	com/tencent/mm/vfs/NativeFileSystem:cP	(Ljava/lang/String;Z)Ljava/lang/String;
    //   42: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: sipush 8203
    //   48: invokevirtual 118	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   51: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore 6
    //   56: new 124	java/io/FileInputStream
    //   59: dup
    //   60: aload 6
    //   62: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_1
    //   70: sipush 4096
    //   73: newarray byte
    //   75: astore 5
    //   77: iload_2
    //   78: sipush 4096
    //   81: if_icmpge +32 -> 113
    //   84: aload 4
    //   86: astore_1
    //   87: aload 4
    //   89: aload 5
    //   91: iload_2
    //   92: sipush 4096
    //   95: iload_2
    //   96: isub
    //   97: invokevirtual 131	java/io/FileInputStream:read	([BII)I
    //   100: istore_3
    //   101: iload_3
    //   102: iconst_m1
    //   103: if_icmpeq +10 -> 113
    //   106: iload_3
    //   107: iload_2
    //   108: iadd
    //   109: istore_2
    //   110: goto -33 -> 77
    //   113: aload 4
    //   115: astore_1
    //   116: new 133	java/lang/String
    //   119: dup
    //   120: aload 5
    //   122: iconst_0
    //   123: iload_2
    //   124: invokespecial 136	java/lang/String:<init>	([BII)V
    //   127: astore 5
    //   129: aload 4
    //   131: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   134: sipush 13071
    //   137: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload 5
    //   142: areturn
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   150: sipush 13071
    //   153: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aconst_null
    //   157: areturn
    //   158: astore 5
    //   160: aconst_null
    //   161: astore 4
    //   163: aload 4
    //   165: astore_1
    //   166: ldc 142
    //   168: aload 5
    //   170: ldc 144
    //   172: aload 6
    //   174: invokestatic 148	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokevirtual 151	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   180: invokestatic 157	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   183: aload 4
    //   185: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   188: sipush 13071
    //   191: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   204: sipush 13071
    //   207: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload 4
    //   212: athrow
    //   213: astore 4
    //   215: goto -15 -> 200
    //   218: astore 5
    //   220: goto -57 -> 163
    //   223: astore_1
    //   224: aload 4
    //   226: astore_1
    //   227: goto -81 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	CopyOnWriteFileSystem
    //   0	230	1	paramString	String
    //   1	123	2	i	int
    //   100	9	3	j	int
    //   65	119	4	localFileInputStream	FileInputStream
    //   196	15	4	localObject1	Object
    //   213	12	4	localObject2	Object
    //   75	66	5	localObject3	Object
    //   158	11	5	localIOException1	IOException
    //   218	1	5	localIOException2	IOException
    //   54	119	6	str	String
    // Exception table:
    //   from	to	target	type
    //   56	67	143	java/io/FileNotFoundException
    //   56	67	158	java/io/IOException
    //   56	67	196	finally
    //   70	77	213	finally
    //   87	101	213	finally
    //   116	129	213	finally
    //   166	183	213	finally
    //   70	77	218	java/io/IOException
    //   87	101	218	java/io/IOException
    //   116	129	218	java/io/IOException
    //   70	77	223	java/io/FileNotFoundException
    //   87	101	223	java/io/FileNotFoundException
    //   116	129	223	java/io/FileNotFoundException
  }
  
  private static String aMH(String paramString)
  {
    AppMethodBeat.i(13089);
    paramString = paramString.substring(0, paramString.length() - 1);
    AppMethodBeat.o(13089);
    return paramString;
  }
  
  private boolean cQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13075);
    String str1 = aMG(paramString);
    if (str1 == null)
    {
      AppMethodBeat.o(13075);
      return false;
    }
    String str2 = str1 + '‌';
    int i = gk(str2, -1);
    if (!paramBoolean) {
      if (i == 0)
      {
        new File(str1).delete();
        new File(str2).delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13075);
      return true;
      paramString = ((NativeFileSystem)this.HRw).cP(paramString, true);
      if (i == 0)
      {
        if (!new File(str1).renameTo(new File(paramString)))
        {
          lx(str1, paramString);
          new File(str1).delete();
        }
        new File(str2).delete();
      }
      else
      {
        lx(str1, paramString);
      }
    }
  }
  
  /* Error */
  private static int gk(String paramString, int paramInt)
  {
    // Byte code:
    //   0: sipush 13088
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 190
    //   8: istore_2
    //   9: new 192	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 194
    //   16: invokespecial 196	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore 11
    //   21: getstatic 202	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 21
    //   26: if_icmplt +88 -> 114
    //   29: aload 11
    //   31: invokestatic 205	com/tencent/mm/vfs/CopyOnWriteFileSystem$a:i	(Ljava/io/RandomAccessFile;)J
    //   34: lstore 4
    //   36: lload 4
    //   38: invokestatic 209	com/tencent/mm/vfs/CopyOnWriteFileSystem$b:lock	(J)V
    //   41: aload 11
    //   43: invokevirtual 213	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   46: invokevirtual 218	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   49: astore_0
    //   50: aload_0
    //   51: astore 13
    //   53: lload 4
    //   55: lstore 6
    //   57: aload 11
    //   59: astore 12
    //   61: aload 11
    //   63: invokevirtual 213	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   66: invokevirtual 221	java/nio/channels/FileChannel:size	()J
    //   69: lstore 8
    //   71: lload 8
    //   73: l2i
    //   74: istore_2
    //   75: iload_1
    //   76: ifne +63 -> 139
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 226	java/nio/channels/FileLock:release	()V
    //   87: lload 4
    //   89: ldc2_w 227
    //   92: lcmp
    //   93: ifeq +8 -> 101
    //   96: lload 4
    //   98: invokestatic 231	com/tencent/mm/vfs/CopyOnWriteFileSystem$b:unlock	(J)V
    //   101: aload 11
    //   103: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   106: sipush 13088
    //   109: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iload_2
    //   113: ireturn
    //   114: aload_0
    //   115: invokevirtual 234	java/lang/String:hashCode	()I
    //   118: i2l
    //   119: lstore 4
    //   121: aload_0
    //   122: invokevirtual 162	java/lang/String:length	()I
    //   125: istore_3
    //   126: lload 4
    //   128: iload_3
    //   129: i2l
    //   130: bipush 32
    //   132: lshl
    //   133: lor
    //   134: lstore 4
    //   136: goto -100 -> 36
    //   139: iload_2
    //   140: iload_1
    //   141: iadd
    //   142: istore_1
    //   143: iload_1
    //   144: ifgt +61 -> 205
    //   147: lconst_0
    //   148: lstore 8
    //   150: aload_0
    //   151: astore 13
    //   153: lload 4
    //   155: lstore 6
    //   157: aload 11
    //   159: astore 12
    //   161: iload_1
    //   162: istore_2
    //   163: aload 11
    //   165: lload 8
    //   167: invokevirtual 237	java/io/RandomAccessFile:setLength	(J)V
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 226	java/nio/channels/FileLock:release	()V
    //   178: lload 4
    //   180: ldc2_w 227
    //   183: lcmp
    //   184: ifeq +8 -> 192
    //   187: lload 4
    //   189: invokestatic 231	com/tencent/mm/vfs/CopyOnWriteFileSystem$b:unlock	(J)V
    //   192: aload 11
    //   194: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   197: sipush 13088
    //   200: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iload_1
    //   204: ireturn
    //   205: iload_1
    //   206: i2l
    //   207: lstore 8
    //   209: goto -59 -> 150
    //   212: astore 10
    //   214: aconst_null
    //   215: astore_0
    //   216: ldc2_w 227
    //   219: lstore 4
    //   221: aconst_null
    //   222: astore 11
    //   224: aload_0
    //   225: astore 13
    //   227: lload 4
    //   229: lstore 6
    //   231: aload 11
    //   233: astore 12
    //   235: ldc 142
    //   237: aload 10
    //   239: ldc 239
    //   241: invokestatic 242	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 226	java/nio/channels/FileLock:release	()V
    //   252: lload 4
    //   254: ldc2_w 227
    //   257: lcmp
    //   258: ifeq +8 -> 266
    //   261: lload 4
    //   263: invokestatic 231	com/tencent/mm/vfs/CopyOnWriteFileSystem$b:unlock	(J)V
    //   266: aload 11
    //   268: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   271: sipush 13088
    //   274: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iload_2
    //   278: ireturn
    //   279: astore_0
    //   280: aconst_null
    //   281: astore 10
    //   283: ldc2_w 227
    //   286: lstore 4
    //   288: aconst_null
    //   289: astore 11
    //   291: aload 10
    //   293: ifnull +8 -> 301
    //   296: aload 10
    //   298: invokevirtual 226	java/nio/channels/FileLock:release	()V
    //   301: lload 4
    //   303: ldc2_w 227
    //   306: lcmp
    //   307: ifeq +8 -> 315
    //   310: lload 4
    //   312: invokestatic 231	com/tencent/mm/vfs/CopyOnWriteFileSystem$b:unlock	(J)V
    //   315: aload 11
    //   317: invokestatic 140	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   320: sipush 13088
    //   323: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_0
    //   327: athrow
    //   328: astore_0
    //   329: goto -242 -> 87
    //   332: astore_0
    //   333: goto -155 -> 178
    //   336: astore_0
    //   337: goto -85 -> 252
    //   340: astore 10
    //   342: goto -41 -> 301
    //   345: astore_0
    //   346: aconst_null
    //   347: astore 10
    //   349: ldc2_w 227
    //   352: lstore 4
    //   354: goto -63 -> 291
    //   357: astore_0
    //   358: aconst_null
    //   359: astore 10
    //   361: goto -70 -> 291
    //   364: astore_0
    //   365: aload 13
    //   367: astore 10
    //   369: lload 6
    //   371: lstore 4
    //   373: aload 12
    //   375: astore 11
    //   377: goto -86 -> 291
    //   380: astore 10
    //   382: aconst_null
    //   383: astore_0
    //   384: ldc2_w 227
    //   387: lstore 4
    //   389: goto -165 -> 224
    //   392: astore 10
    //   394: aconst_null
    //   395: astore_0
    //   396: goto -172 -> 224
    //   399: astore 10
    //   401: goto -177 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString	String
    //   0	404	1	paramInt	int
    //   8	270	2	i	int
    //   125	4	3	j	int
    //   34	354	4	l1	long
    //   55	315	6	l2	long
    //   69	139	8	l3	long
    //   212	26	10	localIOException1	IOException
    //   281	16	10	localObject1	Object
    //   340	1	10	localIOException2	IOException
    //   347	21	10	str1	String
    //   380	1	10	localIOException3	IOException
    //   392	1	10	localIOException4	IOException
    //   399	1	10	localIOException5	IOException
    //   19	357	11	localObject2	Object
    //   59	315	12	localObject3	Object
    //   51	315	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   9	21	212	java/io/IOException
    //   9	21	279	finally
    //   83	87	328	java/io/IOException
    //   174	178	332	java/io/IOException
    //   248	252	336	java/io/IOException
    //   296	301	340	java/io/IOException
    //   21	36	345	finally
    //   114	126	345	finally
    //   36	50	357	finally
    //   61	71	364	finally
    //   163	170	364	finally
    //   235	244	364	finally
    //   21	36	380	java/io/IOException
    //   114	126	380	java/io/IOException
    //   36	50	392	java/io/IOException
    //   61	71	399	java/io/IOException
    //   163	170	399	java/io/IOException
  }
  
  private static void lx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13074);
    try
    {
      FileChannel localFileChannel1 = new FileOutputStream(paramString2).getChannel();
      FileChannel localFileChannel2 = new FileInputStream(paramString1).getChannel();
      localFileChannel1.transferFrom(localFileChannel2, 0L, localFileChannel2.size());
      AppMethodBeat.o(13074);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("VFS.CopyOnWriteFileSystem", localIOException, "Failed to copy file: " + paramString1 + " -> " + paramString2);
      AppMethodBeat.o(13074);
    }
  }
  
  public final ReadableByteChannel aMA(String paramString)
  {
    AppMethodBeat.i(13073);
    paramString = openRead(paramString);
    if ((paramString instanceof FileInputStream))
    {
      paramString = ((FileInputStream)paramString).getChannel();
      AppMethodBeat.o(13073);
      return paramString;
    }
    paramString = Channels.newChannel(paramString);
    AppMethodBeat.o(13073);
    return paramString;
  }
  
  public final ByteChannel aMB(String paramString)
  {
    AppMethodBeat.i(13078);
    cQ(paramString, true);
    paramString = ((NativeFileSystem)this.HRw).aMB(paramString);
    AppMethodBeat.o(13078);
    return paramString;
  }
  
  public final FileSystem.b aMC(String paramString)
  {
    AppMethodBeat.i(13070);
    paramString = ((NativeFileSystem)this.HRw).aMC(paramString);
    AppMethodBeat.o(13070);
    return paramString;
  }
  
  public final boolean aMD(String paramString)
  {
    AppMethodBeat.i(13079);
    if ((((NativeFileSystem)this.HRw).aMD(paramString)) || (((NativeFileSystem)this.HRw).aMD(paramString + '​')))
    {
      AppMethodBeat.o(13079);
      return true;
    }
    AppMethodBeat.o(13079);
    return false;
  }
  
  public final FileSystem.a aME(String paramString)
  {
    AppMethodBeat.i(13080);
    Object localObject1 = ((NativeFileSystem)this.HRw).aME(paramString);
    if (localObject1 != null)
    {
      AppMethodBeat.o(13080);
      return localObject1;
    }
    Object localObject2 = ((NativeFileSystem)this.HRw).aME(paramString + '​');
    if (localObject2 == null)
    {
      AppMethodBeat.o(13080);
      return null;
    }
    paramString = aMH(((FileSystem.a)localObject2).EQk);
    localObject1 = aMG(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(13080);
      return null;
    }
    localObject2 = aMH(((FileSystem.a)localObject2).name);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = a.a((String)localObject1, this, paramString, (String)localObject2);
      AppMethodBeat.o(13080);
      return paramString;
    }
    localObject1 = new File((String)localObject1);
    if (!((File)localObject1).exists())
    {
      AppMethodBeat.o(13080);
      return null;
    }
    boolean bool = ((File)localObject1).isDirectory();
    long l = ((File)localObject1).length();
    paramString = new FileSystem.a(this, paramString, (String)localObject2, l, 0xFFFFF000 & 4096L + l - 1L, ((File)localObject1).lastModified(), bool);
    AppMethodBeat.o(13080);
    return paramString;
  }
  
  protected final boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return false;
  }
  
  public final void bN(Map<String, String> arg1)
  {
    AppMethodBeat.i(13086);
    ((NativeFileSystem)this.HRw).bN(???);
    ??? = ((NativeFileSystem)this.HRw).HSl;
    if (??? != null)
    {
      ??? = ??? + '/' + ".cow/";
      if (!???.equals(((NativeFileSystem)this.HRw).cP(".cow/", false)))
      {
        ??? = new RuntimeException("realPath is illegal with filesystem: " + ((NativeFileSystem)this.HRw).toString());
        AppMethodBeat.o(13086);
        throw ???;
      }
      if (!???.equals(this.HRo))
      {
        this.HRo = ???;
        new File(this.HRo).mkdirs();
        synchronized (this.HRp)
        {
          this.HRp.clear();
          AppMethodBeat.o(13086);
          return;
        }
      }
    }
    AppMethodBeat.o(13086);
  }
  
  public final WritableByteChannel cL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13077);
    paramString = cM(paramString, paramBoolean);
    if ((paramString instanceof FileOutputStream))
    {
      paramString = ((FileOutputStream)paramString).getChannel();
      AppMethodBeat.o(13077);
      return paramString;
    }
    paramString = Channels.newChannel(paramString);
    AppMethodBeat.o(13077);
    return paramString;
  }
  
  public final OutputStream cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13076);
    cQ(paramString, paramBoolean);
    paramString = ((NativeFileSystem)this.HRw).cM(paramString, paramBoolean);
    AppMethodBeat.o(13076);
    return paramString;
  }
  
  public final Iterable<FileSystem.a> cN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13083);
    paramString = new UnsupportedOperationException();
    AppMethodBeat.o(13083);
    throw paramString;
  }
  
  public final boolean cO(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String cP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13084);
    String str = ((NativeFileSystem)this.HRw).cP(paramString, paramBoolean);
    if ((paramBoolean) || (new File(str).exists()))
    {
      AppMethodBeat.o(13084);
      return str;
    }
    paramString = aMG(paramString);
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(13084);
      return paramString;
    }
    AppMethodBeat.o(13084);
    return str;
  }
  
  public final boolean cf(String paramString, long paramLong)
  {
    AppMethodBeat.i(13081);
    if (((NativeFileSystem)this.HRw).cf(paramString, paramLong))
    {
      AppMethodBeat.o(13081);
      return true;
    }
    boolean bool = ((NativeFileSystem)this.HRw).cf(paramString + '​', paramLong);
    AppMethodBeat.o(13081);
    return bool;
  }
  
  protected final long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(13085);
    if ((paramFileSystem instanceof CopyOnWriteFileSystem))
    {
      paramFileSystem = (CopyOnWriteFileSystem)paramFileSystem;
      Object localObject = ((NativeFileSystem)paramFileSystem.HRw).aME(paramString2);
      if (localObject == null)
      {
        localObject = paramFileSystem.aMG(paramString2);
        if (localObject == null)
        {
          paramString1 = new FileNotFoundException("File not found: ".concat(String.valueOf(paramString2)));
          AppMethodBeat.o(13085);
          throw paramString1;
        }
        vv(paramString1);
        gk((String)localObject + '‌', 1);
        l = ((NativeFileSystem)this.HRw).d(paramString1 + '​', paramFileSystem.HRw, paramString2 + '​');
        AppMethodBeat.o(13085);
        return l;
      }
      if (((FileSystem.a)localObject).size >= this.HRn)
      {
        AppMethodBeat.o(13085);
        return -1L;
      }
      l = ((NativeFileSystem)this.HRw).d(paramString1, paramFileSystem.HRw, paramString2);
      AppMethodBeat.o(13085);
      return l;
    }
    long l = ((NativeFileSystem)this.HRw).d(paramString1, paramFileSystem, paramString2);
    AppMethodBeat.o(13085);
    return l;
  }
  
  public final int fhA()
  {
    AppMethodBeat.i(13069);
    int i = ((NativeFileSystem)this.HRw).fhA();
    AppMethodBeat.o(13069);
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13072);
    try
    {
      Object localObject = ((NativeFileSystem)this.HRw).openRead(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(13072);
        return localObject;
      }
      localObject = new FileNotFoundException("Filesystem returns null for path: " + paramString + ", FS: " + ((NativeFileSystem)this.HRw).toString());
      AppMethodBeat.o(13072);
      throw ((Throwable)localObject);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramString = aMG(paramString);
      if (paramString != null)
      {
        paramString = new NativeFileSystem.c(paramString);
        AppMethodBeat.o(13072);
        return paramString;
      }
      AppMethodBeat.o(13072);
      throw localFileNotFoundException;
    }
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(13082);
    boolean bool1 = cQ(paramString, false);
    boolean bool2 = ((NativeFileSystem)this.HRw).vv(paramString);
    AppMethodBeat.o(13082);
    return bool2 | bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13087);
    super.writeToParcel(paramParcel, paramInt);
    q.b(paramParcel, CopyOnWriteFileSystem.class, 1);
    paramParcel.writeLong(this.HRn);
    AppMethodBeat.o(13087);
  }
  
  @TargetApi(21)
  static final class a
  {
    static FileSystem.a a(String paramString1, FileSystem paramFileSystem, String paramString2, String paramString3)
    {
      AppMethodBeat.i(13064);
      try
      {
        paramString1 = Os.stat(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(13064);
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramString1.st_mode);
        paramString1 = new FileSystem.a(paramFileSystem, paramString2, paramString3, paramString1.st_size, paramString1.st_blocks * 512L, 1000L * paramString1.st_mtime, bool);
        AppMethodBeat.o(13064);
        return paramString1;
      }
      catch (ErrnoException paramString1)
      {
        AppMethodBeat.o(13064);
      }
      return null;
    }
    
    static long i(RandomAccessFile paramRandomAccessFile)
    {
      AppMethodBeat.i(13063);
      try
      {
        long l = Os.fstat(paramRandomAccessFile.getFD()).st_ino;
        AppMethodBeat.o(13063);
        return l;
      }
      catch (ErrnoException paramRandomAccessFile)
      {
        paramRandomAccessFile = new IOException(paramRandomAccessFile);
        AppMethodBeat.o(13063);
        throw paramRandomAccessFile;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem
 * JD-Core Version:    0.7.0.1
 */