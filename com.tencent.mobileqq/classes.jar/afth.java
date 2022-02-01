import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afth
  implements afrc
{
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  nqt jdField_a_of_type_Nqt;
  nqw jdField_a_of_type_Nqw = new afti(this);
  
  public afth(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app != null)) {
      this.jdField_a_of_type_Nqt = new nqt(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a();
      return;
    case 7: 
      b();
      return;
    }
    c();
  }
  
  public int[] a()
  {
    return new int[] { 3, 7, 13 };
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
      if (this.jdField_a_of_type_Nqt == null) {
        break;
      }
      this.jdField_a_of_type_Nqt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, this.jdField_a_of_type_Nqw, true);
      return;
    }
    label110:
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
    }
    bezz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
    ((beua)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(355)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Nqt != null)
    {
      this.jdField_a_of_type_Nqt.a();
      this.jdField_a_of_type_Nqt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afth
 * JD-Core Version:    0.7.0.1
 */