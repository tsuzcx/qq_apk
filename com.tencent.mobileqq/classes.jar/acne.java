import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acne
  implements Runnable
{
  public acne(EmoticonMainPanel paramEmoticonMainPanel, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b.add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.j = false;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "refresh magic emoji.");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acne
 * JD-Core Version:    0.7.0.1
 */