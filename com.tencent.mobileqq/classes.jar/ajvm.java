import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public final class ajvm
  implements Runnable
{
  public ajvm(QQAppInterface paramQQAppInterface, TroopAIONotifyItem paramTroopAIONotifyItem) {}
  
  public void run()
  {
    try
    {
      try
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        int i = localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.getTableName(), "id=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.id });
        localEntityManager.a();
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.data", 2, "setNotifyItemReaded, id=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.id + ", ret=" + i);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.notify_feeds.data", 2, "setNotifyItemReaded, exp:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvm
 * JD-Core Version:    0.7.0.1
 */