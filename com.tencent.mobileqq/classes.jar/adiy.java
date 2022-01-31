import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class adiy
  extends alxu
{
  public adiy(PhoneUnityPhoneLoginActivity paramPhoneUnityPhoneLoginActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(true);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    if (paramInt == 39)
    {
      azmj.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
      bdcd.a(this.a, 230, this.a.getString(2131695164), this.a.getString(2131695163), null, this.a.getString(2131692209), new adiz(this), null).show();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getString(2131695162);
    }
    QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(false);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    String str;
    if (paramInt == 36) {
      str = this.a.getString(2131695168);
    }
    for (;;)
    {
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      return;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131695167);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adiy
 * JD-Core Version:    0.7.0.1
 */