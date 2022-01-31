import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import mqq.os.MqqHandler;

public class abxv
  implements Runnable
{
  public abxv(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, abyc paramabyc) {}
  
  public void run()
  {
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Abyc != null) {
      ThreadManager.getUIHandler().post(new abxw(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxv
 * JD-Core Version:    0.7.0.1
 */