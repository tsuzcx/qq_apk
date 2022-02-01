import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class akua
  implements BusinessObserver
{
  akua(aktz paramaktz, long paramLong, akuc paramakuc, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt != 10) || (!paramBoolean)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "fail get rsp:" + this.jdField_a_of_type_Long);
      }
      aktz.a(this.jdField_a_of_type_Aktz, -1L);
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
    aktz.a(this.jdField_a_of_type_Aktz).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_Akuc, (aktz)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    aktz.a(this.jdField_a_of_type_Aktz, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */