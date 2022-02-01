import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class alap
  implements BusinessObserver
{
  alap(alao paramalao, long paramLong, alar paramalar, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt != 10) || (!paramBoolean)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "fail get rsp:" + this.jdField_a_of_type_Long);
      }
      alao.a(this.jdField_a_of_type_Alao, -1L);
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
    alao.a(this.jdField_a_of_type_Alao).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_Alar, (alao)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    alao.a(this.jdField_a_of_type_Alao, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alap
 * JD-Core Version:    0.7.0.1
 */