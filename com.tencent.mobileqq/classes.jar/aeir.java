import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class aeir
  implements Runnable
{
  public aeir(EmoticonManager paramEmoticonManager, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage)) {
      QLog.e("EmoticonManager", 1, "saveEmoticonPackage fail epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeir
 * JD-Core Version:    0.7.0.1
 */