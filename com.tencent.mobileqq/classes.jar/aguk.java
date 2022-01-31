import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

class aguk
  implements nrs
{
  aguk(agti paramagti) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bs();
    if (!paramBoolean)
    {
      this.a.B(2131695729);
      return;
    }
    awgf localawgf = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localawgf.a(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localawgf.b(localAccountDetail);
    }
    localawgf.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguk
 * JD-Core Version:    0.7.0.1
 */