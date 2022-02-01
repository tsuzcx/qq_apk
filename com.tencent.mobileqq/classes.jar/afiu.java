import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class afiu
  extends aohf
{
  public afiu(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SecSvcObserver", 2, String.format(Locale.getDefault(), "onGetPhoneUnityLocalData data: %s, create: %s, count: %s", new Object[] { paramObject, Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    }
    boolean bool1;
    if (paramObject == null)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if ((paramObject instanceof ajnf)) {
          bool2 = ((ajnf)paramObject).b;
        }
      }
      paramObject = this.a.findViewById(2131374536);
      if (paramObject != null)
      {
        if (!bool2) {
          break label190;
        }
        paramObject.setVisibility(0);
        if (!this.a.jdField_a_of_type_Boolean) {
          break label138;
        }
        this.a.a(true);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label138:
      if (this.a.jdField_a_of_type_Int == 0)
      {
        this.a.a(false);
      }
      else
      {
        paramObject = (ajng)this.a.app.getManager(102);
        QQSettingSettingActivity.a(this.a, true, paramObject.a);
        continue;
        label190:
        paramObject.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      if (paramBoolean)
      {
        paramString = this.a;
        if (paramInt == 1) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          QQSettingSettingActivity.a(paramString, paramBoolean);
          return;
        }
      }
    } while (!this.a.isResume());
    paramString = this.a.getString(2131691848);
    QQToast.a(this.a.getApplicationContext(), paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SecSvcObserver", 2, "onGetPhoneUnityInfo isSuc: " + paramBoolean);
    }
    if (this.a.isFinishing()) {}
    do
    {
      return;
      QQSettingSettingActivity.a(this.a, paramBoolean, paramBundle);
    } while (!this.a.isResume());
    paramBundle = this.a;
    paramBundle.jdField_a_of_type_Int -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afiu
 * JD-Core Version:    0.7.0.1
 */