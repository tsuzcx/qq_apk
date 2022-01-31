import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;

public class adjz
  implements Runnable
{
  public adjz(ColorScreenManager paramColorScreenManager, int paramInt, VasManager.CompleteListener paramCompleteListener) {}
  
  public void run()
  {
    String str = "colorScreen.android." + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.b(str, this.jdField_a_of_type_ComTencentMobileqqVasVasManager$CompleteListener, null);
    ColorScreenConfig localColorScreenConfig = this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.a(this.jdField_a_of_type_Int);
    if (localColorScreenConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.a(this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.a(str, localColorScreenConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */