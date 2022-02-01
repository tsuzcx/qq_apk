import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.9.1;
import com.tencent.mobileqq.activity.SubLoginActivity.9.2;
import com.tencent.mobileqq.activity.SubLoginActivity.9.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aezx
  extends SubAccountObserver
{
  public aezx(SubLoginActivity paramSubLoginActivity) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("SubLoginActivity.onGetKeyBack() start. subUin=").append(paramString2).append(" key=");
      if (paramString3 == null)
      {
        paramString1 = null;
        QLog.d("Q.subaccount.SubLoginActivity", 2, paramString1);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString3)) {
        break label164;
      }
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.e();
      this.a.b(this.a.getString(2131719086));
      this.a.runOnUiThread(new SubLoginActivity.9.3(this));
    }
    for (;;)
    {
      return;
      paramString1 = "no null.";
      break;
      label164:
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (!SubLoginActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount onGetKeyBack not need bind");
        }
        this.a.e();
        paramString1 = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, true);
        }
        bdxj.a(this.a.app, (byte)1, paramString2);
        bdxj.a(this.a.app, paramString2, 7);
        bdxi.b(this.a.app);
        bdxi.a(this.a.app);
        this.a.setTitle("");
        bdxi.a(this.a.app, this.a, paramString2);
        this.a.finish();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
        }
        paramString1 = (bdxp)this.a.app.getManager(QQManagerFactory.MGR_SUB_ACNT);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, this.a.b);
        }
        this.a.a = true;
      }
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: error, data == null");
      return;
    }
    paramString2 = paramBundle.getString("error");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: subLogin ...onLoginTimeout  subuin =  uin .. .errorMsg = " + paramString2);
    }
    paramString3 = new HashMap();
    paramString3.put("param_FailCode", "12002");
    paramString3.put("fail_step", "loginFail");
    StringBuilder localStringBuilder = new StringBuilder().append("subLogin:");
    if (paramString2 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramString3.put("fail_location", paramString1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString3, "");
      if (!this.a.getActivity().isFinishing()) {}
      try
      {
        this.a.e();
        this.a.runOnUiThread(new SubLoginActivity.9.2(this));
        if (TextUtils.isEmpty(paramString2))
        {
          this.a.b(this.a.getString(2131694253));
          return;
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
        int i = paramBundle.getInt("ret");
        paramString1 = paramBundle.getByteArray("tlverror");
        boolean bool = aozj.a().a(paramString1);
        if ((i == 40) && (bool))
        {
          paramString2 = (ErrMsg)paramBundle.getParcelable("lastError");
          if (paramString2 == null)
          {
            QLog.e("Q.subaccount.SubLoginActivity", 1, "onLoginFailed error: errMsg == null");
            return;
          }
          paramString3 = new Bundle();
          paramString3.putInt("loginret", i);
          paramString3.putString("loginalias", paramBundle.getString("alias"));
          paramString3.putString("msg", paramBundle.getString("error"));
          paramString3.putInt("errorver", paramString2.getVersion());
          paramString3.putByteArray("tlverror", paramString1);
          paramString3.putString("errortitle", paramString2.getTitle());
          paramString3.putString("errorUrl", paramBundle.getString("errorUrl"));
          aozj.a().a(this.a, paramString3);
          return;
        }
        bdla.a(this.a.app, "dc00898", "", "", "0X800B296", "0X800B296", 0, 0, "", "", paramString2, "");
        this.a.b(this.a.getResources().getString(2131718185), paramString2, null);
      }
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginSuccess: start");
    }
    if (this.a.app == null) {
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12001");
    paramString1.put("fail_step", "loginsucc");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, paramString1, "");
    bhhr.a(this.a.app.getApplication().getApplicationContext(), paramString2, true);
    this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, null);
    ThreadManager.post(new SubLoginActivity.9.1(this, paramString2), 8, null, true);
  }
  
  public void onLoginTimeout(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginTimeout:  subuin =  uin");
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12004");
    paramString1.put("fail_step", "loginTimeout");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.e();
      this.a.b(this.a.getString(2131694253));
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void onUserCancel(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12003");
    paramString1.put("fail_step", "onUserCancel");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.e();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezx
 * JD-Core Version:    0.7.0.1
 */