import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

public class aadv
  implements QQPermissionCallback
{
  public aadv(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    babr.b(this.a.a());
    ((acyf)this.a.a(29)).b(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
    aduw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aadv
 * JD-Core Version:    0.7.0.1
 */