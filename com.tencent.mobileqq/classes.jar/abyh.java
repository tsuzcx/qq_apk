import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class abyh
  implements Runnable
{
  public abyh(DoutuManager paramDoutuManager, DoutuItem paramDoutuItem, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetShanMeng item:" + this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      NewIntent localNewIntent = new NewIntent(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getApp(), DoutuServlet.class);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getCurrentAccountUin()).longValue());
        localNewIntent.putExtra("KEY_UUID", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localNewIntent.putExtra("KEY_CMD", 3);
        localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.b);
        localNewIntent.putExtra("KEY_SESSION_TYPE", i);
        localNewIntent.putExtra("key_url", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.c);
        localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
        if (DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager) == null)
        {
          Object localObject = (FriendsManager)DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getManager(50);
          if (localObject != null)
          {
            localObject = ((FriendsManager)localObject).a(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getCurrentAccountUin());
            if (localObject != null) {
              DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager, (Card)localObject);
            }
          }
        }
        if (DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager) != null)
        {
          localNewIntent.putExtra("key_gender", DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).shGender);
          localNewIntent.putExtra("KEY_AGE", DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).age);
        }
        DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).startServlet(localNewIntent);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
          break label393;
        }
        i = 2;
        break;
        localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        localNewIntent.putExtra("KEY_UUID", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.jdField_a_of_type_Long));
      }
      label393:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyh
 * JD-Core Version:    0.7.0.1
 */