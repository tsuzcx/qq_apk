import Wallet.ReportHBGameRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class ajex
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (ReportHBGameRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("QWalletTools", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
    }
    if ((paramBoolean) && (paramBundle != null) && (paramBundle.result == 0)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajex
 * JD-Core Version:    0.7.0.1
 */