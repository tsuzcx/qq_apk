import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aboo
  implements CompoundButton.OnCheckedChangeListener
{
  public aboo(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    CacheConstants.b = paramBoolean;
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(CacheConstants.a, 0).edit().putBoolean(CacheConstants.c, paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aboo
 * JD-Core Version:    0.7.0.1
 */