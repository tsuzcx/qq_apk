import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

abstract class akhk
{
  protected final SharedPreferences a = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 0);
  
  protected abstract String a();
  
  protected void a()
  {
    this.a.edit().putBoolean(a(), true).commit();
  }
  
  protected boolean a()
  {
    return !this.a.contains(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhk
 * JD-Core Version:    0.7.0.1
 */