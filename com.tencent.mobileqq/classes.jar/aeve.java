import Wallet.AcsQueryRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class aeve
  implements EIPCResultCallback, BusinessObserver
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private WeakReference<aevk> jdField_a_of_type_MqqUtilWeakReference;
  
  public aeve(aevk paramaevk, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaevk);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aevk localaevk = (aevk)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localaevk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " onCallback mRef is empty");
      }
      return;
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {}
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = aevj.a(-100, "client_unknown_error"))
    {
      localaevk.queryHasSetNotify(paramEIPCResult, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNotifyObserver", 2, "type:" + paramInt + " isSuccess:" + paramBoolean);
    }
    aevk localaevk = (aevk)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localaevk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " mRef is empty");
      }
      return;
    }
    paramInt = -1;
    Serializable localSerializable = paramBundle.getSerializable("rsp");
    int i;
    if ((localSerializable instanceof AcsQueryRsp))
    {
      paramBundle = ((AcsQueryRsp)localSerializable).err_str;
      i = ((AcsQueryRsp)localSerializable).ret_code;
      paramInt = ((AcsQueryRsp)localSerializable).subscribed;
    }
    for (;;)
    {
      localaevk.queryHasSetNotify(aevj.a(i, paramBundle, paramInt), this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = -100;
      paramBundle = "client_unknown_error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeve
 * JD-Core Version:    0.7.0.1
 */