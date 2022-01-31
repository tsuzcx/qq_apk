import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;

public class aduy
  implements Runnable
{
  public aduy(EmoticonManager paramEmoticonManager, EmoticonKeywords paramEmoticonKeywords) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a();
    try
    {
      localEntityTransaction.a();
      EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonKeywords);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EmoticonManager", 1, "saveKeywordReqTimeToDB e = " + localException.getMessage());
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB cost : " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aduy
 * JD-Core Version:    0.7.0.1
 */