package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLiveBase
{
  private static final String FILE_MD5_FFMPEG_ARM = "___md5_libtxffmpeg_arm_md5______";
  private static final String FILE_MD5_FFMPEG_V64 = "___md5_libtxffmpeg_v64_md5______";
  private static final String FILE_MD5_FFMPEG_V7A = "___md5_libtxffmpeg_v7a_md5______";
  private static final String FILE_MD5_LITEAV_ARM = "___md5_libliteavsdk_arm_md5_____";
  private static final String FILE_MD5_LITEAV_V64 = "___md5_libliteavsdk_v64_md5_____";
  private static final String FILE_MD5_LITEAV_V7A = "___md5_libliteavsdk_v7a_md5_____";
  private static final String FILE_MD5_SATURN_ARM = "___md5_libsaturn_arm_md5________";
  private static final String FILE_MD5_SATURN_V64 = "___md5_libsaturn_v64_md5________";
  private static final String FILE_MD5_SATURN_V7A = "___md5_libsaturn_v7a_md5________";
  private static final String FILE_MD5_TRAE_ARM = "___md5_libtraeimp_arm_md5_______";
  private static final String FILE_MD5_TRAE_V64 = "___md5_libtraeimp_v64_md5_______";
  private static final String FILE_MD5_TRAE_V7A = "___md5_libtraeimp_v7a_md5_______";
  private static final String TAG = "TXLiveBase";
  private static TXLiveBase instance;
  private static ITXLiveBaseListener listener;
  
  static
  {
    AppMethodBeat.i(14238);
    listener = null;
    instance = new TXLiveBase();
    AppMethodBeat.o(14238);
  }
  
  /* Error */
  private static String getFileMD5(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: sipush 14237
    //   11: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: new 82	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 7
    //   27: invokevirtual 89	java/io/File:exists	()Z
    //   30: ifeq +11 -> 41
    //   33: aload 7
    //   35: invokevirtual 92	java/io/File:isFile	()Z
    //   38: ifne +11 -> 49
    //   41: sipush 14237
    //   44: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aconst_null
    //   48: areturn
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 6
    //   56: aload 5
    //   58: astore_1
    //   59: ldc 94
    //   61: invokestatic 100	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload_0
    //   68: astore_3
    //   69: aload_0
    //   70: astore 4
    //   72: new 102	java/io/FileInputStream
    //   75: dup
    //   76: aload 7
    //   78: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: astore 5
    //   83: aload_0
    //   84: astore_1
    //   85: aload_0
    //   86: astore_3
    //   87: aload_0
    //   88: astore 4
    //   90: aload 5
    //   92: aload 6
    //   94: iconst_0
    //   95: sipush 1024
    //   98: invokevirtual 109	java/io/FileInputStream:read	([BII)I
    //   101: istore_2
    //   102: iload_2
    //   103: iconst_m1
    //   104: if_icmpeq +50 -> 154
    //   107: aload_0
    //   108: astore_1
    //   109: aload_0
    //   110: astore_3
    //   111: aload_0
    //   112: astore 4
    //   114: aload_0
    //   115: aload 6
    //   117: iconst_0
    //   118: iload_2
    //   119: invokevirtual 113	java/security/MessageDigest:update	([BII)V
    //   122: goto -39 -> 83
    //   125: astore_0
    //   126: aload_1
    //   127: astore_0
    //   128: new 115	java/math/BigInteger
    //   131: dup
    //   132: iconst_1
    //   133: aload_0
    //   134: invokevirtual 119	java/security/MessageDigest:digest	()[B
    //   137: invokespecial 122	java/math/BigInteger:<init>	(I[B)V
    //   140: bipush 16
    //   142: invokevirtual 126	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   145: astore_0
    //   146: sipush 14237
    //   149: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: areturn
    //   154: aload_0
    //   155: astore_1
    //   156: aload_0
    //   157: astore_3
    //   158: aload_0
    //   159: astore 4
    //   161: aload 5
    //   163: invokevirtual 129	java/io/FileInputStream:close	()V
    //   166: goto -38 -> 128
    //   169: astore_0
    //   170: aload_3
    //   171: astore_0
    //   172: goto -44 -> 128
    //   175: astore_0
    //   176: aload 4
    //   178: astore_0
    //   179: goto -51 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString1	String
    //   0	182	1	paramString2	String
    //   101	18	2	i	int
    //   1	170	3	str1	String
    //   3	174	4	str2	String
    //   6	156	5	localFileInputStream	java.io.FileInputStream
    //   54	62	6	arrayOfByte	byte[]
    //   23	54	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   59	65	125	java/security/NoSuchAlgorithmException
    //   72	83	125	java/security/NoSuchAlgorithmException
    //   90	102	125	java/security/NoSuchAlgorithmException
    //   114	122	125	java/security/NoSuchAlgorithmException
    //   161	166	125	java/security/NoSuchAlgorithmException
    //   59	65	169	java/io/FileNotFoundException
    //   72	83	169	java/io/FileNotFoundException
    //   90	102	169	java/io/FileNotFoundException
    //   114	122	169	java/io/FileNotFoundException
    //   161	166	169	java/io/FileNotFoundException
    //   59	65	175	java/io/IOException
    //   72	83	175	java/io/IOException
    //   90	102	175	java/io/IOException
    //   114	122	175	java/io/IOException
    //   161	166	175	java/io/IOException
  }
  
  public static TXLiveBase getInstance()
  {
    return instance;
  }
  
  public static String getPituSDKVersion()
  {
    AppMethodBeat.i(14235);
    String str = p.a();
    AppMethodBeat.o(14235);
    return str;
  }
  
  public static String getSDKVersionStr()
  {
    AppMethodBeat.i(14233);
    String str = TXCCommonUtil.getSDKVersionStr();
    AppMethodBeat.o(14233);
    return str;
  }
  
  public static boolean isLibraryPathValid(String paramString)
  {
    AppMethodBeat.i(14232);
    String str1 = getFileMD5(paramString, "libliteavsdk.so");
    String str2 = getFileMD5(paramString, "libsaturn.so");
    String str3 = getFileMD5(paramString, "libtxffmpeg.so");
    paramString = getFileMD5(paramString, "libtraeimp-rtmp.so");
    new StringBuilder("MD5-CHECK-V64 libliteavsdk = ").append(str1).append(" FILE_MD5_LITEAV_V64 = ___md5_libliteavsdk_v64_md5_____");
    new StringBuilder("MD5-CHECK-V64 libsaturn    = ").append(str2).append(" FILE_MD5_SATURN_V64 = ___md5_libsaturn_v64_md5________");
    new StringBuilder("MD5-CHECK-V64 libtxffmpeg  = ").append(str3).append(" FILE_MD5_FFMPEG_V64 = ___md5_libtxffmpeg_v64_md5______");
    new StringBuilder("MD5-CHECK-V64 libtraeimpl  = ").append(paramString).append(" FILE_MD5_TRAE_V64   = ___md5_libtraeimp_v64_md5_______");
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_v64_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_v64_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_v64_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_v64_md5_______")))
    {
      AppMethodBeat.o(14232);
      return true;
    }
    new StringBuilder("MD5-CHECK-V7A libliteavsdk = ").append(str1).append(" FILE_MD5_LITEAV_V7A = ___md5_libliteavsdk_v7a_md5_____");
    new StringBuilder("MD5-CHECK-V7A libsaturn    = ").append(str2).append(" FILE_MD5_SATURN_V7A = ___md5_libsaturn_v7a_md5________");
    new StringBuilder("MD5-CHECK-V7A libtxffmpeg  = ").append(str3).append(" FILE_MD5_FFMPEG_V7A = ___md5_libtxffmpeg_v7a_md5______");
    new StringBuilder("MD5-CHECK-V7A libtraeimpl  = ").append(paramString).append(" FILE_MD5_TRAE_V7A   = ___md5_libtraeimp_v7a_md5_______");
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_v7a_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_v7a_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_v7a_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_v7a_md5_______")))
    {
      AppMethodBeat.o(14232);
      return true;
    }
    new StringBuilder("MD5-CHECK-ARM libliteavsdk = ").append(str1).append(" FILE_MD5_LITEAV_ARM = ___md5_libliteavsdk_arm_md5_____");
    new StringBuilder("MD5-CHECK-ARM libsaturn    = ").append(str2).append(" FILE_MD5_SATURN_ARM = ___md5_libsaturn_arm_md5________");
    new StringBuilder("MD5-CHECK-ARM libtxffmpeg  = ").append(str3).append(" FILE_MD5_FFMPEG_ARM = ___md5_libtxffmpeg_arm_md5______");
    new StringBuilder("MD5-CHECK-ARM libtraeimpl  = ").append(paramString).append(" FILE_MD5_TRAE_ARM   = ___md5_libtraeimp_arm_md5_______");
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_arm_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_arm_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_arm_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_arm_md5_______")))
    {
      AppMethodBeat.o(14232);
      return true;
    }
    AppMethodBeat.o(14232);
    return false;
  }
  
  public static void setAppID(String paramString)
  {
    AppMethodBeat.i(14236);
    TXCCommonUtil.setAppID(paramString);
    AppMethodBeat.o(14236);
  }
  
  public static void setAppVersion(String paramString)
  {
    AppMethodBeat.i(14230);
    TXCDRApi.txSetAppVersion(paramString);
    TXCCommonUtil.setAppVersion(paramString);
    AppMethodBeat.o(14230);
  }
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(14229);
    TXCLog.setConsoleEnabled(paramBoolean);
    AppMethodBeat.o(14229);
  }
  
  public static void setLibraryPath(String paramString)
  {
    AppMethodBeat.i(14231);
    com.tencent.liteav.basic.util.f.b(paramString);
    AppMethodBeat.o(14231);
  }
  
  public static void setListener(ITXLiveBaseListener paramITXLiveBaseListener)
  {
    AppMethodBeat.i(14227);
    TXCLog.setListener(new TXLiveBase.a(null));
    listener = paramITXLiveBaseListener;
    AppMethodBeat.o(14227);
  }
  
  public static void setLogLevel(int paramInt)
  {
    AppMethodBeat.i(14228);
    TXCLog.setLevel(paramInt);
    AppMethodBeat.o(14228);
  }
  
  public static void setPituLicencePath(String paramString)
  {
    AppMethodBeat.i(14234);
    TXCCommonUtil.setPituLicencePath(paramString);
    AppMethodBeat.o(14234);
  }
  
  public static void setUserId(String paramString)
  {
    AppMethodBeat.i(222653);
    TXCCommonUtil.setUserId(paramString);
    AppMethodBeat.o(222653);
  }
  
  public String getLicenceInfo(Context paramContext)
  {
    AppMethodBeat.i(14226);
    com.tencent.liteav.basic.license.f localf = new com.tencent.liteav.basic.license.f();
    LicenceCheck.a().a(localf, paramContext);
    paramContext = localf.a;
    AppMethodBeat.o(14226);
    return paramContext;
  }
  
  public void setLicence(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14225);
    LicenceCheck.a().a(paramContext, paramString1, paramString2);
    AppMethodBeat.o(14225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.TXLiveBase
 * JD-Core Version:    0.7.0.1
 */