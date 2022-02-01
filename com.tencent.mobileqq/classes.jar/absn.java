import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class absn
{
  protected static long a;
  public static ArrayList<LightAppSettingInfo> a;
  public static volatile ConcurrentHashMap<Integer, LightAppSettingInfo> a;
  protected absp a;
  public Activity a;
  protected Bundle a;
  protected bisl a;
  protected DeviceInfo a;
  protected String a;
  protected AppRuntime a;
  private BusinessObserver a;
  protected boolean a;
  protected ArrayList<Integer> b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public absn()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new abso(this);
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.c = false;
  }
  
  public absn(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new abso(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public absn(Activity paramActivity, absp paramabsp)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new abso(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Absp = paramabsp;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public static String a(Resources paramResources, LightAppSettingInfo paramLightAppSettingInfo, String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("null")) {}
    }
    else
    {
      str = paramResources.getString(2131691505);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.b)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.jdField_a_of_type_JavaLangString)) && (bjlo.a(paramLightAppSettingInfo.b))) {
      return paramResources.getString(2131691507, new Object[] { str });
    }
    return paramResources.getString(2131691506, new Object[] { str });
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (bjlo.a(paramString1)))
    {
      bjlo.a(paramActivity, paramString1);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("autoDownload", false);
    localBundle.putString("packageName", paramString1);
    localBundle.putString("appId", paramString2);
    bjhq.b(paramActivity, localBundle);
  }
  
  private void a(Intent paramIntent, LightAppSettingInfo paramLightAppSettingInfo)
  {
    String str = null;
    if (paramLightAppSettingInfo.jdField_d_of_type_Int == 2) {
      str = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    }
    for (;;)
    {
      paramIntent.putExtra("url", str);
      return;
      if (paramLightAppSettingInfo.jdField_d_of_type_Int == 17) {
        str = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/print.html";
      }
    }
  }
  
  public static void a(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        LightAppSettingInfo localLightAppSettingInfo = (LightAppSettingInfo)paramArrayList.next();
        if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
          jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
        }
      }
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.get(i));
        if (i != this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i += 1;
      }
    }
    localBundle.putString("pids", ((StringBuilder)localObject).toString());
    if ((this.d) && (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)) {
      localBundle.putLong("din", this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din);
    }
    if (this.d) {}
    for (localObject = "get_public_lightapp_info";; localObject = "get_lightapp_info")
    {
      absz.a((String)localObject, localBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqObserverBusinessObserver);
      return;
    }
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.c)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          a(((abgm)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a());
          localLightAppSettingInfo1 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public HashMap<Integer, String> a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          while (i < paramJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
            if (localJSONObject != null) {
              localHashMap.put(Integer.valueOf(localJSONObject.getInt("property_id")), localJSONObject.getString("property_val"));
            }
            i += 1;
          }
        }
        return localHashMap;
      }
      catch (Exception paramJSONArray) {}
    }
  }
  
  public void a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((abgm)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 15000L)
        {
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localObject2.productId))) {
              localArrayList.add(Integer.valueOf(localObject2.productId));
            }
            i += 1;
          }
          if (localArrayList.size() > 0) {
            a(localArrayList, false);
          }
        }
      }
    }
  }
  
  public void a(DeviceInfo paramDeviceInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramDeviceInfo == null)
    {
      if (this.jdField_a_of_type_Absp != null) {
        this.jdField_a_of_type_Absp.a(false);
      }
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("showProgress", true);; bool = true)
    {
      this.jdField_b_of_type_Boolean = true;
      this.d = paramBoolean;
      LightAppSettingInfo localLightAppSettingInfo = a(paramDeviceInfo);
      String str;
      if (localLightAppSettingInfo != null) {
        if ((localLightAppSettingInfo.e != 3) && (localLightAppSettingInfo.e != 7) && (localLightAppSettingInfo.e != 5) && (localLightAppSettingInfo.e != 4) && (localLightAppSettingInfo.e != 1) && (localLightAppSettingInfo.e != 8) && (localLightAppSettingInfo.e != 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightAppUtil", 2, "bindType=" + localLightAppSettingInfo.e);
          }
          bjkv.a().a(2131691508);
          str = null;
        }
      }
      for (;;)
      {
        if ((str == null) && (0 == 0))
        {
          paramDeviceInfo = new Intent();
          paramDeviceInfo.setClassName("com.tencent.mobileqq", "com.tencent.biz.pubaccount.PublicAccountBrowser");
          paramDeviceInfo.putExtra("url", "https://qzs.qq.com/open/mobile/qq_download/index.html");
          paramDeviceInfo.putExtra("isPublicDevice", paramBoolean);
          absy.a(null, "Net_LiteApp_Setting", 0, 1, localLightAppSettingInfo.jdField_c_of_type_Int);
          if (str != null) {
            break label713;
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
          label247:
          if (this.jdField_a_of_type_Absp == null) {
            break label794;
          }
          this.jdField_a_of_type_Absp.a(true);
          return;
          if (localLightAppSettingInfo.jdField_a_of_type_Int == 0) {
            switch (localLightAppSettingInfo.jdField_d_of_type_Int)
            {
            default: 
              if ((TextUtils.isEmpty(localLightAppSettingInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
                break label935;
              }
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            case 2: 
              if ((localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(200031))))
              {
                str = "com.tencent.device.superav.ui.SuperVideoActivity";
                continue;
              }
              if ((this.d) && (a()))
              {
                str = "com.tencent.device.lightapp.LightAppActivity";
                continue;
              }
              str = "com.tencent.device.av.VideoActivity";
              break;
            case 14: 
              str = "com.tencent.device.qqwifi.WiFiStorageActivity";
              break;
            case 16: 
              str = "com.tencent.device.av.VisualDoorBellActivity";
              break;
            case 17: 
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            }
          }
          if (localLightAppSettingInfo.jdField_a_of_type_Int == 1)
          {
            if ((TextUtils.isEmpty(localLightAppSettingInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
              break label935;
            }
            str = "com.tencent.device.lightapp.LightAppActivity";
            continue;
          }
          bjkv.a().a(2131691512);
          if (this.jdField_a_of_type_Absp == null) {
            break;
          }
          this.jdField_a_of_type_Absp.a(false);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("device_info", paramDeviceInfo);
        localBundle.putParcelable("lightapp_setting", localLightAppSettingInfo);
        if (paramBundle != null) {
          localBundle.putBundle("extras", paramBundle);
        }
        if (0 == 0) {}
        for (Intent localIntent = new Intent();; localIntent = null)
        {
          localIntent.putExtra("uin", String.valueOf(paramDeviceInfo.din));
          if (!TextUtils.isEmpty(paramDeviceInfo.displayName)) {
            localIntent.putExtra("uinname", paramDeviceInfo.displayName);
          }
          for (;;)
          {
            localIntent.putExtra("account", paramDeviceInfo.serialNum);
            localIntent.putExtra("pid", paramDeviceInfo.productId);
            localIntent.putExtra("device_info", paramDeviceInfo);
            localIntent.putExtra("isPublicDevice", paramBoolean);
            if (this.d) {
              a(localIntent, localLightAppSettingInfo);
            }
            if ((paramBundle != null) && (paramBundle.getBoolean("isFromBindSucc", false))) {
              localIntent.putExtra("bindSuccTime", System.currentTimeMillis());
            }
            localIntent.putExtras(localBundle);
            paramDeviceInfo = localIntent;
            break;
            localIntent.putExtra("uinname", absz.a(paramDeviceInfo));
          }
          label713:
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            paramDeviceInfo.setClassName(this.jdField_a_of_type_AndroidAppActivity, str);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
            break label247;
          }
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          bmij.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramDeviceInfo, str, -1, null, SmartDevicePluginProxyActivity.class);
          break label247;
          label794:
          break;
          if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
          {
            if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
            {
              bjkv.a().a(2131691511);
              if (this.jdField_a_of_type_Absp == null) {
                break;
              }
              this.jdField_a_of_type_Absp.a(false);
              return;
            }
            this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
            this.jdField_a_of_type_AndroidOsBundle = paramBundle;
            paramBundle = new ArrayList();
            paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
            a(paramBundle, bool);
            return;
          }
          bjkv.a().a(2131691510);
          if ((this.jdField_a_of_type_Bisl != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
            this.jdField_a_of_type_Bisl.dismiss();
          }
          if (this.jdField_a_of_type_Absp == null) {
            break;
          }
          this.jdField_a_of_type_Absp.a(false);
          return;
        }
        label935:
        str = null;
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return false;
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
    {
      localObject = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      label30:
      if (localObject == null) {
        break label97;
      }
      localObject = new WebView((Context)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
        ((WebView)localObject).removeJavascriptInterface("accessibility");
        ((WebView)localObject).removeJavascriptInterface("accessibilityTraversal");
      }
      if ((localObject == null) || (((WebView)localObject).getX5WebViewExtension() == null)) {
        break label99;
      }
    }
    label97:
    label99:
    for (boolean bool = true;; bool = false)
    {
      ((WebView)localObject).destroy();
      return bool;
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      break label30;
      break;
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        break label103;
      }
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.c(2131691509);
      this.jdField_a_of_type_Bisl.show();
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      bjko.d("LightAppUtil", "app == null when dologin");
      if (this.jdField_a_of_type_Absp != null) {
        this.jdField_a_of_type_Absp.a(false);
      }
      return;
      label103:
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bjkv.a().a(2131694462);
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absn
 * JD-Core Version:    0.7.0.1
 */