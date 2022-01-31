import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;

public class aaon
{
  public static int a(Context paramContext, AdAppBtnData paramAdAppBtnData)
  {
    if ((paramContext == null) || (paramAdAppBtnData == null)) {}
    do
    {
      do
      {
        return -1;
        paramContext = paramAdAppBtnData.packageName;
        paramAdAppBtnData = paramAdAppBtnData.apkUrlhttp;
      } while ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramAdAppBtnData)));
      paramContext = bfgi.a().b(paramAdAppBtnData);
    } while ((paramContext == null) || ((paramContext.a() != 2) && (paramContext.a() != 3)));
    return paramContext.f;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
      }
    }
    do
    {
      do
      {
        return -1;
        paramContext = bfgi.a().b(paramString2);
        if (paramContext != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
      return -1;
      if (paramContext.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " true");
        }
        return paramContext.f;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
    return -1;
  }
  
  private static Intent a(String paramString)
  {
    return BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(paramString);
  }
  
  private static Intent a(String paramString, Uri paramUri)
  {
    Intent localIntent = new Intent();
    if (paramUri != null) {
      localIntent.setData(paramUri);
    }
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.setPackage(paramString);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_ads");
    return localIntent;
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      Object localObject = paramString;
      if (i >= 0) {
        localObject = paramString.substring(i + 1);
      }
      paramString = ((String)localObject).split("&");
      if (paramString != null)
      {
        int j = paramString.length;
        i = 0;
        while (i < j)
        {
          localObject = paramString[i].split("=");
          if (localObject.length > 1)
          {
            String str = URLDecoder.decode(localObject[1]);
            localHashMap.put(localObject[0], str);
          }
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    alyh.a("scheme", paramString1, paramString2, "4", "gdtAppAd", paramContext.getClass().getName());
  }
  
  public static void a(Bundle paramBundle)
  {
    bfel.a();
    Object localObject1 = paramBundle.getString("schemaUrl");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("&"))) {
      if (!((String)localObject1).startsWith("http://")) {}
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        String str = new URL((String)localObject1).getQuery();
        Object localObject5 = bfel.a(str);
        localObject4 = (String)((HashMap)localObject5).get("appid");
        localObject1 = localObject4;
        localObject3 = str;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = (String)((HashMap)localObject5).get(bfjy.b);
          localObject3 = str;
        }
        str = bfel.g() + File.separator + "qapp_center_detail.htm";
        localObject4 = new File(str);
        if (!((File)localObject4).exists()) {
          bfhd.a("Page/system", bfel.h());
        }
        localObject5 = new Intent();
        Bundle localBundle = new Bundle();
        if (!((File)localObject4).exists()) {
          break label456;
        }
        str = "file:///" + str;
        localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + "2410";
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(localObject1))) {
          break label487;
        }
        localObject1 = localObject4;
        localObject3 = localObject1;
        if ("1".equals((String)bfel.a(paramBundle.getString("schemaUrl")).get("auto_download")))
        {
          localObject3 = localObject1;
          if (!((String)localObject1).contains("auto_download")) {
            localObject3 = (String)localObject1 + "&auto_download=1";
          }
        }
        ((Intent)localObject5).setClass(bexd.a().a(), QZoneAppListActivity.class);
        localBundle.putString("APP_URL", str);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        localBundle.putInt("goto_type", 2);
        if (paramBundle.getInt("process_id") == 2) {
          localBundle.putInt("process_id", 2);
        }
        ((Intent)localObject5).putExtras(localBundle);
        ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
        ((Intent)localObject5).putExtra("big_brother_source_key", "biz_src_ads");
        ((Intent)localObject5).putExtra("big_brother_ref_source_key", paramBundle.getString("big_brother_ref_source_key"));
        ((Intent)localObject5).addFlags(872415232);
        bexd.a().a().startActivity((Intent)localObject5);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
      Object localObject2 = localObject1;
      continue;
      Object localObject3 = localObject1;
      continue;
      label456:
      localObject2 = bfel.m() + File.separator + "qapp_center_detail.htm";
      continue;
      label487:
      localObject1 = (String)localObject4 + "&" + (String)localObject3;
    }
  }
  
  @Deprecated
  public static void a(GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      ((aanq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110)).a(BaseApplicationImpl.getContext(), paramGdtBaseAdItem);
      if (TextUtils.isEmpty(paramGdtBaseAdItem.f)) {
        break label106;
      }
    }
    label106:
    for (paramGdtBaseAdItem = paramGdtBaseAdItem.f;; paramGdtBaseAdItem = paramGdtBaseAdItem.b)
    {
      AdReporterForAnalysis.reportForAPIInvoked(BaseApplicationImpl.getApplication(), false, "com.tencent.gdtad.util.GdtAppOpenUtil#doAppJump(GdtBaseAdItem)", paramGdtBaseAdItem);
      return;
      Bundle localBundle = new Bundle();
      localBundle.setClassLoader(GdtBaseAdItem.class.getClassLoader());
      localBundle.putParcelable("gdtBaseAdItem", paramGdtBaseAdItem);
      QIPCClientHelper.getInstance().callServer("gdt_ipc", "do_app_jump", localBundle, null);
      break;
    }
  }
  
  public static boolean a()
  {
    return bdee.h(BaseApplicationImpl.getContext());
  }
  
  public static boolean a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if (!c(paramContext, paramGdtBaseAdItem)) {
      return b(paramContext, paramGdtBaseAdItem);
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    DownloadInfo localDownloadInfo;
    Object localObject;
    do
    {
      return bool2;
      if (QLog.isColorLevel()) {
        QLog.d("GdtAppOpenUtil", 2, " packageName:" + paramString);
      }
      localDownloadInfo = bfgi.a().c(paramString);
      if (localDownloadInfo == null)
      {
        QLog.e("GdtAppOpenUtil", 2, " DownloadInfo == null");
        return false;
      }
      localObject = "";
      if (TextUtils.isEmpty(localDownloadInfo.l)) {
        break;
      }
      localObject = localDownloadInfo.l;
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        if (new File((String)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgExist(" + bool1 + ")  packageName:" + paramString + ", path:" + (String)localObject);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.c == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo.d);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo);
        localObject = paramContext;
      }
    }
    for (;;)
    {
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.l = paramContext;
      localDownloadInfo.a(4);
      bfgi.a().c(localDownloadInfo);
      localObject = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo.d);
        localObject = paramContext;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = Uri.parse(paramString2);
          bool1 = bool2;
          if (!"http".equalsIgnoreCase(paramString2.getScheme()))
          {
            bool1 = bool2;
            if (!"https".equalsIgnoreCase(paramString2.getScheme()))
            {
              paramString1 = a(paramString1, paramString2);
              bool1 = bool2;
              if (paramContext.getPackageManager().resolveActivity(paramString1, 65536) != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (!"http".equalsIgnoreCase(paramString.getScheme()))
      {
        bool1 = bool2;
        if (!"https".equalsIgnoreCase(paramString.getScheme())) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
          return -1;
          paramContext = bfgi.a().b(paramString2);
          if (paramContext != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
        return -1;
        if (paramContext.a() != 3) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " true");
        }
      } while ((TextUtils.isEmpty(paramContext.l)) || (!new File(paramContext.l + ".temp").exists()));
      return paramContext.f;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp:" + paramString2 + " false");
    return -1;
  }
  
  public static boolean b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramGdtBaseAdItem.jdField_a_of_type_JavaLangString))
      {
        localIntent = a(paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
        bool1 = bool2;
        if (localIntent != null)
        {
          localIntent.putExtra("big_brother_source_key", "biz_src_ads");
          if (paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle != null) {
            localIntent.putExtras(paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle);
          }
          bool1 = bool3;
        }
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      bool3 = true;
      bool2 = true;
      bool1 = bool3;
      aaod.a(138, paramGdtBaseAdItem.d, paramGdtBaseAdItem.e);
      bool1 = bool3;
      a(paramContext, paramGdtBaseAdItem.b, paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
      bool1 = bool3;
      aanp.a("GdtAppOpenUtil", "launchAPPMain report " + paramGdtBaseAdItem.toString());
      bool1 = bool2;
      return bool1;
    }
    catch (Exception paramContext)
    {
      aanp.d("GdtAppOpenUtil", "launchApp failed", paramContext);
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    DownloadInfo localDownloadInfo;
    Object localObject;
    do
    {
      do
      {
        return bool2;
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, " apkUrlhttp:" + paramString);
        }
        localDownloadInfo = bfgi.a().b(paramString);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      localObject = "";
      if (TextUtils.isEmpty(localDownloadInfo.l)) {
        break;
      }
      localObject = localDownloadInfo.l;
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        if (new File((String)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgExist(" + bool1 + ")  apkUrlhttp:" + paramString + ", path:" + (String)localObject);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.c == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo.d);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo);
        localObject = paramContext;
      }
    }
    for (;;)
    {
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.l = paramContext;
      localDownloadInfo.a(4);
      bfgi.a().c(localDownloadInfo);
      localObject = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo.d);
        localObject = paramContext;
      }
    }
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return -1;
      paramContext = bfgi.a().b(paramString2);
    } while ((paramContext == null) || ((paramContext.a() != 2) && (paramContext.a() != 3)));
    return paramContext.f;
  }
  
  private static boolean c(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (a(paramContext, paramGdtBaseAdItem.jdField_a_of_type_JavaLangString, paramGdtBaseAdItem.c))
    {
      Object localObject = Uri.parse(paramGdtBaseAdItem.c);
      localObject = a(paramGdtBaseAdItem.jdField_a_of_type_JavaLangString, (Uri)localObject);
      if (paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle != null) {
        ((Intent)localObject).putExtras(paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle);
      }
      if (localObject != null) {
        bool1 = bool2;
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        boolean bool3 = true;
        bool2 = true;
        bool1 = bool3;
        aaod.a(137, paramGdtBaseAdItem.d, paramGdtBaseAdItem.e);
        bool1 = bool3;
        a(paramContext, paramGdtBaseAdItem.b, paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
        bool1 = bool3;
        aanp.a("GdtAppOpenUtil", "launchAPPDeepLink report " + paramGdtBaseAdItem.toString());
        bool1 = bool2;
        return bool1;
      }
      catch (Exception paramContext)
      {
        aanp.d("GdtAppOpenUtil", "launchAPPDeepLink failed", paramContext);
        return bool1;
      }
    }
    aanp.a("GdtAppOpenUtil", "launchAPPDeepLink isDLURISupported false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaon
 * JD-Core Version:    0.7.0.1
 */