import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class afcv
  extends aohf
{
  public afcv(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(null);
    if (paramInt != 0) {
      if (paramInt == 39)
      {
        bhlq.a(this.a, 230, this.a.getString(2131694249), this.a.getString(2131694252), null, this.a.getString(2131691833), new afcw(this), null).show();
        PhoneUnityBindInfoActivity.a(this.a).a = false;
        PhoneUnityBindInfoActivity.a(this.a).setChecked(false);
        bdll.b(this.a.app, "dc00898", "", "", "0X800B320", "0X800B320", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131694232);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcObserver", 4, "bindPhoneNumLogin fail retCode: " + paramInt);
      }
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      break;
      PhoneUnityBindInfoActivity.a(this.a).a = true;
      PhoneUnityBindInfoActivity.a(this.a).setChecked(true);
      bdll.b(this.a.app, "dc00898", "", "", "0X800B31E", "0X800B31E", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo, success=" + paramBoolean);
    if (paramBoolean)
    {
      blir localblir = this.a.a;
      if (localblir != null) {
        localblir.dismiss();
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle);
      return;
      PhoneUnityBindInfoActivity.a(this.a, 2131694160);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    PhoneUnityBindInfoActivity.b(this.a).setOnCheckedChangeListener(null);
    if (paramBoolean2)
    {
      PhoneUnityBindInfoActivity.b(this.a).setChecked(paramBoolean1);
      PhoneUnityBindInfoActivity.a(this.a).c = paramBoolean1;
      PhoneUnityBindInfoActivity.a(this.a).b = paramBoolean1;
      if (paramBoolean1) {
        bdll.b(this.a.app, "dc00898", "", "", "0X800B31A", "0X800B31A", 0, 0, "", "", "", "");
      }
      PhoneUnityBindInfoActivity.b(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    Object localObject = PhoneUnityBindInfoActivity.b(this.a);
    if (!paramBoolean1)
    {
      paramBoolean2 = true;
      label114:
      ((FormSwitchItem)localObject).setChecked(paramBoolean2);
      localObject = PhoneUnityBindInfoActivity.a(this.a);
      if (paramBoolean1) {
        break label183;
      }
    }
    label183:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      ((ajnh)localObject).b = paramBoolean2;
      if (!paramBoolean1) {
        break;
      }
      bdll.b(this.a.app, "dc00898", "", "", "0X800B31B", "0X800B31B", 0, 0, "", "", "", "");
      break;
      paramBoolean2 = false;
      break label114;
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(null);
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramInt == 0)
    {
      PhoneUnityBindInfoActivity.a(this.a).setChecked(false);
      PhoneUnityBindInfoActivity.a(this.a).a = false;
      bdll.b(this.a.app, "dc00898", "", "", "0X800B31F", "0X800B31F", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(this.a);
      PhoneUnityBindInfoActivity.c(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "UnbindPhoneNumLogin error " + paramInt + " errMsg: " + paramString);
    }
    if (!PhoneUnityBindInfoActivity.a(this.a))
    {
      if (paramInt != 36) {
        break label220;
      }
      PhoneUnityBindInfoActivity.b(this.a);
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a).setChecked(true);
      PhoneUnityBindInfoActivity.a(this.a).a = true;
      bdll.b(this.a.app, "dc00898", "", "", "0X800B321", "0X800B321", 0, 0, "", "", "", "");
      break;
      label220:
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131694247);
      }
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcv
 * JD-Core Version:    0.7.0.1
 */