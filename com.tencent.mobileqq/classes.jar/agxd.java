import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class agxd
  implements agvc
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agxd(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a()
  {
    axab localaxab;
    if (this.jdField_a_of_type_Int > 0)
    {
      localaxab = (axab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(308);
      if (localaxab == null) {
        break label93;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    label93:
    while (!QLog.isColorLevel())
    {
      return;
      localaxab.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, axab.b);
      return;
      localaxab.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, axab.c);
      return;
    }
    QLog.d("UnreadCountHelper", 2, "PushNotificationManager is null");
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a();
  }
  
  public int[] a()
  {
    return new int[] { 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxd
 * JD-Core Version:    0.7.0.1
 */