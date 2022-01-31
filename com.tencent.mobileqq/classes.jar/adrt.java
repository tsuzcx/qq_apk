import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class adrt
  implements Runnable
{
  public adrt(DraftTextManager paramDraftTextManager, DraftTextInfo paramDraftTextInfo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      ((EntityManager)localObject3).b((Entity)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityManager)localObject3).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adrt
 * JD-Core Version:    0.7.0.1
 */