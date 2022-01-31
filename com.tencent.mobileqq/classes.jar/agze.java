import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class agze
  implements BusinessObserver
{
  agze(agzd paramagzd, long paramLong, agzg paramagzg, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt != 10) || (!paramBoolean)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "fail get rsp:" + this.jdField_a_of_type_Long);
      }
      agzd.a(this.jdField_a_of_type_Agzd, -1L);
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
    agzd.a(this.jdField_a_of_type_Agzd).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_Agzg, (agzd)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    agzd.a(this.jdField_a_of_type_Agzd, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agze
 * JD-Core Version:    0.7.0.1
 */