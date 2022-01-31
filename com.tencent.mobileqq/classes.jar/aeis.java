import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class aeis
  implements Runnable
{
  public aeis(EmoticonManager paramEmoticonManager, Emoticon paramEmoticon) {}
  
  public void run()
  {
    EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    if (!EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon)) {
      QLog.e("EmoticonManager", 1, "saveEmoticon fail epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ", eId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeis
 * JD-Core Version:    0.7.0.1
 */