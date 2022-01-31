import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class abzt
  extends WtloginObserver
{
  public abzt(RiskHintDlgFragment paramRiskHintDlgFragment) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()))
    {
      if ((paramInt != 0) || (paramDevlockInfo == null)) {
        break label305;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RiskHintDlgFragment", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("RiskHintDlgFragment", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("RiskHintDlgFragment", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
        QLog.d("RiskHintDlgFragment", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
        QLog.d("RiskHintDlgFragment", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("RiskHintDlgFragment", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      aoem.a().a(paramDevlockInfo.TransferInfo);
      this.a.a = paramDevlockInfo;
    }
    label305:
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RiskHintDlgFragment", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("RiskHintDlgFragment", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
    } while (paramDevlockInfo != null);
    QLog.d("RiskHintDlgFragment", 2, "OnCheckDevLockStatus DevlockInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abzt
 * JD-Core Version:    0.7.0.1
 */