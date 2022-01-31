import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class ajly
  implements Runnable
{
  public ajly(HbThemeConfigManager paramHbThemeConfigManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config: " + this.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "hbThemeConfig.cfg", Base64.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajly
 * JD-Core Version:    0.7.0.1
 */