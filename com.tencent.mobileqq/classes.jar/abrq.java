import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class abrq
  extends akge
{
  public abrq(PhoneUnityPhoneLoginActivity paramPhoneUnityPhoneLoginActivity) {}
  
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
      axqy.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
      bbdj.a(this.a, 230, this.a.getString(2131695007), this.a.getString(2131695006), null, this.a.getString(2131692139), new abrr(this), null).show();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getString(2131695005);
    }
    bcql.a(this.a, str, 0).b(this.a.getTitleBarHeight());
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
      str = this.a.getString(2131695011);
    }
    for (;;)
    {
      bcql.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      return;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131695010);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abrq
 * JD-Core Version:    0.7.0.1
 */