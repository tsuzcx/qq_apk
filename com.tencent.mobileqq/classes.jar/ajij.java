import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationShowNewEntryConfigController.1;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationShowNewEntryConfigController.2;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajij
  extends ajib
{
  private List<ajfo> a;
  
  public ajij(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private void c()
  {
    Object localObject1 = (aocd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, Recent need to create and add");
    }
    Object localObject2 = ((ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = bdzy.a().a();
      if (localObject2 != null)
      {
        long l = ((structmsg.StructMsg)localObject2).msg_time.get();
        ((aocd)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, anvx.a(2131691074), l, l);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, Recent be Added");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, structMsg is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty");
      }
      ((aocd)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty。 when deleteRecent");
  }
  
  private void c(aqxv paramaqxv)
  {
    if (QLog.isColorLevel())
    {
      if (paramaqxv != null) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, newConf = " + paramaqxv.toString());
      }
    }
    else
    {
      if ((paramaqxv != null) && (paramaqxv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label92;
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, call updateRecentUserListWhenNewEntryNotShow");
      }
    }
    label92:
    do
    {
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, newConf is null ");
      break;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, delete notification entry in recent");
      }
      ((aocd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART)).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      paramaqxv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (paramaqxv == null);
    paramaqxv.sendMessage(paramaqxv.obtainMessage(1009));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.1(this, paramInt));
  }
  
  public void a(ajfo paramajfo)
  {
    if (paramajfo != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramajfo);
    }
  }
  
  public void a(aqxv paramaqxv)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.2(this, paramaqxv));
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(ajfo paramajfo)
  {
    if (paramajfo != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramajfo);
    }
  }
  
  public void b(aqxv paramaqxv)
  {
    if (paramaqxv == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "INewTroopNotificationUnreadCountChangedListener, newConf = " + paramaqxv.toString());
    }
    a(paramaqxv);
    c(paramaqxv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajij
 * JD-Core Version:    0.7.0.1
 */