import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

public class akzs
  extends SSOAccountObserver
{
  public akzs(AuthorityActivity paramAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.k = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      ReportManager.a().a("agent_login", this.a.jdField_d_of_type_Long, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      OpenSdkStatic.a().a(1, "LOGIN_GETTICKT", paramString, AuthorityActivity.f, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      ReportCenter.a().a(paramString, "", AuthorityActivity.f, "1", "1", "" + paramInt1, false);
      ReportCenter.a().a(paramString, "", AuthorityActivity.f, "1", "6", "" + paramInt1, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.a.e = SystemClock.elapsedRealtime();
        LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.jdField_d_of_type_Long));
        if ((paramInt1 == 1002) && (this.a.jdField_d_of_type_Int < 2))
        {
          paramString = this.a;
          paramString.jdField_d_of_type_Int += 1;
          this.a.f();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131435603));
      paramString = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131435603);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
      return;
    }
    this.a.c(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramBundle.getBoolean("fake_callback");
    if ((!bool) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, l);
    }
    int i;
    Object localObject;
    if (!bool)
    {
      i = paramBundle.getInt("code");
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "103");
      ((Bundle)localObject).putString("act_type", "10");
      ((Bundle)localObject).putString("stringext_1", "GetTicketNoPassword");
      ((Bundle)localObject).putString("intext_2", "" + i);
      ((Bundle)localObject).putString("intext_5", "" + (l - AuthorityActivity.a(this.a).a));
      ReportCenter.a().a((Bundle)localObject, AuthorityActivity.f, paramString, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + i);
      LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.jdField_d_of_type_Long));
    }
    try
    {
      ReportManager.a().a("agent_login", this.a.jdField_d_of_type_Long, this.a.jdField_a_of_type_JavaLangString.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      OpenSdkStatic.a().a(0, "LOGIN_GETTICKT", paramString, AuthorityActivity.f, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      ReportCenter.a().a(paramString, "", AuthorityActivity.f, "1", "1", "0", false);
      this.a.k = false;
      this.a.jdField_d_of_type_Int = 0;
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.a.a(paramString, (String)localObject, paramBundle);
      this.a.e = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.a.jdField_d_of_type_Int = 0;
    this.a.e = SystemClock.elapsedRealtime();
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.jdField_d_of_type_Long));
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akzs
 * JD-Core Version:    0.7.0.1
 */