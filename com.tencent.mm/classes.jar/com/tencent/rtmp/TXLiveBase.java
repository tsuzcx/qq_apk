package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.basic.b.e;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLiveBase
{
  private static final String FILE_MD5_FFMPEG = "___md5_libtxffmpeg_md5__________";
  private static final String FILE_MD5_LITEAV = "___md5_libliteavsdk_md5_________";
  private static final String FILE_MD5_SATURN = "___md5_libsaturn_md5____________";
  private static final String FILE_MD5_TRAE = "___md5_libtraeimp_md5___________";
  private static final String TAG = "TXLiveBase";
  private static TXLiveBase instance;
  private static ITXLiveBaseListener listener;
  
  static
  {
    AppMethodBeat.i(65607);
    listener = null;
    instance = new TXLiveBase();
    AppMethodBeat.o(65607);
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
    //   8: ldc 60
    //   10: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: new 62	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 69	java/io/File:exists	()Z
    //   29: ifeq +11 -> 40
    //   32: aload 7
    //   34: invokevirtual 72	java/io/File:isFile	()Z
    //   37: ifne +10 -> 47
    //   40: ldc 60
    //   42: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: sipush 1024
    //   50: newarray byte
    //   52: astore 6
    //   54: aload 5
    //   56: astore_1
    //   57: ldc 74
    //   59: invokestatic 80	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   62: astore_0
    //   63: aload_0
    //   64: astore_1
    //   65: aload_0
    //   66: astore_3
    //   67: aload_0
    //   68: astore 4
    //   70: new 82	java/io/FileInputStream
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: astore 5
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: astore_3
    //   85: aload_0
    //   86: astore 4
    //   88: aload 5
    //   90: aload 6
    //   92: iconst_0
    //   93: sipush 1024
    //   96: invokevirtual 89	java/io/FileInputStream:read	([BII)I
    //   99: istore_2
    //   100: iload_2
    //   101: iconst_m1
    //   102: if_icmpeq +49 -> 151
    //   105: aload_0
    //   106: astore_1
    //   107: aload_0
    //   108: astore_3
    //   109: aload_0
    //   110: astore 4
    //   112: aload_0
    //   113: aload 6
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 93	java/security/MessageDigest:update	([BII)V
    //   120: goto -39 -> 81
    //   123: astore_0
    //   124: aload_1
    //   125: astore_0
    //   126: new 95	java/math/BigInteger
    //   129: dup
    //   130: iconst_1
    //   131: aload_0
    //   132: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   135: invokespecial 102	java/math/BigInteger:<init>	(I[B)V
    //   138: bipush 16
    //   140: invokevirtual 106	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   143: astore_0
    //   144: ldc 60
    //   146: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: areturn
    //   151: aload_0
    //   152: astore_1
    //   153: aload_0
    //   154: astore_3
    //   155: aload_0
    //   156: astore 4
    //   158: aload 5
    //   160: invokevirtual 109	java/io/FileInputStream:close	()V
    //   163: goto -37 -> 126
    //   166: astore_0
    //   167: aload_3
    //   168: astore_0
    //   169: goto -43 -> 126
    //   172: astore_0
    //   173: aload 4
    //   175: astore_0
    //   176: goto -50 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString1	String
    //   0	179	1	paramString2	String
    //   99	18	2	i	int
    //   1	167	3	str1	String
    //   3	171	4	str2	String
    //   6	153	5	localFileInputStream	java.io.FileInputStream
    //   52	62	6	arrayOfByte	byte[]
    //   22	53	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   57	63	123	java/security/NoSuchAlgorithmException
    //   70	81	123	java/security/NoSuchAlgorithmException
    //   88	100	123	java/security/NoSuchAlgorithmException
    //   112	120	123	java/security/NoSuchAlgorithmException
    //   158	163	123	java/security/NoSuchAlgorithmException
    //   57	63	166	java/io/FileNotFoundException
    //   70	81	166	java/io/FileNotFoundException
    //   88	100	166	java/io/FileNotFoundException
    //   112	120	166	java/io/FileNotFoundException
    //   158	163	166	java/io/FileNotFoundException
    //   57	63	172	java/io/IOException
    //   70	81	172	java/io/IOException
    //   88	100	172	java/io/IOException
    //   112	120	172	java/io/IOException
    //   158	163	172	java/io/IOException
  }
  
  public static TXLiveBase getInstance()
  {
    return instance;
  }
  
  public static String getPituSDKVersion()
  {
    AppMethodBeat.i(65604);
    String str = o.a();
    AppMethodBeat.o(65604);
    return str;
  }
  
  public static String getSDKVersionStr()
  {
    AppMethodBeat.i(65602);
    String str = TXCCommonUtil.getSDKVersionStr();
    AppMethodBeat.o(65602);
    return str;
  }
  
  public static boolean isLibraryPathValid(String paramString)
  {
    AppMethodBeat.i(65601);
    String str1 = getFileMD5(paramString, "libliteavsdk.so");
    String str2 = getFileMD5(paramString, "libsaturn.so");
    String str3 = getFileMD5(paramString, "libtxffmpeg.so");
    paramString = getFileMD5(paramString, "libtraeimp-rtmp-armeabi.so");
    new StringBuilder("MD5-Check libliteavsdk = ").append(str1).append(" FILE_MD5_LITEAV = ___md5_libliteavsdk_md5_________");
    new StringBuilder("MD5-Check libsaturn = ").append(str2).append(" FILE_MD5_SATURN = ___md5_libsaturn_md5____________");
    new StringBuilder("MD5-Check libtxffmpeg = ").append(str3).append(" FILE_MD5_FFMPEG = ___md5_libtxffmpeg_md5__________");
    new StringBuilder("MD5-Check libtraeimpl = ").append(paramString).append(" FILE_MD5_TRAE = ___md5_libtraeimp_md5___________");
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_md5_________")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_md5____________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_md5__________")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_md5___________")))
    {
      AppMethodBeat.o(65601);
      return true;
    }
    AppMethodBeat.o(65601);
    return false;
  }
  
  public static void setAppID(String paramString)
  {
    AppMethodBeat.i(65605);
    TXCCommonUtil.setAppID(paramString);
    AppMethodBeat.o(65605);
  }
  
  public static void setAppVersion(String paramString)
  {
    AppMethodBeat.i(65599);
    TXCDRApi.txSetAppVersion(paramString);
    TXCCommonUtil.setAppVersion(paramString);
    AppMethodBeat.o(65599);
  }
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(65598);
    TXCLog.setConsoleEnabled(paramBoolean);
    AppMethodBeat.o(65598);
  }
  
  public static void setLibraryPath(String paramString)
  {
    AppMethodBeat.i(65600);
    b.b(paramString);
    AppMethodBeat.o(65600);
  }
  
  public static void setListener(ITXLiveBaseListener paramITXLiveBaseListener)
  {
    AppMethodBeat.i(65596);
    TXCLog.setListener(new TXLiveBase.a(null));
    listener = paramITXLiveBaseListener;
    AppMethodBeat.o(65596);
  }
  
  public static void setLogLevel(int paramInt)
  {
    AppMethodBeat.i(65597);
    TXCLog.setLevel(paramInt);
    AppMethodBeat.o(65597);
  }
  
  public static void setPituLicencePath(String paramString)
  {
    AppMethodBeat.i(65603);
    TXCCommonUtil.setPituLicencePath(paramString);
    AppMethodBeat.o(65603);
  }
  
  public void setLicence(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65595);
    e.a().a(paramContext, paramString1, paramString2);
    AppMethodBeat.o(65595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.TXLiveBase
 * JD-Core Version:    0.7.0.1
 */