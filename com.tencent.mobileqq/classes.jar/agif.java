import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class agif
  implements agin
{
  public aikr a;
  private ailr jdField_a_of_type_Ailr;
  private aofu jdField_a_of_type_Aofu = new agig(this);
  public bfox a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agif(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.sessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.mActivity;
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin))) {
      return;
    }
    a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    c();
  }
  
  private void c()
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
            break label237;
          }
          i = j;
        }
      }
      if (i != 0)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        if (localObject != null)
        {
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          localTroopInfo = localTroopManager.b((String)localObject);
          if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject)) && (localTroopInfo.isNotSetTroopClassInfo()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
          {
            i = localTroopManager.a((String)localObject);
            if (i < 3)
            {
              if (!localBoolean.booleanValue()) {
                break label242;
              }
              bghd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, bghd.b);
            }
          }
        }
      }
    }
    for (;;)
    {
      localTroopManager.a((String)localObject, i + 1);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_edu", "", "Grp_data", "classinfo_Clk", 0, 0, localTroopInfo.troopuin, "", "", "");
      return;
      label237:
      i = 0;
      break;
      label242:
      bghd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, bghd.a);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {}
    do
    {
      do
      {
        do
        {
          TroopInfo localTroopInfo;
          do
          {
            return;
            localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          } while (localTroopInfo == null);
          if (this.jdField_a_of_type_Bfox == null) {
            this.jdField_a_of_type_Bfox = ((bfox)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
          }
          if ((!localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (!localTroopInfo.isNotSetTroopClassInfo()) || (this.jdField_a_of_type_Bfox == null)) {
            break;
          }
          this.jdField_a_of_type_Bfox.a = this.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        } while (!(this.jdField_a_of_type_Bfox.a instanceof bfxr));
        ((bfxr)this.jdField_a_of_type_Bfox.a).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
        return;
      } while (this.jdField_a_of_type_Aikr == null);
      if (QLog.isColorLevel()) {
        QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopClassInfoChangedReceiver dismissTipsBar.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) {
        this.jdField_a_of_type_Ailr = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
      }
    } while (this.jdField_a_of_type_Ailr == null);
    this.jdField_a_of_type_Aikr.a(this.jdField_a_of_type_Ailr, false);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      a();
      return;
    case 4: 
      b();
      return;
    }
    d();
  }
  
  public int[] a()
  {
    return new int[] { 4, 7, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agif
 * JD-Core Version:    0.7.0.1
 */