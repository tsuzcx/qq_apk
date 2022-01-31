import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class alqc
  implements alqe
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    awzj localawzj = new awzj();
    j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) != 67108864) {
        break label99;
      }
      j = 335544320;
    }
    catch (Exception paramString4)
    {
      for (;;)
      {
        int k;
        int i;
        continue;
        j = 268435456;
      }
    }
    i = j;
    if ((k & 0x20000000) == 536870912) {
      i = j | 0x20000000;
    }
    j = i;
    if ((k & 0x400000) == 4194304) {
      j = i | 0x400000;
    }
    localawzj.a(a(), paramContext, paramString1, paramString2, paramString3, j);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return false;
    }
    Object localObject1 = null;
    String str1 = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$" + "&big_brother_source_key=" + paramString3;
    try
    {
      Object localObject2 = alqb.a(new JSONObject(paramString2));
      Object localObject3 = ((Map)localObject2).get("url");
      paramString2 = (String)localObject1;
      if (localObject3 != null)
      {
        paramString2 = (String)localObject1;
        if ((localObject3 instanceof String)) {
          paramString2 = (String)localObject3;
        }
      }
      try
      {
        localObject1 = ((Map)localObject2).get("data");
        if ((localObject1 == null) || (!(localObject1 instanceof Map))) {
          break label383;
        }
        localObject2 = (Map)localObject1;
        localObject1 = new StringBuilder();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = ((Map.Entry)localObject4).getKey();
          localObject4 = ((Map.Entry)localObject4).getValue();
          if ((localObject3 != null) && ((localObject3 instanceof String)) && (localObject4 != null))
          {
            ((StringBuilder)localObject1).append("&");
            ((StringBuilder)localObject1).append(localObject3);
            ((StringBuilder)localObject1).append("=");
            ((StringBuilder)localObject1).append(localObject4.toString());
          }
        }
        if (!QLog.isColorLevel()) {
          break label256;
        }
      }
      catch (JSONException localJSONException) {}
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2 = null;
      }
    }
    QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.jsonParseError");
    label256:
    if (!a(localBaseActivity, paramString4)) {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new Intent(localBaseActivity, QQBrowserActivity.class);
        paramString1.putExtra("url", paramString2);
        ArkAppCenter.a(paramString1, paramString3);
        paramString1.putExtra("fromArkAppDownload", true);
        localBaseActivity.startActivity(paramString1);
      }
    }
    for (;;)
    {
      return true;
      String str2 = str1 + localJSONException;
      str1 = str2;
      break;
      if (QLog.isColorLevel())
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler, download url is empty");
        continue;
        a(localBaseActivity, paramString1, str1, paramString4, "0");
      }
    }
  }
  
  protected QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramString3 = BaseActivity.sTopActivity;
    if (paramString3 == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (paramJSONObject == null) {}
    for (paramJSONObject = "biz_src_jc_ark";; paramJSONObject = paramJSONObject.optString("businessId", "biz_src_jc_ark"))
    {
      String str = BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).getString(paramString1, null);
      if ((str == null) || (str.length() <= 0) || (!a(paramString3, str))) {
        break;
      }
      a(paramString1, paramString2, paramJSONObject, str);
      return true;
    }
    paramString3 = a();
    if (paramString3 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate.app is null.");
      return false;
    }
    ((ArkAppCenter)paramString3.getManager(121)).a(paramString1, this, new alqd(this, paramString2, paramJSONObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqc
 * JD-Core Version:    0.7.0.1
 */