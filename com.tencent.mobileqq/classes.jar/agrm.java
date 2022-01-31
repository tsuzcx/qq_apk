import android.content.Intent;
import com.tencent.mobileqq.portal.RedPacketServlet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class agrm
  implements Runnable
{
  public agrm(RedPacketServlet paramRedPacketServlet, Intent paramIntent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketServlet.getAppRuntime().startServlet((NewIntent)this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrm
 * JD-Core Version:    0.7.0.1
 */