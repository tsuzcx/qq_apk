import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oicq.wlogin_sdk.tools.MD5;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class almz
{
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
    }
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
        Object localObject1 = new File(str1);
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          if (((Document)localObject3).getElementsByTagName("splash").getLength() < 1) {
            return false;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((File)localObject1).isDirectory())) {
            continue;
          }
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 == null) {
            continue;
          }
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject2 = localObject1[i];
          if ((localObject2 == null) || (!((File)localObject2).exists())) {
            break label1053;
          }
          ((File)localObject2).delete();
          break label1053;
        }
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paramString = ((Document)localObject3).getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
        String str3 = ((Document)localObject3).getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
        String str2 = ((Document)localObject3).getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
        localObject1 = ((Document)localObject3).getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
        int j = Integer.valueOf(((Document)localObject3).getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
        int k = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
        int m = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
        int n = Integer.valueOf(((Document)localObject3).getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
        Object localObject3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse(str2).getTime();
        int i1 = bdee.a(BaseApplication.getContext());
        i = 0;
        if (i1 == 2)
        {
          if (!QLog.isColorLevel()) {
            break label1060;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
          break label1060;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i);
          }
          if (i < j)
          {
            if (!QLog.isColorLevel()) {
              break label1065;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
            break label1065;
          }
        }
        else
        {
          if (i1 == 3)
          {
            if (!QLog.isColorLevel()) {
              break label1067;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
            break label1067;
          }
          if (i1 == 4)
          {
            if (!QLog.isColorLevel()) {
              break label1073;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
            break label1073;
          }
          if (i1 != 1) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label1079;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
          break label1079;
        }
        bdiv.a(BaseApplicationImpl.getContext(), paramInt, k, m, n, (String)localObject1, (String)localObject3, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() SUCCESS record to SP");
        }
        if (((SimpleDateFormat)localObject2).parse(str2).getTime() < System.currentTimeMillis())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the config is out of date, return");
          break;
        }
        localObject2 = new File(str1 + "/" + (String)localObject1 + ".zip");
        if (!a(paramQQAppInterface, paramString, (File)localObject2, (String)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label1087;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
          break label1087;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
        }
        paramQQAppInterface = str1 + "/" + (String)localObject1;
        paramString = new File(paramQQAppInterface);
        if (!bjps.b((File)localObject2, paramString))
        {
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
          if (!QLog.isColorLevel()) {
            break label1089;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
          break label1089;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
        }
        if (!a(paramQQAppInterface + "/md5.txt", paramQQAppInterface))
        {
          if (!QLog.isColorLevel()) {
            break label1091;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
          break label1091;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
        }
        if ((paramString != null) && (paramString.isDirectory()))
        {
          long l = paramString.lastModified();
          paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
          paramQQAppInterface.putLong("dynamic_splash_config_folder_modify_time", l);
          paramQQAppInterface.commit();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the folder path of splash is" + str1);
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() finish");
        }
        return true;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() ERROR = " + paramQQAppInterface.getMessage());
        }
        return false;
      }
      label1053:
      i += 1;
      continue;
      label1060:
      int i = 0;
      continue;
      label1065:
      return false;
      label1067:
      i = 10;
      continue;
      label1073:
      i = 20;
      continue;
      label1079:
      i = 100;
    }
    return true;
    label1087:
    return false;
    label1089:
    return false;
    label1091:
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = MD5.getFileMD5(paramFile);
      if ((str == null) || (!str.equalsIgnoreCase(paramString2))) {}
    }
    do
    {
      return true;
      paramFile.delete();
      boolean bool = HttpDownloadUtil.a(paramQQAppInterface, paramString1, paramFile);
      if ((paramFile == null) || (!paramFile.exists())) {
        break;
      }
      if (bool != true) {
        break label82;
      }
      paramQQAppInterface = MD5.getFileMD5(paramFile);
    } while ((paramQQAppInterface != null) && (paramQQAppInterface.equalsIgnoreCase(paramString2)));
    return false;
    label82:
    paramFile.delete();
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 7
    //   8: istore 8
    //   10: aload_0
    //   11: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: iload 7
    //   26: istore 8
    //   28: iload 8
    //   30: ireturn
    //   31: new 42	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 11
    //   41: new 42	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 12
    //   51: aload 12
    //   53: invokevirtual 61	java/io/File:exists	()Z
    //   56: ifeq +11 -> 67
    //   59: aload 12
    //   61: invokevirtual 110	java/io/File:isDirectory	()Z
    //   64: ifne +37 -> 101
    //   67: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +12 -> 82
    //   73: ldc 16
    //   75: iconst_2
    //   76: ldc_w 301
    //   79: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iload 7
    //   84: istore 8
    //   86: iconst_0
    //   87: ifeq -59 -> 28
    //   90: new 303	java/lang/NullPointerException
    //   93: dup
    //   94: invokespecial 304	java/lang/NullPointerException:<init>	()V
    //   97: athrow
    //   98: astore_0
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 12
    //   103: invokevirtual 114	java/io/File:listFiles	()[Ljava/io/File;
    //   106: astore 12
    //   108: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +85 -> 196
    //   114: aload 12
    //   116: arraylength
    //   117: istore_3
    //   118: iconst_0
    //   119: istore_2
    //   120: iload_2
    //   121: iload_3
    //   122: if_icmpge +46 -> 168
    //   125: aload 12
    //   127: iload_2
    //   128: aaload
    //   129: astore 13
    //   131: ldc 16
    //   133: iconst_2
    //   134: new 24	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 306
    //   144: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 13
    //   149: invokevirtual 309	java/io/File:getName	()Ljava/lang/String;
    //   152: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: iload_2
    //   162: iconst_1
    //   163: iadd
    //   164: istore_2
    //   165: goto -45 -> 120
    //   168: ldc 16
    //   170: iconst_2
    //   171: new 24	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 311
    //   181: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 12
    //   186: arraylength
    //   187: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 12
    //   198: arraylength
    //   199: ifgt +37 -> 236
    //   202: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 16
    //   210: iconst_2
    //   211: ldc_w 313
    //   214: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: iload 7
    //   219: istore 8
    //   221: iconst_0
    //   222: ifeq -194 -> 28
    //   225: new 303	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 304	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_0
    //   234: iconst_0
    //   235: ireturn
    //   236: aload 11
    //   238: invokevirtual 61	java/io/File:exists	()Z
    //   241: ifne +37 -> 278
    //   244: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +12 -> 259
    //   250: ldc 16
    //   252: iconst_2
    //   253: ldc_w 315
    //   256: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: iload 7
    //   261: istore 8
    //   263: iconst_0
    //   264: ifeq -236 -> 28
    //   267: new 303	java/lang/NullPointerException
    //   270: dup
    //   271: invokespecial 304	java/lang/NullPointerException:<init>	()V
    //   274: athrow
    //   275: astore_0
    //   276: iconst_0
    //   277: ireturn
    //   278: aload 12
    //   280: arraylength
    //   281: iconst_1
    //   282: isub
    //   283: istore 4
    //   285: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +30 -> 318
    //   291: ldc 16
    //   293: iconst_2
    //   294: new 24	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 317
    //   304: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: new 319	java/io/BufferedReader
    //   321: dup
    //   322: new 321	java/io/InputStreamReader
    //   325: dup
    //   326: new 323	java/io/FileInputStream
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 324	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   334: invokespecial 327	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   337: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   340: astore 12
    //   342: iconst_0
    //   343: istore_2
    //   344: aload 12
    //   346: astore_0
    //   347: aload 12
    //   349: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   352: astore 11
    //   354: aload 11
    //   356: ifnull +605 -> 961
    //   359: aload 12
    //   361: astore_0
    //   362: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +33 -> 398
    //   368: aload 12
    //   370: astore_0
    //   371: ldc 16
    //   373: iconst_2
    //   374: new 24	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 335
    //   384: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 11
    //   389: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 12
    //   400: astore_0
    //   401: aload 11
    //   403: invokevirtual 338	java/lang/String:length	()I
    //   406: istore_3
    //   407: iload_3
    //   408: iconst_5
    //   409: if_icmpge +62 -> 471
    //   412: iconst_1
    //   413: istore 7
    //   415: iload_2
    //   416: iload 4
    //   418: if_icmpeq +536 -> 954
    //   421: iload 10
    //   423: istore 9
    //   425: aload 12
    //   427: astore_0
    //   428: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +19 -> 450
    //   434: aload 12
    //   436: astore_0
    //   437: ldc 16
    //   439: iconst_2
    //   440: ldc_w 340
    //   443: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: iload 10
    //   448: istore 9
    //   450: iload 9
    //   452: istore 8
    //   454: aload 12
    //   456: ifnull -428 -> 28
    //   459: aload 12
    //   461: invokevirtual 343	java/io/BufferedReader:close	()V
    //   464: iload 9
    //   466: ireturn
    //   467: astore_0
    //   468: iload 9
    //   470: ireturn
    //   471: aload 12
    //   473: astore_0
    //   474: aload 11
    //   476: ldc_w 345
    //   479: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   482: astore 11
    //   484: aload 12
    //   486: astore_0
    //   487: aload 11
    //   489: arraylength
    //   490: iconst_2
    //   491: if_icmpeq +9 -> 500
    //   494: iconst_0
    //   495: istore 7
    //   497: goto -82 -> 415
    //   500: aload 12
    //   502: astore_0
    //   503: new 24	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   510: aload_1
    //   511: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc 211
    //   516: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 11
    //   521: iconst_0
    //   522: aaload
    //   523: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: astore 13
    //   531: aload 12
    //   533: astore_0
    //   534: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +33 -> 570
    //   540: aload 12
    //   542: astore_0
    //   543: ldc 16
    //   545: iconst_2
    //   546: new 24	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 351
    //   556: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload 13
    //   561: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 12
    //   572: astore_0
    //   573: new 42	java/io/File
    //   576: dup
    //   577: aload 13
    //   579: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   582: astore 13
    //   584: aload 12
    //   586: astore_0
    //   587: aload 13
    //   589: invokevirtual 61	java/io/File:exists	()Z
    //   592: ifne +27 -> 619
    //   595: aload 12
    //   597: astore_0
    //   598: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +366 -> 967
    //   604: aload 12
    //   606: astore_0
    //   607: ldc 16
    //   609: iconst_2
    //   610: ldc_w 353
    //   613: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: goto +351 -> 967
    //   619: aload 12
    //   621: astore_0
    //   622: aload 13
    //   624: invokestatic 284	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   627: astore 13
    //   629: aload 13
    //   631: ifnull +91 -> 722
    //   634: aload 12
    //   636: astore_0
    //   637: aload 13
    //   639: invokevirtual 338	java/lang/String:length	()I
    //   642: aload 11
    //   644: iconst_1
    //   645: aaload
    //   646: invokevirtual 338	java/lang/String:length	()I
    //   649: if_icmpeq +73 -> 722
    //   652: aload 12
    //   654: astore_0
    //   655: aload 13
    //   657: invokevirtual 338	java/lang/String:length	()I
    //   660: istore 5
    //   662: aload 12
    //   664: astore_0
    //   665: aload 11
    //   667: iconst_1
    //   668: aaload
    //   669: invokevirtual 338	java/lang/String:length	()I
    //   672: istore 6
    //   674: iconst_0
    //   675: istore_3
    //   676: iload_3
    //   677: iload 5
    //   679: iload 6
    //   681: isub
    //   682: if_icmpge +40 -> 722
    //   685: aload 12
    //   687: astore_0
    //   688: aload 11
    //   690: iconst_1
    //   691: new 24	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 355
    //   701: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 11
    //   706: iconst_1
    //   707: aaload
    //   708: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: aastore
    //   715: iload_3
    //   716: iconst_1
    //   717: iadd
    //   718: istore_3
    //   719: goto -43 -> 676
    //   722: aload 13
    //   724: ifnull +18 -> 742
    //   727: aload 12
    //   729: astore_0
    //   730: aload 13
    //   732: aload 11
    //   734: iconst_1
    //   735: aaload
    //   736: invokevirtual 288	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   739: ifne +64 -> 803
    //   742: aload 12
    //   744: astore_0
    //   745: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +225 -> 973
    //   751: aload 12
    //   753: astore_0
    //   754: ldc 16
    //   756: iconst_2
    //   757: new 24	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 357
    //   767: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload 13
    //   772: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc_w 359
    //   778: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload 11
    //   783: iconst_1
    //   784: aaload
    //   785: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 361
    //   791: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: goto +173 -> 973
    //   803: iload_2
    //   804: iconst_1
    //   805: iadd
    //   806: istore_2
    //   807: aload 12
    //   809: astore_0
    //   810: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq +32 -> 845
    //   816: aload 12
    //   818: astore_0
    //   819: ldc 16
    //   821: iconst_2
    //   822: new 24	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 363
    //   832: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: iload_2
    //   836: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: goto -501 -> 344
    //   848: astore 11
    //   850: aconst_null
    //   851: astore_1
    //   852: iconst_1
    //   853: istore 7
    //   855: aload_1
    //   856: astore_0
    //   857: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +35 -> 895
    //   863: aload_1
    //   864: astore_0
    //   865: ldc 16
    //   867: iconst_2
    //   868: new 24	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   875: ldc_w 365
    //   878: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload 11
    //   883: invokevirtual 274	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   886: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: iload 7
    //   897: istore 8
    //   899: aload_1
    //   900: ifnull -872 -> 28
    //   903: aload_1
    //   904: invokevirtual 343	java/io/BufferedReader:close	()V
    //   907: iload 7
    //   909: ireturn
    //   910: astore_0
    //   911: iload 7
    //   913: ireturn
    //   914: astore_1
    //   915: aconst_null
    //   916: astore_0
    //   917: aload_0
    //   918: ifnull +7 -> 925
    //   921: aload_0
    //   922: invokevirtual 343	java/io/BufferedReader:close	()V
    //   925: aload_1
    //   926: athrow
    //   927: astore_0
    //   928: goto -3 -> 925
    //   931: astore_1
    //   932: goto -15 -> 917
    //   935: astore 11
    //   937: iconst_1
    //   938: istore 7
    //   940: aload 12
    //   942: astore_1
    //   943: goto -88 -> 855
    //   946: astore 11
    //   948: aload 12
    //   950: astore_1
    //   951: goto -96 -> 855
    //   954: iload 7
    //   956: istore 9
    //   958: goto -508 -> 450
    //   961: iconst_1
    //   962: istore 7
    //   964: goto -549 -> 415
    //   967: iconst_0
    //   968: istore 7
    //   970: goto -555 -> 415
    //   973: iconst_0
    //   974: istore 7
    //   976: goto -561 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	paramString1	String
    //   0	979	1	paramString2	String
    //   119	717	2	i	int
    //   117	602	3	j	int
    //   283	136	4	k	int
    //   660	22	5	m	int
    //   672	10	6	n	int
    //   4	971	7	bool1	boolean
    //   8	890	8	bool2	boolean
    //   423	534	9	bool3	boolean
    //   1	446	10	bool4	boolean
    //   39	743	11	localObject1	Object
    //   848	34	11	localException1	Exception
    //   935	1	11	localException2	Exception
    //   946	1	11	localException3	Exception
    //   49	900	12	localObject2	Object
    //   129	642	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   90	98	98	java/lang/Exception
    //   225	233	233	java/lang/Exception
    //   267	275	275	java/lang/Exception
    //   459	464	467	java/lang/Exception
    //   31	67	848	java/lang/Exception
    //   67	82	848	java/lang/Exception
    //   101	118	848	java/lang/Exception
    //   131	161	848	java/lang/Exception
    //   168	196	848	java/lang/Exception
    //   196	217	848	java/lang/Exception
    //   236	259	848	java/lang/Exception
    //   278	318	848	java/lang/Exception
    //   318	342	848	java/lang/Exception
    //   903	907	910	java/lang/Exception
    //   31	67	914	finally
    //   67	82	914	finally
    //   101	118	914	finally
    //   131	161	914	finally
    //   168	196	914	finally
    //   196	217	914	finally
    //   236	259	914	finally
    //   278	318	914	finally
    //   318	342	914	finally
    //   921	925	927	java/lang/Exception
    //   347	354	931	finally
    //   362	368	931	finally
    //   371	398	931	finally
    //   401	407	931	finally
    //   428	434	931	finally
    //   437	446	931	finally
    //   474	484	931	finally
    //   487	494	931	finally
    //   503	531	931	finally
    //   534	540	931	finally
    //   543	570	931	finally
    //   573	584	931	finally
    //   587	595	931	finally
    //   598	604	931	finally
    //   607	616	931	finally
    //   622	629	931	finally
    //   637	652	931	finally
    //   655	662	931	finally
    //   665	674	931	finally
    //   688	715	931	finally
    //   730	742	931	finally
    //   745	751	931	finally
    //   754	800	931	finally
    //   810	816	931	finally
    //   819	845	931	finally
    //   857	863	931	finally
    //   865	895	931	finally
    //   347	354	935	java/lang/Exception
    //   362	368	935	java/lang/Exception
    //   371	398	935	java/lang/Exception
    //   401	407	935	java/lang/Exception
    //   474	484	935	java/lang/Exception
    //   487	494	935	java/lang/Exception
    //   503	531	935	java/lang/Exception
    //   534	540	935	java/lang/Exception
    //   543	570	935	java/lang/Exception
    //   573	584	935	java/lang/Exception
    //   587	595	935	java/lang/Exception
    //   598	604	935	java/lang/Exception
    //   607	616	935	java/lang/Exception
    //   622	629	935	java/lang/Exception
    //   637	652	935	java/lang/Exception
    //   655	662	935	java/lang/Exception
    //   665	674	935	java/lang/Exception
    //   688	715	935	java/lang/Exception
    //   730	742	935	java/lang/Exception
    //   745	751	935	java/lang/Exception
    //   754	800	935	java/lang/Exception
    //   810	816	935	java/lang/Exception
    //   819	845	935	java/lang/Exception
    //   428	434	946	java/lang/Exception
    //   437	446	946	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     almz
 * JD-Core Version:    0.7.0.1
 */