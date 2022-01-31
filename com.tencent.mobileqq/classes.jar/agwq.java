import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class agwq
  implements Manager
{
  public Context a;
  private bbhz jdField_a_of_type_Bbhz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agwq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  private void a(agws paramagws, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramagws != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("retMsg", paramString1);
      localBundle.putString("payTime", paramString2);
      localBundle.putString("orderId", paramString3);
      paramagws.a(localBundle);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bbhz != null) && (this.jdField_a_of_type_Bbhz.isShowing())) {
      this.jdField_a_of_type_Bbhz.dismiss();
    }
    this.jdField_a_of_type_Bbhz = bbcv.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131708817), "", ajyc.a(2131708818), new agwr(this), null, null);
    this.jdField_a_of_type_Bbhz.show();
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject, agws paramagws)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "jsonParams=" + paramJSONObject + ", puin=" + paramString);
      }
      return false;
    }
    if (!((agzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245)).a(paramString))
    {
      a();
      a(paramagws, -4, "auth failed!", null, null);
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
        a(paramagws, -6, "expireTime overdue", null, null);
        return false;
      }
      paramagws = new PublicQuickPayManager.1(this, new Handler(), paramagws, paramString);
      localBundle.putParcelable("_qwallet_payresult_receiver", paramagws);
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
      PayBridgeActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseActivity.sTopActivity, paramagws, 9, localBundle);
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "open OpenPayActivity success");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublicQuickPayManager", 2, "publicQuickPay parameters parse error");
    }
    a();
    a(paramagws, -4, "params parse error", null, null);
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */