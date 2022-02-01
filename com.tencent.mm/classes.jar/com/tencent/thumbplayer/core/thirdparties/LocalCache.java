package com.tencent.thumbplayer.core.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPThreadUtil;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalCache
{
  private static final int MAX_COUNT = 2147483647;
  private static final int MAX_SIZE = 50000000;
  public static final int TIME_DAY = 86400;
  public static final int TIME_HOUR = 3600;
  private static Map<String, LocalCache> mInstanceMap;
  private ACacheManager mCache;
  
  static
  {
    AppMethodBeat.i(197727);
    mInstanceMap = new HashMap();
    AppMethodBeat.o(197727);
  }
  
  private LocalCache(File paramFile, long paramLong, int paramInt)
  {
    AppMethodBeat.i(197702);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      this.mCache = null;
      AppMethodBeat.o(197702);
      return;
    }
    this.mCache = new ACacheManager(paramFile, paramLong, paramInt, null);
    AppMethodBeat.o(197702);
  }
  
  public static LocalCache get(Context paramContext)
  {
    AppMethodBeat.i(197696);
    paramContext = get(paramContext, "LocalCache");
    AppMethodBeat.o(197696);
    return paramContext;
  }
  
  public static LocalCache get(Context paramContext, long paramLong, int paramInt)
  {
    AppMethodBeat.i(197699);
    paramContext = get(new File(paramContext.getCacheDir(), "LocalCache"), paramLong, paramInt);
    AppMethodBeat.o(197699);
    return paramContext;
  }
  
  public static LocalCache get(Context paramContext, String paramString)
  {
    AppMethodBeat.i(197697);
    paramContext = get(new File(paramContext.getCacheDir(), paramString), 50000000L, 2147483647);
    AppMethodBeat.o(197697);
    return paramContext;
  }
  
  public static LocalCache get(File paramFile)
  {
    AppMethodBeat.i(197698);
    paramFile = get(paramFile, 50000000L, 2147483647);
    AppMethodBeat.o(197698);
    return paramFile;
  }
  
  public static LocalCache get(File paramFile, long paramLong, int paramInt)
  {
    AppMethodBeat.i(197700);
    localObject = null;
    try
    {
      localLocalCache = (LocalCache)mInstanceMap.get(paramFile.getAbsoluteFile() + myPid());
      localObject = localLocalCache;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LocalCache localLocalCache;
        label102:
        continue;
        paramFile = localObject;
      }
    }
    if (localObject == null)
    {
      try
      {
        localLocalCache = new LocalCache(paramFile, paramLong, paramInt);
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
        mInstanceMap.put(paramFile.getAbsolutePath() + myPid(), localLocalCache);
        paramFile = localLocalCache;
      }
      catch (Throwable paramFile)
      {
        paramFile = localLocalCache;
        break label102;
      }
      AppMethodBeat.o(197700);
      return paramFile;
    }
  }
  
  private static String myPid()
  {
    AppMethodBeat.i(197701);
    String str = "_" + Process.myPid();
    AppMethodBeat.o(197701);
    return str;
  }
  
  public void clear()
  {
    AppMethodBeat.i(197726);
    if (this.mCache == null)
    {
      AppMethodBeat.o(197726);
      return;
    }
    ACacheManager.access$1500(this.mCache);
    AppMethodBeat.o(197726);
  }
  
  public File file(String paramString)
  {
    AppMethodBeat.i(197724);
    if (this.mCache == null)
    {
      AppMethodBeat.o(197724);
      return null;
    }
    paramString = ACacheManager.access$100(this.mCache, paramString);
    if (paramString.exists())
    {
      AppMethodBeat.o(197724);
      return paramString;
    }
    AppMethodBeat.o(197724);
    return null;
  }
  
  /* Error */
  public byte[] getAsBinary(String paramString)
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 162
    //   14: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   23: aload_1
    //   24: invokestatic 165	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 56	java/io/File:exists	()Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +10 -> 44
    //   37: ldc 162
    //   39: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 167	java/io/RandomAccessFile
    //   47: dup
    //   48: aload_3
    //   49: ldc 169
    //   51: invokespecial 170	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 174	java/io/RandomAccessFile:length	()J
    //   59: l2i
    //   60: newarray byte
    //   62: astore 4
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 178	java/io/RandomAccessFile:read	([B)I
    //   70: ifle +45 -> 115
    //   73: aload 4
    //   75: invokestatic 182	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$800	([B)Z
    //   78: ifne +20 -> 98
    //   81: aload 4
    //   83: invokestatic 186	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$900	([B)[B
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   91: ldc 162
    //   93: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: aload_3
    //   99: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 193	com/tencent/thumbplayer/core/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   107: pop
    //   108: ldc 162
    //   110: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_3
    //   116: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   119: ldc 162
    //   121: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   137: ldc 162
    //   139: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   155: ldc 162
    //   157: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_3
    //   163: goto -72 -> 91
    //   166: astore_3
    //   167: goto -65 -> 102
    //   170: astore_1
    //   171: goto -52 -> 119
    //   174: astore_1
    //   175: goto -38 -> 137
    //   178: astore_3
    //   179: goto -24 -> 155
    //   182: astore_1
    //   183: goto -36 -> 147
    //   186: astore_1
    //   187: goto -58 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	LocalCache
    //   0	190	1	paramString	String
    //   32	2	2	bool	boolean
    //   27	125	3	localObject	Object
    //   162	1	3	localIOException1	java.io.IOException
    //   166	1	3	localIOException2	java.io.IOException
    //   178	1	3	localIOException3	java.io.IOException
    //   62	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   19	33	126	java/lang/Exception
    //   44	55	126	java/lang/Exception
    //   19	33	144	finally
    //   44	55	144	finally
    //   87	91	162	java/io/IOException
    //   98	102	166	java/io/IOException
    //   115	119	170	java/io/IOException
    //   133	137	174	java/io/IOException
    //   151	155	178	java/io/IOException
    //   55	87	182	finally
    //   55	87	186	java/lang/Exception
  }
  
  public Bitmap getAsBitmap(String paramString)
  {
    AppMethodBeat.i(197720);
    if (getAsBinary(paramString) == null)
    {
      AppMethodBeat.o(197720);
      return null;
    }
    paramString = LocalCache.Utils.access$1100(getAsBinary(paramString));
    AppMethodBeat.o(197720);
    return paramString;
  }
  
  public Drawable getAsDrawable(String paramString)
  {
    AppMethodBeat.i(197723);
    if (getAsBinary(paramString) == null)
    {
      AppMethodBeat.o(197723);
      return null;
    }
    paramString = LocalCache.Utils.access$1300(LocalCache.Utils.access$1100(getAsBinary(paramString)));
    AppMethodBeat.o(197723);
    return paramString;
  }
  
  public JSONArray getAsJSONArray(String paramString)
  {
    AppMethodBeat.i(197711);
    paramString = getAsString(paramString);
    try
    {
      paramString = new JSONArray(paramString);
      AppMethodBeat.o(197711);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(197711);
    }
    return null;
  }
  
  public JSONObject getAsJSONObject(String paramString)
  {
    AppMethodBeat.i(197708);
    paramString = getAsString(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(197708);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(197708);
    }
    return null;
  }
  
  /* Error */
  public Object getAsObject(String paramString)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 198	com/tencent/thumbplayer/core/thirdparties/LocalCache:getAsBinary	(Ljava/lang/String;)[B
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +97 -> 109
    //   15: new 230	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 233	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore_2
    //   24: new 235	java/io/ObjectInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 238	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 242	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 243	java/io/ByteArrayInputStream:close	()V
    //   42: aload_1
    //   43: invokevirtual 244	java/io/ObjectInputStream:close	()V
    //   46: ldc 228
    //   48: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   63: invokevirtual 243	java/io/ByteArrayInputStream:close	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 244	java/io/ObjectInputStream:close	()V
    //   74: ldc 228
    //   76: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   91: invokevirtual 243	java/io/ByteArrayInputStream:close	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 244	java/io/ObjectInputStream:close	()V
    //   102: ldc 228
    //   104: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: ldc 228
    //   111: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	178	0	this	LocalCache
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
  public String getAsString(String paramString)
  {
    // Byte code:
    //   0: ldc 245
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 245
    //   14: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   23: aload_1
    //   24: invokestatic 165	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 56	java/io/File:exists	()Z
    //   32: ifne +10 -> 42
    //   35: ldc 245
    //   37: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aconst_null
    //   41: areturn
    //   42: new 247	java/io/BufferedReader
    //   45: dup
    //   46: new 249	java/io/FileReader
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 252	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   54: invokespecial 255	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_2
    //   58: ldc_w 257
    //   61: astore_3
    //   62: aload_2
    //   63: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +26 -> 96
    //   73: new 98	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   80: aload_3
    //   81: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 4
    //   86: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_3
    //   93: goto -31 -> 62
    //   96: aload_3
    //   97: invokestatic 263	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$500	(Ljava/lang/String;)Z
    //   100: ifne +19 -> 119
    //   103: aload_3
    //   104: invokestatic 266	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$600	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_1
    //   108: aload_2
    //   109: invokevirtual 267	java/io/BufferedReader:close	()V
    //   112: ldc 245
    //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: areturn
    //   119: aload_2
    //   120: invokevirtual 267	java/io/BufferedReader:close	()V
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 193	com/tencent/thumbplayer/core/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   128: pop
    //   129: ldc 245
    //   131: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 267	java/io/BufferedReader:close	()V
    //   147: ldc 245
    //   149: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 267	java/io/BufferedReader:close	()V
    //   165: ldc 245
    //   167: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_2
    //   173: goto -61 -> 112
    //   176: astore_2
    //   177: goto -54 -> 123
    //   180: astore_1
    //   181: goto -34 -> 147
    //   184: astore_2
    //   185: goto -20 -> 165
    //   188: astore_1
    //   189: goto -32 -> 157
    //   192: astore_1
    //   193: goto -54 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	LocalCache
    //   0	196	1	paramString	String
    //   27	135	2	localObject	Object
    //   172	1	2	localIOException1	java.io.IOException
    //   176	1	2	localIOException2	java.io.IOException
    //   184	1	2	localIOException3	java.io.IOException
    //   61	43	3	str1	String
    //   66	19	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   42	58	136	java/io/IOException
    //   42	58	154	finally
    //   108	112	172	java/io/IOException
    //   119	123	176	java/io/IOException
    //   143	147	180	java/io/IOException
    //   161	165	184	java/io/IOException
    //   62	68	188	finally
    //   73	93	188	finally
    //   96	108	188	finally
    //   62	68	192	java/io/IOException
    //   73	93	192	java/io/IOException
    //   96	108	192	java/io/IOException
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(197718);
    put(paramString, LocalCache.Utils.access$1000(paramBitmap));
    AppMethodBeat.o(197718);
  }
  
  public void put(String paramString, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(197719);
    put(paramString, LocalCache.Utils.access$1000(paramBitmap), paramInt);
    AppMethodBeat.o(197719);
  }
  
  public void put(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(197721);
    put(paramString, LocalCache.Utils.access$1200(paramDrawable));
    AppMethodBeat.o(197721);
  }
  
  public void put(String paramString, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(197722);
    put(paramString, LocalCache.Utils.access$1200(paramDrawable), paramInt);
    AppMethodBeat.o(197722);
  }
  
  public void put(String paramString, Serializable paramSerializable)
  {
    AppMethodBeat.i(197715);
    put(paramString, paramSerializable, -1);
    AppMethodBeat.o(197715);
  }
  
  /* Error */
  public void put(String paramString, Serializable paramSerializable, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 299
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 301	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 302	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 5
    //   15: new 304	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 307	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_2
    //   29: invokevirtual 311	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload 5
    //   34: invokevirtual 315	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   37: astore_2
    //   38: iload_3
    //   39: iconst_m1
    //   40: if_icmpeq +22 -> 62
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: iload_3
    //   47: invokevirtual 281	com/tencent/thumbplayer/core/thirdparties/LocalCache:put	(Ljava/lang/String;[BI)V
    //   50: aload 4
    //   52: invokevirtual 316	java/io/ObjectOutputStream:close	()V
    //   55: ldc_w 299
    //   58: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: aload_1
    //   64: aload_2
    //   65: invokevirtual 276	com/tencent/thumbplayer/core/thirdparties/LocalCache:put	(Ljava/lang/String;[B)V
    //   68: goto -18 -> 50
    //   71: astore_1
    //   72: aload 4
    //   74: ifnull +8 -> 82
    //   77: aload 4
    //   79: invokevirtual 316	java/io/ObjectOutputStream:close	()V
    //   82: ldc_w 299
    //   85: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: return
    //   89: astore_1
    //   90: ldc_w 299
    //   93: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore_1
    //   98: ldc_w 299
    //   101: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: astore_1
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull +8 -> 119
    //   114: aload 4
    //   116: invokevirtual 316	java/io/ObjectOutputStream:close	()V
    //   119: ldc_w 299
    //   122: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_1
    //   127: ldc_w 299
    //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 316	java/io/ObjectOutputStream:close	()V
    //   145: ldc_w 299
    //   148: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_1
    //   152: athrow
    //   153: astore_2
    //   154: goto -9 -> 145
    //   157: astore_1
    //   158: aload 4
    //   160: astore_2
    //   161: goto -24 -> 137
    //   164: astore_1
    //   165: goto -56 -> 109
    //   168: astore_1
    //   169: aconst_null
    //   170: astore 4
    //   172: goto -100 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	LocalCache
    //   0	175	1	paramString	String
    //   0	175	2	paramSerializable	Serializable
    //   0	175	3	paramInt	int
    //   24	147	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   13	20	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   26	38	71	java/lang/Exception
    //   43	50	71	java/lang/Exception
    //   62	68	71	java/lang/Exception
    //   50	55	89	java/lang/Throwable
    //   77	82	97	java/lang/Throwable
    //   6	26	105	java/lang/Throwable
    //   114	119	126	java/lang/Throwable
    //   6	26	134	finally
    //   141	145	153	java/lang/Throwable
    //   26	38	157	finally
    //   43	50	157	finally
    //   62	68	157	finally
    //   26	38	164	java/lang/Throwable
    //   43	50	164	java/lang/Throwable
    //   62	68	164	java/lang/Throwable
    //   6	26	168	java/lang/Exception
  }
  
  /* Error */
  public void put(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 318
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 318
    //   16: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   24: aload_1
    //   25: invokestatic 157	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   28: astore 4
    //   30: new 320	java/io/BufferedWriter
    //   33: dup
    //   34: new 322	java/io/FileWriter
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 323	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   43: sipush 1024
    //   46: invokespecial 326	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 329	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 332	java/io/BufferedWriter:flush	()V
    //   59: aload_1
    //   60: invokevirtual 333	java/io/BufferedWriter:close	()V
    //   63: aload_0
    //   64: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   67: aload 4
    //   69: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   72: ldc_w 318
    //   75: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +11 -> 94
    //   86: aload_1
    //   87: invokevirtual 332	java/io/BufferedWriter:flush	()V
    //   90: aload_1
    //   91: invokevirtual 333	java/io/BufferedWriter:close	()V
    //   94: aload_0
    //   95: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   98: aload 4
    //   100: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   103: ldc_w 318
    //   106: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +11 -> 125
    //   117: aload_2
    //   118: invokevirtual 332	java/io/BufferedWriter:flush	()V
    //   121: aload_2
    //   122: invokevirtual 333	java/io/BufferedWriter:close	()V
    //   125: aload_0
    //   126: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   129: aload 4
    //   131: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   134: ldc_w 318
    //   137: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_2
    //   143: goto -84 -> 59
    //   146: astore_1
    //   147: goto -84 -> 63
    //   150: astore_2
    //   151: goto -61 -> 90
    //   154: astore_1
    //   155: goto -61 -> 94
    //   158: astore_3
    //   159: goto -38 -> 121
    //   162: astore_2
    //   163: goto -38 -> 125
    //   166: astore_2
    //   167: aload_1
    //   168: astore_3
    //   169: aload_2
    //   170: astore_1
    //   171: aload_3
    //   172: astore_2
    //   173: goto -60 -> 113
    //   176: astore_2
    //   177: goto -95 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	LocalCache
    //   0	180	1	paramString1	String
    //   0	180	2	paramString2	String
    //   158	1	3	localIOException	java.io.IOException
    //   168	4	3	str	String
    //   28	102	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	50	79	java/io/IOException
    //   30	50	110	finally
    //   55	59	142	java/io/IOException
    //   59	63	146	java/io/IOException
    //   86	90	150	java/io/IOException
    //   90	94	154	java/io/IOException
    //   117	121	158	java/io/IOException
    //   121	125	162	java/io/IOException
    //   50	55	166	finally
    //   50	55	176	java/io/IOException
  }
  
  public void put(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(197704);
    put(paramString1, LocalCache.Utils.access$300(paramInt, paramString2));
    AppMethodBeat.o(197704);
  }
  
  public void put(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(197709);
    put(paramString, paramJSONArray.toString());
    AppMethodBeat.o(197709);
  }
  
  public void put(String paramString, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(197710);
    put(paramString, paramJSONArray.toString(), paramInt);
    AppMethodBeat.o(197710);
  }
  
  public void put(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(197706);
    put(paramString, paramJSONObject.toString());
    AppMethodBeat.o(197706);
  }
  
  public void put(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(197707);
    put(paramString, paramJSONObject.toString(), paramInt);
    AppMethodBeat.o(197707);
  }
  
  /* Error */
  public void put(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 358
    //   16: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   24: aload_1
    //   25: invokestatic 157	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   28: astore 4
    //   30: new 360	java/io/FileOutputStream
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 361	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 363	java/io/FileOutputStream:write	([B)V
    //   45: aload_1
    //   46: invokevirtual 364	java/io/FileOutputStream:flush	()V
    //   49: aload_1
    //   50: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   53: aload_0
    //   54: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   57: aload 4
    //   59: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   62: ldc_w 358
    //   65: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +11 -> 84
    //   76: aload_1
    //   77: invokevirtual 364	java/io/FileOutputStream:flush	()V
    //   80: aload_1
    //   81: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   84: aload_0
    //   85: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   88: aload 4
    //   90: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   93: ldc_w 358
    //   96: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +11 -> 115
    //   107: aload_2
    //   108: invokevirtual 364	java/io/FileOutputStream:flush	()V
    //   111: aload_2
    //   112: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   115: aload_0
    //   116: getfield 61	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   119: aload 4
    //   121: invokestatic 337	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   124: ldc_w 358
    //   127: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: goto -18 -> 115
    //   136: astore_2
    //   137: aload_1
    //   138: astore_3
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: astore_2
    //   143: goto -40 -> 103
    //   146: astore_1
    //   147: goto -63 -> 84
    //   150: astore_2
    //   151: goto -79 -> 72
    //   154: astore_1
    //   155: goto -102 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	LocalCache
    //   0	158	1	paramString	String
    //   0	158	2	paramArrayOfByte	byte[]
    //   138	4	3	str	String
    //   28	92	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	40	69	java/lang/Exception
    //   30	40	100	finally
    //   107	115	132	java/io/IOException
    //   40	45	136	finally
    //   76	84	146	java/io/IOException
    //   40	45	150	java/lang/Exception
    //   45	53	154	java/io/IOException
  }
  
  public void put(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(197713);
    put(paramString, LocalCache.Utils.access$700(paramInt, paramArrayOfByte));
    AppMethodBeat.o(197713);
  }
  
  public boolean remove(String paramString)
  {
    AppMethodBeat.i(197725);
    if (this.mCache == null)
    {
      AppMethodBeat.o(197725);
      return false;
    }
    boolean bool = ACacheManager.access$1400(this.mCache, paramString);
    AppMethodBeat.o(197725);
    return bool;
  }
  
  public class ACacheManager
  {
    private final AtomicInteger cacheCount;
    protected File cacheDir;
    private final AtomicLong cacheSize;
    private final int countLimit;
    private final Map<File, Long> lastUsageDates;
    private final long sizeLimit;
    
    private ACacheManager(File paramFile, long paramLong, int paramInt)
    {
      AppMethodBeat.i(197658);
      this.lastUsageDates = Collections.synchronizedMap(new HashMap());
      this.cacheDir = paramFile;
      this.sizeLimit = paramLong;
      this.countLimit = paramInt;
      this.cacheSize = new AtomicLong();
      this.cacheCount = new AtomicInteger();
      calculateCacheSizeAndCacheCount();
      AppMethodBeat.o(197658);
    }
    
    private void calculateCacheSizeAndCacheCount()
    {
      AppMethodBeat.i(197659);
      TPThreadUtil.THREAD_POOL_EXECUTOR.execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(197657);
          File[] arrayOfFile = LocalCache.ACacheManager.this.cacheDir.listFiles();
          if (arrayOfFile != null)
          {
            int m = arrayOfFile.length;
            int j = 0;
            int i = 0;
            int k = 0;
            while (j < m)
            {
              File localFile = arrayOfFile[j];
              k = (int)(k + LocalCache.ACacheManager.access$1600(LocalCache.ACacheManager.this, localFile));
              LocalCache.ACacheManager.this.lastUsageDates.put(localFile, Long.valueOf(localFile.lastModified()));
              j += 1;
              i += 1;
            }
            LocalCache.ACacheManager.this.cacheSize.set(k);
            LocalCache.ACacheManager.this.cacheCount.set(i);
          }
          AppMethodBeat.o(197657);
        }
      });
      AppMethodBeat.o(197659);
    }
    
    private long calculateSize(File paramFile)
    {
      AppMethodBeat.i(197666);
      if (paramFile == null)
      {
        AppMethodBeat.o(197666);
        return 0L;
      }
      long l = paramFile.length();
      AppMethodBeat.o(197666);
      return l;
    }
    
    private void clear()
    {
      AppMethodBeat.i(197664);
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
      AppMethodBeat.o(197664);
    }
    
    private File get(String paramString)
    {
      AppMethodBeat.i(197661);
      paramString = newFile(paramString);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramString.setLastModified(localLong.longValue());
      this.lastUsageDates.put(paramString, localLong);
      AppMethodBeat.o(197661);
      return paramString;
    }
    
    private File newFile(String paramString)
    {
      AppMethodBeat.i(197662);
      paramString = new File(this.cacheDir, paramString.hashCode());
      AppMethodBeat.o(197662);
      return paramString;
    }
    
    private void put(File paramFile)
    {
      AppMethodBeat.i(197660);
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
      AppMethodBeat.o(197660);
    }
    
    private boolean remove(String paramString)
    {
      AppMethodBeat.i(197663);
      boolean bool = get(paramString).delete();
      AppMethodBeat.o(197663);
      return bool;
    }
    
    private long removeNext()
    {
      AppMethodBeat.i(197665);
      if (this.lastUsageDates.isEmpty())
      {
        AppMethodBeat.o(197665);
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
              break label212;
            }
            localObject3 = (File)localEntry.getKey();
            localObject1 = localObject4;
            break label222;
          }
          if (localObject1 == null)
          {
            AppMethodBeat.o(197665);
            return 0L;
          }
        }
        long l = calculateSize(localFile);
        if ((localFile != null) && (localFile.delete())) {
          this.lastUsageDates.remove(localFile);
        }
        AppMethodBeat.o(197665);
        return l;
        label212:
        Object localObject4 = localFile;
        Object localObject2 = localObject3;
        Object localObject3 = localObject4;
        label222:
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.thirdparties.LocalCache
 * JD-Core Version:    0.7.0.1
 */