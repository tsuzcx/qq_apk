import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

public class acjc
  implements QQPermissionCallback
{
  public acjc(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.b(this.a.a());
    ((afgb)this.a.a(29)).b(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aexq.a().a(this.a.jdField_a_of_type_AndroidContentContext);
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
    aggx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjc
 * JD-Core Version:    0.7.0.1
 */