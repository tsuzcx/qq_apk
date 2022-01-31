import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aehp
  implements EIPCResultCallback
{
  aehp(aeho paramaeho) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      aegs.n(this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehp
 * JD-Core Version:    0.7.0.1
 */