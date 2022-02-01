import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;

class ajvn
  implements bkvz
{
  ajvn(ajvj paramajvj, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = ajvj.a(this.jdField_a_of_type_Ajvj, paramVarArgs[0], this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ajuh.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Statistics");
    localNewIntent.putExtra("data", bgau.a(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new ajvo(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvn
 * JD-Core Version:    0.7.0.1
 */