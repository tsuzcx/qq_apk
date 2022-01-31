import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aeiq
  implements Runnable
{
  public aeiq(EmoticonManager paramEmoticonManager, List paramList) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a();
    localEntityTransaction.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, localEmoticonPackage))) {
        QLog.e("EmoticonManager", 1, "saveEmoticonPackages fail epId = " + localEmoticonPackage.epId);
      }
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeiq
 * JD-Core Version:    0.7.0.1
 */