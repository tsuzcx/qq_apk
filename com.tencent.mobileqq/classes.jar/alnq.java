import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class alnq
{
  private static final String a = alkn.a + "/RDModules" + File.separator + "ConfigData_";
  
  public static int a(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return 0;
    }
    paramString = b(paramInt, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, 0);
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return a + paramInt + "_" + paramString;
    }
    return a + paramInt;
  }
  
  private static void a(int paramInt1, int paramInt2) {}
  
  private static void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    paramString = b(paramInt1, paramString);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt2);
    paramContext.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RDConfigServletProxy", 2, "onConfigFailed type: " + paramInt1 + " result:" + paramInt2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    if (paramQQAppInterface == null) {}
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          return;
          i = a(paramQQAppInterface.getApp(), paramInt, paramString);
        } while (paramConfig == null);
        j = paramConfig.version.get();
        k = paramConfig.type.get();
        if (paramInt != k)
        {
          QLog.e("RDConfigServletProxyRDConfigServletProxy", 2, String.format("onConfigReceived type error: serverType[%s], localType[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) }));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RDConfigServletProxyRDConfigServletProxy", 2, String.format("onConfigReceived: serverVersion[%s], localVersion[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        }
      } while (j == i);
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RDConfigServletProxy", 2, "config is null!");
    return;
    int i = 0;
    if (i < paramConfig.msg_content_list.size())
    {
      Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
      byte[] arrayOfByte;
      if (localObject1 != null)
      {
        k = ((ConfigurationService.Content)localObject1).task_id.get();
        if (((ConfigurationService.Content)localObject1).compress.get() != 1) {
          break label358;
        }
        arrayOfByte = ayma.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
        if (arrayOfByte != null) {
          break label283;
        }
        QLog.e("RDConfigServletProxy", 2, "config uncompress error, type:" + paramInt + "taskid:" + k);
        localObject1 = null;
      }
      for (;;)
      {
        b(paramQQAppInterface, paramInt, paramString, (String)localObject1);
        i += 1;
        break;
        try
        {
          label283:
          localObject1 = new String(arrayOfByte, "UTF-8");
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            localOutOfMemoryError.printStackTrace();
          }
          System.gc();
          try
          {
            String str1 = new String(arrayOfByte, "UTF-8");
          }
          catch (Throwable localThrowable)
          {
            str2 = null;
          }
        }
        continue;
        label358:
        String str2 = str2.content.get().toStringUtf8();
      }
    }
    if (a(paramInt, paramString, paramConfig))
    {
      a(paramQQAppInterface.getApp(), paramInt, paramString, j);
      a(paramInt, 0);
      return;
    }
    a(paramQQAppInterface.getApp(), paramInt, paramString, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.ConfigSeq paramConfigSeq, boolean paramBoolean, String paramString)
  {
    if ((paramConfigSeq == null) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = paramConfigSeq.type.get();
      if (!a(i, paramString)) {
        a(paramQQAppInterface.getApp(), i, paramString, 0);
      }
      j = a(paramQQAppInterface.getApp(), i, paramString);
      paramConfigSeq.version.set(j);
      if (paramBoolean) {
        paramConfigSeq.compress.set(1);
      }
      if (b(paramQQAppInterface.getApp(), i, paramString) < 0) {
        a(paramQQAppInterface.getApp(), i, paramString, new alnr(paramQQAppInterface, i, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("RDConfigServletProxy", 2, "setRequestConfig type:" + i + " version:" + j + " compress:" + paramBoolean + " uin:" + paramString);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    if (TextUtils.isEmpty(paramString)) {}
    while (!bgmg.a(paramString + File.separator + paramInt + ".cfg")) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static boolean a(int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_2
    //   16: ifnonnull +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: iload_0
    //   22: aload_1
    //   23: invokestatic 270	alnq:a	(ILjava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne -12 -> 19
    //   34: new 25	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 9
    //   44: aload 9
    //   46: invokevirtual 285	java/io/File:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 9
    //   54: invokevirtual 288	java/io/File:mkdirs	()Z
    //   57: pop
    //   58: new 10	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 28	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload_0
    //   76: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 272
    //   82: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 10
    //   90: new 10	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   97: aload 10
    //   99: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 290
    //   105: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 9
    //   113: aload 9
    //   115: invokestatic 292	bgmg:d	(Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_2
    //   120: invokevirtual 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:toByteArray	()[B
    //   123: astore 11
    //   125: aload 11
    //   127: ifnonnull +99 -> 226
    //   130: iconst_0
    //   131: ifeq +11 -> 142
    //   134: new 295	java/lang/NullPointerException
    //   137: dup
    //   138: invokespecial 296	java/lang/NullPointerException:<init>	()V
    //   141: athrow
    //   142: iconst_0
    //   143: ifeq +11 -> 154
    //   146: new 295	java/lang/NullPointerException
    //   149: dup
    //   150: invokespecial 296	java/lang/NullPointerException:<init>	()V
    //   153: athrow
    //   154: aload 10
    //   156: invokestatic 292	bgmg:d	(Ljava/lang/String;)Z
    //   159: pop
    //   160: aload 9
    //   162: aload 10
    //   164: invokestatic 300	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   167: pop
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -32 -> 142
    //   177: ldc 96
    //   179: iconst_2
    //   180: new 10	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 302
    //   190: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: goto -61 -> 142
    //   206: astore_1
    //   207: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -56 -> 154
    //   213: ldc 96
    //   215: iconst_2
    //   216: ldc_w 307
    //   219: aload_1
    //   220: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: goto -69 -> 154
    //   226: new 312	java/io/FileOutputStream
    //   229: dup
    //   230: aload 9
    //   232: invokespecial 313	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   235: astore_1
    //   236: aload 8
    //   238: astore_2
    //   239: aload_1
    //   240: astore 5
    //   242: aload 7
    //   244: astore 6
    //   246: aload_1
    //   247: invokevirtual 317	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   250: invokevirtual 323	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   253: astore 4
    //   255: aload 4
    //   257: ifnull +62 -> 319
    //   260: aload 4
    //   262: astore_2
    //   263: aload_1
    //   264: astore 5
    //   266: aload 4
    //   268: astore 6
    //   270: aload_1
    //   271: invokevirtual 317	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   274: lconst_0
    //   275: invokevirtual 327	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   278: pop
    //   279: aload 4
    //   281: astore_2
    //   282: aload_1
    //   283: astore 5
    //   285: aload 4
    //   287: astore 6
    //   289: aload_1
    //   290: aload 11
    //   292: arraylength
    //   293: invokestatic 332	aggi:a	(I)[B
    //   296: invokevirtual 336	java/io/FileOutputStream:write	([B)V
    //   299: aload 4
    //   301: astore_2
    //   302: aload_1
    //   303: astore 5
    //   305: aload 4
    //   307: astore 6
    //   309: aload_1
    //   310: aload 11
    //   312: iconst_0
    //   313: aload 11
    //   315: arraylength
    //   316: invokevirtual 339	java/io/FileOutputStream:write	([BII)V
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   337: aload 10
    //   339: invokestatic 292	bgmg:d	(Ljava/lang/String;)Z
    //   342: pop
    //   343: aload 9
    //   345: aload 10
    //   347: invokestatic 300	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   350: istore_3
    //   351: iload_3
    //   352: ireturn
    //   353: astore_2
    //   354: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -28 -> 329
    //   360: ldc 96
    //   362: iconst_2
    //   363: new 10	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 302
    //   373: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_2
    //   377: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: goto -57 -> 329
    //   389: astore_1
    //   390: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq -56 -> 337
    //   396: ldc 96
    //   398: iconst_2
    //   399: ldc_w 307
    //   402: aload_1
    //   403: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto -69 -> 337
    //   409: astore 4
    //   411: aconst_null
    //   412: astore_1
    //   413: aload 5
    //   415: astore_2
    //   416: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +30 -> 449
    //   422: ldc 96
    //   424: iconst_2
    //   425: new 10	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 349
    //   435: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 4
    //   440: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload_1
    //   450: ifnull +7 -> 457
    //   453: aload_1
    //   454: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   457: aload_2
    //   458: ifnull +7 -> 465
    //   461: aload_2
    //   462: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   465: aload 10
    //   467: invokestatic 292	bgmg:d	(Ljava/lang/String;)Z
    //   470: pop
    //   471: aload 9
    //   473: aload 10
    //   475: invokestatic 300	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   478: istore_3
    //   479: goto -128 -> 351
    //   482: astore_1
    //   483: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq -29 -> 457
    //   489: ldc 96
    //   491: iconst_2
    //   492: new 10	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 302
    //   502: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_1
    //   506: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: goto -58 -> 457
    //   518: astore_1
    //   519: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq -57 -> 465
    //   525: ldc 96
    //   527: iconst_2
    //   528: ldc_w 307
    //   531: aload_1
    //   532: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: goto -70 -> 465
    //   538: astore 4
    //   540: aconst_null
    //   541: astore_1
    //   542: aload 6
    //   544: astore_2
    //   545: aload_1
    //   546: astore 5
    //   548: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +36 -> 587
    //   554: aload 6
    //   556: astore_2
    //   557: aload_1
    //   558: astore 5
    //   560: ldc 96
    //   562: iconst_2
    //   563: new 10	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 351
    //   573: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 4
    //   578: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload 6
    //   589: ifnull +8 -> 597
    //   592: aload 6
    //   594: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   605: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +225 -> 833
    //   611: ldc 96
    //   613: iconst_2
    //   614: ldc_w 353
    //   617: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: iconst_0
    //   621: istore_3
    //   622: goto -271 -> 351
    //   625: astore_2
    //   626: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq -32 -> 597
    //   632: ldc 96
    //   634: iconst_2
    //   635: new 10	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 302
    //   645: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_2
    //   649: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: goto -61 -> 597
    //   661: astore_1
    //   662: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq -60 -> 605
    //   668: ldc 96
    //   670: iconst_2
    //   671: ldc_w 307
    //   674: aload_1
    //   675: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   678: goto -73 -> 605
    //   681: astore_1
    //   682: aconst_null
    //   683: astore 5
    //   685: aload 4
    //   687: astore_2
    //   688: aload_2
    //   689: ifnull +7 -> 696
    //   692: aload_2
    //   693: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   696: aload 5
    //   698: ifnull +8 -> 706
    //   701: aload 5
    //   703: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   706: aload 10
    //   708: invokestatic 292	bgmg:d	(Ljava/lang/String;)Z
    //   711: pop
    //   712: aload 9
    //   714: aload 10
    //   716: invokestatic 300	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   719: pop
    //   720: aload_1
    //   721: athrow
    //   722: astore_2
    //   723: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq -30 -> 696
    //   729: ldc 96
    //   731: iconst_2
    //   732: new 10	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 302
    //   742: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload_2
    //   746: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   749: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: goto -59 -> 696
    //   758: astore_2
    //   759: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   762: ifeq -56 -> 706
    //   765: ldc 96
    //   767: iconst_2
    //   768: ldc_w 307
    //   771: aload_2
    //   772: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   775: goto -69 -> 706
    //   778: astore_1
    //   779: goto -91 -> 688
    //   782: astore 4
    //   784: aload_2
    //   785: astore 5
    //   787: aload_1
    //   788: astore_2
    //   789: aload 4
    //   791: astore_1
    //   792: goto -104 -> 688
    //   795: astore 4
    //   797: goto -255 -> 542
    //   800: astore 4
    //   802: aconst_null
    //   803: astore 5
    //   805: aload_1
    //   806: astore_2
    //   807: aload 5
    //   809: astore_1
    //   810: goto -394 -> 416
    //   813: astore 6
    //   815: aload 4
    //   817: astore_2
    //   818: aload_1
    //   819: astore 5
    //   821: aload 6
    //   823: astore 4
    //   825: aload_2
    //   826: astore_1
    //   827: aload 5
    //   829: astore_2
    //   830: goto -414 -> 416
    //   833: iconst_0
    //   834: istore_3
    //   835: goto -484 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	paramInt	int
    //   0	838	1	paramString	String
    //   0	838	2	paramConfig	ConfigurationService.Config
    //   350	485	3	bool	boolean
    //   4	321	4	localFileLock	java.nio.channels.FileLock
    //   409	30	4	localOverlappingFileLockException1	java.nio.channels.OverlappingFileLockException
    //   538	148	4	localException1	Exception
    //   782	8	4	localObject1	Object
    //   795	1	4	localException2	Exception
    //   800	16	4	localOverlappingFileLockException2	java.nio.channels.OverlappingFileLockException
    //   823	1	4	localOverlappingFileLockException3	java.nio.channels.OverlappingFileLockException
    //   13	815	5	localObject2	Object
    //   1	592	6	localObject3	Object
    //   813	9	6	localOverlappingFileLockException4	java.nio.channels.OverlappingFileLockException
    //   10	233	7	localObject4	Object
    //   7	230	8	localObject5	Object
    //   42	671	9	localObject6	Object
    //   88	627	10	str	String
    //   123	191	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	142	170	java/lang/Exception
    //   146	154	206	java/lang/Exception
    //   324	329	353	java/lang/Exception
    //   333	337	389	java/lang/Exception
    //   119	125	409	java/nio/channels/OverlappingFileLockException
    //   226	236	409	java/nio/channels/OverlappingFileLockException
    //   453	457	482	java/lang/Exception
    //   461	465	518	java/lang/Exception
    //   119	125	538	java/lang/Exception
    //   226	236	538	java/lang/Exception
    //   592	597	625	java/lang/Exception
    //   601	605	661	java/lang/Exception
    //   119	125	681	finally
    //   226	236	681	finally
    //   692	696	722	java/lang/Exception
    //   701	706	758	java/lang/Exception
    //   246	255	778	finally
    //   270	279	778	finally
    //   289	299	778	finally
    //   309	319	778	finally
    //   548	554	778	finally
    //   560	587	778	finally
    //   416	449	782	finally
    //   246	255	795	java/lang/Exception
    //   270	279	795	java/lang/Exception
    //   289	299	795	java/lang/Exception
    //   309	319	795	java/lang/Exception
    //   246	255	800	java/nio/channels/OverlappingFileLockException
    //   270	279	813	java/nio/channels/OverlappingFileLockException
    //   289	299	813	java/nio/channels/OverlappingFileLockException
    //   309	319	813	java/nio/channels/OverlappingFileLockException
  }
  
  /* Error */
  public static boolean a(Context paramContext, int paramInt, String paramString, alns paramalns)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_3
    //   5: ifnonnull +9 -> 14
    //   8: iconst_0
    //   9: istore 7
    //   11: iload 7
    //   13: ireturn
    //   14: iload_1
    //   15: aload_2
    //   16: invokestatic 270	alnq:a	(ILjava/lang/String;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: new 10	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 28	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 272
    //   53: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 277	bgmg:a	(Ljava/lang/String;)Z
    //   64: ifne +5 -> 69
    //   67: iconst_0
    //   68: ireturn
    //   69: aconst_null
    //   70: astore_0
    //   71: aconst_null
    //   72: astore 9
    //   74: new 357	java/io/FileInputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 358	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 10
    //   84: aload 10
    //   86: invokevirtual 359	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: lconst_0
    //   90: ldc2_w 360
    //   93: iconst_1
    //   94: invokevirtual 364	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +1350 -> 1449
    //   102: new 366	java/io/BufferedInputStream
    //   105: dup
    //   106: aload 10
    //   108: invokespecial 369	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: astore_0
    //   112: iconst_4
    //   113: newarray byte
    //   115: astore 11
    //   117: aload_0
    //   118: aload 11
    //   120: invokevirtual 375	java/io/InputStream:read	([B)I
    //   123: iconst_4
    //   124: if_icmpne +1319 -> 1443
    //   127: aload 11
    //   129: iconst_0
    //   130: invokestatic 378	aggi:a	([BI)I
    //   133: istore 4
    //   135: iload 4
    //   137: iconst_4
    //   138: if_icmple +11 -> 149
    //   141: iload 4
    //   143: ldc_w 379
    //   146: if_icmplt +87 -> 233
    //   149: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +30 -> 182
    //   155: ldc 96
    //   157: iconst_2
    //   158: new 10	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 381
    //   168: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 4
    //   173: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iconst_0
    //   183: istore 7
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   193: aload 10
    //   195: ifnull +8 -> 203
    //   198: aload 10
    //   200: invokevirtual 382	java/io/FileInputStream:close	()V
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 383	java/io/InputStream:close	()V
    //   211: iload 7
    //   213: ifne +170 -> 383
    //   216: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +12 -> 231
    //   222: ldc 96
    //   224: iconst_2
    //   225: ldc_w 385
    //   228: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: iload 4
    //   235: newarray byte
    //   237: astore 11
    //   239: aload_0
    //   240: aload 11
    //   242: iconst_0
    //   243: iload 4
    //   245: invokevirtual 388	java/io/InputStream:read	([BII)I
    //   248: iload 4
    //   250: if_icmpeq +39 -> 289
    //   253: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +1199 -> 1455
    //   259: ldc 96
    //   261: iconst_2
    //   262: new 10	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 390
    //   272: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto +1169 -> 1455
    //   289: new 121	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   292: dup
    //   293: invokespecial 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:<init>	()V
    //   296: astore 9
    //   298: aload 9
    //   300: aload 11
    //   302: checkcast 393	[B
    //   305: invokevirtual 397	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   308: pop
    //   309: iconst_1
    //   310: istore 7
    //   312: goto -127 -> 185
    //   315: astore 11
    //   317: iconst_1
    //   318: istore 7
    //   320: goto -135 -> 185
    //   323: astore_2
    //   324: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -134 -> 193
    //   330: ldc 96
    //   332: iconst_2
    //   333: ldc_w 399
    //   336: aload_2
    //   337: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: goto -147 -> 193
    //   343: astore_2
    //   344: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -144 -> 203
    //   350: ldc 96
    //   352: iconst_2
    //   353: ldc_w 401
    //   356: aload_2
    //   357: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   360: goto -157 -> 203
    //   363: astore_0
    //   364: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq -156 -> 211
    //   370: ldc 96
    //   372: iconst_2
    //   373: ldc_w 403
    //   376: aload_0
    //   377: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: goto -169 -> 211
    //   383: aload 9
    //   385: ifnonnull +5 -> 390
    //   388: iconst_0
    //   389: ireturn
    //   390: iload_1
    //   391: aload 9
    //   393: getfield 134	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   396: invokevirtual 131	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   399: if_icmpeq +5 -> 404
    //   402: iconst_0
    //   403: ireturn
    //   404: aload 9
    //   406: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   409: ifnull +14 -> 423
    //   412: aload 9
    //   414: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   417: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   420: ifne +19 -> 439
    //   423: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +11 -> 437
    //   429: ldc 96
    //   431: iconst_2
    //   432: ldc 167
    //   434: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: iconst_0
    //   438: ireturn
    //   439: aload 9
    //   441: getfield 125	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   444: invokevirtual 131	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   447: istore 5
    //   449: iconst_0
    //   450: istore 4
    //   452: iload 7
    //   454: istore 8
    //   456: iload 8
    //   458: istore 7
    //   460: iload 4
    //   462: aload 9
    //   464: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   467: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   470: if_icmpge -459 -> 11
    //   473: aload 9
    //   475: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   478: iload 4
    //   480: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   483: checkcast 172	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   486: astore_0
    //   487: aload_0
    //   488: ifnull +112 -> 600
    //   491: aload_0
    //   492: getfield 176	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore 6
    //   500: aload_0
    //   501: getfield 182	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   504: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   507: iconst_1
    //   508: if_icmpne +165 -> 673
    //   511: aload_0
    //   512: getfield 186	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   515: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   518: invokevirtual 197	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   521: invokestatic 202	ayma:a	([B)[B
    //   524: astore_2
    //   525: aload_2
    //   526: ifnonnull +83 -> 609
    //   529: ldc 96
    //   531: iconst_2
    //   532: new 10	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   539: ldc 204
    //   541: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: iload_1
    //   545: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: ldc 206
    //   550: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 6
    //   555: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aconst_null
    //   565: astore_0
    //   566: aload_3
    //   567: iload 5
    //   569: iload 6
    //   571: aload_0
    //   572: iload 4
    //   574: iconst_1
    //   575: iadd
    //   576: aload 9
    //   578: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   581: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   584: invokeinterface 408 6 0
    //   589: istore 8
    //   591: iload 8
    //   593: istore 7
    //   595: iload 8
    //   597: ifeq -586 -> 11
    //   600: iload 4
    //   602: iconst_1
    //   603: iadd
    //   604: istore 4
    //   606: goto -150 -> 456
    //   609: new 63	java/lang/String
    //   612: dup
    //   613: aload_2
    //   614: ldc 211
    //   616: invokespecial 214	java/lang/String:<init>	([BLjava/lang/String;)V
    //   619: astore_0
    //   620: goto -54 -> 566
    //   623: astore_0
    //   624: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +7 -> 634
    //   630: aload_0
    //   631: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   634: aconst_null
    //   635: astore_0
    //   636: goto -70 -> 566
    //   639: astore_0
    //   640: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq +7 -> 650
    //   646: aload_0
    //   647: invokevirtual 218	java/lang/OutOfMemoryError:printStackTrace	()V
    //   650: invokestatic 223	java/lang/System:gc	()V
    //   653: new 63	java/lang/String
    //   656: dup
    //   657: aload_2
    //   658: ldc 211
    //   660: invokespecial 214	java/lang/String:<init>	([BLjava/lang/String;)V
    //   663: astore_0
    //   664: goto -98 -> 566
    //   667: astore_0
    //   668: aconst_null
    //   669: astore_0
    //   670: goto -104 -> 566
    //   673: aload_0
    //   674: getfield 186	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   677: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   680: invokevirtual 226	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   683: astore_0
    //   684: goto -118 -> 566
    //   687: astore 11
    //   689: aconst_null
    //   690: astore_0
    //   691: aconst_null
    //   692: astore 10
    //   694: aconst_null
    //   695: astore 9
    //   697: aconst_null
    //   698: astore_2
    //   699: aload 11
    //   701: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   704: ldc 96
    //   706: iconst_2
    //   707: new 10	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   714: ldc_w 410
    //   717: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload 11
    //   722: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   731: aload_0
    //   732: ifnull +7 -> 739
    //   735: aload_0
    //   736: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   739: aload 10
    //   741: ifnull +8 -> 749
    //   744: aload 10
    //   746: invokevirtual 382	java/io/FileInputStream:close	()V
    //   749: aload 9
    //   751: ifnull +8 -> 759
    //   754: aload 9
    //   756: invokevirtual 383	java/io/InputStream:close	()V
    //   759: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   762: ifeq +12 -> 774
    //   765: ldc 96
    //   767: iconst_2
    //   768: ldc_w 385
    //   771: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: iconst_0
    //   775: ireturn
    //   776: astore_0
    //   777: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq -41 -> 739
    //   783: ldc 96
    //   785: iconst_2
    //   786: ldc_w 399
    //   789: aload_0
    //   790: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   793: goto -54 -> 739
    //   796: astore_0
    //   797: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq -51 -> 749
    //   803: ldc 96
    //   805: iconst_2
    //   806: ldc_w 401
    //   809: aload_0
    //   810: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   813: goto -64 -> 749
    //   816: astore_0
    //   817: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq -61 -> 759
    //   823: ldc 96
    //   825: iconst_2
    //   826: ldc_w 403
    //   829: aload_0
    //   830: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   833: goto -74 -> 759
    //   836: astore_0
    //   837: aconst_null
    //   838: astore 11
    //   840: aconst_null
    //   841: astore 10
    //   843: aconst_null
    //   844: astore 9
    //   846: aconst_null
    //   847: astore_2
    //   848: iconst_1
    //   849: istore 4
    //   851: aload 11
    //   853: ifnull +8 -> 861
    //   856: aload 11
    //   858: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   861: aload 10
    //   863: ifnull +8 -> 871
    //   866: aload 10
    //   868: invokevirtual 382	java/io/FileInputStream:close	()V
    //   871: aload 9
    //   873: ifnull +8 -> 881
    //   876: aload 9
    //   878: invokevirtual 383	java/io/InputStream:close	()V
    //   881: iload 4
    //   883: ifne +86 -> 969
    //   886: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +12 -> 901
    //   892: ldc 96
    //   894: iconst_2
    //   895: ldc_w 385
    //   898: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   901: iconst_0
    //   902: ireturn
    //   903: astore 11
    //   905: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq -47 -> 861
    //   911: ldc 96
    //   913: iconst_2
    //   914: ldc_w 399
    //   917: aload 11
    //   919: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   922: goto -61 -> 861
    //   925: astore 10
    //   927: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq -59 -> 871
    //   933: ldc 96
    //   935: iconst_2
    //   936: ldc_w 401
    //   939: aload 10
    //   941: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   944: goto -73 -> 871
    //   947: astore 9
    //   949: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq -71 -> 881
    //   955: ldc 96
    //   957: iconst_2
    //   958: ldc_w 403
    //   961: aload 9
    //   963: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   966: goto -85 -> 881
    //   969: aload_2
    //   970: ifnonnull +5 -> 975
    //   973: iconst_0
    //   974: ireturn
    //   975: iload_1
    //   976: aload_2
    //   977: getfield 134	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   980: invokevirtual 131	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   983: if_icmpeq +5 -> 988
    //   986: iconst_0
    //   987: ireturn
    //   988: aload_2
    //   989: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   992: ifnull +13 -> 1005
    //   995: aload_2
    //   996: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   999: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1002: ifne +19 -> 1021
    //   1005: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1008: ifeq +11 -> 1019
    //   1011: ldc 96
    //   1013: iconst_2
    //   1014: ldc 167
    //   1016: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1019: iconst_0
    //   1020: ireturn
    //   1021: aload_2
    //   1022: getfield 125	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1025: invokevirtual 131	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1028: istore 5
    //   1030: iconst_0
    //   1031: istore 4
    //   1033: iload 4
    //   1035: aload_2
    //   1036: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1039: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1042: if_icmpge +129 -> 1171
    //   1045: aload_2
    //   1046: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1049: iload 4
    //   1051: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1054: checkcast 172	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   1057: astore 9
    //   1059: aload 9
    //   1061: ifnull +203 -> 1264
    //   1064: aload 9
    //   1066: getfield 176	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1069: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1072: istore 6
    //   1074: aload 9
    //   1076: getfield 182	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1079: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1082: iconst_1
    //   1083: if_icmpne +165 -> 1248
    //   1086: aload 9
    //   1088: getfield 186	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1091: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1094: invokevirtual 197	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1097: invokestatic 202	ayma:a	([B)[B
    //   1100: astore 10
    //   1102: aload 10
    //   1104: ifnonnull +69 -> 1173
    //   1107: ldc 96
    //   1109: iconst_2
    //   1110: new 10	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   1117: ldc 204
    //   1119: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: iload_1
    //   1123: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1126: ldc 206
    //   1128: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: iload 6
    //   1133: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1136: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1142: aconst_null
    //   1143: astore 9
    //   1145: aload_3
    //   1146: iload 5
    //   1148: iload 6
    //   1150: aload 9
    //   1152: iload 4
    //   1154: iconst_1
    //   1155: iadd
    //   1156: aload_2
    //   1157: getfield 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1160: invokevirtual 165	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1163: invokeinterface 408 6 0
    //   1168: ifne +96 -> 1264
    //   1171: aload_0
    //   1172: athrow
    //   1173: new 63	java/lang/String
    //   1176: dup
    //   1177: aload 10
    //   1179: ldc 211
    //   1181: invokespecial 214	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1184: astore 9
    //   1186: goto -41 -> 1145
    //   1189: astore 9
    //   1191: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +8 -> 1202
    //   1197: aload 9
    //   1199: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   1202: aconst_null
    //   1203: astore 9
    //   1205: goto -60 -> 1145
    //   1208: astore 9
    //   1210: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq +8 -> 1221
    //   1216: aload 9
    //   1218: invokevirtual 218	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1221: invokestatic 223	java/lang/System:gc	()V
    //   1224: new 63	java/lang/String
    //   1227: dup
    //   1228: aload 10
    //   1230: ldc 211
    //   1232: invokespecial 214	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1235: astore 9
    //   1237: goto -92 -> 1145
    //   1240: astore 9
    //   1242: aconst_null
    //   1243: astore 9
    //   1245: goto -100 -> 1145
    //   1248: aload 9
    //   1250: getfield 186	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1253: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1256: invokevirtual 226	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1259: astore 9
    //   1261: goto -116 -> 1145
    //   1264: iload 4
    //   1266: iconst_1
    //   1267: iadd
    //   1268: istore 4
    //   1270: goto -237 -> 1033
    //   1273: astore_0
    //   1274: aconst_null
    //   1275: astore 11
    //   1277: aconst_null
    //   1278: astore 9
    //   1280: aconst_null
    //   1281: astore_2
    //   1282: iconst_1
    //   1283: istore 4
    //   1285: goto -434 -> 851
    //   1288: astore_0
    //   1289: aconst_null
    //   1290: astore 12
    //   1292: aconst_null
    //   1293: astore 9
    //   1295: iconst_1
    //   1296: istore 4
    //   1298: aload_2
    //   1299: astore 11
    //   1301: aload 12
    //   1303: astore_2
    //   1304: goto -453 -> 851
    //   1307: astore 12
    //   1309: aconst_null
    //   1310: astore 13
    //   1312: iconst_1
    //   1313: istore 4
    //   1315: aload_0
    //   1316: astore 9
    //   1318: aload_2
    //   1319: astore 11
    //   1321: aload 12
    //   1323: astore_0
    //   1324: aload 13
    //   1326: astore_2
    //   1327: goto -476 -> 851
    //   1330: astore 12
    //   1332: aload 9
    //   1334: astore 13
    //   1336: iconst_1
    //   1337: istore 4
    //   1339: aload_0
    //   1340: astore 9
    //   1342: aload_2
    //   1343: astore 11
    //   1345: aload 12
    //   1347: astore_0
    //   1348: aload 13
    //   1350: astore_2
    //   1351: goto -500 -> 851
    //   1354: astore 12
    //   1356: iconst_1
    //   1357: istore 4
    //   1359: aload_0
    //   1360: astore 11
    //   1362: aload 12
    //   1364: astore_0
    //   1365: goto -514 -> 851
    //   1368: astore 12
    //   1370: iconst_0
    //   1371: istore 4
    //   1373: aload_0
    //   1374: astore 11
    //   1376: aload 12
    //   1378: astore_0
    //   1379: goto -528 -> 851
    //   1382: astore 11
    //   1384: aconst_null
    //   1385: astore_2
    //   1386: aconst_null
    //   1387: astore_0
    //   1388: aconst_null
    //   1389: astore 9
    //   1391: goto -692 -> 699
    //   1394: astore 11
    //   1396: aconst_null
    //   1397: astore 12
    //   1399: aload_2
    //   1400: astore_0
    //   1401: aconst_null
    //   1402: astore 9
    //   1404: aload 12
    //   1406: astore_2
    //   1407: goto -708 -> 699
    //   1410: astore 11
    //   1412: aconst_null
    //   1413: astore 12
    //   1415: aload_0
    //   1416: astore 9
    //   1418: aload_2
    //   1419: astore_0
    //   1420: aload 12
    //   1422: astore_2
    //   1423: goto -724 -> 699
    //   1426: astore 11
    //   1428: aload_0
    //   1429: astore 12
    //   1431: aload_2
    //   1432: astore_0
    //   1433: aload 9
    //   1435: astore_2
    //   1436: aload 12
    //   1438: astore 9
    //   1440: goto -741 -> 699
    //   1443: iconst_1
    //   1444: istore 7
    //   1446: goto -1261 -> 185
    //   1449: iconst_1
    //   1450: istore 7
    //   1452: goto -1267 -> 185
    //   1455: iconst_0
    //   1456: istore 7
    //   1458: goto -1273 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1461	0	paramContext	Context
    //   0	1461	1	paramInt	int
    //   0	1461	2	paramString	String
    //   0	1461	3	paramalns	alns
    //   133	1239	4	i	int
    //   447	700	5	j	int
    //   498	651	6	k	int
    //   9	1448	7	bool1	boolean
    //   454	142	8	bool2	boolean
    //   72	805	9	localConfig	ConfigurationService.Config
    //   947	15	9	localException1	Exception
    //   1057	128	9	localObject1	Object
    //   1189	9	9	localException2	Exception
    //   1203	1	9	localObject2	Object
    //   1208	9	9	localOutOfMemoryError	OutOfMemoryError
    //   1235	1	9	str	String
    //   1240	1	9	localThrowable	Throwable
    //   1243	196	9	localObject3	Object
    //   82	785	10	localFileInputStream	java.io.FileInputStream
    //   925	15	10	localException3	Exception
    //   1100	129	10	arrayOfByte1	byte[]
    //   115	186	11	arrayOfByte2	byte[]
    //   315	1	11	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   687	34	11	localException4	Exception
    //   838	19	11	localObject4	Object
    //   903	15	11	localException5	Exception
    //   1275	100	11	localObject5	Object
    //   1382	1	11	localException6	Exception
    //   1394	1	11	localException7	Exception
    //   1410	1	11	localException8	Exception
    //   1426	1	11	localException9	Exception
    //   1290	12	12	localObject6	Object
    //   1307	15	12	localObject7	Object
    //   1330	16	12	localObject8	Object
    //   1354	9	12	localObject9	Object
    //   1368	9	12	localObject10	Object
    //   1397	40	12	localContext	Context
    //   1310	39	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   298	309	315	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   189	193	323	java/lang/Exception
    //   198	203	343	java/lang/Exception
    //   207	211	363	java/lang/Exception
    //   609	620	623	java/lang/Exception
    //   609	620	639	java/lang/OutOfMemoryError
    //   653	664	667	java/lang/Throwable
    //   74	84	687	java/lang/Exception
    //   735	739	776	java/lang/Exception
    //   744	749	796	java/lang/Exception
    //   754	759	816	java/lang/Exception
    //   74	84	836	finally
    //   856	861	903	java/lang/Exception
    //   866	871	925	java/lang/Exception
    //   876	881	947	java/lang/Exception
    //   1173	1186	1189	java/lang/Exception
    //   1173	1186	1208	java/lang/OutOfMemoryError
    //   1224	1237	1240	java/lang/Throwable
    //   84	98	1273	finally
    //   102	112	1288	finally
    //   112	135	1307	finally
    //   149	182	1307	finally
    //   233	286	1307	finally
    //   289	298	1307	finally
    //   298	309	1330	finally
    //   699	704	1354	finally
    //   704	731	1368	finally
    //   84	98	1382	java/lang/Exception
    //   102	112	1394	java/lang/Exception
    //   112	135	1410	java/lang/Exception
    //   149	182	1410	java/lang/Exception
    //   233	286	1410	java/lang/Exception
    //   289	298	1410	java/lang/Exception
    //   298	309	1426	java/lang/Exception
  }
  
  public static int b(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return -1;
    }
    paramString = c(paramInt, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, -1);
  }
  
  private static String b(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return "rdconfigdataproxy_cp_" + paramInt + "_version_" + paramString;
    }
    return "rdconfigdataproxy_cp_" + paramInt + "_version";
  }
  
  private static void b(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    paramString = c(paramInt1, paramString);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt2);
    paramContext.commit();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.has("switch")) {
          break;
        }
        boolean bool = "on".equalsIgnoreCase(paramString2.getString("switch"));
        if (bool)
        {
          b(paramQQAppInterface.getApp(), paramInt, paramString1, 1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RDConfigServletProxy", 2, "parseSwitch, type:" + paramInt + " switch:" + bool + "  uin:" + paramString1);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.e("RDConfigServletProxy", 2, "parse switch exception " + paramQQAppInterface);
        return;
      }
      b(paramQQAppInterface.getApp(), paramInt, paramString1, 0);
    }
  }
  
  private static String c(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return "rdconfigdataproxy_cp_" + paramInt + "_switch_" + paramString;
    }
    return "rdconfigdataproxy_cp_" + paramInt + "_switch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnq
 * JD-Core Version:    0.7.0.1
 */