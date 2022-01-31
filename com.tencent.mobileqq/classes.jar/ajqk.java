import QQWalletPay.ReqCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletHelper;

public class ajqk
  extends ajfb
{
  private boolean a;
  
  public ajqk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQWalletPayAuthServer.checkChangePwdAuth");
      localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
  }
  
  public void a(AuthCodeReq paramAuthCodeReq)
  {
    if (paramAuthCodeReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VacThirdCodeSvc.fetchCodes");
      localToServiceMsg.extraData.putSerializable("AuthCodeReq", paramAuthCodeReq);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
  }
  
  public void a(GetPasswordReq paramGetPasswordReq)
  {
    if (paramGetPasswordReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
      localToServiceMsg.extraData.putSerializable("GetPasswordReq", paramGetPasswordReq);
      super.send(localToServiceMsg);
      this.a = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
  }
  
  public void a(PfaFriendRqt paramPfaFriendRqt)
  {
    if (paramPfaFriendRqt == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QWalletPfa.RecFriend");
      localToServiceMsg.extraData.putSerializable("PfaFriendRqt", paramPfaFriendRqt);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetRecentList: on send--cmd=QWalletPfa.RecFriend");
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return ajql.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool;
    do
    {
      return;
      bool = paramFromServiceMsg.isSuccess();
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    } while (TextUtils.isEmpty(paramToServiceMsg));
    if (paramToServiceMsg.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0)
    {
      super.notifyUI(1, bool, paramObject);
      return;
    }
    if (paramToServiceMsg.compareTo("WalletGestureSvc.GetPassword") == 0) {
      if ((paramObject == null) || (!(paramObject instanceof GetPasswordRsp))) {
        break label367;
      }
    }
    label367:
    for (paramToServiceMsg = (GetPasswordRsp)paramObject;; paramToServiceMsg = null)
    {
      if ((bool) && (paramToServiceMsg != null) && (paramToServiceMsg.ret == 0))
      {
        PatternLockUtils.setSyncPatternLockState(this.app.getApp(), this.app.getCurrentAccountUin(), false);
        paramFromServiceMsg = "";
        if (!TextUtils.isEmpty(paramToServiceMsg.password))
        {
          paramFromServiceMsg = QWalletHelper.getQWDevId();
          paramFromServiceMsg = MD5.toMD5(paramFromServiceMsg + paramToServiceMsg.password);
        }
        PatternLockUtils.setPWD(this.app.getApp(), this.app.getCurrentAccountUin(), paramFromServiceMsg);
        PatternLockUtils.setCheckIntervalTime(this.app.getApp(), this.app.getCurrentAccountUin(), paramToServiceMsg.checkInterval);
        PatternLockUtils.setForgroundIntervalTime(this.app.getApp(), this.app.getCurrentAccountUin(), paramToServiceMsg.passInterval);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: onReceive isSuccess:" + bool);
        return;
        if ((this.a) && (badq.d(this.app.getApp())))
        {
          this.a = false;
          paramToServiceMsg = new GetPasswordReq();
          paramToServiceMsg.MQOS = "Android";
          paramFromServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
          paramFromServiceMsg.extraData.putSerializable("GetPasswordReq", paramToServiceMsg);
          super.send(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
          }
        }
      }
      break;
      if (paramToServiceMsg.compareTo("VacThirdCodeSvc.fetchCodes") == 0)
      {
        super.notifyUI(4, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("QWalletPfa.RecFriend") != 0) {
        break;
      }
      super.notifyUI(5, bool, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqk
 * JD-Core Version:    0.7.0.1
 */