import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import mqq.os.MqqHandler;

public class acex
  implements Runnable
{
  public acex(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, acfe paramacfe) {}
  
  public void run()
  {
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Acfe != null) {
      ThreadManager.getUIHandler().post(new acey(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */