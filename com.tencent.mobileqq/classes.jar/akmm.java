import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.QWalletPubAdReport.ReportRsp;

class akmm
  implements BusinessObserver
{
  akmm(akml paramakml) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager", 2, "onReceive:type:" + paramInt + ",isSuccess:" + paramBoolean + ",bundle:" + paramBundle + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.a.a));
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle != null) && (paramBoolean))
      {
        QWalletPubAdReport.ReportRsp localReportRsp = new QWalletPubAdReport.ReportRsp();
        localReportRsp.mergeFrom(paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "doReqAdsStatistics onReceive: retCode:" + localReportRsp.ret.get() + ",msg:" + localReportRsp.msg.get());
        }
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("QWalletGdtAdManager", 1, paramBundle, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmm
 * JD-Core Version:    0.7.0.1
 */