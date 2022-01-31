import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

public class aeqk
  implements Runnable
{
  public aeqk(EmoticonManager paramEmoticonManager) {}
  
  public void run()
  {
    String str;
    synchronized (this.a)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class.getSimpleName());
      EntityTransaction localEntityTransaction = this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        Iterator localIterator1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          EmoticonManager.a(this.a, str, true, false);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
    Iterator localIterator2 = this.a.b.iterator();
    while (localIterator2.hasNext())
    {
      str = (String)localIterator2.next();
      EmoticonManager.a(this.a, str, false, true);
    }
    localObject1.c();
    localObject1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqk
 * JD-Core Version:    0.7.0.1
 */