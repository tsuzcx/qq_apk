import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.NewIntent;

public class aicr
  implements Runnable
{
  public aicr(QZoneManagerImp paramQZoneManagerImp, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + QZoneNotifyServlet.c + ",config interval:" + QZoneHelper.a() + "difference: " + (l - QZoneNotifyServlet.c));
    }
    QQAppInterface localQQAppInterface;
    if (l - QZoneNotifyServlet.c > QZoneHelper.a())
    {
      localQQAppInterface = QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp);
      if ((localQQAppInterface != null) && (localQQAppInterface.getApplication() != null)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", this.jdField_a_of_type_Int);
      localNewIntent.putExtra("scene", 103);
      localQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicr
 * JD-Core Version:    0.7.0.1
 */