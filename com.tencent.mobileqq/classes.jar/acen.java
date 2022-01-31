import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

public class acen
  implements QQPermissionCallback
{
  public acen(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a.a());
    ((afbm)this.a.a(29)).b(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aetb.a().a(this.a.jdField_a_of_type_AndroidContentContext);
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
    agci.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acen
 * JD-Core Version:    0.7.0.1
 */