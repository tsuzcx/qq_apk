import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class adhp
  extends bafg
{
  adhp(adho paramadho, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    if ((paramLong == Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!adho.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated.");
      }
      TroopInfo localTroopInfo = ((TroopManager)adho.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localTroopInfo == null) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
      }
      adho.a(this.a).a(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
    }
    label133:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!adho.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.");
      }
      if (adho.a(this.a) != null) {
        break label59;
      }
    }
    label58:
    label59:
    do
    {
      bafe localbafe;
      List localList;
      do
      {
        do
        {
          break label58;
          do
          {
            return;
          } while (adho.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          localbafe = adho.a(this.a).a(Long.valueOf(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
          if (localbafe == null) {
            break;
          }
          this.a.a(localbafe);
        } while (localbafe.a().size() <= 0);
        localList = localbafe.a();
      } while (System.currentTimeMillis() <= localbafe.b());
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.getTroopShortcutBarAppIdsRedPoint.");
      }
      adho.a(this.a).a(Long.valueOf(paramLong), localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo. info is null. Will not update UI and redpoint.");
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!adho.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetTroopAppidsRedPoint.");
      }
      bafe localbafe = adho.a(this.a).a(Long.valueOf(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      this.a.a(localbafe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhp
 * JD-Core Version:    0.7.0.1
 */