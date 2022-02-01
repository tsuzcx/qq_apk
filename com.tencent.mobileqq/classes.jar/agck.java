import Wallet.AcsQueryRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class agck
  implements EIPCResultCallback, BusinessObserver
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private WeakReference<agcq> jdField_a_of_type_MqqUtilWeakReference;
  
  public agck(agcq paramagcq, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramagcq);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    agcq localagcq = (agcq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localagcq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " onCallback mRef is empty");
      }
      return;
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {}
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = agcp.a(-100, "client_unknown_error"))
    {
      localagcq.queryHasSetNotify(paramEIPCResult, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNotifyObserver", 2, "type:" + paramInt + " isSuccess:" + paramBoolean);
    }
    agcq localagcq = (agcq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localagcq == null)
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
      localagcq.queryHasSetNotify(agcp.a(i, paramBundle, paramInt), this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = -100;
      paramBundle = "client_unknown_error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agck
 * JD-Core Version:    0.7.0.1
 */