import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;

public class afnt
  extends afnn
{
  private TroopAppShortcutContainer jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
  private boolean jdField_a_of_type_Boolean;
  
  public afnt(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void a(String paramString)
  {
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
      c(false);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    aftb localaftb = (aftb)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(55);
    if (localaftb != null) {
      localaftb.e();
    }
    agwr.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer = new afnu(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin(), 1);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a() == null) {}
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) && (a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      return true;
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a(paramInt);
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened", new Object[0]));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.b();
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.c();
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) && (bfaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))))
      {
        bety localbety = (bety)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(171);
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject == null) {
          return;
        }
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        if ((localObject != null) && (localbety != null))
        {
          localbety.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin), (int)((TroopInfo)localObject).dwGroupClassExt, null);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("parseLong Exception", new Object[0]));
      }
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.g();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnt
 * JD-Core Version:    0.7.0.1
 */