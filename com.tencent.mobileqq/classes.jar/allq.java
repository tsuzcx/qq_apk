import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;

public class allq
  implements Runnable
{
  public allq(QidianManager paramQidianManager, BmqqAccountType paramBmqqAccountType) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentQidianQidianManager.a.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataBmqqAccountType);
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     allq
 * JD-Core Version:    0.7.0.1
 */