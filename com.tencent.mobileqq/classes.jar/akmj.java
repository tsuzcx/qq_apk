import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;

class akmj
  implements blqq
{
  akmj(akmh paramakmh, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = akmh.a(this.jdField_a_of_type_Akmh, paramVarArgs[0], this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), aklf.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Query");
    localNewIntent.putExtra("data", bguc.a(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new akmk(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmj
 * JD-Core Version:    0.7.0.1
 */