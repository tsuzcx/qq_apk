import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class aite
  implements BusinessObserver
{
  aite(aitd paramaitd, long paramLong, aitg paramaitg, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt != 10) || (!paramBoolean)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "fail get rsp:" + this.jdField_a_of_type_Long);
      }
      aitd.a(this.jdField_a_of_type_Aitd, -1L);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    paramBundle = (RspWalletConfig)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "RspWalletConfig|" + paramBundle);
    }
    aitd.a(this.jdField_a_of_type_Aitd).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_Aitg, (aitd)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    aitd.a(this.jdField_a_of_type_Aitd, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aite
 * JD-Core Version:    0.7.0.1
 */