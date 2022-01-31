import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class alem
{
  public static int a;
  public static DisplayMetrics a;
  public static boolean a;
  public static int b;
  public static int c;
  public static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_Int = BaseChatItemLayout.jdField_d_of_type_Int;
    b = BaseChatItemLayout.e;
    c = BaseChatItemLayout.c;
    jdField_d_of_type_Int = BaseChatItemLayout.c;
    a(1);
  }
  
  public static float a()
  {
    return BaseChatItemLayout.jdField_d_of_type_Float;
  }
  
  public static String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        if (!awnu.b()) {
          continue;
        }
        localJSONObject2.put("mode", "concise");
        localJSONObject2.put("themeId", ThemeUtil.getCurrentThemeId());
        localJSONObject1.put("theme", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject2;
        QLog.e("ArkApp.ArkAppCenterUtil", 1, "Exception=", localJSONException);
        continue;
      }
      return localJSONObject1.toString();
      localJSONObject2.put("mode", "default");
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppCenterUtil", 2, "AAShare.CopyFileToCache appName is null or local path is null");
      }
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
      int i = (int)(Math.random() * 10.0D);
      paramString1 = String.format("share_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
      str = str + "/" + paramString1;
      paramString1 = "res:" + paramString1;
    } while (bace.d(paramString2, str));
    return "";
  }
  
  public static void a()
  {
    String str = a();
    QLog.d("ArkApp.ArkAppCenterUtil", 1, new Object[] { "onThemeChanged.appconfig=", str });
    try
    {
      ark.arkApplicationSetConfig(null, str);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "onThemeChanged.ark so not load.e=", localUnsatisfiedLinkError);
    }
  }
  
  private static void a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    int i = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_d_of_type_Int = i;
    if (jdField_a_of_type_AndroidUtilDisplayMetrics == null) {
      jdField_a_of_type_AndroidUtilDisplayMetrics = localDisplayMetrics;
    }
    QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize model=", Build.MODEL, ",screenWidth=", Integer.valueOf(i), ",sDisplayWith=", Integer.valueOf(c), ",scene=", Integer.valueOf(paramInt) });
    if ((i >= 1536) && (c != 840))
    {
      jdField_a_of_type_Boolean = true;
      c = 840;
      jdField_a_of_type_Int = (int)(c - 108.0F * a());
      b = jdField_a_of_type_Int - BaseChatItemLayout.i - BaseChatItemLayout.j;
      QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize handle fold screen sChatBubbleMaxWidth=", Integer.valueOf(jdField_a_of_type_Int), ",sDisplayWith=", Integer.valueOf(c), ",sChatTextViewMaxWidth=", Integer.valueOf(b) });
    }
  }
  
  public static void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.screenWidthDp != e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "ArkFold.BaseChatePie.onConfigurationChanged.mOldScreenDp=", Integer.valueOf(e), ",newScreenDp=", Integer.valueOf(paramConfiguration.screenWidthDp) });
      }
      e = paramConfiguration.screenWidthDp;
      a(2);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "preDownloadArkApp download start,appName: ", paramString1, ",appView=", paramString2 });
    }
    ArkAppMgr.getInstance().getAppPathByName(paramString1, paramString2, "0.0.0.1", null, new alen());
  }
  
  public static void a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ArkApp.ArkAppCenterUtil";
    }
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString = new StringBuilder("print density info:");
      paramString.append("\n model=").append(Build.MODEL).append(", ver=").append(Build.VERSION.RELEASE).append(",SDK=").append(Build.VERSION.SDK_INT).append("\n BaseChatItemLayout.density=").append(BaseChatItemLayout.jdField_d_of_type_Float).append("\n application density=").append(localDisplayMetrics.density).append("-").append(localDisplayMetrics.scaledDensity);
      if (paramContext != null)
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        paramString.append("\n activity density=").append(paramContext.density).append("-").append(paramContext.scaledDensity);
      }
      QLog.i(str, 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "printScaleInfo Exception:", paramString);
    }
  }
  
  public static boolean a()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof aegy))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alem
 * JD-Core Version:    0.7.0.1
 */