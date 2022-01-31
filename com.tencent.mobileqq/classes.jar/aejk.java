import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.model.pluginactions.CampusCirclePluginAction;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class aejk
  implements Runnable
{
  public aejk(CampusCirclePluginAction paramCampusCirclePluginAction, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    RedTouchItem localRedTouchItem1 = localLocalRedTouchManager.a(10017);
    RedTouchItem localRedTouchItem2 = localLocalRedTouchManager.a(103421);
    if ((localLocalRedTouchManager.a(localRedTouchItem2)) && (localRedTouchItem2.redtouchType == 1)) {
      localLocalRedTouchManager.a(103421);
    }
    if (localLocalRedTouchManager.a(localRedTouchItem1)) {
      localLocalRedTouchManager.a(10017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejk
 * JD-Core Version:    0.7.0.1
 */