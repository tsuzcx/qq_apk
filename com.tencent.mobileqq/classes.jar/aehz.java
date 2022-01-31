import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;

class aehz
  implements ndm
{
  aehz(aegy paramaegy) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bn();
    if (!paramBoolean)
    {
      this.a.B(2131629887);
      return;
    }
    atmp localatmp = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localatmp.a(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localatmp.b(localAccountDetail);
    }
    localatmp.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehz
 * JD-Core Version:    0.7.0.1
 */