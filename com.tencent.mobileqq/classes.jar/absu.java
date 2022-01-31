import com.qq.im.poi.LbsPackConfig;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.qphone.base.util.QLog;

public class absu
  implements Runnable
{
  public absu(ConfigServlet paramConfigServlet, LbsPackConfig paramLbsPackConfig, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleLbsPackConfig ,excute runnable");
    }
    if (this.jdField_a_of_type_ComQqImPoiLbsPackConfig != null) {
      this.jdField_a_of_type_ComQqImPoiLbsPackConfig.saveToFile(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     absu
 * JD-Core Version:    0.7.0.1
 */