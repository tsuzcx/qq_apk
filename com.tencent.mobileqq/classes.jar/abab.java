import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import mqq.app.MobileQQ;

public class abab
  implements Runnable
{
  public abab(ArkAppCGI paramArkAppCGI, QQAppInterface paramQQAppInterface, abad paramabad, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    if ((ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI) == null) || (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Abad, false, null);
      return;
    }
    ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI).a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abab
 * JD-Core Version:    0.7.0.1
 */