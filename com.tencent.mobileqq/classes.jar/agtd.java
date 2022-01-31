import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordTextView;

public class agtd
  implements Runnable
{
  public agtd(LSRecordPanel paramLSRecordPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.b(i);
    LSRecordPanel.a(this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtd
 * JD-Core Version:    0.7.0.1
 */