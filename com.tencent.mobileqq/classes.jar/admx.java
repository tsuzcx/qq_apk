import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.PhoneUnityVerifyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URLEncoder;

public class admx
  extends amcj
{
  public admx(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
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
        azqs.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
        bdgm.a(this.a, 230, this.a.getString(2131695166), this.a.getString(2131695165), null, this.a.getString(2131692210), new adnc(this), null).show();
      }
      return;
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.a.getString(2131695164);
    }
    QQToast.a(this.a, (CharSequence)localObject, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramBoolean)
    {
      bhuf localbhuf = this.a.jdField_a_of_type_Bhuf;
      if (localbhuf != null) {
        localbhuf.dismiss();
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
      PhoneUnityBindInfoActivity.a(this.a, 2131695065);
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.a(this.a);
    if (this.a.isFinishing()) {}
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
              break label587;
            }
            if (paramBundle == null) {
              break label551;
            }
            this.a.jdField_a_of_type_AndroidOsBundle = paramBundle;
            localObject = this.a;
            i = paramBundle.getInt("sso_result", -1);
            if (i != 66) {
              break;
            }
            if (this.a.jdField_a_of_type_Bdjz == null)
            {
              this.a.jdField_a_of_type_Bdjz = bdgm.a((Context)localObject, 230, alud.a(2131708436), "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, alud.a(2131708433), new admy(this), null);
              this.a.jdField_a_of_type_Bdjz.setOnCancelListener(new admz(this));
            }
            if ((this.a.jdField_a_of_type_Bdjz != null) && (!this.a.jdField_a_of_type_Bdjz.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.jdField_a_of_type_Bdjz.show();
              this.a.e = true;
            }
            paramBundle = this.a.jdField_a_of_type_Bhuf;
          } while (paramBundle == null);
          paramBundle.dismiss();
          return;
          if (i != 65) {
            break;
          }
          if (this.a.jdField_b_of_type_Bdjz == null)
          {
            this.a.jdField_b_of_type_Bdjz = bdgm.a((Context)localObject, 230, alud.a(2131708426), alud.a(2131708422), null, alud.a(2131708414), new adna(this), null);
            this.a.jdField_b_of_type_Bdjz.setOnCancelListener(new adnb(this));
          }
          if ((this.a.jdField_b_of_type_Bdjz != null) && (!this.a.jdField_b_of_type_Bdjz.isShowing()) && (!this.a.isFinishing()))
          {
            this.a.jdField_b_of_type_Bdjz.show();
            this.a.e = true;
          }
          paramBundle = this.a.jdField_a_of_type_Bhuf;
        } while (paramBundle == null);
        paramBundle.dismiss();
        return;
      } while (!paramBundle.containsKey("skip_url"));
      paramBundle = paramBundle.getString("skip_url");
    } while (TextUtils.isEmpty(paramBundle));
    paramBundle = new StringBuilder(paramBundle);
    paramBundle.append("?");
    paramBundle.append("type=" + aqaz.d);
    paramBundle.append("&plat=1");
    paramBundle.append("&app=1");
    paramBundle.append("&version=8.3.5.4555");
    paramBundle.append("&device=" + URLEncoder.encode(Build.DEVICE));
    paramBundle.append("&system=" + Build.VERSION.RELEASE);
    paramBundle.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    paramBundle = paramBundle.toString();
    Object localObject = new Intent(this.a, PhoneUnityVerifyActivity.class);
    ((Intent)localObject).putExtra("url", paramBundle);
    this.a.startActivityForResult((Intent)localObject, 1006);
    BaseActivity.sTopActivity.overridePendingTransition(2130771997, 0);
    return;
    label551:
    QQToast.a(this.a, this.a.getString(2131695149), 0).b(this.a.getTitleBarHeight());
    this.a.finish();
    return;
    label587:
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramBoolean)
    {
      localObject = this.a.jdField_a_of_type_Bhuf;
      if (localObject != null) {
        ((bhuf)localObject).dismiss();
      }
      azqs.b(this.a.app, "CliOper", "", "", "0X8005D0B", "0X8005D0B", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
    }
    PhoneUnityBindInfoActivity.a(this.a, alud.a(2131708416));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admx
 * JD-Core Version:    0.7.0.1
 */