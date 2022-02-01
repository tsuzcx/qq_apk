package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils
{
  private static final String FILE_NAME = "TPDLProxyUtils";
  
  public static String byteArrayToString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256239);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(256239);
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      AppMethodBeat.o(256239);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
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
    AppMethodBeat.i(256249);
    Object localObject2 = "";
    String str1 = "";
    String str2 = str1;
    localObject1 = localObject2;
    try
    {
      Object localObject3 = "ping -c " + paramInt + " www.qq.com";
      str2 = str1;
      localObject1 = localObject2;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject3).getInputStream()));
      for (;;)
      {
        str2 = str1;
        localObject1 = localObject2;
        String str3 = localBufferedReader.readLine();
        str2 = str1;
        localObject1 = localObject2;
        if (str3 == null) {
          break;
        }
        localObject3 = localObject2;
        str2 = str1;
        localObject1 = localObject2;
        if (str3.contains(" packet loss"))
        {
          str2 = str1;
          localObject1 = localObject2;
          paramInt = str3.indexOf("received, ");
          str2 = str1;
          localObject1 = localObject2;
          int i = str3.indexOf("%");
          str2 = str1;
          localObject1 = localObject2;
          localObject3 = str3.substring(paramInt + "received, ".length(), i + 1);
        }
        localObject2 = localObject3;
        str2 = str1;
        localObject1 = localObject3;
        if (str3.contains("avg"))
        {
          str2 = str1;
          localObject1 = localObject3;
          paramInt = str3.indexOf("/", 20);
          str2 = str1;
          localObject1 = localObject3;
          str1 = str3.substring(paramInt + 1, str3.indexOf(".", paramInt));
          localObject2 = localObject3;
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      localObject1 = (String)localObject1 + ";" + str2;
      AppMethodBeat.o(256249);
    }
  }
  
  public static int objectToInt(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(256242);
    if (paramObject == null)
    {
      AppMethodBeat.o(256242);
      return paramInt;
    }
    try
    {
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(256242);
      return i;
    }
    catch (Throwable paramObject)
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to int failed, error:" + paramObject.toString());
      AppMethodBeat.o(256242);
    }
    return paramInt;
  }
  
  public static long objectToLong(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(256244);
    if (paramObject == null)
    {
      AppMethodBeat.o(256244);
      return paramLong;
    }
    try
    {
      long l = ((Long)paramObject).longValue();
      AppMethodBeat.o(256244);
      return l;
    }
    catch (Throwable paramObject)
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to long failed, error:" + paramObject.toString());
      AppMethodBeat.o(256244);
    }
    return paramLong;
  }
  
  /* Error */
  public static String serialize(Object paramObject)
  {
    // Byte code:
    //   0: ldc 157
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 159	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 160	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 162	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 165	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 5
    //   23: aload_1
    //   24: astore_3
    //   25: aload 5
    //   27: astore_2
    //   28: aload 5
    //   30: aload_0
    //   31: invokevirtual 169	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   34: aload_1
    //   35: astore_3
    //   36: aload 5
    //   38: astore_2
    //   39: aload_1
    //   40: ldc 171
    //   42: invokevirtual 174	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_0
    //   46: aload 5
    //   48: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   51: aload_1
    //   52: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   55: ldc 157
    //   57: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: areturn
    //   62: astore_2
    //   63: ldc 8
    //   65: iconst_0
    //   66: ldc 38
    //   68: new 40	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 180
    //   74: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   81: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   90: goto -39 -> 51
    //   93: astore_1
    //   94: ldc 8
    //   96: iconst_0
    //   97: ldc 38
    //   99: new 40	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 182
    //   105: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   112: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   121: goto -66 -> 55
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_1
    //   131: astore_3
    //   132: aload_0
    //   133: astore_2
    //   134: ldc 8
    //   136: iconst_0
    //   137: ldc 38
    //   139: new 40	java/lang/StringBuilder
    //   142: dup
    //   143: ldc 184
    //   145: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: aload 4
    //   150: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   153: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   170: aload_1
    //   171: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   174: ldc 157
    //   176: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: ldc 29
    //   181: areturn
    //   182: astore_0
    //   183: ldc 8
    //   185: iconst_0
    //   186: ldc 38
    //   188: new 40	java/lang/StringBuilder
    //   191: dup
    //   192: ldc 180
    //   194: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   201: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   210: goto -40 -> 170
    //   213: astore_0
    //   214: ldc 8
    //   216: iconst_0
    //   217: ldc 38
    //   219: new 40	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 182
    //   225: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_0
    //   229: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   232: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   241: goto -67 -> 174
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +7 -> 257
    //   253: aload_2
    //   254: invokevirtual 177	java/io/ObjectOutputStream:close	()V
    //   257: aload_1
    //   258: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   261: ldc 157
    //   263: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_2
    //   269: ldc 8
    //   271: iconst_0
    //   272: ldc 38
    //   274: new 40	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 180
    //   280: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_2
    //   284: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   287: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   296: goto -39 -> 257
    //   299: astore_1
    //   300: ldc 8
    //   302: iconst_0
    //   303: ldc 38
    //   305: new 40	java/lang/StringBuilder
    //   308: dup
    //   309: ldc 182
    //   311: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload_1
    //   315: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   318: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   327: goto -66 -> 261
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_2
    //   333: goto -84 -> 249
    //   336: astore_0
    //   337: aload_3
    //   338: astore_1
    //   339: goto -90 -> 249
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_0
    //   346: goto -216 -> 130
    //   349: astore 4
    //   351: aload 5
    //   353: astore_0
    //   354: goto -224 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramObject	Object
    //   12	40	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   93	16	1	localThrowable1	Throwable
    //   127	131	1	localObject1	Object
    //   299	16	1	localThrowable2	Throwable
    //   338	1	1	localObject2	Object
    //   27	12	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	16	2	localThrowable3	Throwable
    //   133	121	2	localObject3	Object
    //   268	16	2	localThrowable4	Throwable
    //   332	1	2	localObject4	Object
    //   24	314	3	localObject5	Object
    //   124	25	4	localThrowable5	Throwable
    //   342	1	4	localThrowable6	Throwable
    //   349	1	4	localThrowable7	Throwable
    //   21	331	5	localObjectOutputStream2	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   46	51	62	java/lang/Throwable
    //   51	55	93	java/lang/Throwable
    //   5	13	124	java/lang/Throwable
    //   166	170	182	java/lang/Throwable
    //   170	174	213	java/lang/Throwable
    //   5	13	244	finally
    //   253	257	268	java/lang/Throwable
    //   257	261	299	java/lang/Throwable
    //   13	23	330	finally
    //   28	34	336	finally
    //   39	46	336	finally
    //   134	162	336	finally
    //   13	23	342	java/lang/Throwable
    //   28	34	349	java/lang/Throwable
    //   39	46	349	java/lang/Throwable
  }
  
  /* Error */
  public static Object serializeToObject(String paramString)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 189	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_0
    //   10: ldc 171
    //   12: invokevirtual 193	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   15: invokespecial 196	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_1
    //   19: new 198	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 199	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore_3
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 203	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore 4
    //   38: aload_0
    //   39: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   42: aload_1
    //   43: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   46: ldc 187
    //   48: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload 4
    //   53: areturn
    //   54: astore_0
    //   55: ldc 8
    //   57: iconst_0
    //   58: ldc 38
    //   60: new 40	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 207
    //   66: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   73: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   82: goto -40 -> 42
    //   85: astore_0
    //   86: ldc 8
    //   88: iconst_0
    //   89: ldc 38
    //   91: new 40	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 209
    //   97: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   104: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   113: goto -67 -> 46
    //   116: astore 4
    //   118: aconst_null
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: ldc 8
    //   128: iconst_0
    //   129: ldc 38
    //   131: new 40	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 211
    //   137: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 4
    //   142: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   145: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   170: ldc 187
    //   172: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: ldc 8
    //   180: iconst_0
    //   181: ldc 38
    //   183: new 40	java/lang/StringBuilder
    //   186: dup
    //   187: ldc 207
    //   189: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   196: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   205: goto -43 -> 162
    //   208: astore_0
    //   209: ldc 8
    //   211: iconst_0
    //   212: ldc 38
    //   214: new 40	java/lang/StringBuilder
    //   217: dup
    //   218: ldc 209
    //   220: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   227: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   236: goto -66 -> 170
    //   239: astore_0
    //   240: aconst_null
    //   241: astore_3
    //   242: aconst_null
    //   243: astore_1
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   260: ldc 187
    //   262: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_0
    //   266: athrow
    //   267: astore_2
    //   268: ldc 8
    //   270: iconst_0
    //   271: ldc 38
    //   273: new 40	java/lang/StringBuilder
    //   276: dup
    //   277: ldc 207
    //   279: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload_2
    //   283: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   286: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   295: goto -43 -> 252
    //   298: astore_1
    //   299: ldc 8
    //   301: iconst_0
    //   302: ldc 38
    //   304: new 40	java/lang/StringBuilder
    //   307: dup
    //   308: ldc 209
    //   310: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: aload_1
    //   314: invokevirtual 49	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 60	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   326: goto -66 -> 260
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -88 -> 244
    //   335: astore_0
    //   336: aload_2
    //   337: astore_1
    //   338: goto -94 -> 244
    //   341: astore 4
    //   343: aconst_null
    //   344: astore_0
    //   345: goto -223 -> 122
    //   348: astore 4
    //   350: goto -228 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramString	String
    //   18	239	1	localByteArrayInputStream1	java.io.ByteArrayInputStream
    //   298	16	1	localThrowable1	Throwable
    //   337	1	1	localObject1	Object
    //   31	95	2	localByteArrayInputStream2	java.io.ByteArrayInputStream
    //   267	70	2	localThrowable2	Throwable
    //   29	303	3	str	String
    //   36	16	4	localObject2	Object
    //   116	25	4	localThrowable3	Throwable
    //   341	1	4	localThrowable4	Throwable
    //   348	1	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   38	42	54	java/lang/Throwable
    //   42	46	85	java/lang/Throwable
    //   5	19	116	java/lang/Throwable
    //   158	162	177	java/lang/Throwable
    //   166	170	208	java/lang/Throwable
    //   5	19	239	finally
    //   248	252	267	java/lang/Throwable
    //   256	260	298	java/lang/Throwable
    //   19	28	329	finally
    //   32	38	335	finally
    //   126	154	335	finally
    //   19	28	341	java/lang/Throwable
    //   32	38	348	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils
 * JD-Core Version:    0.7.0.1
 */