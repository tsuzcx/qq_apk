import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;

class akmk
  implements BusinessObserver
{
  akmk(akmj paramakmj) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager", 2, "onReceive:type:" + paramInt + ",isSuccess:" + paramBoolean + ",bundle:" + paramBundle + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.a.jdField_a_of_type_Long));
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle != null) && (paramBoolean))
      {
        QWalletPubAdReport.QueryRsp localQueryRsp = new QWalletPubAdReport.QueryRsp();
        localQueryRsp.mergeFrom(paramBundle);
        paramInt = localQueryRsp.ret.get();
        if (paramInt == 0)
        {
          akmh.a(this.a.jdField_a_of_type_Akmh, localQueryRsp.pv_flag.get());
          akmh.a(this.a.jdField_a_of_type_Akmh, localQueryRsp);
          if (QLog.isColorLevel()) {
            QLog.i("QWalletGdtAdManager", 2, "doReqAdsControl onReceive: retCode:" + localQueryRsp.ret.get() + ",msg:" + localQueryRsp.msg.get());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QWalletGdtAdManager", 2, "onReceive fail,retCode:" + paramInt);
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      QLog.e("QWalletGdtAdManager", 1, "onReceive fail exception:" + paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmk
 * JD-Core Version:    0.7.0.1
 */