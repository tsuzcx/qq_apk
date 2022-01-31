import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class aezr
  extends bceg
{
  aezr(aezp paramaezp, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    if ((paramLong == Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!aezp.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated.");
      }
      TroopInfo localTroopInfo = ((TroopManager)aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localTroopInfo == null) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
      }
      aezp.a(this.a).a(Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
    }
    label133:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!aezp.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.");
      }
      if (aezp.a(this.a) != null) {
        break label59;
      }
    }
    label58:
    label59:
    do
    {
      bcee localbcee;
      List localList;
      do
      {
        do
        {
          break label58;
          do
          {
            return;
          } while (aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          localbcee = aezp.a(this.a).a(Long.valueOf(Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
          if (localbcee == null) {
            break;
          }
          this.a.a(localbcee);
        } while (localbcee.a().size() <= 0);
        localList = localbcee.a();
      } while (System.currentTimeMillis() <= localbcee.b());
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.getTroopShortcutBarAppIdsRedPoint.");
      }
      aezp.a(this.a).a(Long.valueOf(paramLong), localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo. info is null. Will not update UI and redpoint.");
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!aezp.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetTroopAppidsRedPoint.");
      }
      bcee localbcee = aezp.a(this.a).a(Long.valueOf(Long.parseLong(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      this.a.a(localbcee);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezr
 * JD-Core Version:    0.7.0.1
 */