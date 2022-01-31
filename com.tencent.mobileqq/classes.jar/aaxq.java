import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import mqq.app.Constants.LogoutReason;

public class aaxq
{
  private ajyr jdField_a_of_type_Ajyr;
  public bbgu a;
  public bcqf a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  
  public aaxq(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
    }
    if (this.jdField_a_of_type_Ajyr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.removeObserver(this.jdField_a_of_type_Ajyr);
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
        axqy.b(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
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
      axqy.b(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
      if (this.jdField_a_of_type_Ajyr == null) {
        this.jdField_a_of_type_Ajyr = new aaxr(this, localBaseActivity);
      }
      this.jdField_a_of_type_Bbgu = ajyi.a(localHotChatManager.a(paramRecentUser.uin), new aaxs(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
      return;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxq
 * JD-Core Version:    0.7.0.1
 */