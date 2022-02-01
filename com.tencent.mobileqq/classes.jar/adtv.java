import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.Constants.LogoutReason;

public class adtv
{
  private anwo jdField_a_of_type_Anwo;
  public bisl a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  public QQCustomDialog a;
  
  public adtv(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Bisl != null)
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
    }
    if (this.jdField_a_of_type_Anwo != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.removeObserver(this.jdField_a_of_type_Anwo);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a;
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    HotChatManager localHotChatManager = localQQAppInterface.getHotChatMng(false);
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
        bdla.b(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
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
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
      if (this.jdField_a_of_type_Anwo == null) {
        this.jdField_a_of_type_Anwo = new adtw(this, localBaseActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = anwf.a(localHotChatManager.a(paramRecentUser.uin), new adtx(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
      return;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtv
 * JD-Core Version:    0.7.0.1
 */