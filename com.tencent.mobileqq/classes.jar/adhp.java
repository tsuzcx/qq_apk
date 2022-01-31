import android.os.Handler;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;

public class adhp
  implements Runnable
{
  public adhp(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void run()
  {
    if (this.a.b())
    {
      this.a.e();
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhp
 * JD-Core Version:    0.7.0.1
 */