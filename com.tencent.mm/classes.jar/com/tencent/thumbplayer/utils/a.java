package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static Map<String, a> mInstanceMap;
  private a ZHO;
  
  static
  {
    AppMethodBeat.i(222163);
    mInstanceMap = new HashMap();
    AppMethodBeat.o(222163);
  }
  
  private a(File paramFile)
  {
    AppMethodBeat.i(222120);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      this.ZHO = null;
      AppMethodBeat.o(222120);
      return;
    }
    this.ZHO = new a(paramFile, 50000000L, 2147483647, (byte)0);
    AppMethodBeat.o(222120);
  }
  
  private static a U(File paramFile)
  {
    AppMethodBeat.i(222110);
    localObject = null;
    try
    {
      locala = (a)mInstanceMap.get(paramFile.getAbsoluteFile() + myPid());
      localObject = locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a locala;
        label92:
        continue;
        paramFile = localObject;
      }
    }
    if (localObject == null)
    {
      try
      {
        locala = new a(paramFile);
      }
      catch (Throwable paramFile)
      {
        for (;;)
        {
          paramFile = localObject;
        }
      }
      try
      {
        mInstanceMap.put(paramFile.getAbsolutePath() + myPid(), locala);
        paramFile = locala;
      }
      catch (Throwable paramFile)
      {
        paramFile = locala;
        break label92;
      }
      AppMethodBeat.o(222110);
      return paramFile;
    }
  }
  
  public static a dh(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222102);
    paramContext = U(new File(paramContext.getCacheDir(), paramString));
    AppMethodBeat.o(222102);
    return paramContext;
  }
  
  /* Error */
  private byte[] getAsBinary(String paramString)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 117
    //   14: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   23: aload_1
    //   24: invokevirtual 120	com/tencent/thumbplayer/utils/a$a:get	(Ljava/lang/String;)Ljava/io/File;
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 45	java/io/File:exists	()Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +10 -> 44
    //   37: ldc 117
    //   39: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 122	java/io/RandomAccessFile
    //   47: dup
    //   48: aload_3
    //   49: ldc 124
    //   51: invokespecial 125	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 129	java/io/RandomAccessFile:length	()J
    //   59: l2i
    //   60: newarray byte
    //   62: astore 4
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 133	java/io/RandomAccessFile:read	([B)I
    //   70: ifle +66 -> 136
    //   73: aload 4
    //   75: invokestatic 137	com/tencent/thumbplayer/utils/a$b:isDue	([B)Z
    //   78: ifne +41 -> 119
    //   81: aload 4
    //   83: astore_1
    //   84: aload 4
    //   86: invokestatic 140	com/tencent/thumbplayer/utils/a$b:hasDateInfo	([B)Z
    //   89: ifeq +19 -> 108
    //   92: aload 4
    //   94: aload 4
    //   96: invokestatic 143	com/tencent/thumbplayer/utils/a$b:dx	([B)I
    //   99: iconst_1
    //   100: iadd
    //   101: aload 4
    //   103: arraylength
    //   104: invokestatic 147	com/tencent/thumbplayer/utils/a$b:copyOfRange	([BII)[B
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   112: ldc 117
    //   114: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: areturn
    //   119: aload_3
    //   120: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 154	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   128: pop
    //   129: ldc 117
    //   131: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   140: ldc 117
    //   142: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   158: ldc 117
    //   160: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   176: ldc 117
    //   178: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_3
    //   184: goto -72 -> 112
    //   187: astore_3
    //   188: goto -65 -> 123
    //   191: astore_1
    //   192: goto -52 -> 140
    //   195: astore_1
    //   196: goto -38 -> 158
    //   199: astore_3
    //   200: goto -24 -> 176
    //   203: astore_1
    //   204: goto -36 -> 168
    //   207: astore_1
    //   208: aload_3
    //   209: astore_1
    //   210: goto -60 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	a
    //   0	213	1	paramString	String
    //   32	2	2	bool	boolean
    //   27	146	3	localObject	Object
    //   183	1	3	localIOException1	java.io.IOException
    //   187	1	3	localIOException2	java.io.IOException
    //   199	10	3	localIOException3	java.io.IOException
    //   62	40	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   19	33	147	java/lang/Exception
    //   44	55	147	java/lang/Exception
    //   19	33	165	finally
    //   44	55	165	finally
    //   108	112	183	java/io/IOException
    //   119	123	187	java/io/IOException
    //   136	140	191	java/io/IOException
    //   154	158	195	java/io/IOException
    //   172	176	199	java/io/IOException
    //   55	81	203	finally
    //   84	108	203	finally
    //   55	81	207	java/lang/Exception
    //   84	108	207	java/lang/Exception
  }
  
  private static String myPid()
  {
    AppMethodBeat.i(222114);
    String str = "_" + Process.myPid();
    AppMethodBeat.o(222114);
    return str;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(222161);
    if (this.ZHO == null)
    {
      AppMethodBeat.o(222161);
      return;
    }
    this.ZHO.clear();
    AppMethodBeat.o(222161);
  }
  
  /* Error */
  public final Object getAsObject(String paramString)
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 177	com/tencent/thumbplayer/utils/a:getAsBinary	(Ljava/lang/String;)[B
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +97 -> 109
    //   15: new 179	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 182	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore_2
    //   24: new 184	java/io/ObjectInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 191	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   42: aload_1
    //   43: invokevirtual 193	java/io/ObjectInputStream:close	()V
    //   46: ldc 175
    //   48: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_3
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 193	java/io/ObjectInputStream:close	()V
    //   74: ldc 175
    //   76: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 193	java/io/ObjectInputStream:close	()V
    //   102: ldc 175
    //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: ldc 175
    //   111: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_2
    //   117: goto -75 -> 42
    //   120: astore_1
    //   121: goto -75 -> 46
    //   124: astore_2
    //   125: goto -59 -> 66
    //   128: astore_1
    //   129: goto -55 -> 74
    //   132: astore_3
    //   133: goto -39 -> 94
    //   136: astore_2
    //   137: goto -35 -> 102
    //   140: astore_1
    //   141: aconst_null
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload 4
    //   148: astore_2
    //   149: goto -63 -> 86
    //   152: astore 4
    //   154: aload_1
    //   155: astore 5
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: astore_1
    //   162: aload 5
    //   164: astore_2
    //   165: goto -79 -> 86
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -113 -> 58
    //   174: astore_3
    //   175: goto -117 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	a
    //   0	178	1	paramString	String
    //   23	76	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   116	1	2	localIOException1	java.io.IOException
    //   124	1	2	localIOException2	java.io.IOException
    //   136	9	2	localIOException3	java.io.IOException
    //   148	17	2	localObject1	Object
    //   37	54	3	localObject2	Object
    //   132	1	3	localIOException4	java.io.IOException
    //   145	14	3	localObject3	Object
    //   174	1	3	localException	Exception
    //   142	5	4	localObject4	Object
    //   152	8	4	localObject5	Object
    //   155	8	5	str	String
    // Exception table:
    //   from	to	target	type
    //   15	24	53	java/lang/Exception
    //   15	24	81	finally
    //   38	42	116	java/io/IOException
    //   42	46	120	java/io/IOException
    //   62	66	124	java/io/IOException
    //   70	74	128	java/io/IOException
    //   90	94	132	java/io/IOException
    //   98	102	136	java/io/IOException
    //   24	33	140	finally
    //   33	38	152	finally
    //   24	33	168	java/lang/Exception
    //   33	38	174	java/lang/Exception
  }
  
  /* Error */
  public final void put(String paramString, java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 195
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 197	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 198	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore 5
    //   17: new 200	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload 5
    //   23: invokespecial 203	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_3
    //   27: aload_3
    //   28: aload_2
    //   29: invokevirtual 207	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload 5
    //   34: invokevirtual 211	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   37: astore_2
    //   38: aload_0
    //   39: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   42: ifnull +45 -> 87
    //   45: aload_0
    //   46: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   49: aload_1
    //   50: invokevirtual 214	com/tencent/thumbplayer/utils/a$a:newFile	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore 5
    //   55: new 216	java/io/FileOutputStream
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_1
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 220	java/io/FileOutputStream:write	([B)V
    //   70: aload_1
    //   71: invokevirtual 223	java/io/FileOutputStream:flush	()V
    //   74: aload_1
    //   75: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   78: aload_0
    //   79: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   82: aload 5
    //   84: invokestatic 227	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   87: aload_3
    //   88: invokevirtual 228	java/io/ObjectOutputStream:close	()V
    //   91: ldc 195
    //   93: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +11 -> 112
    //   104: aload_1
    //   105: invokevirtual 223	java/io/FileOutputStream:flush	()V
    //   108: aload_1
    //   109: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   112: aload_0
    //   113: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   116: aload 5
    //   118: invokestatic 227	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   121: goto -34 -> 87
    //   124: astore_1
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 228	java/io/ObjectOutputStream:close	()V
    //   133: ldc 195
    //   135: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +11 -> 154
    //   146: aload_2
    //   147: invokevirtual 223	java/io/FileOutputStream:flush	()V
    //   150: aload_2
    //   151: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   154: aload_0
    //   155: getfield 50	com/tencent/thumbplayer/utils/a:ZHO	Lcom/tencent/thumbplayer/utils/a$a;
    //   158: aload 5
    //   160: invokestatic 227	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   163: ldc 195
    //   165: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 228	java/io/ObjectOutputStream:close	()V
    //   179: ldc 195
    //   181: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: return
    //   185: astore_1
    //   186: ldc 195
    //   188: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_1
    //   193: ldc 195
    //   195: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: astore_1
    //   200: ldc 195
    //   202: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: return
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 228	java/io/ObjectOutputStream:close	()V
    //   217: ldc 195
    //   219: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: athrow
    //   224: astore_2
    //   225: goto -8 -> 217
    //   228: astore_1
    //   229: goto -20 -> 209
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -64 -> 171
    //   238: astore_1
    //   239: aload 4
    //   241: astore_3
    //   242: goto -117 -> 125
    //   245: astore_2
    //   246: goto -92 -> 154
    //   249: astore_2
    //   250: aload_1
    //   251: astore 4
    //   253: aload_2
    //   254: astore_1
    //   255: aload 4
    //   257: astore_2
    //   258: goto -116 -> 142
    //   261: astore_1
    //   262: goto -150 -> 112
    //   265: astore_2
    //   266: goto -166 -> 100
    //   269: astore_1
    //   270: goto -192 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	a
    //   0	273	1	paramString	String
    //   0	273	2	paramSerializable	java.io.Serializable
    //   26	216	3	localObject1	Object
    //   1	255	4	str	String
    //   15	144	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	65	97	java/lang/Exception
    //   27	55	124	java/lang/Exception
    //   70	78	124	java/lang/Exception
    //   78	87	124	java/lang/Exception
    //   104	112	124	java/lang/Exception
    //   112	121	124	java/lang/Exception
    //   146	154	124	java/lang/Exception
    //   154	170	124	java/lang/Exception
    //   55	65	139	finally
    //   27	55	170	java/lang/Throwable
    //   70	78	170	java/lang/Throwable
    //   78	87	170	java/lang/Throwable
    //   104	112	170	java/lang/Throwable
    //   112	121	170	java/lang/Throwable
    //   146	154	170	java/lang/Throwable
    //   154	170	170	java/lang/Throwable
    //   87	91	185	java/lang/Throwable
    //   129	133	192	java/lang/Throwable
    //   175	179	199	java/lang/Throwable
    //   8	27	206	finally
    //   213	217	224	java/lang/Throwable
    //   27	55	228	finally
    //   70	78	228	finally
    //   78	87	228	finally
    //   104	112	228	finally
    //   112	121	228	finally
    //   146	154	228	finally
    //   154	170	228	finally
    //   8	27	232	java/lang/Throwable
    //   8	27	238	java/lang/Exception
    //   146	154	245	java/io/IOException
    //   65	70	249	finally
    //   104	112	261	java/io/IOException
    //   65	70	265	java/lang/Exception
    //   70	78	269	java/io/IOException
  }
  
  public final boolean remove(String paramString)
  {
    AppMethodBeat.i(222159);
    if (this.ZHO == null)
    {
      AppMethodBeat.o(222159);
      return false;
    }
    boolean bool = a.a(this.ZHO, paramString);
    AppMethodBeat.o(222159);
    return bool;
  }
  
  public static final class a
  {
    final AtomicInteger cacheCount;
    protected File cacheDir;
    final AtomicLong cacheSize;
    private final int countLimit;
    final Map<File, Long> lastUsageDates;
    private final long sizeLimit;
    
    private a(File paramFile, long paramLong, int paramInt)
    {
      AppMethodBeat.i(222056);
      this.lastUsageDates = Collections.synchronizedMap(new HashMap());
      this.cacheDir = paramFile;
      this.sizeLimit = paramLong;
      this.countLimit = paramInt;
      this.cacheSize = new AtomicLong();
      this.cacheCount = new AtomicInteger();
      j.THREAD_POOL_EXECUTOR.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222050);
          File[] arrayOfFile = a.a.this.cacheDir.listFiles();
          if (arrayOfFile != null)
          {
            int m = arrayOfFile.length;
            int j = 0;
            int i = 0;
            int k = 0;
            while (j < m)
            {
              File localFile = arrayOfFile[j];
              k = (int)(k + a.a.calculateSize(localFile));
              a.a.this.lastUsageDates.put(localFile, Long.valueOf(localFile.lastModified()));
              j += 1;
              i += 1;
            }
            a.a.this.cacheSize.set(k);
            a.a.this.cacheCount.set(i);
          }
          AppMethodBeat.o(222050);
        }
      });
      AppMethodBeat.o(222056);
    }
    
    static long calculateSize(File paramFile)
    {
      AppMethodBeat.i(222076);
      if (paramFile == null)
      {
        AppMethodBeat.o(222076);
        return 0L;
      }
      long l = paramFile.length();
      AppMethodBeat.o(222076);
      return l;
    }
    
    private void put(File paramFile)
    {
      AppMethodBeat.i(222063);
      for (int i = this.cacheCount.get(); i + 1 > this.countLimit; i = this.cacheCount.addAndGet(-1))
      {
        l1 = removeNext();
        this.cacheSize.addAndGet(-l1);
      }
      this.cacheCount.addAndGet(1);
      long l2 = calculateSize(paramFile);
      for (long l1 = this.cacheSize.get(); l1 + l2 > this.sizeLimit; l1 = this.cacheSize.addAndGet(-l1)) {
        l1 = removeNext();
      }
      this.cacheSize.addAndGet(l2);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramFile.setLastModified(localLong.longValue());
      this.lastUsageDates.put(paramFile, localLong);
      AppMethodBeat.o(222063);
    }
    
    private boolean remove(String paramString)
    {
      AppMethodBeat.i(222066);
      boolean bool = get(paramString).delete();
      AppMethodBeat.o(222066);
      return bool;
    }
    
    private long removeNext()
    {
      AppMethodBeat.i(222074);
      if (this.lastUsageDates.isEmpty())
      {
        AppMethodBeat.o(222074);
        return 0L;
      }
      Object localObject1 = this.lastUsageDates.entrySet();
      for (;;)
      {
        synchronized (this.lastUsageDates)
        {
          Iterator localIterator = ((Set)localObject1).iterator();
          localObject1 = null;
          localObject3 = null;
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (localObject1 == null)
            {
              localObject1 = (File)localEntry.getKey();
              localObject3 = (Long)localEntry.getValue();
              continue;
            }
            localObject4 = (Long)localEntry.getValue();
            if (((Long)localObject4).longValue() >= ((Long)localObject3).longValue()) {
              break label211;
            }
            localObject3 = (File)localEntry.getKey();
            localObject1 = localObject4;
            break label221;
          }
          if (localObject1 == null)
          {
            AppMethodBeat.o(222074);
            return 0L;
          }
        }
        long l = calculateSize(localFile);
        if ((localFile != null) && (localFile.delete())) {
          this.lastUsageDates.remove(localFile);
        }
        AppMethodBeat.o(222074);
        return l;
        label211:
        Object localObject4 = localFile;
        Object localObject2 = localObject3;
        Object localObject3 = localObject4;
        label221:
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
    
    final void clear()
    {
      AppMethodBeat.i(222067);
      this.lastUsageDates.clear();
      this.cacheSize.set(0L);
      File[] arrayOfFile = this.cacheDir.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
      AppMethodBeat.o(222067);
    }
    
    final File get(String paramString)
    {
      AppMethodBeat.i(222064);
      paramString = newFile(paramString);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramString.setLastModified(localLong.longValue());
      this.lastUsageDates.put(paramString, localLong);
      AppMethodBeat.o(222064);
      return paramString;
    }
    
    final File newFile(String paramString)
    {
      AppMethodBeat.i(222065);
      paramString = new File(this.cacheDir, paramString.hashCode());
      AppMethodBeat.o(222065);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.a
 * JD-Core Version:    0.7.0.1
 */