package com.tencent.tmassistantsdk.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReqHead;
import com.tencent.tmassistantsdk.protocol.jce.Request;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.protocol.jce.RspHead;
import com.tencent.tmassistantsdk.protocol.jce.Terminal;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import java.util.List;

public class ProtocolPackage
{
  static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
  static final byte FLAG_CRYPT = 2;
  static final byte FLAG_ZIP = 1;
  public static final String ServerEncoding = "utf-8";
  private static final String TAG = "ProtocolPackage";
  static final int ZIP_TRIGGER = 256;
  
  public static byte[] buildPostData(Request paramRequest)
  {
    if (paramRequest == null) {
      return null;
    }
    paramRequest.head.encryptWithPack = 0;
    if (paramRequest.body.length > 256)
    {
      paramRequest.body = ZipUtils.zip(paramRequest.body);
      paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x1));
    }
    paramRequest.body = encrypt(paramRequest.body, "ji*9^&43U0X-~./(".getBytes());
    paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x2));
    return jceStructToUTF8Byte(paramRequest);
  }
  
  public static JceStruct buildReportRequest(byte paramByte, List<byte[]> paramList, String paramString1, int paramInt, String paramString2)
  {
    ReportLogRequest localReportLogRequest = new ReportLogRequest();
    localReportLogRequest.logType = paramByte;
    localReportLogRequest.logData = formatLogData(paramList);
    localReportLogRequest.hostAppPackageName = paramString1;
    localReportLogRequest.hostAppVersion = paramInt;
    localReportLogRequest.hostUserId = paramString2;
    return localReportLogRequest;
  }
  
  public static Request buildRequest(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    Request localRequest = new Request();
    localRequest.head = getReqHead(paramJceStruct);
    localRequest.body = jceStructToUTF8Byte(paramJceStruct);
    return localRequest;
  }
  
  public static JceStruct bytes2JceObj(byte[] paramArrayOfByte, Class<? extends JceStruct> paramClass)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private static JceStruct createFromRequest(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - 7) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        y.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        y.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        y.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  /* Error */
  public static byte[] formatLogData(List<byte[]> paramList)
  {
    // Byte code:
    //   0: new 182	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 183	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 185	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 188	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: invokeinterface 194 1 0
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: invokeinterface 200 1 0
    //   41: ifeq +89 -> 130
    //   44: aload 4
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_0
    //   50: invokeinterface 203 1 0
    //   55: checkcast 204	[B
    //   58: astore 5
    //   60: aload 4
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 208	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload 4
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 211	java/io/DataOutputStream:write	([B)V
    //   85: goto -55 -> 30
    //   88: astore_2
    //   89: aload 4
    //   91: astore_0
    //   92: aload_2
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: ldc 19
    //   101: aload 4
    //   103: ldc 165
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 214	java/io/ByteArrayOutputStream:close	()V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 215	java/io/DataOutputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: aload 4
    //   132: astore_3
    //   133: aload_1
    //   134: astore_2
    //   135: aload_1
    //   136: invokevirtual 218	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   139: astore_0
    //   140: aload_1
    //   141: invokevirtual 214	java/io/ByteArrayOutputStream:close	()V
    //   144: aload 4
    //   146: invokevirtual 215	java/io/DataOutputStream:close	()V
    //   149: aload_0
    //   150: areturn
    //   151: astore_1
    //   152: ldc 19
    //   154: aload_1
    //   155: ldc 165
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: areturn
    //   166: astore_1
    //   167: ldc 19
    //   169: aload_1
    //   170: ldc 165
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -35 -> 144
    //   182: astore_1
    //   183: ldc 19
    //   185: aload_1
    //   186: ldc 165
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -75 -> 120
    //   198: astore_0
    //   199: ldc 19
    //   201: aload_0
    //   202: ldc 165
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -83 -> 128
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 214	java/io/ByteArrayOutputStream:close	()V
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 215	java/io/DataOutputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_1
    //   238: ldc 19
    //   240: aload_1
    //   241: ldc 165
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: goto -23 -> 227
    //   253: astore_1
    //   254: ldc 19
    //   256: aload_1
    //   257: ldc 165
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: goto -31 -> 235
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_3
    //   272: goto -53 -> 219
    //   275: astore_0
    //   276: aload_2
    //   277: astore_1
    //   278: goto -59 -> 219
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -192 -> 95
    //   290: astore 4
    //   292: aconst_null
    //   293: astore_0
    //   294: goto -199 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramList	List<byte[]>
    //   7	134	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   151	4	1	localIOException1	java.io.IOException
    //   166	4	1	localIOException2	java.io.IOException
    //   182	4	1	localIOException3	java.io.IOException
    //   218	6	1	localObject1	Object
    //   237	4	1	localIOException4	java.io.IOException
    //   253	4	1	localIOException5	java.io.IOException
    //   277	10	1	localObject2	Object
    //   22	56	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   88	5	2	localException1	Exception
    //   98	179	2	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   20	252	3	localObject3	Object
    //   16	129	4	localObject4	Object
    //   281	1	4	localException2	Exception
    //   290	1	4	localException3	Exception
    //   58	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	30	88	java/lang/Exception
    //   35	44	88	java/lang/Exception
    //   49	60	88	java/lang/Exception
    //   65	73	88	java/lang/Exception
    //   78	85	88	java/lang/Exception
    //   135	140	88	java/lang/Exception
    //   144	149	151	java/io/IOException
    //   140	144	166	java/io/IOException
    //   116	120	182	java/io/IOException
    //   124	128	198	java/io/IOException
    //   0	8	214	finally
    //   223	227	237	java/io/IOException
    //   231	235	253	java/io/IOException
    //   8	18	269	finally
    //   23	30	275	finally
    //   35	44	275	finally
    //   49	60	275	finally
    //   65	73	275	finally
    //   78	85	275	finally
    //   99	112	275	finally
    //   135	140	275	finally
    //   0	8	281	java/lang/Exception
    //   8	18	290	java/lang/Exception
  }
  
  public static ReqHead getReqHead(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    ReqHead localReqHead = new ReqHead();
    localReqHead.requestId = GlobalUtil.getMemUUID();
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - 7);
    localReqHead.cmdId = GlobalUtil.getInstance().getJceCmdIdByClassName(paramJceStruct);
    localReqHead.qua = GlobalUtil.getInstance().mQUA;
    localReqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
    localReqHead.terminal = new Terminal();
    localReqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
    localReqHead.assistantVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
    return localReqHead;
  }
  
  public static byte[] jceStructToUTF8Byte(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static Response unpackPackage(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Response localResponse = new Response();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localResponse;
        if (localResponse.head.ret == 0)
        {
          if ((localResponse.head.encryptWithPack & 0x2) == 2) {
            localResponse.body = decrypt(localResponse.body, "ji*9^&43U0X-~./(".getBytes());
          }
          if ((localResponse.head.encryptWithPack & 0x1) == 1) {
            localResponse.body = ZipUtils.unzip(localResponse.body);
          }
          GlobalUtil.getInstance().setPhoneGuid(localResponse.head.phoneGuid);
          return localResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("ProtocolPackage", paramArrayOfByte, "", new Object[0]);
      }
    }
    return null;
  }
  
  public static JceStruct unpageageJceResponse(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = createFromRequest(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          y.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
          return null;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.ProtocolPackage
 * JD-Core Version:    0.7.0.1
 */