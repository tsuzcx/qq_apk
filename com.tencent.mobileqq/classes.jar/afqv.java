import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class afqv
  implements afrc
{
  public ahps a;
  private ahqs jdField_a_of_type_Ahqs;
  public behu a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public afqv(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.sessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.mActivity;
  }
  
  private void b()
  {
    int j = 1;
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    }
    int i;
    TroopManager localTroopManager;
    TroopInfo localTroopInfo;
    if (localObject != null)
    {
      Boolean localBoolean = Boolean.valueOf(((Intent)localObject).getBooleanExtra("isFromContactTab", false));
      int k = ((Intent)localObject).getIntExtra("aio_msg_source", -1);
      i = j;
      if (k != 0)
      {
        i = j;
        if (k != 1)
        {
          if (!localBoolean.booleanValue()) {
            break label236;
          }
          i = j;
        }
      }
      if (i != 0)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        if (localObject != null)
        {
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localTroopInfo = localTroopManager.b((String)localObject);
          if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject)) && (localTroopInfo.isNotSetTroopClassInfo()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
          {
            i = localTroopManager.a((String)localObject);
            if (i < 3)
            {
              if (!localBoolean.booleanValue()) {
                break label241;
              }
              beyy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, beyy.b);
            }
          }
        }
      }
    }
    for (;;)
    {
      localTroopManager.a((String)localObject, i + 1);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_edu", "", "Grp_data", "classinfo_Clk", 0, 0, localTroopInfo.troopuin, "", "", "");
      return;
      label236:
      i = 0;
      break;
      label241:
      beyy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, beyy.a);
    }
  }
  
  public void a()
  {
    TroopInfo localTroopInfo = null;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager != null) {
      localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    if (this.jdField_a_of_type_Behu == null) {
      this.jdField_a_of_type_Behu = ((behu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(289));
    }
    if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (localTroopInfo.isNotSetTroopClassInfo())) {
      if (this.jdField_a_of_type_Behu != null)
      {
        this.jdField_a_of_type_Behu.a = this.jdField_a_of_type_Behu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        if ((this.jdField_a_of_type_Behu.a instanceof beqp)) {
          ((beqp)this.jdField_a_of_type_Behu.a).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ahps == null);
      if (QLog.isColorLevel()) {
        QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopClassInfoChangedReceiver dismissTipsBar.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) {
        this.jdField_a_of_type_Ahqs = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
      }
    } while (this.jdField_a_of_type_Ahqs == null);
    this.jdField_a_of_type_Ahps.a(this.jdField_a_of_type_Ahqs, false);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 6: 
      a();
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 3, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqv
 * JD-Core Version:    0.7.0.1
 */