import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class akqv
  implements Manager
{
  public Context a;
  private bhgj jdField_a_of_type_Bhgj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public akqv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  private void a(akqx paramakqx, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramakqx != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("retMsg", paramString1);
      localBundle.putString("payTime", paramString2);
      localBundle.putString("orderId", paramString3);
      paramakqx.a(localBundle);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bhgj != null) && (this.jdField_a_of_type_Bhgj.isShowing())) {
      this.jdField_a_of_type_Bhgj.dismiss();
    }
    this.jdField_a_of_type_Bhgj = bhdj.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131708276), "", anvx.a(2131708277), new akqw(this), null, null);
    this.jdField_a_of_type_Bhgj.show();
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject, akqx paramakqx)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "jsonParams=" + paramJSONObject + ", puin=" + paramString);
      }
      return false;
    }
    if (!((aktz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a(paramString))
    {
      a();
      a(paramakqx, -4, "auth failed!", null, null);
      return false;
    }
    String str1 = paramJSONObject.optString("appId");
    paramString = paramJSONObject.optString("orderId");
    Object localObject = paramJSONObject.optString("expireTime");
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", str1);
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      if (Long.parseLong((String)localObject) <= NetConnInfoCenter.getServerTimeMillis() / 1000L)
      {
        a();
        a(paramakqx, -6, "expireTime overdue", null, null);
        return false;
      }
      paramakqx = new PublicQuickPayManager.1(this, new Handler(), paramakqx, paramString);
      localBundle.putParcelable("_qwallet_payresult_receiver", paramakqx);
      paramString = "";
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tokenId", paramJSONObject.optString("tokenId"));
        String str2 = paramJSONObject.optString("bargainor_id", "0");
        paramJSONObject = paramJSONObject.optString("channel", "other");
        ((JSONObject)localObject).put("appInfo", "appid#" + str1 + "|bargainor_id#" + str2 + "|channel#" + paramJSONObject);
        paramJSONObject = ((JSONObject)localObject).toString();
        paramString = paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
      localBundle.putString("payparmas_json", paramString);
      localBundle.putInt("payparmas_paytype", 9);
      localBundle.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "publicpaymsg.pay.result", "payinvoke", null, 0, null));
      localBundle.putInt("pay_requestcode", 9);
      PayBridgeActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseActivity.sTopActivity, paramakqx, 9, localBundle);
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "open OpenPayActivity success");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublicQuickPayManager", 2, "publicQuickPay parameters parse error");
    }
    a();
    a(paramakqx, -4, "params parse error", null, null);
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqv
 * JD-Core Version:    0.7.0.1
 */