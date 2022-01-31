import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.TimerCallback;

public class aikd
  extends CountDownTimer.CountDownTimerListener
{
  public aikd(CountdownTextView paramCountdownTextView, long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    super(paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView$TimerCallback.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikd
 * JD-Core Version:    0.7.0.1
 */