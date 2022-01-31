import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

public class aanl
  implements QQPermissionCallback
{
  public aanl(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.b(this.a.a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
    aeft.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aanl
 * JD-Core Version:    0.7.0.1
 */