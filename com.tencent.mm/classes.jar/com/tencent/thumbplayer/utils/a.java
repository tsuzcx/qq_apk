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
  private a ahMR;
  
  static
  {
    AppMethodBeat.i(227126);
    mInstanceMap = new HashMap();
    AppMethodBeat.o(227126);
  }
  
  private a(File paramFile)
  {
    AppMethodBeat.i(227106);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      this.ahMR = null;
      AppMethodBeat.o(227106);
      return;
    }
    this.ahMR = new a(paramFile, 50000000L, 2147483647, (byte)0);
    AppMethodBeat.o(227106);
  }
  
  /* Error */
  private static a Z(File paramFile)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_1
    //   7: getstatic 32	com/tencent/thumbplayer/utils/a:mInstanceMap	Ljava/util/Map;
    //   10: new 63	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 68	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   21: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokestatic 76	com/tencent/thumbplayer/utils/a:myPid	()Ljava/lang/String;
    //   27: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokeinterface 88 2 0
    //   38: checkcast 2	com/tencent/thumbplayer/utils/a
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_1
    //   45: ifnonnull +70 -> 115
    //   48: new 2	com/tencent/thumbplayer/utils/a
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 90	com/tencent/thumbplayer/utils/a:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: getstatic 32	com/tencent/thumbplayer/utils/a:mInstanceMap	Ljava/util/Map;
    //   60: new 63	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   67: aload_0
    //   68: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokestatic 76	com/tencent/thumbplayer/utils/a:myPid	()Ljava/lang/String;
    //   77: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokeinterface 97 3 0
    //   89: pop
    //   90: aload_2
    //   91: astore_0
    //   92: ldc 61
    //   94: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: areturn
    //   99: astore_0
    //   100: aload_1
    //   101: astore_0
    //   102: goto -10 -> 92
    //   105: astore_0
    //   106: aload_2
    //   107: astore_0
    //   108: goto -16 -> 92
    //   111: astore_2
    //   112: goto -68 -> 44
    //   115: aload_1
    //   116: astore_0
    //   117: goto -25 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramFile	File
    //   6	110	1	localObject	Object
    //   41	66	2	locala	a
    //   111	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	57	99	finally
    //   57	90	105	finally
    //   7	42	111	java/lang/Exception
  }
  
  public static a dq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227079);
    paramContext = Z(new File(paramContext.getCacheDir(), paramString));
    AppMethodBeat.o(227079);
    return paramContext;
  }
  
  /* Error */
  private byte[] getAsBinary(String paramString)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 115
    //   14: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   23: aload_1
    //   24: invokevirtual 118	com/tencent/thumbplayer/utils/a$a:get	(Ljava/lang/String;)Ljava/io/File;
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 45	java/io/File:exists	()Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +10 -> 44
    //   37: ldc 115
    //   39: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 120	java/io/RandomAccessFile
    //   47: dup
    //   48: aload_3
    //   49: ldc 122
    //   51: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 127	java/io/RandomAccessFile:length	()J
    //   59: l2i
    //   60: newarray byte
    //   62: astore 4
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 131	java/io/RandomAccessFile:read	([B)I
    //   70: ifle +66 -> 136
    //   73: aload 4
    //   75: invokestatic 135	com/tencent/thumbplayer/utils/a$b:isDue	([B)Z
    //   78: ifne +41 -> 119
    //   81: aload 4
    //   83: astore_1
    //   84: aload 4
    //   86: invokestatic 138	com/tencent/thumbplayer/utils/a$b:hasDateInfo	([B)Z
    //   89: ifeq +19 -> 108
    //   92: aload 4
    //   94: aload 4
    //   96: invokestatic 141	com/tencent/thumbplayer/utils/a$b:dz	([B)I
    //   99: iconst_1
    //   100: iadd
    //   101: aload 4
    //   103: arraylength
    //   104: invokestatic 145	com/tencent/thumbplayer/utils/a$b:copyOfRange	([BII)[B
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   112: ldc 115
    //   114: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: areturn
    //   119: aload_3
    //   120: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 152	com/tencent/thumbplayer/utils/a:remove	(Ljava/lang/String;)Z
    //   128: pop
    //   129: ldc 115
    //   131: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   140: ldc 115
    //   142: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   158: ldc 115
    //   160: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   176: ldc 115
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
    AppMethodBeat.i(227099);
    String str = "_" + Process.myPid();
    AppMethodBeat.o(227099);
    return str;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(227161);
    if (this.ahMR == null)
    {
      AppMethodBeat.o(227161);
      return;
    }
    this.ahMR.clear();
    AppMethodBeat.o(227161);
  }
  
  /* Error */
  public final Object getAsObject(String paramString)
  {
    // Byte code:
    //   0: ldc 173
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 175	com/tencent/thumbplayer/utils/a:getAsBinary	(Ljava/lang/String;)[B
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +97 -> 109
    //   15: new 177	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 180	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore_2
    //   24: new 182	java/io/ObjectInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 185	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 189	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   42: aload_1
    //   43: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   46: ldc 173
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
    //   63: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   74: ldc 173
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
    //   91: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   102: ldc 173
    //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: ldc 173
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
    //   174	1	3	localException	java.lang.Exception
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
    //   3: ldc 193
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 195	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore 5
    //   17: new 198	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload 5
    //   23: invokespecial 201	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_3
    //   27: aload_3
    //   28: aload_2
    //   29: invokevirtual 205	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload 5
    //   34: invokevirtual 209	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   37: astore_2
    //   38: aload_0
    //   39: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   42: ifnull +45 -> 87
    //   45: aload_0
    //   46: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   49: aload_1
    //   50: invokevirtual 212	com/tencent/thumbplayer/utils/a$a:newFile	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore 5
    //   55: new 214	java/io/FileOutputStream
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 215	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_1
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 218	java/io/FileOutputStream:write	([B)V
    //   70: aload_1
    //   71: invokevirtual 221	java/io/FileOutputStream:flush	()V
    //   74: aload_1
    //   75: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   78: aload_0
    //   79: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   82: aload 5
    //   84: invokestatic 225	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   87: aload_3
    //   88: invokevirtual 226	java/io/ObjectOutputStream:close	()V
    //   91: ldc 193
    //   93: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +11 -> 112
    //   104: aload_1
    //   105: invokevirtual 221	java/io/FileOutputStream:flush	()V
    //   108: aload_1
    //   109: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   112: aload_0
    //   113: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   116: aload 5
    //   118: invokestatic 225	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   121: goto -34 -> 87
    //   124: astore_1
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 226	java/io/ObjectOutputStream:close	()V
    //   133: ldc 193
    //   135: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +11 -> 154
    //   146: aload_2
    //   147: invokevirtual 221	java/io/FileOutputStream:flush	()V
    //   150: aload_2
    //   151: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   154: aload_0
    //   155: getfield 50	com/tencent/thumbplayer/utils/a:ahMR	Lcom/tencent/thumbplayer/utils/a$a;
    //   158: aload 5
    //   160: invokestatic 225	com/tencent/thumbplayer/utils/a$a:a	(Lcom/tencent/thumbplayer/utils/a$a;Ljava/io/File;)V
    //   163: ldc 193
    //   165: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 226	java/io/ObjectOutputStream:close	()V
    //   179: ldc 193
    //   181: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: return
    //   185: astore_1
    //   186: ldc 193
    //   188: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_1
    //   193: ldc 193
    //   195: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: astore_1
    //   200: ldc 193
    //   202: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: return
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_3
    //   209: goto -38 -> 171
    //   212: astore_1
    //   213: aload 4
    //   215: astore_3
    //   216: goto -91 -> 125
    //   219: astore_2
    //   220: goto -66 -> 154
    //   223: astore_2
    //   224: aload_1
    //   225: astore 4
    //   227: aload_2
    //   228: astore_1
    //   229: aload 4
    //   231: astore_2
    //   232: goto -90 -> 142
    //   235: astore_1
    //   236: goto -124 -> 112
    //   239: astore_2
    //   240: goto -140 -> 100
    //   243: astore_1
    //   244: goto -166 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	a
    //   0	247	1	paramString	String
    //   0	247	2	paramSerializable	java.io.Serializable
    //   26	190	3	localObject1	Object
    //   1	229	4	str	String
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
    //   27	55	170	finally
    //   70	78	170	finally
    //   78	87	170	finally
    //   104	112	170	finally
    //   112	121	170	finally
    //   146	154	170	finally
    //   154	170	170	finally
    //   87	91	185	finally
    //   129	133	192	finally
    //   175	179	199	finally
    //   8	27	206	finally
    //   8	27	212	java/lang/Exception
    //   146	154	219	java/io/IOException
    //   65	70	223	finally
    //   104	112	235	java/io/IOException
    //   65	70	239	java/lang/Exception
    //   70	78	243	java/io/IOException
  }
  
  public final boolean remove(String paramString)
  {
    AppMethodBeat.i(227155);
    if (this.ahMR == null)
    {
      AppMethodBeat.o(227155);
      return false;
    }
    boolean bool = a.a(this.ahMR, paramString);
    AppMethodBeat.o(227155);
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
      AppMethodBeat.i(227121);
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
          AppMethodBeat.i(227046);
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
          AppMethodBeat.o(227046);
        }
      });
      AppMethodBeat.o(227121);
    }
    
    static long calculateSize(File paramFile)
    {
      AppMethodBeat.i(227174);
      if (paramFile == null)
      {
        AppMethodBeat.o(227174);
        return 0L;
      }
      long l = paramFile.length();
      AppMethodBeat.o(227174);
      return l;
    }
    
    private void put(File paramFile)
    {
      AppMethodBeat.i(227133);
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
      AppMethodBeat.o(227133);
    }
    
    private boolean remove(String paramString)
    {
      AppMethodBeat.i(227147);
      boolean bool = get(paramString).delete();
      AppMethodBeat.o(227147);
      return bool;
    }
    
    private long removeNext()
    {
      AppMethodBeat.i(227164);
      if (this.lastUsageDates.isEmpty())
      {
        AppMethodBeat.o(227164);
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
            AppMethodBeat.o(227164);
            return 0L;
          }
        }
        long l = calculateSize(localFile);
        if ((localFile != null) && (localFile.delete())) {
          this.lastUsageDates.remove(localFile);
        }
        AppMethodBeat.o(227164);
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
      AppMethodBeat.i(227230);
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
      AppMethodBeat.o(227230);
    }
    
    final File get(String paramString)
    {
      AppMethodBeat.i(227212);
      paramString = newFile(paramString);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramString.setLastModified(localLong.longValue());
      this.lastUsageDates.put(paramString, localLong);
      AppMethodBeat.o(227212);
      return paramString;
    }
    
    final File newFile(String paramString)
    {
      AppMethodBeat.i(227220);
      paramString = new File(this.cacheDir, paramString.hashCode());
      AppMethodBeat.o(227220);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.a
 * JD-Core Version:    0.7.0.1
 */