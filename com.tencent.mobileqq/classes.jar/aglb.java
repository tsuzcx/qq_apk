import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class aglb
  implements agin
{
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  nxu jdField_a_of_type_Nxu;
  nxx jdField_a_of_type_Nxx = new aglc(this);
  
  public aglb(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app != null)) {
      this.jdField_a_of_type_Nxu = new nxu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    case 8: 
      b();
      return;
    }
    c();
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 14 };
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo == null)) {
      return;
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getCurrentAccountUin()) == null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
      }
      if (this.jdField_a_of_type_Nxu == null) {
        break;
      }
      this.jdField_a_of_type_Nxu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, this.jdField_a_of_type_Nxx, true);
      return;
    }
    label110:
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
    }
    bgif.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
    ((bgbg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Nxu != null)
    {
      this.jdField_a_of_type_Nxu.a();
      this.jdField_a_of_type_Nxu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */