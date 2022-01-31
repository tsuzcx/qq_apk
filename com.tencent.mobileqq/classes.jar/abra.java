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
import java.net.URLEncoder;

public class abra
  extends akge
{
  public abra(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
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
        axqy.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
        bbdj.a(this.a, 230, this.a.getString(2131695007), this.a.getString(2131695006), null, this.a.getString(2131692139), new abrf(this), null).show();
      }
      return;
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.a.getString(2131695005);
    }
    bcql.a(this.a, (CharSequence)localObject, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramBoolean)
    {
      bfpc localbfpc = this.a.jdField_a_of_type_Bfpc;
      if (localbfpc != null) {
        localbfpc.dismiss();
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
      PhoneUnityBindInfoActivity.a(this.a, 2131694906);
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
            if (this.a.jdField_a_of_type_Bbgu == null)
            {
              this.a.jdField_a_of_type_Bbgu = bbdj.a((Context)localObject, 230, ajya.a(2131708052), "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, ajya.a(2131708049), new abrb(this), null);
              this.a.jdField_a_of_type_Bbgu.setOnCancelListener(new abrc(this));
            }
            if ((this.a.jdField_a_of_type_Bbgu != null) && (!this.a.jdField_a_of_type_Bbgu.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.jdField_a_of_type_Bbgu.show();
              this.a.e = true;
            }
            paramBundle = this.a.jdField_a_of_type_Bfpc;
          } while (paramBundle == null);
          paramBundle.dismiss();
          return;
          if (i != 65) {
            break;
          }
          if (this.a.jdField_b_of_type_Bbgu == null)
          {
            this.a.jdField_b_of_type_Bbgu = bbdj.a((Context)localObject, 230, ajya.a(2131708042), ajya.a(2131708038), null, ajya.a(2131708030), new abrd(this), null);
            this.a.jdField_b_of_type_Bbgu.setOnCancelListener(new abre(this));
          }
          if ((this.a.jdField_b_of_type_Bbgu != null) && (!this.a.jdField_b_of_type_Bbgu.isShowing()) && (!this.a.isFinishing()))
          {
            this.a.jdField_b_of_type_Bbgu.show();
            this.a.e = true;
          }
          paramBundle = this.a.jdField_a_of_type_Bfpc;
        } while (paramBundle == null);
        paramBundle.dismiss();
        return;
      } while (!paramBundle.containsKey("skip_url"));
      paramBundle = paramBundle.getString("skip_url");
    } while (TextUtils.isEmpty(paramBundle));
    paramBundle = new StringBuilder(paramBundle);
    paramBundle.append("?");
    paramBundle.append("type=" + aoeo.d);
    paramBundle.append("&plat=1");
    paramBundle.append("&app=1");
    paramBundle.append("&version=8.3.0.4480");
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
    bcql.a(this.a, this.a.getString(2131694990), 0).b(this.a.getTitleBarHeight());
    this.a.finish();
    return;
    label587:
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramBoolean)
    {
      localObject = this.a.jdField_a_of_type_Bfpc;
      if (localObject != null) {
        ((bfpc)localObject).dismiss();
      }
      axqy.b(this.a.app, "CliOper", "", "", "0X8005D0B", "0X8005D0B", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
    }
    PhoneUnityBindInfoActivity.a(this.a, ajya.a(2131708032));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abra
 * JD-Core Version:    0.7.0.1
 */