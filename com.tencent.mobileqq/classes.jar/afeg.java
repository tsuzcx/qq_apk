import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afeg
  extends bcip
{
  afeg(afee paramafee, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    if ((paramLong == Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!afee.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated.");
      }
      TroopInfo localTroopInfo = ((TroopManager)afee.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localTroopInfo == null) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
      }
      afee.a(this.a).a(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
    }
    label133:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!afee.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.");
      }
      if (afee.a(this.a) != null) {
        break label59;
      }
    }
    label58:
    label59:
    do
    {
      bcin localbcin;
      List localList;
      do
      {
        do
        {
          break label58;
          do
          {
            return;
          } while (afee.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          localbcin = afee.a(this.a).a(Long.valueOf(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
          if (localbcin == null) {
            break;
          }
          this.a.a(localbcin);
        } while (localbcin.a().size() <= 0);
        localList = localbcin.a();
      } while (System.currentTimeMillis() <= localbcin.b());
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.getTroopShortcutBarAppIdsRedPoint.");
      }
      afee.a(this.a).a(Long.valueOf(paramLong), localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo. info is null. Will not update UI and redpoint.");
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!afee.a(this.a).N))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetTroopAppidsRedPoint.");
      }
      bcin localbcin = afee.a(this.a).a(Long.valueOf(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      this.a.a(localbcin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afeg
 * JD-Core Version:    0.7.0.1
 */