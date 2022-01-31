import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afuy
  implements acxg
{
  private afuz jdField_a_of_type_Afuz;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  
  public afuy(afuz paramafuz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramafuz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramafuz.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Afuz = paramafuz;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramafuz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a(int paramInt)
  {
    QLog.i("MiniMultiForwardHelper", 2, "RESUME onMoveToState：=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = BaseChatItemLayout.jdField_a_of_type_Boolean;
      BaseChatItemLayout.jdField_a_of_type_Boolean = false;
      QLog.i("MiniMultiForwardHelper", 2, "RESUME mPreCheckBoxVisibleStat：=" + this.jdField_a_of_type_Boolean + "  BaseChatItemLayout.CheckBoxVisible :" + BaseChatItemLayout.jdField_a_of_type_Boolean);
      return;
    }
    BaseChatItemLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    QLog.i("MiniMultiForwardHelper", 2, "RESUME mPreCheckBoxVisibleStat：=" + this.jdField_a_of_type_Boolean + "  BaseChatItemLayout.CheckBoxVisible :" + BaseChatItemLayout.jdField_a_of_type_Boolean);
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 8, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuy
 * JD-Core Version:    0.7.0.1
 */