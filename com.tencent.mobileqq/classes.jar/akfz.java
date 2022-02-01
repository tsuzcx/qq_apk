import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import org.json.JSONException;
import org.json.JSONObject;

public class akfz
{
  public static String a(String paramString)
  {
    String str = "";
    if (paramString.contains("pre_code="))
    {
      str = paramString.substring(paramString.indexOf("pre_code="));
      paramString = str;
      if (str.contains("&")) {
        paramString = str.substring(0, str.indexOf("&"));
      }
      str = paramString;
      if (paramString.contains("=")) {
        str = paramString.split("=")[1];
      }
    }
    return str;
  }
  
  public static JSONObject a(int paramInt, Bundle paramBundle, Activity paramActivity)
  {
    if (paramInt == 0)
    {
      try
      {
        Object localObject = paramBundle.getString("grapH5CommonHbResult");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBundle = new JSONObject((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("H5HbUtil", 2, "grapH5Json: " + paramBundle);
          }
          if (paramBundle.optJSONObject("hb_data") != null)
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("viewTag", "showHbDetail");
            ((JSONObject)localObject).put("extra_data", paramBundle.optJSONObject("hb_data"));
            paramBundle = new Bundle();
            paramBundle.putString("json", ((JSONObject)localObject).toString());
            paramBundle.putString("callbackSn", "0");
            PayBridgeActivity.a(paramActivity, 5, paramBundle, null);
            return null;
          }
          paramActivity = a(paramBundle.optJSONObject("detail"));
          paramBundle.remove("detail");
          paramBundle.put("detail_data", paramActivity);
        }
        else
        {
          paramActivity = new JSONObject();
          paramBundle = paramBundle.getString("detail");
          if (!TextUtils.isEmpty(paramBundle))
          {
            paramBundle = a(new JSONObject(paramBundle));
            paramBundle.remove("retcode");
            paramBundle.remove("retmsg");
            paramActivity.put("detail_data", paramBundle);
          }
          paramActivity.put("retcode", 0);
          paramActivity.put("retmsg", "ok");
          paramBundle = paramActivity;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = null;
      }
    }
    else
    {
      paramActivity = new JSONObject();
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getString("retmsg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            paramActivity.put("retmsg", new JSONObject(paramBundle).optString("err_msg"));
            paramActivity.put("retcode", paramInt);
            paramBundle = paramActivity;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          paramBundle = paramActivity;
        }
        paramActivity.put("retmsg", "error when grap hb");
      }
    }
    return paramBundle;
  }
  
  public static JSONObject a(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    String str4 = paramJSONObject.optString("listid");
    String str1 = paramJSONObject.optString("uin");
    if ((!StringUtil.isEmpty(str1)) && (str1.equals(paramAppInterface.getCurrentAccountUin())) && (!StringUtil.isEmpty(str4)))
    {
      String str2 = paramJSONObject.optString("feedsid");
      String str3 = paramJSONObject.optString("token");
      str4 = str4 + "_" + a(str3);
      if (QLog.isColorLevel()) {
        QLog.i("H5HbUtil", 2, "cache key: " + str4);
      }
      bkwg localbkwg = bkwg.a();
      paramJSONObject = localbkwg.b(str4);
      paramAppInterface = paramJSONObject;
      if (StringUtil.isEmpty(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5HbUtil", 2, "get cache from disk");
        }
        paramAppInterface = localbkwg.a(str1, str4, SharedPreferencesProxyManager.getInstance().getProxy("qb_tenpay_h5_common_hb_" + str1, 4));
      }
      if (QLog.isColorLevel()) {
        QLog.d("H5HbUtil", 2, "paramForGarpH5CommonHb:" + paramAppInterface);
      }
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        paramAppInterface = new JSONObject(paramAppInterface);
        paramAppInterface.put("feedsid", str2);
        paramAppInterface.put("uin", str1);
        paramAppInterface.put("token", str3);
        paramAppInterface.put("viewTag", "grapH5CommonHb");
        return paramAppInterface;
      }
    }
    return null;
  }
  
  private static JSONObject a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject.optJSONObject("send_object");
      String str = localJSONObject.optString("lucky_uin");
      localJSONObject.remove("lucky_uin");
      if (!StringUtil.isEmpty(str)) {
        localJSONObject.put("lucky_name", akfu.a(str));
      }
      paramJSONObject.remove("send_object");
      paramJSONObject.put("send_object", localJSONObject);
      return paramJSONObject;
    }
    return localJSONObject;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_data", paramString);
    localBundle.putString("callbackSn", "0");
    paramString = new Bundle();
    paramString.putInt("PayInvokerId", 22);
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    paramString.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
    paramString.putBundle("_qwallet_payparams_data", localBundle);
    paramString.putString("_qwallet_payparams_tag", "grapH5CommonHb");
    QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
  }
  
  public static void a(AppInterface paramAppInterface, JSONObject paramJSONObject, String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject = paramJSONObject.optString("listid");
    String str1 = paramJSONObject.optString("uin");
    String str2 = paramJSONObject.optString("offset");
    String str3 = paramJSONObject.optString("limit");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(paramAppInterface.getCurrentAccountUin())) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("listid", localObject);
      paramJSONObject.put("uin", str1);
      paramJSONObject.put("offset", str2);
      paramJSONObject.put("limit", str3);
      localObject = bkwg.a().b((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        paramJSONObject.put("authkey", ((JSONObject)localObject).optString("authkey"));
        paramJSONObject.put("grouptype", ((JSONObject)localObject).optString("grouptype"));
        paramJSONObject.put("groupid", ((JSONObject)localObject).optString("groupid"));
      }
      paramJSONObject.put("viewTag", paramString);
      b(paramAppInterface, paramJSONObject.toString(), paramResultReceiver);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("H5HbUtil", 2, "notifyViewUpdate extstr = " + paramJSONObject);
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_data", paramString);
      localBundle.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
      paramString.putBundle("_qwallet_payparams_data", localBundle);
      paramString.putString("_qwallet_payparams_tag", "redgiftH5CommonDetail");
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfz
 * JD-Core Version:    0.7.0.1
 */