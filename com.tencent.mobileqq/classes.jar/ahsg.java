import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ahsg
  implements EIPCResultCallback
{
  ahsg(ahsd paramahsd) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      ahsd.r(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsg
 * JD-Core Version:    0.7.0.1
 */