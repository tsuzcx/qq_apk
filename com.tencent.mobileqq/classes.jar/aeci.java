import android.os.Bundle;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class aeci
  extends aodj
{
  public aeci(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SecSvcObserver", 2, "onGetPhoneUnityInfo isSuc: " + paramBoolean);
    }
    String str;
    if ((this.a.isResume()) && (paramBundle != null))
    {
      str = paramBundle.getString("phone");
      paramBundle = paramBundle.getString("mibao_set_url");
      if (!StringUtil.isEmpty(str)) {
        break label78;
      }
    }
    label78:
    for (int i = 1;; i = 0)
    {
      bdvn.a(i, str, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeci
 * JD-Core Version:    0.7.0.1
 */