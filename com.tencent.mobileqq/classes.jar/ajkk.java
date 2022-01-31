import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ajkk
{
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  private boolean jdField_a_of_type_Boolean;
  
  public DrawerPushItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ApolloAioBubblePush.1(this, paramQQAppInterface), 8, null, true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAioBubblePush", 2, "DO NOT show bubble, maybe item is null, item:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      }
    }
    ajeq localajeq;
    do
    {
      do
      {
        return false;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloAioBubblePush", 2, "DO NOT show bubble cause it has been showed.");
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_type == 4) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id)))
      {
        paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAioBubblePush", 2, "[onShowBubble] parseGameReddot mPushItem.msg_id has show:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
        }
      }
      QLog.i("ApolloAioBubblePush", 1, "Show bubble, id:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
      localajeq = ajfh.a(paramQQAppInterface);
    } while (localajeq == null);
    localajeq.a("", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content);
    this.jdField_a_of_type_Boolean = true;
    b(paramQQAppInterface);
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(paramInt), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
    return true;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (paramQQAppInterface == null)) {}
    do
    {
      return;
      paramQQAppInterface = (airx)paramQQAppInterface.getManager(153);
    } while (!this.jdField_a_of_type_Boolean);
    DrawerPushItem localDrawerPushItem = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    localDrawerPushItem.show_sum += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum == this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)
    {
      QLog.i("ApolloAioBubblePush", 1, "remove item from db, id:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    QLog.i("ApolloAioBubblePush", 1, "update item from db" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkk
 * JD-Core Version:    0.7.0.1
 */