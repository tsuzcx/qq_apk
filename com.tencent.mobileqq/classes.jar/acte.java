import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import mqq.app.Constants.LogoutReason;

public class acte
{
  private aluu jdField_a_of_type_Aluu;
  public bdjz a;
  public bety a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  
  public acte(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
    }
    if (this.jdField_a_of_type_Aluu != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.removeObserver(this.jdField_a_of_type_Aluu);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a;
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    HotChatManager localHotChatManager = localQQAppInterface.a(false);
    HotChatInfo localHotChatInfo;
    if ((localHotChatManager != null) && (localHotChatManager.b(paramRecentUser.uin)))
    {
      localHotChatManager.a(paramRecentUser.uin);
      localHotChatInfo = localHotChatManager.a(paramRecentUser.uin);
      if (localHotChatInfo != null)
      {
        if (localHotChatInfo.state == 0) {
          break label114;
        }
        if (!localHotChatInfo.isWifiHotChat) {
          break label109;
        }
        i = 1;
        azqs.b(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
      }
    }
    label109:
    label114:
    while ((localHotChatInfo.adminLevel != 0) || ((localHotChatInfo.ownerUin != null) && (localHotChatInfo.ownerUin.equals(localQQAppInterface.getCurrentAccountUin())))) {
      for (;;)
      {
        return;
        i = 2;
      }
    }
    if (localHotChatInfo.isWifiHotChat) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
      if (this.jdField_a_of_type_Aluu == null) {
        this.jdField_a_of_type_Aluu = new actf(this, localBaseActivity);
      }
      this.jdField_a_of_type_Bdjz = alul.a(localHotChatManager.a(paramRecentUser.uin), new actg(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
      return;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acte
 * JD-Core Version:    0.7.0.1
 */