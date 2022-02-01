import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class agli
  implements agin
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agli(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void a()
  {
    awtn localawtn;
    if (this.jdField_a_of_type_Int > 0)
    {
      localawtn = (awtn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER);
      if (localawtn == null) {
        break label93;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
      {
      }
    }
    label93:
    while (!QLog.isColorLevel())
    {
      return;
      localawtn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, awtn.b);
      return;
      localawtn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, awtn.c);
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
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    a();
  }
  
  public int[] a()
  {
    return new int[] { 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agli
 * JD-Core Version:    0.7.0.1
 */