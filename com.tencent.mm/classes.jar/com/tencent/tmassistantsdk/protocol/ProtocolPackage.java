package com.tencent.tmassistantsdk.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(102263);
    if (paramRequest == null)
    {
      AppMethodBeat.o(102263);
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
    paramRequest = jceStructToUTF8Byte(paramRequest);
    AppMethodBeat.o(102263);
    return paramRequest;
  }
  
  public static JceStruct buildReportRequest(byte paramByte, List<byte[]> paramList, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(102260);
    ReportLogRequest localReportLogRequest = new ReportLogRequest();
    localReportLogRequest.logType = paramByte;
    localReportLogRequest.logData = formatLogData(paramList);
    localReportLogRequest.hostAppPackageName = paramString1;
    localReportLogRequest.hostAppVersion = paramInt;
    localReportLogRequest.hostUserId = paramString2;
    AppMethodBeat.o(102260);
    return localReportLogRequest;
  }
  
  public static Request buildRequest(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102262);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102262);
      return null;
    }
    Request localRequest = new Request();
    localRequest.head = getReqHead(paramJceStruct);
    localRequest.body = jceStructToUTF8Byte(paramJceStruct);
    AppMethodBeat.o(102262);
    return localRequest;
  }
  
  public static JceStruct bytes2JceObj(byte[] paramArrayOfByte, Class<? extends JceStruct> paramClass)
  {
    AppMethodBeat.i(102268);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(102268);
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(paramArrayOfByte);
      AppMethodBeat.o(102268);
      return paramClass;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(102268);
    }
    return null;
  }
  
  private static JceStruct createFromRequest(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102266);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102266);
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - 7) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
      AppMethodBeat.o(102266);
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        ad.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        ad.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        ad.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
        paramJceStruct = null;
      }
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102271);
    paramArrayOfByte1 = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    AppMethodBeat.o(102271);
    return paramArrayOfByte1;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102270);
    paramArrayOfByte1 = new Cryptor().encrypt(paramArrayOfByte1, paramArrayOfByte2);
    AppMethodBeat.o(102270);
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static byte[] formatLogData(List<byte[]> paramList)
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 199	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 200	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 202	java/io/DataOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 205	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: invokeinterface 211 1 0
    //   34: astore_0
    //   35: aload 4
    //   37: astore_3
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: invokeinterface 217 1 0
    //   46: ifeq +94 -> 140
    //   49: aload 4
    //   51: astore_3
    //   52: aload_1
    //   53: astore_2
    //   54: aload_0
    //   55: invokeinterface 220 1 0
    //   60: checkcast 221	[B
    //   63: astore 5
    //   65: aload 4
    //   67: astore_3
    //   68: aload_1
    //   69: astore_2
    //   70: aload 4
    //   72: aload 5
    //   74: arraylength
    //   75: invokevirtual 224	java/io/DataOutputStream:writeInt	(I)V
    //   78: aload 4
    //   80: astore_3
    //   81: aload_1
    //   82: astore_2
    //   83: aload 4
    //   85: aload 5
    //   87: invokevirtual 227	java/io/DataOutputStream:write	([B)V
    //   90: goto -55 -> 35
    //   93: astore_2
    //   94: aload 4
    //   96: astore_0
    //   97: aload_2
    //   98: astore 4
    //   100: aload_0
    //   101: astore_3
    //   102: aload_1
    //   103: astore_2
    //   104: ldc 19
    //   106: aload 4
    //   108: ldc 179
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 231	java/io/DataOutputStream:close	()V
    //   133: ldc 197
    //   135: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: aload 4
    //   142: astore_3
    //   143: aload_1
    //   144: astore_2
    //   145: aload_1
    //   146: invokevirtual 234	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: astore_0
    //   150: aload_1
    //   151: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   154: aload 4
    //   156: invokevirtual 231	java/io/DataOutputStream:close	()V
    //   159: ldc 197
    //   161: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_0
    //   165: areturn
    //   166: astore_1
    //   167: ldc 19
    //   169: aload_1
    //   170: ldc 179
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -25 -> 154
    //   182: astore_1
    //   183: ldc 19
    //   185: aload_1
    //   186: ldc 179
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -36 -> 159
    //   198: astore_1
    //   199: ldc 19
    //   201: aload_1
    //   202: ldc 179
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -86 -> 125
    //   214: astore_0
    //   215: ldc 19
    //   217: aload_0
    //   218: ldc 179
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: goto -94 -> 133
    //   230: astore_0
    //   231: aconst_null
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 231	java/io/DataOutputStream:close	()V
    //   251: ldc 197
    //   253: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_0
    //   257: athrow
    //   258: astore_1
    //   259: ldc 19
    //   261: aload_1
    //   262: ldc 179
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -28 -> 243
    //   274: astore_1
    //   275: ldc 19
    //   277: aload_1
    //   278: ldc 179
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: goto -36 -> 251
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_3
    //   293: goto -58 -> 235
    //   296: astore_0
    //   297: aload_2
    //   298: astore_1
    //   299: goto -64 -> 235
    //   302: astore 4
    //   304: aconst_null
    //   305: astore_0
    //   306: aconst_null
    //   307: astore_1
    //   308: goto -208 -> 100
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_0
    //   315: goto -215 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramList	List<byte[]>
    //   12	139	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   166	4	1	localIOException1	java.io.IOException
    //   182	4	1	localIOException2	java.io.IOException
    //   198	4	1	localIOException3	java.io.IOException
    //   234	6	1	localObject1	Object
    //   258	4	1	localIOException4	java.io.IOException
    //   274	4	1	localIOException5	java.io.IOException
    //   298	10	1	localObject2	Object
    //   27	56	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   93	5	2	localException1	Exception
    //   103	195	2	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   25	268	3	localObject3	Object
    //   21	134	4	localObject4	Object
    //   302	1	4	localException2	Exception
    //   311	1	4	localException3	Exception
    //   63	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	35	93	java/lang/Exception
    //   40	49	93	java/lang/Exception
    //   54	65	93	java/lang/Exception
    //   70	78	93	java/lang/Exception
    //   83	90	93	java/lang/Exception
    //   145	150	93	java/lang/Exception
    //   150	154	166	java/io/IOException
    //   154	159	182	java/io/IOException
    //   121	125	198	java/io/IOException
    //   129	133	214	java/io/IOException
    //   5	13	230	finally
    //   239	243	258	java/io/IOException
    //   247	251	274	java/io/IOException
    //   13	23	290	finally
    //   28	35	296	finally
    //   40	49	296	finally
    //   54	65	296	finally
    //   70	78	296	finally
    //   83	90	296	finally
    //   104	117	296	finally
    //   145	150	296	finally
    //   5	13	302	java/lang/Exception
    //   13	23	311	java/lang/Exception
  }
  
  public static ReqHead getReqHead(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102261);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102261);
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
    AppMethodBeat.o(102261);
    return localReqHead;
  }
  
  public static byte[] jceStructToUTF8Byte(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(102267);
    if (paramJceStruct == null)
    {
      AppMethodBeat.o(102267);
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    paramJceStruct = localJceOutputStream.toByteArray();
    AppMethodBeat.o(102267);
    return paramJceStruct;
  }
  
  public static Response unpackPackage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102264);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      AppMethodBeat.o(102264);
      return null;
    }
    Response localResponse = new Response();
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      localResponse.readFrom(paramArrayOfByte);
      if (localResponse.head.ret == 0)
      {
        if ((localResponse.head.encryptWithPack & 0x2) == 2) {
          localResponse.body = decrypt(localResponse.body, "ji*9^&43U0X-~./(".getBytes());
        }
        if ((localResponse.head.encryptWithPack & 0x1) == 1) {
          localResponse.body = ZipUtils.unzip(localResponse.body);
        }
        GlobalUtil.getInstance().setPhoneGuid(localResponse.head.phoneGuid);
      }
      AppMethodBeat.o(102264);
      return localResponse;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("ProtocolPackage", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(102264);
    }
    return null;
  }
  
  public static JceStruct unpageageJceResponse(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102265);
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = createFromRequest(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          AppMethodBeat.o(102265);
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          ad.printErrStackTrace("ProtocolPackage", paramJceStruct, "", new Object[0]);
          AppMethodBeat.o(102265);
          return null;
        }
      }
    }
    AppMethodBeat.o(102265);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.ProtocolPackage
 * JD-Core Version:    0.7.0.1
 */