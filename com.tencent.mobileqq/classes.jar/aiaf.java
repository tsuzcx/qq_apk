import android.content.Context;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aiaf
  implements Runnable
{
  public aiaf(ThemeSwitchManager paramThemeSwitchManager, Context paramContext, String paramString) {}
  
  public void run()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "漫游主题已更新", 4000).a();
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitchManager", 2, "setSkinTheme, QQToast.makeText: set sv theme id=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiaf
 * JD-Core Version:    0.7.0.1
 */