import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class akcx
  extends Handler
{
  private akcx(JumpAction paramJumpAction) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (JumpAction.a(this.a) != null)
    {
      JumpAction.a(this.a).a();
      JumpAction.a(this.a).removeObserver(JumpAction.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "msf return error ");
      }
      JumpAction.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        JumpAction.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    JumpAction.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcx
 * JD-Core Version:    0.7.0.1
 */