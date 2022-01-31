import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;

public class ajwb
  implements Runnable
{
  public ajwb(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    ((SportManager)this.a.a.getManager(259)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajwb
 * JD-Core Version:    0.7.0.1
 */