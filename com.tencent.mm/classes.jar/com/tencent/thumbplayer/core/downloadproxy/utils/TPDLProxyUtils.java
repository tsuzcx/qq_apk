package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils
{
  private static final String FILE_NAME = "TPDLProxyUtils";
  
  public static String byteArrayToString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227959);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(227959);
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      AppMethodBeat.o(227959);
      return paramArrayOfByte;
    }
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "byteArrayToString failed, error:" + paramArrayOfByte.toString());
        paramArrayOfByte = "";
      }
    }
  }
  
  public static String losePackageCheck(int paramInt)
  {
    AppMethodBeat.i(228021);
    Object localObject3 = "";
    String str1 = "";
    String str2 = str1;
    localObject1 = localObject3;
    try
    {
      Object localObject4 = "ping -c " + paramInt + " www.qq.com";
      str2 = str1;
      localObject1 = localObject3;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject4).getInputStream()));
      for (;;)
      {
        str2 = str1;
        localObject1 = localObject3;
        String str3 = localBufferedReader.readLine();
        str2 = str1;
        localObject1 = localObject3;
        if (str3 == null) {
          break;
        }
        localObject4 = localObject3;
        str2 = str1;
        localObject1 = localObject3;
        if (str3.contains(" packet loss"))
        {
          str2 = str1;
          localObject1 = localObject3;
          paramInt = str3.indexOf("received, ");
          str2 = str1;
          localObject1 = localObject3;
          int i = str3.indexOf("%");
          str2 = str1;
          localObject1 = localObject3;
          localObject4 = str3.substring(paramInt + "received, ".length(), i + 1);
        }
        localObject3 = localObject4;
        str2 = str1;
        localObject1 = localObject4;
        if (str3.contains("avg"))
        {
          str2 = str1;
          localObject1 = localObject4;
          paramInt = str3.indexOf("/", 20);
          str2 = str1;
          localObject1 = localObject4;
          str1 = str3.substring(paramInt + 1, str3.indexOf(".", paramInt));
          localObject3 = localObject4;
        }
      }
      return localObject1;
    }
    finally
    {
      localObject1 = (String)localObject1 + ";" + str2;
      AppMethodBeat.o(228021);
    }
  }
  
  public static int objectToInt(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(227970);
    if (paramObject == null)
    {
      AppMethodBeat.o(227970);
      return paramInt;
    }
    try
    {
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(227970);
      return i;
    }
    finally
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to int failed, error:" + paramObject.toString());
      AppMethodBeat.o(227970);
    }
    return paramInt;
  }
  
  public static long objectToLong(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(227982);
    if (paramObject == null)
    {
      AppMethodBeat.o(227982);
      return paramLong;
    }
    try
    {
      long l = ((Long)paramObject).longValue();
      AppMethodBeat.o(227982);
      return l;
    }
    finally
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to long failed, error:" + paramObject.toString());
      AppMethodBeat.o(227982);
    }
    return paramLong;
  }
  
  /* Error */
  public static String serialize(Object paramObject)
  {
    // Byte code:
    //   0: ldc 157
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 159	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 160	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_2
    //   13: new 162	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 165	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual 169	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   27: aload_2
    //   28: ldc 171
    //   30: invokevirtual 174	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   38: aload_2
    //   39: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   42: ldc 157
    //   44: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: ldc 8
    //   52: iconst_0
    //   53: ldc 36
    //   55: new 38	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 180
    //   61: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   68: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   77: goto -39 -> 38
    //   80: astore_1
    //   81: ldc 8
    //   83: iconst_0
    //   84: ldc 36
    //   86: new 38	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 182
    //   92: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   99: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   108: goto -66 -> 42
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_1
    //   116: ldc 8
    //   118: iconst_0
    //   119: ldc 36
    //   121: new 38	java/lang/StringBuilder
    //   124: dup
    //   125: ldc 184
    //   127: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   134: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   155: ldc 157
    //   157: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: ldc 27
    //   162: areturn
    //   163: astore_0
    //   164: ldc 8
    //   166: iconst_0
    //   167: ldc 36
    //   169: new 38	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 180
    //   175: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   182: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   191: goto -40 -> 151
    //   194: astore_0
    //   195: ldc 8
    //   197: iconst_0
    //   198: ldc 36
    //   200: new 38	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 182
    //   206: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   213: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   222: goto -67 -> 155
    //   225: astore_0
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   234: aload_2
    //   235: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   238: ldc 157
    //   240: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_0
    //   244: athrow
    //   245: astore_1
    //   246: ldc 8
    //   248: iconst_0
    //   249: ldc 36
    //   251: new 38	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 180
    //   257: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_1
    //   261: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   264: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   273: goto -39 -> 234
    //   276: astore_1
    //   277: ldc 8
    //   279: iconst_0
    //   280: ldc 36
    //   282: new 38	java/lang/StringBuilder
    //   285: dup
    //   286: ldc 182
    //   288: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_1
    //   292: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   295: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   304: goto -66 -> 238
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_1
    //   310: goto -194 -> 116
    //   313: astore_0
    //   314: goto -198 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramObject	Object
    //   21	14	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   49	16	1	localObject1	Object
    //   80	16	1	localObject2	Object
    //   115	116	1	localObject3	Object
    //   245	16	1	localObject4	Object
    //   276	16	1	localObject5	Object
    //   309	1	1	localObject6	Object
    //   12	223	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   34	38	49	finally
    //   38	42	80	finally
    //   5	13	111	finally
    //   147	151	163	finally
    //   151	155	194	finally
    //   116	143	225	finally
    //   230	234	245	finally
    //   234	238	276	finally
    //   13	22	307	finally
    //   22	34	313	finally
  }
  
  /* Error */
  public static Object serializeToObject(String paramString)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 189	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_0
    //   10: ldc 171
    //   12: invokevirtual 193	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   15: invokespecial 196	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 198	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 199	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 203	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   37: aload_2
    //   38: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   41: ldc 187
    //   43: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: areturn
    //   48: astore_1
    //   49: ldc 8
    //   51: iconst_0
    //   52: ldc 36
    //   54: new 38	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 207
    //   60: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   67: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   76: goto -39 -> 37
    //   79: astore_1
    //   80: ldc 8
    //   82: iconst_0
    //   83: ldc 36
    //   85: new 38	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 209
    //   91: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   98: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   107: goto -66 -> 41
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_2
    //   115: ldc 8
    //   117: iconst_0
    //   118: ldc 36
    //   120: new 38	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 211
    //   126: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_0
    //   130: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   133: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   158: ldc 187
    //   160: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: ldc 8
    //   168: iconst_0
    //   169: ldc 36
    //   171: new 38	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 207
    //   177: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   184: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   193: goto -43 -> 150
    //   196: astore_0
    //   197: ldc 8
    //   199: iconst_0
    //   200: ldc 36
    //   202: new 38	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 209
    //   208: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   215: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   224: goto -66 -> 158
    //   227: astore_0
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   244: ldc 187
    //   246: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_0
    //   250: athrow
    //   251: astore_1
    //   252: ldc 8
    //   254: iconst_0
    //   255: ldc 36
    //   257: new 38	java/lang/StringBuilder
    //   260: dup
    //   261: ldc 207
    //   263: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_1
    //   267: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   270: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   279: goto -43 -> 236
    //   282: astore_1
    //   283: ldc 8
    //   285: iconst_0
    //   286: ldc 36
    //   288: new 38	java/lang/StringBuilder
    //   291: dup
    //   292: ldc 209
    //   294: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: aload_1
    //   298: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   301: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   310: goto -66 -> 244
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -201 -> 115
    //   319: astore_0
    //   320: goto -205 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramString	String
    //   27	7	1	localObjectInputStream	java.io.ObjectInputStream
    //   48	16	1	localObject1	Object
    //   79	16	1	localObject2	Object
    //   112	121	1	localObject3	Object
    //   251	16	1	localObject4	Object
    //   282	16	1	localObject5	Object
    //   315	1	1	localObject6	Object
    //   18	223	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   33	37	48	finally
    //   37	41	79	finally
    //   5	19	110	finally
    //   146	150	165	finally
    //   154	158	196	finally
    //   115	142	227	finally
    //   232	236	251	finally
    //   240	244	282	finally
    //   19	28	313	finally
    //   28	33	319	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils
 * JD-Core Version:    0.7.0.1
 */