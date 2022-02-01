import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class agho
  implements agin
{
  public aikf a;
  aofu jdField_a_of_type_Aofu = new aghp(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agho(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.sessionInfo;
  }
  
  private void b()
  {
    a();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (a()))
    {
      if (this.jdField_a_of_type_Aikf == null) {
        this.jdField_a_of_type_Aikf = new aikf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if ((!this.jdField_a_of_type_Aikf.a((ailr)localObject)) && (this.jdField_a_of_type_Aikf.a((ailr)localObject, true)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        i = ((SharedPreferences)localObject).getInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0);
        ((SharedPreferences)localObject).edit().putInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i + 1).apply();
      }
    }
    while (this.jdField_a_of_type_Aikf == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Aikf.a((ailr)localObject, false);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      c();
      return;
    case 7: 
      b();
      return;
    }
    d();
  }
  
  public boolean a()
  {
    bacq localbacq = (bacq)aqxe.a().a(701);
    if ((localbacq == null) || (!localbacq.c())) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!((awio)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(33)).c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
        return false;
        if (!((ailk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(75)).d()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!b()));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0) < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 7, 14 };
  }
  
  public boolean b()
  {
    if (bdvn.a()) {}
    for (;;)
    {
      return false;
      Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (localObject != null)) {}
      for (localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin); (localObject != null) && (((TroopInfo)localObject).isFansTroop()) && (((TroopInfo)localObject).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); localObject = null)
      {
        if (((TroopInfo)localObject).getFansTroopStarId() == 0) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agho
 * JD-Core Version:    0.7.0.1
 */