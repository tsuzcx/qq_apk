import Wallet.SetSelectedSkinRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ajbx
  implements BusinessObserver
{
  public ajbx(RedPacketManager paramRedPacketManager, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    SetSelectedSkinRsp localSetSelectedSkinRsp = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketManager", 2, "setSelectedSkin2ServerIfChanged onReceive isSuccess:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbx
 * JD-Core Version:    0.7.0.1
 */