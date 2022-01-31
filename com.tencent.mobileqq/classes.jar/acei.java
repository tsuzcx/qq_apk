import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.mobileqq.activity.SubLoginActivity.8.2;
import com.tencent.mobileqq.activity.SubLoginActivity.8.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

public class acei
  extends SubAccountObserver
{
  public acei(SubLoginActivity paramSubLoginActivity) {}
  
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
      axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.c();
      this.a.b(this.a.getString(2131719915));
      this.a.runOnUiThread(new SubLoginActivity.8.3(this));
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
      axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (!SubLoginActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount onGetKeyBack not need bind");
        }
        this.a.c();
        paramString1 = (ayax)this.a.app.getManager(61);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, true);
        }
        ayaq.a(this.a.app, (byte)1, paramString2);
        ayaq.a(this.a.app, paramString2, 7);
        ayap.b(this.a.app);
        ayap.a(this.a.app);
        this.a.setTitle("");
        ayap.a(this.a.app, this.a, paramString2);
        this.a.finish();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
        }
        paramString1 = (ayav)this.a.app.getManager(28);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, this.a.b);
        }
        this.a.a = true;
      }
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: subLogin ...onLoginTimeout  subuin =  uin .. .errorMsg = " + paramString4);
    }
    paramString2 = new HashMap();
    paramString2.put("param_FailCode", "12002");
    paramString2.put("fail_step", "loginFail");
    paramString3 = new StringBuilder().append("subLogin:");
    if (paramString4 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2.put("fail_location", paramString1);
      axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString2, "");
      if (!this.a.getActivity().isFinishing()) {}
      try
      {
        this.a.c();
        this.a.runOnUiThread(new SubLoginActivity.8.2(this));
        if (TextUtils.isEmpty(paramString4))
        {
          this.a.b(this.a.getString(2131694608));
          return;
          paramString1 = paramString4;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
        this.a.b(this.a.getResources().getString(2131718891), paramString4, null);
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
    axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, paramString1, "");
    bbkb.a(this.a.app.getApplication().getApplicationContext(), paramString2, true);
    this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, null);
    ThreadManager.post(new SubLoginActivity.8.1(this, paramString2), 8, null, true);
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
    axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.c();
      this.a.b(this.a.getString(2131694608));
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
    axrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.c();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acei
 * JD-Core Version:    0.7.0.1
 */