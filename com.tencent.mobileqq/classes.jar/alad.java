import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class alad
  implements BusinessObserver
{
  public alad(AuthorityActivity paramAuthorityActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.d(this.a).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.d(this.a).jdField_a_of_type_Long);
    String str = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doAuthorize-onReceive, ssoAccount: " + str + " | uin: " + this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    }
    if (!this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString.equals(str)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    paramInt = paramBundle.getInt("code");
    if (!this.a.j) {}
    for (str = "s_a_a_emp";; str = "s_a_a")
    {
      if (paramBoolean)
      {
        this.a.jdField_f_of_type_Int = 0;
        Object localObject3 = new SdkAuthorize.AuthorizeResponse();
        for (;;)
        {
          try
          {
            localObject2 = paramBundle.getByteArray("data");
            localObject1 = localObject2;
            if (!this.a.j) {
              localObject1 = this.a.b((byte[])localObject2);
            }
            if (localObject1 != null)
            {
              l1 = localObject1.length;
              localObject2 = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom((byte[])localObject1);
              if (localObject2 != null)
              {
                localObject3 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
                ((Message)localObject3).what = 1;
                ((Message)localObject3).obj = localObject2;
                this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject3);
                if (((SdkAuthorize.AuthorizeResponse)localObject2).ret.get() == 0) {
                  this.a.a(AuthorityActivity.jdField_f_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, ((SdkAuthorize.AuthorizeResponse)localObject2).expires_in.get(), (byte[])localObject1);
                }
                i = ((SdkAuthorize.AuthorizeResponse)localObject2).toByteArray().length;
                l2 = i;
              }
            }
          }
          catch (Exception paramBundle)
          {
            Object localObject2;
            long l1;
            int i;
            long l2;
            Object localObject1 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            ((Message)localObject1).what = 6;
            ((Message)localObject1).arg1 = 3002;
            ((Message)localObject1).obj = this.a.getResources().getString(2131435603);
            this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject1);
            localObject1 = (String)((Message)localObject1).obj;
            QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
            continue;
          }
          try
          {
            i = ((SdkAuthorize.AuthorizeResponse)localObject2).ret.get();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "103");
            ((Bundle)localObject1).putString("act_type", "13");
            if (!paramBundle.getBoolean("isShort", false)) {
              continue;
            }
            paramBundle = "2";
            ((Bundle)localObject1).putString("intext_3", paramBundle);
            ((Bundle)localObject1).putString("stringext_1", AuthorityActivity.d(this.a).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject1).putString("intext_2", "" + i);
            ((Bundle)localObject1).putString("intext_5", "" + AuthorityActivity.d(this.a).jdField_a_of_type_Long);
            ReportCenter.a().a((Bundle)localObject1, AuthorityActivity.jdField_f_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, false);
            ReportManager.a().a("agent_authority", this.a.h, l1, l2, 0, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i);
            OpenSdkStatic.a().a(0, "LOGIN_AUTH", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, AuthorityActivity.jdField_f_of_type_JavaLangString, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
          }
          catch (Exception paramBundle)
          {
            LogUtility.c("AuthorityActivity", "-->success report exception cmd: agent_authority", paramBundle);
          }
        }
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt);
      }
      for (;;)
      {
        this.a.i = SystemClock.elapsedRealtime();
        LogUtility.c("Authority_TimeCost", "<TimeStamp> authority cost : " + (this.a.i - this.a.h));
        return;
        paramBundle = "1";
        break;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
        if ((paramInt == 1002) && (this.a.jdField_f_of_type_Int < 2))
        {
          paramBundle = this.a;
          paramBundle.jdField_f_of_type_Int += 1;
          this.a.k();
          return;
        }
        paramBundle = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3002;
        paramBundle.obj = this.a.getResources().getString(2131435603);
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
        paramBundle = this.a.getResources().getString(2131435603);
        try
        {
          ReportManager.a().a("agent_authority", this.a.h, 0L, 0L, paramInt, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString), "1000069", paramBundle);
          OpenSdkStatic.a().a(1, "LOGIN_AUTH", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, AuthorityActivity.jdField_f_of_type_JavaLangString, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, paramBundle);
          ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, "", AuthorityActivity.jdField_f_of_type_JavaLangString, "1", "6", "" + 3002, false);
        }
        catch (Exception paramBundle)
        {
          LogUtility.c("AuthorityActivity", "-->failed report exception cmd: agent_authority", paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alad
 * JD-Core Version:    0.7.0.1
 */