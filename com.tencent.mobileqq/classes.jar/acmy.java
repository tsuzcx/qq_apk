import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import mqq.os.MqqHandler;

public class acmy
  implements Runnable
{
  public acmy(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, acnf paramacnf) {}
  
  public void run()
  {
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Acnf != null) {
      ThreadManager.getUIHandler().post(new acmz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmy
 * JD-Core Version:    0.7.0.1
 */