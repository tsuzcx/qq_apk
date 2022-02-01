import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class abff
{
  private static final Set<String> a = new HashSet();
  private static final Set<String> b;
  
  static
  {
    a.add("miniappshowreddot".toLowerCase());
    a.add("miniappshowmessagereddot".toLowerCase());
    a.add("miniappfullscreenshownotificationbtn".toLowerCase());
    a.add("miniappfullscreenshownotificationreddot".toLowerCase());
    a.add("miniapptriggerfullscreenheight".toLowerCase());
    a.add("miniappgetpskeydomain".toLowerCase());
    a.add("miniappsustempermissionconfig".toLowerCase());
    a.add("MiniAppMsfTimeoutValue".toLowerCase());
    a.add("miniappsendrequestbyhttps".toLowerCase());
    a.add("newsdkenable".toLowerCase());
    a.add("MiniAppEcShopNumMsgEnable".toLowerCase());
    a.add("newappsdkenable".toLowerCase());
    a.add("mini_sdk_prelaunch_enable".toLowerCase());
    a.add("sdk_dex_config".toLowerCase());
    a.add("mini_sdk_prelaunch_all_enable".toLowerCase());
    b = new HashSet();
    b.add("qqcircle_enable_eevee_polling");
    b.add("qqcircle_use_eevee_red_point");
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 85	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 97 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 99
    //   34: invokeinterface 103 2 0
    //   39: invokeinterface 107 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 110 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 110 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 117
    //   80: iconst_2
    //   81: new 119	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   88: ldc 122
    //   90: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull -41 -> 67
    //   111: aload_2
    //   112: invokeinterface 110 1 0
    //   117: goto -50 -> 67
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 110 1 0
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -13 -> 123
    //   139: astore_3
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: goto -72 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	12	0	l	long
    //   16	112	2	localCursor	android.database.Cursor
    //   69	35	3	localException1	Exception
    //   120	14	3	localObject1	Object
    //   135	1	3	localObject2	Object
    //   139	1	3	localObject3	Object
    //   143	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	120	finally
    //   21	45	135	finally
    //   72	107	139	finally
    //   21	45	143	java/lang/Exception
  }
  
  public static ContentValues a(String paramString, entrance_cfg paramentrance_cfg)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while ((paramentrance_cfg == null) || (paramentrance_cfg.iEntranceId < 0) || (paramentrance_cfg.iEntranceId > 999));
      paramString = paramString.replace(" ", "");
      QZLog.e("QZConfigProviderUtil", 2, new Object[] { "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(paramentrance_cfg.iEntranceId), " item name: ", paramentrance_cfg.sEntranceName, " item icon: ", paramentrance_cfg.sEntranceIcon, " item action: ", paramentrance_cfg.sEntranceAction, " item qbossicon: ", paramentrance_cfg.sQbossEntranceIcon });
    } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uin", paramString + "&" + paramentrance_cfg.iEntranceId);
    localContentValues.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
    localContentValues.put("entracename", paramentrance_cfg.sEntranceName);
    localContentValues.put("entraceicon", paramentrance_cfg.sEntranceIcon);
    localContentValues.put("entraceaction", paramentrance_cfg.sEntranceAction);
    localContentValues.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
    localContentValues.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
    localContentValues.put("qbossentraceicon", paramentrance_cfg.sQbossEntranceIcon);
    localContentValues.put("qbosstraceinfo", paramentrance_cfg.sQbossTraceInfo);
    return localContentValues;
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 247	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +56 -> 74
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 97 1 0
    //   29: ifeq +45 -> 74
    //   32: aload_1
    //   33: astore_0
    //   34: new 21	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 249
    //   42: invokeinterface 103 2 0
    //   47: invokeinterface 253 2 0
    //   52: invokevirtual 257	java/lang/String:getBytes	()[B
    //   55: ldc_w 259
    //   58: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   61: astore_2
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 110 1 0
    //   72: aload_2
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 110 1 0
    //   84: ldc 153
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +35 -> 130
    //   98: aload_1
    //   99: astore_0
    //   100: ldc 117
    //   102: iconst_2
    //   103: new 119	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 264
    //   113: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_2
    //   117: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aload_2
    //   127: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: ifnull -47 -> 84
    //   134: aload_1
    //   135: invokeinterface 110 1 0
    //   140: goto -56 -> 84
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +9 -> 156
    //   150: aload_0
    //   151: invokeinterface 110 1 0
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: goto -13 -> 146
    //   162: astore_2
    //   163: goto -73 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	129	0	localCursor1	android.database.Cursor
    //   16	119	1	localCursor2	android.database.Cursor
    //   143	14	1	localObject1	Object
    //   158	1	1	localObject2	Object
    //   61	12	2	str	String
    //   87	40	2	localException1	Exception
    //   162	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	87	java/lang/Exception
    //   0	17	143	finally
    //   23	32	158	finally
    //   34	62	158	finally
    //   92	98	158	finally
    //   100	130	158	finally
    //   23	32	162	java/lang/Exception
    //   34	62	162	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str).append("_").append(paramString1).append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = a().getString(a(paramString1, paramString2), paramString3);
      if (paramString1 != null) {}
      label67:
      for (;;) {}
    }
    catch (Exception paramString3)
    {
      try
      {
        paramString3 = paramString1.trim();
        paramString1 = paramString3;
      }
      catch (Exception paramString3)
      {
        break label67;
      }
      try
      {
        QZLog.d("QZConfigProviderUtil", 1, "getHighPriorityConfig. , secondKey: " + paramString2 + ", result: " + paramString1);
        return paramString1;
      }
      catch (Exception paramString3)
      {
        break label67;
      }
      paramString3 = paramString3;
      paramString1 = null;
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { "getHighPriorityConfig exception. secondKey: " + paramString2, paramString3 });
      return paramString1;
    }
  }
  
  /* Error */
  public static Map<String, String> a()
  {
    // Byte code:
    //   0: new 303	java/util/HashMap
    //   3: dup
    //   4: invokespecial 304	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 306	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +92 -> 118
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 97 1 0
    //   37: ifeq +81 -> 118
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 21	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc_w 308
    //   52: invokeinterface 103 2 0
    //   57: invokeinterface 253 2 0
    //   62: invokevirtual 257	java/lang/String:getBytes	()[B
    //   65: ldc_w 259
    //   68: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   71: new 21	java/lang/String
    //   74: dup
    //   75: aload_2
    //   76: aload_2
    //   77: ldc_w 310
    //   80: invokeinterface 103 2 0
    //   85: invokeinterface 253 2 0
    //   90: invokevirtual 257	java/lang/String:getBytes	()[B
    //   93: ldc_w 259
    //   96: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   99: invokeinterface 315 3 0
    //   104: pop
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: invokeinterface 318 1 0
    //   113: istore_0
    //   114: iload_0
    //   115: ifne -75 -> 40
    //   118: aload_2
    //   119: ifnull +9 -> 128
    //   122: aload_2
    //   123: invokeinterface 110 1 0
    //   128: aload_3
    //   129: areturn
    //   130: astore_3
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: astore_1
    //   135: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +35 -> 173
    //   141: aload_2
    //   142: astore_1
    //   143: ldc 117
    //   145: iconst_2
    //   146: new 119	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 320
    //   156: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_3
    //   160: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload_3
    //   170: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 110 1 0
    //   183: aconst_null
    //   184: areturn
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +9 -> 198
    //   192: aload_1
    //   193: invokeinterface 110 1 0
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: goto -13 -> 188
    //   204: astore_3
    //   205: goto -72 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   113	2	0	bool	boolean
    //   30	163	1	localCursor1	android.database.Cursor
    //   24	154	2	localCursor2	android.database.Cursor
    //   185	14	2	localObject1	Object
    //   200	1	2	localObject2	Object
    //   7	122	3	localHashMap	java.util.HashMap
    //   130	40	3	localException1	Exception
    //   204	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	130	java/lang/Exception
    //   8	25	185	finally
    //   31	40	200	finally
    //   42	105	200	finally
    //   107	114	200	finally
    //   135	141	200	finally
    //   143	173	200	finally
    //   31	40	204	java/lang/Exception
    //   42	105	204	java/lang/Exception
    //   107	114	204	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("QZConfigProviderUtil", 2, "saveIspCheckTime time:" + paramLong);
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.f, localContentValues);
      localContentValues.clear();
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    if (paramString == null)
    {
      str = "";
      localContentValues.put("cookie", str);
      QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.b, localContentValues);
        if (paramString == null) {
          continue;
        }
        QLog.i("QZConfigProviderUtil", 1, paramString.toString() + " saveConfigCookie done.");
      }
      catch (SQLException paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      catch (Exception paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      localContentValues.clear();
      return;
      str = paramString;
      break;
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    if (("qqminiapp".equals(paramString1)) && ("miniappshowfullscreen".equals(paramString2))) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        i = Integer.valueOf(paramString3).intValue();
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        paramString1.edit().putInt(str + "_" + "miniappshowfullscreen", i).apply();
        QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], full screen config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
        return;
      }
      catch (Exception paramString1)
      {
        QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], full screen config exception. key: " + paramString2 + ", value: " + paramString3 });
        return;
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsetting".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsetting", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], setting config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], setting config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowclose".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowclose", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], close config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], close config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsearch".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsearch", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreentitle".equals(paramString2))) {
        try
        {
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putString(str + "_" + "miniappfullscreentitle", paramString3).apply();
          QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp, search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp, search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && (a.contains(paramString2))) {
        try
        {
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putString(str + "_" + paramString2, paramString3).apply();
          QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp high priority config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          if ("sdk_dex_config".equals(paramString2))
          {
            MiniSdkLauncher.onDexConfigUpdate(paramString3);
            return;
          }
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp high priority config exception. key: " + paramString2 + ", value: " + paramString3 });
        }
      }
    }
  }
  
  public static void a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    if (paramArrayList == null) {}
    while (paramArrayList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ContentValues localContentValues = a(paramString, (entrance_cfg)paramArrayList.next());
      if (localContentValues != null) {
        localArrayList.add(localContentValues);
      }
    }
    a((ContentValues[])localArrayList.toArray(new ContentValues[0]));
  }
  
  public static void a(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  public static void a(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = a(paramMap, paramString2);
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      if (bool) {
        a(paramString1);
      }
    }
    for (;;)
    {
      a(paramString2);
      if (paramAppRuntime != null) {}
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            blsb.a(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
      a("");
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.e, localContentValues);
      return true;
    }
    catch (SQLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  public static boolean a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 554	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 565	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc 151
    //   24: ldc 153
    //   26: invokevirtual 157	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   29: astore_0
    //   30: new 119	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 567
    //   40: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 569
    //   50: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_0
    //   57: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   63: getstatic 572	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   66: aconst_null
    //   67: aload_0
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +214 -> 289
    //   78: aload_0
    //   79: invokeinterface 97 1 0
    //   84: ifeq +205 -> 289
    //   87: aload_1
    //   88: new 145	NS_UNDEAL_COUNT/entrance_cfg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: ldc 207
    //   96: invokeinterface 103 2 0
    //   101: invokeinterface 576 2 0
    //   106: new 21	java/lang/String
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: ldc 212
    //   114: invokeinterface 103 2 0
    //   119: invokeinterface 253 2 0
    //   124: invokevirtual 257	java/lang/String:getBytes	()[B
    //   127: ldc_w 259
    //   130: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   133: new 21	java/lang/String
    //   136: dup
    //   137: aload_0
    //   138: aload_0
    //   139: ldc 214
    //   141: invokeinterface 103 2 0
    //   146: invokeinterface 253 2 0
    //   151: invokevirtual 257	java/lang/String:getBytes	()[B
    //   154: ldc_w 259
    //   157: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   160: new 21	java/lang/String
    //   163: dup
    //   164: aload_0
    //   165: aload_0
    //   166: ldc 216
    //   168: invokeinterface 103 2 0
    //   173: invokeinterface 253 2 0
    //   178: invokevirtual 257	java/lang/String:getBytes	()[B
    //   181: ldc_w 259
    //   184: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   187: aload_0
    //   188: aload_0
    //   189: ldc 218
    //   191: invokeinterface 103 2 0
    //   196: invokeinterface 576 2 0
    //   201: aload_0
    //   202: aload_0
    //   203: ldc 223
    //   205: invokeinterface 103 2 0
    //   210: invokeinterface 576 2 0
    //   215: new 21	java/lang/String
    //   218: dup
    //   219: aload_0
    //   220: aload_0
    //   221: ldc 227
    //   223: invokeinterface 103 2 0
    //   228: invokeinterface 253 2 0
    //   233: invokevirtual 257	java/lang/String:getBytes	()[B
    //   236: ldc_w 259
    //   239: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   242: new 21	java/lang/String
    //   245: dup
    //   246: aload_0
    //   247: aload_0
    //   248: ldc 229
    //   250: invokeinterface 103 2 0
    //   255: invokeinterface 253 2 0
    //   260: invokevirtual 257	java/lang/String:getBytes	()[B
    //   263: ldc_w 259
    //   266: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   269: iconst_0
    //   270: aconst_null
    //   271: invokespecial 579	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;)V
    //   274: invokevirtual 475	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: aload_0
    //   279: invokeinterface 318 1 0
    //   284: istore_2
    //   285: iload_2
    //   286: ifne -199 -> 87
    //   289: aload_0
    //   290: ifnull -279 -> 11
    //   293: aload_0
    //   294: invokeinterface 110 1 0
    //   299: iconst_0
    //   300: ireturn
    //   301: astore_1
    //   302: aconst_null
    //   303: astore_0
    //   304: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +33 -> 340
    //   310: ldc 117
    //   312: iconst_2
    //   313: new 119	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 581
    //   323: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload_1
    //   337: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_0
    //   341: ifnull -330 -> 11
    //   344: aload_0
    //   345: invokeinterface 110 1 0
    //   350: iconst_0
    //   351: ireturn
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_0
    //   355: aload_0
    //   356: ifnull +9 -> 365
    //   359: aload_0
    //   360: invokeinterface 110 1 0
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: goto -13 -> 355
    //   371: astore_1
    //   372: goto -17 -> 355
    //   375: astore_1
    //   376: goto -72 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString	String
    //   0	379	1	paramArrayList	ArrayList<entrance_cfg>
    //   284	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   57	74	301	java/lang/Exception
    //   57	74	352	finally
    //   78	87	367	finally
    //   87	285	367	finally
    //   304	340	371	finally
    //   78	87	375	java/lang/Exception
    //   87	285	375	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Map<String, java.util.concurrent.ConcurrentHashMap<String, String>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 584 1 0
    //   6: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 586	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +310 -> 336
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokeinterface 318 1 0
    //   39: ifeq +170 -> 209
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: iconst_0
    //   48: invokeinterface 253 2 0
    //   53: astore 7
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: iconst_1
    //   61: invokeinterface 253 2 0
    //   66: astore 8
    //   68: aload 7
    //   70: ifnull -41 -> 29
    //   73: aload 8
    //   75: ifnull -46 -> 29
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: iconst_2
    //   84: invokeinterface 253 2 0
    //   89: astore 9
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: aload 7
    //   97: invokeinterface 497 2 0
    //   102: checkcast 588	java/util/concurrent/ConcurrentHashMap
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ifnonnull +29 -> 142
    //   116: aload 4
    //   118: astore_3
    //   119: new 588	java/util/concurrent/ConcurrentHashMap
    //   122: dup
    //   123: invokespecial 589	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   126: astore 5
    //   128: aload 4
    //   130: astore_3
    //   131: aload_0
    //   132: aload 7
    //   134: aload 5
    //   136: invokeinterface 315 3 0
    //   141: pop
    //   142: aload 5
    //   144: ifnull -115 -> 29
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: aload 8
    //   154: aload 9
    //   156: invokevirtual 590	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: goto -131 -> 29
    //   163: astore_0
    //   164: aload 4
    //   166: astore_3
    //   167: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +23 -> 193
    //   173: aload 4
    //   175: astore_3
    //   176: ldc 117
    //   178: iconst_2
    //   179: aload_0
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 592
    //   189: aastore
    //   190: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   193: aload 4
    //   195: ifnull +139 -> 334
    //   198: aload 4
    //   200: invokeinterface 110 1 0
    //   205: iconst_0
    //   206: istore_2
    //   207: iload_2
    //   208: ireturn
    //   209: iconst_1
    //   210: istore_1
    //   211: iload_1
    //   212: istore_2
    //   213: aload 4
    //   215: ifnull -8 -> 207
    //   218: aload 4
    //   220: invokeinterface 110 1 0
    //   225: iload_1
    //   226: ireturn
    //   227: astore_0
    //   228: iload_1
    //   229: istore_2
    //   230: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -26 -> 207
    //   236: ldc 117
    //   238: iconst_2
    //   239: aload_0
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 592
    //   249: aastore
    //   250: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   253: iload_1
    //   254: ireturn
    //   255: astore_0
    //   256: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +20 -> 279
    //   262: ldc 117
    //   264: iconst_2
    //   265: aload_0
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: ldc_w 592
    //   275: aastore
    //   276: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 110 1 0
    //   294: aload_0
    //   295: athrow
    //   296: astore_3
    //   297: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -6 -> 294
    //   303: ldc 117
    //   305: iconst_2
    //   306: aload_3
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: ldc_w 592
    //   316: aastore
    //   317: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: goto -26 -> 294
    //   323: astore_0
    //   324: goto -40 -> 284
    //   327: astore_0
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -167 -> 164
    //   334: iconst_0
    //   335: ireturn
    //   336: iconst_0
    //   337: istore_1
    //   338: goto -127 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramMap	Map<String, java.util.concurrent.ConcurrentHashMap<String, String>>
    //   210	128	1	bool1	boolean
    //   206	24	2	bool2	boolean
    //   31	258	3	localCursor1	android.database.Cursor
    //   296	11	3	localException	Exception
    //   22	308	4	localCursor2	android.database.Cursor
    //   109	42	5	localConcurrentHashMap1	java.util.concurrent.ConcurrentHashMap
    //   105	7	6	localConcurrentHashMap2	java.util.concurrent.ConcurrentHashMap
    //   53	80	7	str1	String
    //   66	87	8	str2	String
    //   89	66	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   32	42	163	java/lang/Exception
    //   45	55	163	java/lang/Exception
    //   58	68	163	java/lang/Exception
    //   81	91	163	java/lang/Exception
    //   94	107	163	java/lang/Exception
    //   119	128	163	java/lang/Exception
    //   131	142	163	java/lang/Exception
    //   150	160	163	java/lang/Exception
    //   218	225	227	java/lang/Exception
    //   198	205	255	java/lang/Exception
    //   0	24	281	finally
    //   288	294	296	java/lang/Exception
    //   32	42	323	finally
    //   45	55	323	finally
    //   58	68	323	finally
    //   81	91	323	finally
    //   94	107	323	finally
    //   119	128	323	finally
    //   131	142	323	finally
    //   150	160	323	finally
    //   167	173	323	finally
    //   176	193	323	finally
    //   0	24	327	java/lang/Exception
  }
  
  private static boolean a(Map<String, byte[]> paramMap, String paramString)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return false;
    }
    paramString = paramMap.keySet();
    QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainkey count:", Integer.valueOf(paramString.size()) });
    localArrayList = new ArrayList();
    Iterator localIterator1 = paramString.iterator();
    while (localIterator1.hasNext())
    {
      paramString = (String)localIterator1.next();
      Object localObject1 = (byte[])paramMap.get(paramString);
      if ((paramString != null) && (localObject1 != null) && (localObject1.length > 0))
      {
        QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainKey:", paramString });
        QzoneConfig.getInstance().deleteConfigs(paramString);
        UniAttribute localUniAttribute = new UniAttribute();
        localUniAttribute.setEncodeName("utf-8");
        localUniAttribute.decode((byte[])localObject1);
        Iterator localIterator2 = localUniAttribute.getKeySet().iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = (String)localIterator2.next();
          String str = (String)localUniAttribute.get((String)localObject2);
          localObject1 = paramString;
          if (localObject2 != null)
          {
            if (QLog.isColorLevel()) {
              QZLog.i("QZConfigProviderUtil", 2, new Object[] { " main key:", paramString, " second key:", localObject2, " value:", str });
            }
            localObject1 = paramString.toLowerCase();
            paramString = ((String)localObject2).toLowerCase();
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("main_key", (String)localObject1);
            ((ContentValues)localObject2).put("second_key", paramString);
            ((ContentValues)localObject2).put("value", str);
            QzoneConfig.getInstance().updateOneConfig((String)localObject1, paramString, str);
            localArrayList.add(localObject2);
            a((String)localObject1, paramString, str);
            b((String)localObject1, paramString, str);
          }
          paramString = (String)localObject1;
        }
        try
        {
          BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QZLog.i("QZConfigProviderUtil", 4, new Object[] { "deleteConfig: ", paramString });
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("QZConfigProviderUtil", 1, paramString, new Object[] { "deleteConfig error:" });
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      localArrayList.clear();
      bool = true;
    }
    catch (SQLException paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        bool = false;
      }
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        boolean bool = false;
      }
    }
    finally
    {
      localArrayList.clear();
    }
    return bool;
  }
  
  private static boolean a(ContentValues[] paramArrayOfContentValues)
  {
    boolean bool = false;
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.g, paramArrayOfContentValues);
      bool = true;
    }
    catch (SQLException paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
      return false;
    }
    catch (Exception paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
    }
    return bool;
    return false;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 559	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +128 -> 146
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 97 1 0
    //   29: ifeq +117 -> 146
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 556
    //   39: invokeinterface 103 2 0
    //   44: invokeinterface 253 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 110 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 117
    //   79: iconst_2
    //   80: new 119	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 659
    //   90: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +35 -> 143
    //   111: aload_0
    //   112: invokeinterface 110 1 0
    //   117: ldc 153
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 110 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -13 -> 123
    //   139: astore_2
    //   140: goto -73 -> 67
    //   143: ldc 153
    //   145: areturn
    //   146: ldc 153
    //   148: astore_1
    //   149: goto -97 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	96	0	localCursor	android.database.Cursor
    //   120	14	0	localObject1	Object
    //   135	1	0	localObject2	Object
    //   22	127	1	localObject3	Object
    //   49	2	2	str	String
    //   64	40	2	localException1	Exception
    //   139	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	120	finally
    //   23	32	135	finally
    //   34	50	135	finally
    //   69	75	135	finally
    //   77	107	135	finally
    //   23	32	139	java/lang/Exception
    //   34	50	139	java/lang/Exception
  }
  
  /* Error */
  public static String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 554	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 554	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 586	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc_w 661
    //   37: iconst_2
    //   38: anewarray 21	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_1
    //   48: aastore
    //   49: aconst_null
    //   50: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +149 -> 204
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokeinterface 97 1 0
    //   66: ifeq +138 -> 204
    //   69: aload_1
    //   70: astore_0
    //   71: aload_1
    //   72: aload_1
    //   73: ldc_w 310
    //   76: invokeinterface 103 2 0
    //   81: invokeinterface 253 2 0
    //   86: astore_2
    //   87: aload_2
    //   88: astore_0
    //   89: aload_1
    //   90: ifnull +11 -> 101
    //   93: aload_1
    //   94: invokeinterface 110 1 0
    //   99: aload_2
    //   100: astore_0
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   108: aload_2
    //   109: astore_0
    //   110: goto -9 -> 101
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: astore_0
    //   118: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +22 -> 143
    //   124: aload_1
    //   125: astore_0
    //   126: ldc 117
    //   128: iconst_2
    //   129: aload_2
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: ldc_w 666
    //   139: aastore
    //   140: invokestatic 595	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   143: aload_1
    //   144: ifnull +55 -> 199
    //   147: aload_1
    //   148: invokeinterface 110 1 0
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -54 -> 101
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   163: aconst_null
    //   164: astore_0
    //   165: goto -64 -> 101
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: ifnull +9 -> 181
    //   175: aload_0
    //   176: invokeinterface 110 1 0
    //   181: aload_1
    //   182: athrow
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   188: goto -7 -> 181
    //   191: astore_1
    //   192: goto -21 -> 171
    //   195: astore_2
    //   196: goto -80 -> 116
    //   199: aconst_null
    //   200: astore_0
    //   201: goto -100 -> 101
    //   204: aconst_null
    //   205: astore_2
    //   206: goto -119 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString1	String
    //   0	209	1	paramString2	String
    //   86	23	2	str	String
    //   113	17	2	localException1	Exception
    //   195	1	2	localException2	Exception
    //   205	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	99	103	java/lang/Exception
    //   24	54	113	java/lang/Exception
    //   147	153	158	java/lang/Exception
    //   24	54	168	finally
    //   175	181	183	java/lang/Exception
    //   60	69	191	finally
    //   71	87	191	finally
    //   118	124	191	finally
    //   126	143	191	finally
    //   60	69	195	java/lang/Exception
    //   71	87	195	java/lang/Exception
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    if ("qqcircle".equals(paramString1)) {}
    try
    {
      if (b.contains(paramString2))
      {
        SharedPreferences localSharedPreferences = a();
        paramString1 = a(paramString1, paramString2);
        localSharedPreferences.edit().putString(paramString1, paramString3).apply();
        QZLog.d("QZConfigProviderUtil", 1, "saveHighPriorityConfig.  secondKey: " + paramString2 + ", value: " + paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveHighPriorityConfig. exception. secondKey: " + paramString2 + ", value: " + paramString3, paramString1 });
    }
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 79	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 586	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 21	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 674
    //   18: aastore
    //   19: ldc_w 676
    //   22: iconst_1
    //   23: anewarray 21	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 679 1 0
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +27 -> 80
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull +12 -> 74
    //   65: aload 4
    //   67: invokeinterface 110 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 97 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 576 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 117
    //   125: iconst_2
    //   126: new 119	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 681
    //   136: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 683
    //   146: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 110 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 110 1 0
    //   195: aload_0
    //   196: athrow
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_0
    //   200: goto -15 -> 185
    //   203: astore 5
    //   205: goto -94 -> 111
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -136 -> 74
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -157 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   51	164	1	i	int
    //   59	151	2	j	int
    //   43	147	3	localCursor1	android.database.Cursor
    //   34	137	4	localCursor2	android.database.Cursor
    //   106	55	5	localException1	Exception
    //   203	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	36	106	java/lang/Exception
    //   0	36	182	finally
    //   44	52	199	finally
    //   83	91	199	finally
    //   94	103	199	finally
    //   114	120	199	finally
    //   123	165	199	finally
    //   44	52	203	java/lang/Exception
    //   83	91	203	java/lang/Exception
    //   94	103	203	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abff
 * JD-Core Version:    0.7.0.1
 */