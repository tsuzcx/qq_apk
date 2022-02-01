package mqq.util;

import android.os.Environment;
import java.io.File;

public class MqqConnRateReport
{
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_APPPROCESSINFO_ISNULL = 8;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_HALF_CLOSE = 10;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_NEEDBOOT_TIMEOUT = 14;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_PROCESSNAME_ISEMPTY = 7;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_PROCESS_ISDIED = 9;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_RECVRESPONSE_DEAD_OBJECT = 11;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_RECVRESPONSE_EXCEPTION = 12;
  public static final int ERR_MSF_RECV_APPPROCESSMANAGER_SENDTIME = 13;
  public static final int ERR_MSF_RECV_FROMSERVICEMSG_NOTSUCCESS = 3;
  public static final int ERR_MSF_RECV_HANDLECMDPUSH_APPPUSH_ISNULL = 6;
  public static final int ERR_MSF_RECV_HANDLECMDPUSH_CMDNOT_FIND = 5;
  public static final int ERR_MSF_RECV_HANDLECMDPUSH_UIN_NOTEQUAL = 4;
  public static final int ERR_MSF_RECV_MSFRESPUTIL_PUSHHANDLER_ISNULL = 18;
  public static final int ERR_MSF_RECV_MSFSERVICEPROXY_ISPUSHCONFIG = 17;
  public static final int ERR_MSF_RECV_MSFSERVICEPROXY_NOTCONNECT_MSF = 16;
  public static final int ERR_MSF_RECV_MSFSERVICEPROXY_TOKENEXPIRED = 15;
  public static final int ERR_MSF_RECV_REASON1 = 1;
  public static final int ERR_MSF_RECV_SERVLETCONTAINER_SERVLET_ISNULL_OR_EQUALSEND = 20;
  public static final int ERR_MSF_RECV_SERVLETCONTAINER_SET_ISNULL = 19;
  public static final int ERR_MSF_RECV_TOSERVICEMSG_NOTNULL = 2;
  public static final int ERR_MSF_SEND_VIDEOACK_REASON1 = 100;
  public static final int ERR_NONE = 0;
  public static final String TAG = "MqqConnRateReport";
  static MqqConnRateReport g_Instance;
  static String msfReportLogPath = "";
  
  public static MqqConnRateReport getInstance()
  {
    if (g_Instance == null)
    {
      g_Instance = new MqqConnRateReport();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/audio/");
      msfReportLogPath = localStringBuilder.toString();
    }
    return g_Instance;
  }
  
  /* Error */
  public void doReport(MqqConnRateReport.EventType paramEventType, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 71	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_1
    //   17: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 5
    //   23: ldc 106
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: invokestatic 112	android/os/SystemClock:elapsedRealtime	()J
    //   34: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc 106
    //   45: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: iload_3
    //   52: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 5
    //   58: ldc 123
    //   60: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_1
    //   70: invokestatic 126	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   73: ldc 128
    //   75: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne +4 -> 82
    //   81: return
    //   82: new 80	java/io/File
    //   85: dup
    //   86: getstatic 95	mqq/util/MqqConnRateReport:msfReportLogPath	Ljava/lang/String;
    //   89: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 139	java/io/File:exists	()Z
    //   99: ifne +12 -> 111
    //   102: aload 5
    //   104: invokevirtual 142	java/io/File:mkdirs	()Z
    //   107: ifne +4 -> 111
    //   110: return
    //   111: iconst_1
    //   112: istore 4
    //   114: iconst_1
    //   115: istore_3
    //   116: new 71	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   123: astore 5
    //   125: aload 5
    //   127: getstatic 95	mqq/util/MqqConnRateReport:msfReportLogPath	Ljava/lang/String;
    //   130: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 5
    //   136: aload_1
    //   137: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: new 80	java/io/File
    //   144: dup
    //   145: aload 5
    //   147: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore 7
    //   155: aconst_null
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 5
    //   161: new 144	java/io/FileOutputStream
    //   164: dup
    //   165: aload 7
    //   167: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   170: astore_1
    //   171: aload_1
    //   172: aload_2
    //   173: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   176: aload_1
    //   177: invokevirtual 154	java/io/FileOutputStream:flush	()V
    //   180: aload_1
    //   181: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   184: goto +5 -> 189
    //   187: iconst_0
    //   188: istore_3
    //   189: iload_3
    //   190: ifne +77 -> 267
    //   193: goto +68 -> 261
    //   196: astore 5
    //   198: aload_1
    //   199: astore_2
    //   200: aload 5
    //   202: astore_1
    //   203: goto +12 -> 215
    //   206: goto +40 -> 246
    //   209: goto +44 -> 253
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_2
    //   215: iload 4
    //   217: istore_3
    //   218: aload_2
    //   219: ifnull +15 -> 234
    //   222: aload_2
    //   223: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   226: iload 4
    //   228: istore_3
    //   229: goto +5 -> 234
    //   232: iconst_0
    //   233: istore_3
    //   234: iload_3
    //   235: ifne +9 -> 244
    //   238: aload 7
    //   240: invokevirtual 160	java/io/File:delete	()Z
    //   243: pop
    //   244: aload_1
    //   245: athrow
    //   246: aload_1
    //   247: ifnull +14 -> 261
    //   250: goto +7 -> 257
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   261: aload 7
    //   263: invokevirtual 160	java/io/File:delete	()Z
    //   266: pop
    //   267: return
    //   268: astore_1
    //   269: aload 6
    //   271: astore_1
    //   272: goto -19 -> 253
    //   275: astore_1
    //   276: aload 5
    //   278: astore_1
    //   279: goto -33 -> 246
    //   282: astore_2
    //   283: goto -74 -> 209
    //   286: astore_2
    //   287: goto -81 -> 206
    //   290: astore_1
    //   291: goto -104 -> 187
    //   294: astore_2
    //   295: goto -63 -> 232
    //   298: astore_1
    //   299: goto -38 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	MqqConnRateReport
    //   0	302	1	paramEventType	MqqConnRateReport.EventType
    //   0	302	2	paramArrayOfByte	byte[]
    //   0	302	3	paramInt	int
    //   112	115	4	i	int
    //   12	148	5	localObject1	Object
    //   196	81	5	localObject2	Object
    //   156	114	6	localObject3	Object
    //   153	109	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   171	180	196	finally
    //   161	171	212	finally
    //   161	171	268	java/io/FileNotFoundException
    //   161	171	275	java/io/IOException
    //   171	180	282	java/io/FileNotFoundException
    //   171	180	286	java/io/IOException
    //   180	184	290	java/io/IOException
    //   222	226	294	java/io/IOException
    //   257	261	298	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.util.MqqConnRateReport
 * JD-Core Version:    0.7.0.1
 */