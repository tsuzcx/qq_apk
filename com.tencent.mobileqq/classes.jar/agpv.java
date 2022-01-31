import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

class agpv
  implements nrs
{
  agpv(agot paramagot) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bs();
    if (!paramBoolean)
    {
      this.a.B(2131695727);
      return;
    }
    awbw localawbw = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localawbw.a(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localawbw.b(localAccountDetail);
    }
    localawbw.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpv
 * JD-Core Version:    0.7.0.1
 */