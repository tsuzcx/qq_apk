import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;

public class aeni
  implements Runnable
{
  public aeni(DraftTextManager paramDraftTextManager, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
      localEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeni
 * JD-Core Version:    0.7.0.1
 */