import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.1;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class aeje
  implements BusinessObserver
{
  public aeje(QQNotifySettingBaseFragment paramQQNotifySettingBaseFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((QQNotifySettingBaseFragment.a(this.a).isShowing()) && (QQNotifySettingBaseFragment.a(this.a) != null)) {
      QQNotifySettingBaseFragment.a(this.a).dismiss();
    }
    if (paramInt == 2005)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQNotifySettingBaseFragment.a(), 2, "acs msg succ");
      }
      if (!paramBoolean) {
        break label114;
      }
      paramBundle = (AcsGetMsgRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null) {
        QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.1(this, paramBundle));
      }
    }
    else
    {
      return;
    }
    QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.2(this));
    return;
    label114:
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeje
 * JD-Core Version:    0.7.0.1
 */