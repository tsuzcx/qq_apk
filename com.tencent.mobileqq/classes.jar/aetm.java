import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aetm
  extends anut
{
  public aetm(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a;
    RelativeLayout localRelativeLayout = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (paramInt == 0) {}
    for (int i = 1;; i = 3)
    {
      PhoneUnityBindInfoActivity.a((PhoneUnityBindInfoActivity)localObject, localRelativeLayout, i, 2);
      if (paramInt != 0)
      {
        if (paramInt != 39) {
          break;
        }
        bcst.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
        bglp.a(this.a, 230, this.a.getString(2131694209), this.a.getString(2131694208), null, this.a.getString(2131691829), new aetr(this), null).show();
      }
      return;
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.a.getString(2131694207);
    }
    QQToast.a(this.a, (CharSequence)localObject, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "onGetPhoneUnityInfo, success=" + paramBoolean);
    if (paramBoolean)
    {
      bkho localbkho = this.a.jdField_a_of_type_Bkho;
      if (localbkho != null) {
        localbkho.dismiss();
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
      PhoneUnityBindInfoActivity.a(this.a, 2131694142);
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, success=" + paramBoolean);
    PhoneUnityBindInfoActivity.a(this.a);
    if (this.a.isFinishing()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            if (paramBoolean) {
              break label456;
            }
            if (paramBundle == null) {
              break label420;
            }
            this.a.jdField_a_of_type_AndroidOsBundle = paramBundle;
            localObject = this.a;
            i = paramBundle.getInt("sso_result", -1);
            QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, fail, result=" + i);
            if (i != 66) {
              break;
            }
            if (this.a.jdField_a_of_type_Bgpa == null)
            {
              this.a.jdField_a_of_type_Bgpa = bglp.a((Context)localObject, 230, anni.a(2131706813), "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, anni.a(2131706810), new aetn(this), null);
              this.a.jdField_a_of_type_Bgpa.setOnCancelListener(new aeto(this));
            }
            if ((this.a.jdField_a_of_type_Bgpa != null) && (!this.a.jdField_a_of_type_Bgpa.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.jdField_a_of_type_Bgpa.show();
              this.a.e = true;
            }
            paramBundle = this.a.jdField_a_of_type_Bkho;
          } while (paramBundle == null);
          paramBundle.dismiss();
          return;
          if (i != 65) {
            break;
          }
          if (this.a.jdField_b_of_type_Bgpa == null)
          {
            this.a.jdField_b_of_type_Bgpa = bglp.a((Context)localObject, 230, anni.a(2131706803), anni.a(2131706799), null, anni.a(2131706791), new aetp(this), null);
            this.a.jdField_b_of_type_Bgpa.setOnCancelListener(new aetq(this));
          }
          if ((this.a.jdField_b_of_type_Bgpa != null) && (!this.a.jdField_b_of_type_Bgpa.isShowing()) && (!this.a.isFinishing()))
          {
            this.a.jdField_b_of_type_Bgpa.show();
            this.a.e = true;
          }
          paramBundle = this.a.jdField_a_of_type_Bkho;
        } while (paramBundle == null);
        paramBundle.dismiss();
        return;
      } while (!paramBundle.containsKey("skip_url"));
      paramBundle = paramBundle.getString("skip_url");
    } while (TextUtils.isEmpty(paramBundle));
    QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, startVerifyActivity");
    PhoneUnityBindInfoActivity.a(this.a, paramBundle);
    return;
    label420:
    QQToast.a(this.a, this.a.getString(2131694192), 0).b(this.a.getTitleBarHeight());
    this.a.finish();
    return;
    label456:
    if (paramBoolean)
    {
      localObject = this.a.jdField_a_of_type_Bkho;
      if (localObject != null) {
        ((bkho)localObject).dismiss();
      }
      bcst.b(this.a.app, "CliOper", "", "", "0X8005D0B", "0X8005D0B", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
    }
    PhoneUnityBindInfoActivity.b(this.a, anni.a(2131706793));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetm
 * JD-Core Version:    0.7.0.1
 */