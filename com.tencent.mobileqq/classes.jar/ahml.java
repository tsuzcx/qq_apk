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

public class ahml
{
  private static final String a = ajed.aU + "RDModules" + File.separator + "ConfigData_";
  
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
        arrayOfByte = atiu.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
        a(paramQQAppInterface.getApp(), i, paramString, new ahmm(paramQQAppInterface, i, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("RDConfigServletProxy", 2, "setRequestConfig type:" + i + " version:" + j + " compress:" + paramBoolean + " uin:" + paramString);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    if (TextUtils.isEmpty(paramString)) {}
    while (!bace.a(paramString + File.separator + paramInt + ".cfg")) {
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
    //   23: invokestatic 272	ahml:a	(ILjava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne -12 -> 19
    //   34: new 26	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 284	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 9
    //   44: aload 9
    //   46: invokevirtual 287	java/io/File:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 9
    //   54: invokevirtual 290	java/io/File:mkdirs	()Z
    //   57: pop
    //   58: new 10	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 29	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload_0
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 274
    //   82: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 10
    //   90: new 10	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   97: aload 10
    //   99: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 292
    //   105: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 9
    //   113: aload 9
    //   115: invokestatic 294	bace:d	(Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_2
    //   120: invokevirtual 295	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:toByteArray	()[B
    //   123: astore 11
    //   125: aload 11
    //   127: ifnonnull +79 -> 206
    //   130: iconst_0
    //   131: ifeq +11 -> 142
    //   134: new 297	java/lang/NullPointerException
    //   137: dup
    //   138: invokespecial 298	java/lang/NullPointerException:<init>	()V
    //   141: athrow
    //   142: iconst_0
    //   143: ifeq +11 -> 154
    //   146: new 297	java/lang/NullPointerException
    //   149: dup
    //   150: invokespecial 298	java/lang/NullPointerException:<init>	()V
    //   153: athrow
    //   154: aload 10
    //   156: invokestatic 294	bace:d	(Ljava/lang/String;)Z
    //   159: pop
    //   160: aload 9
    //   162: aload 10
    //   164: invokestatic 302	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   167: pop
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -20 -> 154
    //   177: ldc 98
    //   179: iconst_2
    //   180: new 10	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 304
    //   190: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: goto -49 -> 154
    //   206: new 309	java/io/FileOutputStream
    //   209: dup
    //   210: aload 9
    //   212: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   215: astore_1
    //   216: aload 8
    //   218: astore_2
    //   219: aload_1
    //   220: astore 5
    //   222: aload 7
    //   224: astore 6
    //   226: aload_1
    //   227: invokevirtual 314	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   230: invokevirtual 320	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   233: astore 4
    //   235: aload 4
    //   237: ifnull +62 -> 299
    //   240: aload 4
    //   242: astore_2
    //   243: aload_1
    //   244: astore 5
    //   246: aload 4
    //   248: astore 6
    //   250: aload_1
    //   251: invokevirtual 314	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   254: lconst_0
    //   255: invokevirtual 324	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   258: pop
    //   259: aload 4
    //   261: astore_2
    //   262: aload_1
    //   263: astore 5
    //   265: aload 4
    //   267: astore 6
    //   269: aload_1
    //   270: aload 11
    //   272: arraylength
    //   273: invokestatic 329	acsp:a	(I)[B
    //   276: invokevirtual 333	java/io/FileOutputStream:write	([B)V
    //   279: aload 4
    //   281: astore_2
    //   282: aload_1
    //   283: astore 5
    //   285: aload 4
    //   287: astore 6
    //   289: aload_1
    //   290: aload 11
    //   292: iconst_0
    //   293: aload 11
    //   295: arraylength
    //   296: invokevirtual 336	java/io/FileOutputStream:write	([BII)V
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   309: aload_1
    //   310: ifnull +7 -> 317
    //   313: aload_1
    //   314: invokevirtual 344	java/io/FileOutputStream:close	()V
    //   317: aload 10
    //   319: invokestatic 294	bace:d	(Ljava/lang/String;)Z
    //   322: pop
    //   323: aload 9
    //   325: aload 10
    //   327: invokestatic 302	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   330: istore_3
    //   331: iload_3
    //   332: ireturn
    //   333: astore_1
    //   334: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq -20 -> 317
    //   340: ldc 98
    //   342: iconst_2
    //   343: new 10	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 304
    //   353: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: goto -49 -> 317
    //   369: astore 4
    //   371: aconst_null
    //   372: astore_1
    //   373: aload 5
    //   375: astore_2
    //   376: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +30 -> 409
    //   382: ldc 98
    //   384: iconst_2
    //   385: new 10	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 346
    //   395: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 4
    //   400: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 344	java/io/FileOutputStream:close	()V
    //   425: aload 10
    //   427: invokestatic 294	bace:d	(Ljava/lang/String;)Z
    //   430: pop
    //   431: aload 9
    //   433: aload 10
    //   435: invokestatic 302	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   438: istore_3
    //   439: goto -108 -> 331
    //   442: astore_1
    //   443: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq -21 -> 425
    //   449: ldc 98
    //   451: iconst_2
    //   452: new 10	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 304
    //   462: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: goto -50 -> 425
    //   478: astore 4
    //   480: aconst_null
    //   481: astore_1
    //   482: aload 6
    //   484: astore_2
    //   485: aload_1
    //   486: astore 5
    //   488: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +36 -> 527
    //   494: aload 6
    //   496: astore_2
    //   497: aload_1
    //   498: astore 5
    //   500: ldc 98
    //   502: iconst_2
    //   503: new 10	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 348
    //   513: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 4
    //   518: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: aload 6
    //   529: ifnull +8 -> 537
    //   532: aload 6
    //   534: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   537: aload_1
    //   538: ifnull +7 -> 545
    //   541: aload_1
    //   542: invokevirtual 344	java/io/FileOutputStream:close	()V
    //   545: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +183 -> 731
    //   551: ldc 98
    //   553: iconst_2
    //   554: ldc_w 350
    //   557: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: iconst_0
    //   561: istore_3
    //   562: goto -231 -> 331
    //   565: astore_1
    //   566: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq -24 -> 545
    //   572: ldc 98
    //   574: iconst_2
    //   575: new 10	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 304
    //   585: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -53 -> 545
    //   601: astore_1
    //   602: aconst_null
    //   603: astore 5
    //   605: aload 4
    //   607: astore_2
    //   608: aload_2
    //   609: ifnull +7 -> 616
    //   612: aload_2
    //   613: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   616: aload 5
    //   618: ifnull +8 -> 626
    //   621: aload 5
    //   623: invokevirtual 344	java/io/FileOutputStream:close	()V
    //   626: aload 10
    //   628: invokestatic 294	bace:d	(Ljava/lang/String;)Z
    //   631: pop
    //   632: aload 9
    //   634: aload 10
    //   636: invokestatic 302	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   639: pop
    //   640: aload_1
    //   641: athrow
    //   642: astore_2
    //   643: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq -20 -> 626
    //   649: ldc 98
    //   651: iconst_2
    //   652: new 10	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 304
    //   662: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: goto -49 -> 626
    //   678: astore_1
    //   679: goto -71 -> 608
    //   682: astore 4
    //   684: aload_2
    //   685: astore 5
    //   687: aload_1
    //   688: astore_2
    //   689: aload 4
    //   691: astore_1
    //   692: goto -84 -> 608
    //   695: astore 4
    //   697: goto -215 -> 482
    //   700: astore 4
    //   702: aconst_null
    //   703: astore 5
    //   705: aload_1
    //   706: astore_2
    //   707: aload 5
    //   709: astore_1
    //   710: goto -334 -> 376
    //   713: astore 6
    //   715: aload 4
    //   717: astore 5
    //   719: aload_1
    //   720: astore_2
    //   721: aload 6
    //   723: astore 4
    //   725: aload 5
    //   727: astore_1
    //   728: goto -352 -> 376
    //   731: iconst_0
    //   732: istore_3
    //   733: goto -402 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	paramInt	int
    //   0	736	1	paramString	String
    //   0	736	2	paramConfig	ConfigurationService.Config
    //   330	403	3	bool	boolean
    //   4	301	4	localFileLock	java.nio.channels.FileLock
    //   369	30	4	localOverlappingFileLockException1	java.nio.channels.OverlappingFileLockException
    //   478	128	4	localException1	Exception
    //   682	8	4	localObject1	Object
    //   695	1	4	localException2	Exception
    //   700	16	4	localOverlappingFileLockException2	java.nio.channels.OverlappingFileLockException
    //   723	1	4	localOverlappingFileLockException3	java.nio.channels.OverlappingFileLockException
    //   13	713	5	localObject2	Object
    //   1	532	6	localObject3	Object
    //   713	9	6	localOverlappingFileLockException4	java.nio.channels.OverlappingFileLockException
    //   10	213	7	localObject4	Object
    //   7	210	8	localObject5	Object
    //   42	591	9	localObject6	Object
    //   88	547	10	str	String
    //   123	171	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	142	170	java/lang/Exception
    //   146	154	170	java/lang/Exception
    //   304	309	333	java/lang/Exception
    //   313	317	333	java/lang/Exception
    //   119	125	369	java/nio/channels/OverlappingFileLockException
    //   206	216	369	java/nio/channels/OverlappingFileLockException
    //   413	417	442	java/lang/Exception
    //   421	425	442	java/lang/Exception
    //   119	125	478	java/lang/Exception
    //   206	216	478	java/lang/Exception
    //   532	537	565	java/lang/Exception
    //   541	545	565	java/lang/Exception
    //   119	125	601	finally
    //   206	216	601	finally
    //   612	616	642	java/lang/Exception
    //   621	626	642	java/lang/Exception
    //   226	235	678	finally
    //   250	259	678	finally
    //   269	279	678	finally
    //   289	299	678	finally
    //   488	494	678	finally
    //   500	527	678	finally
    //   376	409	682	finally
    //   226	235	695	java/lang/Exception
    //   250	259	695	java/lang/Exception
    //   269	279	695	java/lang/Exception
    //   289	299	695	java/lang/Exception
    //   226	235	700	java/nio/channels/OverlappingFileLockException
    //   250	259	713	java/nio/channels/OverlappingFileLockException
    //   269	279	713	java/nio/channels/OverlappingFileLockException
    //   289	299	713	java/nio/channels/OverlappingFileLockException
  }
  
  /* Error */
  public static boolean a(Context paramContext, int paramInt, String paramString, ahmn paramahmn)
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
    //   16: invokestatic 272	ahml:a	(ILjava/lang/String;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: new 10	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 29	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 274
    //   53: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 279	bace:a	(Ljava/lang/String;)Z
    //   64: ifne +5 -> 69
    //   67: iconst_0
    //   68: ireturn
    //   69: aconst_null
    //   70: astore_0
    //   71: aconst_null
    //   72: astore 9
    //   74: new 354	java/io/FileInputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 10
    //   84: aload 10
    //   86: invokevirtual 356	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: lconst_0
    //   90: ldc2_w 357
    //   93: iconst_1
    //   94: invokevirtual 361	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +1269 -> 1368
    //   102: new 363	java/io/BufferedInputStream
    //   105: dup
    //   106: aload 10
    //   108: invokespecial 366	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: astore_0
    //   112: iconst_4
    //   113: newarray byte
    //   115: astore 11
    //   117: aload_0
    //   118: aload 11
    //   120: invokevirtual 372	java/io/InputStream:read	([B)I
    //   123: iconst_4
    //   124: if_icmpne +1238 -> 1362
    //   127: aload 11
    //   129: iconst_0
    //   130: invokestatic 375	acsp:a	([BI)I
    //   133: istore 4
    //   135: iload 4
    //   137: iconst_4
    //   138: if_icmple +11 -> 149
    //   141: iload 4
    //   143: ldc_w 376
    //   146: if_icmplt +87 -> 233
    //   149: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +30 -> 182
    //   155: ldc 98
    //   157: iconst_2
    //   158: new 10	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 378
    //   168: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 4
    //   173: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iconst_0
    //   183: istore 7
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   193: aload 10
    //   195: ifnull +8 -> 203
    //   198: aload 10
    //   200: invokevirtual 379	java/io/FileInputStream:close	()V
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 380	java/io/InputStream:close	()V
    //   211: iload 7
    //   213: ifne +144 -> 357
    //   216: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +12 -> 231
    //   222: ldc 98
    //   224: iconst_2
    //   225: ldc_w 382
    //   228: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: iload 4
    //   235: newarray byte
    //   237: astore 11
    //   239: aload_0
    //   240: aload 11
    //   242: iconst_0
    //   243: iload 4
    //   245: invokevirtual 385	java/io/InputStream:read	([BII)I
    //   248: iload 4
    //   250: if_icmpeq +39 -> 289
    //   253: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +1118 -> 1374
    //   259: ldc 98
    //   261: iconst_2
    //   262: new 10	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 387
    //   272: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto +1088 -> 1374
    //   289: new 123	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   292: dup
    //   293: invokespecial 388	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:<init>	()V
    //   296: astore 9
    //   298: aload 9
    //   300: aload 11
    //   302: checkcast 390	[B
    //   305: invokevirtual 394	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   308: pop
    //   309: iconst_1
    //   310: istore 7
    //   312: goto -127 -> 185
    //   315: astore 11
    //   317: iconst_1
    //   318: istore 7
    //   320: goto -135 -> 185
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   328: ldc 98
    //   330: iconst_2
    //   331: new 10	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 396
    //   341: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto -143 -> 211
    //   357: aload 9
    //   359: ifnonnull +5 -> 364
    //   362: iconst_0
    //   363: ireturn
    //   364: iload_1
    //   365: aload 9
    //   367: getfield 136	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   370: invokevirtual 133	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   373: if_icmpeq +5 -> 378
    //   376: iconst_0
    //   377: ireturn
    //   378: aload 9
    //   380: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   383: ifnull +14 -> 397
    //   386: aload 9
    //   388: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   394: ifne +19 -> 413
    //   397: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +11 -> 411
    //   403: ldc 98
    //   405: iconst_2
    //   406: ldc 169
    //   408: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: iconst_0
    //   412: ireturn
    //   413: aload 9
    //   415: getfield 127	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   418: invokevirtual 133	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   421: istore 5
    //   423: iconst_0
    //   424: istore 4
    //   426: iload 7
    //   428: istore 8
    //   430: iload 8
    //   432: istore 7
    //   434: iload 4
    //   436: aload 9
    //   438: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   441: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   444: if_icmpge -433 -> 11
    //   447: aload 9
    //   449: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   452: iload 4
    //   454: invokevirtual 172	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: checkcast 174	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   460: astore_0
    //   461: aload_0
    //   462: ifnull +112 -> 574
    //   465: aload_0
    //   466: getfield 178	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   469: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   472: istore 6
    //   474: aload_0
    //   475: getfield 184	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   478: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   481: iconst_1
    //   482: if_icmpne +165 -> 647
    //   485: aload_0
    //   486: getfield 188	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   489: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   492: invokevirtual 199	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   495: invokestatic 204	atiu:a	([B)[B
    //   498: astore_2
    //   499: aload_2
    //   500: ifnonnull +83 -> 583
    //   503: ldc 98
    //   505: iconst_2
    //   506: new 10	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   513: ldc 206
    //   515: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: iload_1
    //   519: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: ldc 208
    //   524: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: iload 6
    //   529: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   532: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: aconst_null
    //   539: astore_0
    //   540: aload_3
    //   541: iload 5
    //   543: iload 6
    //   545: aload_0
    //   546: iload 4
    //   548: iconst_1
    //   549: iadd
    //   550: aload 9
    //   552: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   555: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   558: invokeinterface 401 6 0
    //   563: istore 8
    //   565: iload 8
    //   567: istore 7
    //   569: iload 8
    //   571: ifeq -560 -> 11
    //   574: iload 4
    //   576: iconst_1
    //   577: iadd
    //   578: istore 4
    //   580: goto -150 -> 430
    //   583: new 65	java/lang/String
    //   586: dup
    //   587: aload_2
    //   588: ldc 213
    //   590: invokespecial 216	java/lang/String:<init>	([BLjava/lang/String;)V
    //   593: astore_0
    //   594: goto -54 -> 540
    //   597: astore_0
    //   598: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +7 -> 608
    //   604: aload_0
    //   605: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   608: aconst_null
    //   609: astore_0
    //   610: goto -70 -> 540
    //   613: astore_0
    //   614: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +7 -> 624
    //   620: aload_0
    //   621: invokevirtual 220	java/lang/OutOfMemoryError:printStackTrace	()V
    //   624: invokestatic 225	java/lang/System:gc	()V
    //   627: new 65	java/lang/String
    //   630: dup
    //   631: aload_2
    //   632: ldc 213
    //   634: invokespecial 216	java/lang/String:<init>	([BLjava/lang/String;)V
    //   637: astore_0
    //   638: goto -98 -> 540
    //   641: astore_0
    //   642: aconst_null
    //   643: astore_0
    //   644: goto -104 -> 540
    //   647: aload_0
    //   648: getfield 188	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   651: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   654: invokevirtual 228	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   657: astore_0
    //   658: goto -118 -> 540
    //   661: astore 11
    //   663: aconst_null
    //   664: astore_0
    //   665: aconst_null
    //   666: astore 10
    //   668: aconst_null
    //   669: astore 9
    //   671: aconst_null
    //   672: astore_2
    //   673: aload 11
    //   675: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   678: ldc 98
    //   680: iconst_2
    //   681: new 10	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   688: ldc_w 403
    //   691: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 11
    //   696: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: aload_0
    //   706: ifnull +7 -> 713
    //   709: aload_0
    //   710: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   713: aload 10
    //   715: ifnull +8 -> 723
    //   718: aload 10
    //   720: invokevirtual 379	java/io/FileInputStream:close	()V
    //   723: aload 9
    //   725: ifnull +8 -> 733
    //   728: aload 9
    //   730: invokevirtual 380	java/io/InputStream:close	()V
    //   733: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq +12 -> 748
    //   739: ldc 98
    //   741: iconst_2
    //   742: ldc_w 382
    //   745: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: iconst_0
    //   749: ireturn
    //   750: astore_0
    //   751: aload_0
    //   752: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   755: ldc 98
    //   757: iconst_2
    //   758: new 10	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 396
    //   768: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: goto -48 -> 733
    //   784: astore_0
    //   785: aconst_null
    //   786: astore 11
    //   788: aconst_null
    //   789: astore 10
    //   791: aconst_null
    //   792: astore 9
    //   794: aconst_null
    //   795: astore_2
    //   796: iconst_1
    //   797: istore 4
    //   799: aload 11
    //   801: ifnull +8 -> 809
    //   804: aload 11
    //   806: invokevirtual 341	java/nio/channels/FileLock:release	()V
    //   809: aload 10
    //   811: ifnull +8 -> 819
    //   814: aload 10
    //   816: invokevirtual 379	java/io/FileInputStream:close	()V
    //   819: aload 9
    //   821: ifnull +8 -> 829
    //   824: aload 9
    //   826: invokevirtual 380	java/io/InputStream:close	()V
    //   829: iload 4
    //   831: ifne +57 -> 888
    //   834: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +12 -> 849
    //   840: ldc 98
    //   842: iconst_2
    //   843: ldc_w 382
    //   846: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: iconst_0
    //   850: ireturn
    //   851: astore 9
    //   853: aload 9
    //   855: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   858: ldc 98
    //   860: iconst_2
    //   861: new 10	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 396
    //   871: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload 9
    //   876: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: goto -56 -> 829
    //   888: aload_2
    //   889: ifnonnull +5 -> 894
    //   892: iconst_0
    //   893: ireturn
    //   894: iload_1
    //   895: aload_2
    //   896: getfield 136	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   899: invokevirtual 133	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   902: if_icmpeq +5 -> 907
    //   905: iconst_0
    //   906: ireturn
    //   907: aload_2
    //   908: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   911: ifnull +13 -> 924
    //   914: aload_2
    //   915: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   918: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   921: ifne +19 -> 940
    //   924: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +11 -> 938
    //   930: ldc 98
    //   932: iconst_2
    //   933: ldc 169
    //   935: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   938: iconst_0
    //   939: ireturn
    //   940: aload_2
    //   941: getfield 127	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   944: invokevirtual 133	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   947: istore 5
    //   949: iconst_0
    //   950: istore 4
    //   952: iload 4
    //   954: aload_2
    //   955: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   958: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   961: if_icmpge +129 -> 1090
    //   964: aload_2
    //   965: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   968: iload 4
    //   970: invokevirtual 172	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   973: checkcast 174	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   976: astore 9
    //   978: aload 9
    //   980: ifnull +203 -> 1183
    //   983: aload 9
    //   985: getfield 178	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   988: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   991: istore 6
    //   993: aload 9
    //   995: getfield 184	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   998: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1001: iconst_1
    //   1002: if_icmpne +165 -> 1167
    //   1005: aload 9
    //   1007: getfield 188	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1010: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1013: invokevirtual 199	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1016: invokestatic 204	atiu:a	([B)[B
    //   1019: astore 10
    //   1021: aload 10
    //   1023: ifnonnull +69 -> 1092
    //   1026: ldc 98
    //   1028: iconst_2
    //   1029: new 10	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   1036: ldc 206
    //   1038: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: iload_1
    //   1042: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1045: ldc 208
    //   1047: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: iload 6
    //   1052: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1061: aconst_null
    //   1062: astore 9
    //   1064: aload_3
    //   1065: iload 5
    //   1067: iload 6
    //   1069: aload 9
    //   1071: iload 4
    //   1073: iconst_1
    //   1074: iadd
    //   1075: aload_2
    //   1076: getfield 162	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1079: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1082: invokeinterface 401 6 0
    //   1087: ifne +96 -> 1183
    //   1090: aload_0
    //   1091: athrow
    //   1092: new 65	java/lang/String
    //   1095: dup
    //   1096: aload 10
    //   1098: ldc 213
    //   1100: invokespecial 216	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1103: astore 9
    //   1105: goto -41 -> 1064
    //   1108: astore 9
    //   1110: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1113: ifeq +8 -> 1121
    //   1116: aload 9
    //   1118: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   1121: aconst_null
    //   1122: astore 9
    //   1124: goto -60 -> 1064
    //   1127: astore 9
    //   1129: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1132: ifeq +8 -> 1140
    //   1135: aload 9
    //   1137: invokevirtual 220	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1140: invokestatic 225	java/lang/System:gc	()V
    //   1143: new 65	java/lang/String
    //   1146: dup
    //   1147: aload 10
    //   1149: ldc 213
    //   1151: invokespecial 216	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1154: astore 9
    //   1156: goto -92 -> 1064
    //   1159: astore 9
    //   1161: aconst_null
    //   1162: astore 9
    //   1164: goto -100 -> 1064
    //   1167: aload 9
    //   1169: getfield 188	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1172: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1175: invokevirtual 228	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1178: astore 9
    //   1180: goto -116 -> 1064
    //   1183: iload 4
    //   1185: iconst_1
    //   1186: iadd
    //   1187: istore 4
    //   1189: goto -237 -> 952
    //   1192: astore_0
    //   1193: aconst_null
    //   1194: astore 11
    //   1196: aconst_null
    //   1197: astore 9
    //   1199: aconst_null
    //   1200: astore_2
    //   1201: iconst_1
    //   1202: istore 4
    //   1204: goto -405 -> 799
    //   1207: astore_0
    //   1208: aconst_null
    //   1209: astore 12
    //   1211: aconst_null
    //   1212: astore 9
    //   1214: iconst_1
    //   1215: istore 4
    //   1217: aload_2
    //   1218: astore 11
    //   1220: aload 12
    //   1222: astore_2
    //   1223: goto -424 -> 799
    //   1226: astore 12
    //   1228: aconst_null
    //   1229: astore 13
    //   1231: iconst_1
    //   1232: istore 4
    //   1234: aload_0
    //   1235: astore 9
    //   1237: aload_2
    //   1238: astore 11
    //   1240: aload 12
    //   1242: astore_0
    //   1243: aload 13
    //   1245: astore_2
    //   1246: goto -447 -> 799
    //   1249: astore 12
    //   1251: aload 9
    //   1253: astore 13
    //   1255: iconst_1
    //   1256: istore 4
    //   1258: aload_0
    //   1259: astore 9
    //   1261: aload_2
    //   1262: astore 11
    //   1264: aload 12
    //   1266: astore_0
    //   1267: aload 13
    //   1269: astore_2
    //   1270: goto -471 -> 799
    //   1273: astore 12
    //   1275: iconst_1
    //   1276: istore 4
    //   1278: aload_0
    //   1279: astore 11
    //   1281: aload 12
    //   1283: astore_0
    //   1284: goto -485 -> 799
    //   1287: astore 12
    //   1289: iconst_0
    //   1290: istore 4
    //   1292: aload_0
    //   1293: astore 11
    //   1295: aload 12
    //   1297: astore_0
    //   1298: goto -499 -> 799
    //   1301: astore 11
    //   1303: aconst_null
    //   1304: astore_2
    //   1305: aconst_null
    //   1306: astore_0
    //   1307: aconst_null
    //   1308: astore 9
    //   1310: goto -637 -> 673
    //   1313: astore 11
    //   1315: aconst_null
    //   1316: astore 12
    //   1318: aload_2
    //   1319: astore_0
    //   1320: aconst_null
    //   1321: astore 9
    //   1323: aload 12
    //   1325: astore_2
    //   1326: goto -653 -> 673
    //   1329: astore 11
    //   1331: aconst_null
    //   1332: astore 12
    //   1334: aload_0
    //   1335: astore 9
    //   1337: aload_2
    //   1338: astore_0
    //   1339: aload 12
    //   1341: astore_2
    //   1342: goto -669 -> 673
    //   1345: astore 11
    //   1347: aload_0
    //   1348: astore 12
    //   1350: aload_2
    //   1351: astore_0
    //   1352: aload 9
    //   1354: astore_2
    //   1355: aload 12
    //   1357: astore 9
    //   1359: goto -686 -> 673
    //   1362: iconst_1
    //   1363: istore 7
    //   1365: goto -1180 -> 185
    //   1368: iconst_1
    //   1369: istore 7
    //   1371: goto -1186 -> 185
    //   1374: iconst_0
    //   1375: istore 7
    //   1377: goto -1192 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1380	0	paramContext	Context
    //   0	1380	1	paramInt	int
    //   0	1380	2	paramString	String
    //   0	1380	3	paramahmn	ahmn
    //   133	1158	4	i	int
    //   421	645	5	j	int
    //   472	596	6	k	int
    //   9	1367	7	bool1	boolean
    //   428	142	8	bool2	boolean
    //   72	753	9	localConfig	ConfigurationService.Config
    //   851	24	9	localException1	Exception
    //   976	128	9	localObject1	Object
    //   1108	9	9	localException2	Exception
    //   1122	1	9	localObject2	Object
    //   1127	9	9	localOutOfMemoryError	OutOfMemoryError
    //   1154	1	9	str	String
    //   1159	1	9	localThrowable	Throwable
    //   1162	196	9	localObject3	Object
    //   82	1066	10	localObject4	Object
    //   115	186	11	arrayOfByte	byte[]
    //   315	1	11	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   661	34	11	localException3	Exception
    //   786	508	11	localObject5	Object
    //   1301	1	11	localException4	Exception
    //   1313	1	11	localException5	Exception
    //   1329	1	11	localException6	Exception
    //   1345	1	11	localException7	Exception
    //   1209	12	12	localObject6	Object
    //   1226	15	12	localObject7	Object
    //   1249	16	12	localObject8	Object
    //   1273	9	12	localObject9	Object
    //   1287	9	12	localObject10	Object
    //   1316	40	12	localContext	Context
    //   1229	39	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   298	309	315	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   189	193	323	java/lang/Exception
    //   198	203	323	java/lang/Exception
    //   207	211	323	java/lang/Exception
    //   583	594	597	java/lang/Exception
    //   583	594	613	java/lang/OutOfMemoryError
    //   627	638	641	java/lang/Throwable
    //   74	84	661	java/lang/Exception
    //   709	713	750	java/lang/Exception
    //   718	723	750	java/lang/Exception
    //   728	733	750	java/lang/Exception
    //   74	84	784	finally
    //   804	809	851	java/lang/Exception
    //   814	819	851	java/lang/Exception
    //   824	829	851	java/lang/Exception
    //   1092	1105	1108	java/lang/Exception
    //   1092	1105	1127	java/lang/OutOfMemoryError
    //   1143	1156	1159	java/lang/Throwable
    //   84	98	1192	finally
    //   102	112	1207	finally
    //   112	135	1226	finally
    //   149	182	1226	finally
    //   233	286	1226	finally
    //   289	298	1226	finally
    //   298	309	1249	finally
    //   673	678	1273	finally
    //   678	705	1287	finally
    //   84	98	1301	java/lang/Exception
    //   102	112	1313	java/lang/Exception
    //   112	135	1329	java/lang/Exception
    //   149	182	1329	java/lang/Exception
    //   233	286	1329	java/lang/Exception
    //   289	298	1329	java/lang/Exception
    //   298	309	1345	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahml
 * JD-Core Version:    0.7.0.1
 */