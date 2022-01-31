import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class achd
  implements Runnable
{
  public achd(EmoticonFromGroupDBManager paramEmoticonFromGroupDBManager, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation start. opType: " + this.jdField_a_of_type_Int);
    }
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a != null)
    {
      localObject3 = null;
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a.a();
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        localEntityTransaction.a();
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      catch (Exception localException)
      {
        EntityTransaction localEntityTransaction;
        localObject3 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject1;
        QLog.e("EmoticonFromGroup_DBManager", 2, "write2DB ex=", localException);
        if (localObject1 == null) {
          continue;
        }
        localObject1.b();
        continue;
        localObject1 = localException;
        localObject3 = localException;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        localObject1 = localException;
        localObject3 = localException;
        if (!localIterator.hasNext()) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localIterator.next();
        localObject1 = localException;
        localObject3 = localException;
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a.b(localEmoticonFromGroupEntity)) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        if (localEmoticonFromGroupEntity.getStatus() == 1000) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "remove error, e.md5=" + localEmoticonFromGroupEntity.md5);
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        localObject3.b();
      }
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end.");
      }
      return;
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      if (localIterator.hasNext())
      {
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localIterator.next();
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        if (!this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupDBManager.a(localEmoticonFromGroupEntity))
        {
          localObject1 = localEntityTransaction;
          localObject3 = localEntityTransaction;
          if (QLog.isColorLevel())
          {
            localObject1 = localEntityTransaction;
            localObject3 = localEntityTransaction;
            QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + localEmoticonFromGroupEntity.md5);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */