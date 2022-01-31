import com.tencent.mobileqq.vas.VasApngUtil.ApngSoLoadCallBack;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class akpn
  implements EIPCResultCallback
{
  public akpn(VasApngUtil.ApngSoLoadCallBack paramApngSoLoadCallBack) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (this.a != null) {
      this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil", 2, "Apng.so download complete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpn
 * JD-Core Version:    0.7.0.1
 */