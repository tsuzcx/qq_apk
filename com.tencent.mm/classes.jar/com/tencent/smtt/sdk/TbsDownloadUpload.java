package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadUpload
{
  private static TbsDownloadUpload b;
  Map<String, Object> a;
  private Context c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  public SharedPreferences mPreferences;
  
  public TbsDownloadUpload(Context paramContext)
  {
    AppMethodBeat.i(54657);
    this.a = new HashMap();
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_upload", 4);
    this.c = paramContext.getApplicationContext();
    if (this.c == null) {
      this.c = paramContext;
    }
    AppMethodBeat.o(54657);
  }
  
  private static File a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54661);
    q.a();
    paramContext = q.t(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(54661);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists())
    {
      AppMethodBeat.o(54661);
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(54661);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(54661);
    }
    return null;
  }
  
  public static void clear()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance()
  {
    try
    {
      TbsDownloadUpload localTbsDownloadUpload = b;
      return localTbsDownloadUpload;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(54658);
      if (b == null) {
        b = new TbsDownloadUpload(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(54658);
      return paramContext;
    }
    finally {}
  }
  
  public void clearUploadCode()
  {
    AppMethodBeat.i(54659);
    this.a.put("tbs_needdownload_code", Integer.valueOf(0));
    this.a.put("tbs_startdownload_code", Integer.valueOf(0));
    this.a.put("tbs_needdownload_return", Integer.valueOf(0));
    this.a.put("tbs_needdownload_sent", Integer.valueOf(0));
    this.a.put("tbs_startdownload_sent", Integer.valueOf(0));
    this.a.put("tbs_local_core_version", Integer.valueOf(0));
    writeTbsDownloadInfo();
    AppMethodBeat.o(54659);
  }
  
  public void commit()
  {
    try
    {
      AppMethodBeat.i(54663);
      writeTbsDownloadInfo();
      AppMethodBeat.o(54663);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getLocalCoreVersion()
  {
    try
    {
      int j = this.i;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getNeedDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 148
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 132	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	j	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  public int getNeedDownloadReturn()
  {
    try
    {
      int j = this.f;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getStartDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 168
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 140	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	j	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public void readTbsDownloadInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 144
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 54	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   11: ldc 146
    //   13: invokestatic 148	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +11 -> 29
    //   21: ldc 144
    //   23: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: new 150	java/io/BufferedInputStream
    //   32: dup
    //   33: new 152	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 158	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_1
    //   45: new 160	java/util/Properties
    //   48: dup
    //   49: invokespecial 161	java/util/Properties:<init>	()V
    //   52: astore_2
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 164	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   58: aload_2
    //   59: ldc 96
    //   61: ldc 166
    //   63: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_3
    //   67: ldc 166
    //   69: aload_3
    //   70: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +15 -> 88
    //   76: aload_0
    //   77: aload_3
    //   78: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: iconst_0
    //   82: invokestatic 186	java/lang/Math:max	(II)I
    //   85: putfield 132	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   88: aload_2
    //   89: ldc 110
    //   91: ldc 166
    //   93: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_3
    //   97: ldc 166
    //   99: aload_3
    //   100: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +15 -> 118
    //   106: aload_0
    //   107: aload_3
    //   108: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: iconst_0
    //   112: invokestatic 186	java/lang/Math:max	(II)I
    //   115: putfield 140	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   118: aload_2
    //   119: ldc 112
    //   121: ldc 166
    //   123: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: ldc 166
    //   129: aload_3
    //   130: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifne +15 -> 148
    //   136: aload_0
    //   137: aload_3
    //   138: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   141: iconst_0
    //   142: invokestatic 186	java/lang/Math:max	(II)I
    //   145: putfield 135	com/tencent/smtt/sdk/TbsDownloadUpload:f	I
    //   148: aload_2
    //   149: ldc 114
    //   151: ldc 166
    //   153: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_3
    //   157: ldc 166
    //   159: aload_3
    //   160: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifne +15 -> 178
    //   166: aload_0
    //   167: aload_3
    //   168: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   171: iconst_0
    //   172: invokestatic 186	java/lang/Math:max	(II)I
    //   175: putfield 130	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   178: aload_2
    //   179: ldc 116
    //   181: ldc 166
    //   183: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore_3
    //   187: ldc 166
    //   189: aload_3
    //   190: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: ifne +15 -> 208
    //   196: aload_0
    //   197: aload_3
    //   198: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   201: iconst_0
    //   202: invokestatic 186	java/lang/Math:max	(II)I
    //   205: putfield 138	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   208: aload_2
    //   209: ldc 118
    //   211: ldc 166
    //   213: invokevirtual 170	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_2
    //   217: ldc 166
    //   219: aload_2
    //   220: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifne +15 -> 238
    //   226: aload_0
    //   227: aload_2
    //   228: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   231: iconst_0
    //   232: invokestatic 186	java/lang/Math:max	(II)I
    //   235: putfield 127	com/tencent/smtt/sdk/TbsDownloadUpload:i	I
    //   238: aload_1
    //   239: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   242: ldc 144
    //   244: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: goto -221 -> 26
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: ldc 144
    //   258: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: goto -235 -> 26
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   275: ldc 144
    //   277: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: goto -254 -> 26
    //   283: astore_1
    //   284: ldc 144
    //   286: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: goto -263 -> 26
    //   292: astore_2
    //   293: goto -26 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	TbsDownloadUpload
    //   0	296	1	paramContext	Context
    //   52	176	2	localObject1	Object
    //   292	1	2	localObject2	Object
    //   66	132	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	250	finally
    //   21	26	250	finally
    //   238	242	250	finally
    //   242	247	250	finally
    //   256	261	250	finally
    //   271	275	250	finally
    //   275	280	250	finally
    //   284	289	250	finally
    //   238	242	255	java/lang/Exception
    //   7	17	264	finally
    //   29	45	264	finally
    //   271	275	283	java/lang/Exception
    //   45	88	292	finally
    //   88	118	292	finally
    //   118	148	292	finally
    //   148	178	292	finally
    //   178	208	292	finally
    //   208	238	292	finally
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 190
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 192
    //   9: ldc 194
    //   11: invokestatic 199	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 54	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   18: ldc 146
    //   20: invokestatic 148	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnonnull +11 -> 36
    //   28: ldc 190
    //   30: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 150	java/io/BufferedInputStream
    //   39: dup
    //   40: new 152	java/io/FileInputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 158	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_2
    //   52: new 160	java/util/Properties
    //   55: dup
    //   56: invokespecial 161	java/util/Properties:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 164	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload_0
    //   66: getfield 38	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   69: invokeinterface 203 1 0
    //   74: invokeinterface 209 1 0
    //   79: astore 4
    //   81: aload 4
    //   83: invokeinterface 214 1 0
    //   88: ifeq +107 -> 195
    //   91: aload 4
    //   93: invokeinterface 218 1 0
    //   98: checkcast 172	java/lang/String
    //   101: astore 5
    //   103: aload_0
    //   104: getfield 38	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   107: aload 5
    //   109: invokeinterface 222 2 0
    //   114: astore 6
    //   116: aload_3
    //   117: aload 5
    //   119: aload 6
    //   121: invokestatic 225	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokevirtual 229	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   127: pop
    //   128: ldc 192
    //   130: new 231	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 233
    //   136: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload 5
    //   141: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 242
    //   146: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 199	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -79 -> 81
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 252	java/io/BufferedOutputStream:close	()V
    //   182: ldc 190
    //   184: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: goto -154 -> 33
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    //   195: aload_0
    //   196: getfield 38	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   199: invokeinterface 254 1 0
    //   204: new 251	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 256	java/io/FileOutputStream
    //   211: dup
    //   212: aload_1
    //   213: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_1
    //   220: aload_3
    //   221: aload_1
    //   222: aconst_null
    //   223: invokevirtual 264	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   226: aload_2
    //   227: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   230: aload_1
    //   231: invokevirtual 252	java/io/BufferedOutputStream:close	()V
    //   234: ldc 190
    //   236: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: goto -206 -> 33
    //   242: astore_1
    //   243: ldc 190
    //   245: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: goto -215 -> 33
    //   251: astore_1
    //   252: ldc 190
    //   254: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: goto -224 -> 33
    //   260: astore_2
    //   261: goto -31 -> 230
    //   264: astore_2
    //   265: goto -91 -> 174
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_2
    //   273: goto -107 -> 166
    //   276: astore_3
    //   277: goto -111 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	TbsDownloadUpload
    //   23	22	1	localFile1	File
    //   163	1	1	localObject1	Object
    //   165	14	1	localObject2	Object
    //   190	23	1	localFile2	File
    //   219	12	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   242	1	1	localException1	java.lang.Exception
    //   251	1	1	localException2	java.lang.Exception
    //   268	1	1	localObject3	Object
    //   270	1	1	localObject4	Object
    //   51	176	2	localBufferedInputStream	java.io.BufferedInputStream
    //   260	1	2	localException3	java.lang.Exception
    //   264	1	2	localException4	java.lang.Exception
    //   272	1	2	localObject5	Object
    //   59	162	3	localProperties	java.util.Properties
    //   276	1	3	localObject6	Object
    //   79	13	4	localIterator	java.util.Iterator
    //   101	39	5	str	String
    //   114	36	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   52	81	163	finally
    //   81	160	163	finally
    //   195	220	163	finally
    //   2	14	190	finally
    //   28	33	190	finally
    //   170	174	190	finally
    //   178	182	190	finally
    //   182	187	190	finally
    //   226	230	190	finally
    //   230	234	190	finally
    //   234	239	190	finally
    //   243	248	190	finally
    //   252	257	190	finally
    //   230	234	242	java/lang/Exception
    //   178	182	251	java/lang/Exception
    //   226	230	260	java/lang/Exception
    //   170	174	264	java/lang/Exception
    //   14	24	268	finally
    //   36	52	268	finally
    //   220	226	276	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadUpload
 * JD-Core Version:    0.7.0.1
 */