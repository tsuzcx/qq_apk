import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ahrl
  implements EIPCResultCallback
{
  ahrl(ahri paramahri) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      ahri.r(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrl
 * JD-Core Version:    0.7.0.1
 */