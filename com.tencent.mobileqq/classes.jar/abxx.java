import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abxx
  implements abyc
{
  public abxx(EmoticonMainPanel paramEmoticonMainPanel, int paramInt, long paramLong) {}
  
  public void a()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "switchTabMode mMarketPgkDownloaded = true");
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.size() > 0)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.size() <= EmoticonMainPanel.e) || (((EmotionPanelInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.get(EmoticonMainPanel.e)).jdField_a_of_type_Int != 8)) {
            break label149;
          }
          i = 1;
          if (i == 0) {
            break label159;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.size() < 4) {
            break label154;
          }
          i = 3;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g = false;
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_Long, i);
      return;
      label149:
      i = 0;
      break;
      label154:
      i = 0;
      continue;
      label159:
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.size() >= 3) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxx
 * JD-Core Version:    0.7.0.1
 */