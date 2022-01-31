import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abxu
  implements QueryCallback
{
  public abxu(EmoticonMainPanel paramEmoticonMainPanel, long paramLong) {}
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b(paramInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c(paramInteger.intValue());
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d)) {
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList.size() > EmoticonMainPanel.e)
    {
      if (((EmotionPanelInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList.get(EmoticonMainPanel.e)).a != 8) {
        EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.h);
      }
      return;
    }
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxu
 * JD-Core Version:    0.7.0.1
 */