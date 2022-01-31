import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class abvl
  implements RadioGroup.OnCheckedChangeListener
{
  public abvl(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131364965) {
      DBFixConfigActivity.a = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().putInt(this.jdField_a_of_type_JavaLangString + DBFixManager.c, DBFixConfigActivity.a).commit();
      return;
      if (paramInt == 2131364966) {
        DBFixConfigActivity.a = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvl
 * JD-Core Version:    0.7.0.1
 */