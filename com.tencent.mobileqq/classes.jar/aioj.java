import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

class aioj
  implements obz
{
  aioj(ainh paramainh) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bp();
    if (!paramBoolean)
    {
      this.a.A(2131694659);
      return;
    }
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localEntityManager.find(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localEntityManager.remove(localAccountDetail);
    }
    localEntityManager.close();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioj
 * JD-Core Version:    0.7.0.1
 */