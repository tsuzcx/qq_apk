import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;

class akre
  implements bmhi
{
  akre(akrc paramakrc, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = akrc.a(this.jdField_a_of_type_Akrc, paramVarArgs[0], this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), akqa.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Query");
    localNewIntent.putExtra("data", bhjl.a(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new akrf(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akre
 * JD-Core Version:    0.7.0.1
 */