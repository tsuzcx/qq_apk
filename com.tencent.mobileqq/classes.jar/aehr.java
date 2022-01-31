import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aehr
  implements EIPCResultCallback
{
  aehr(aehq paramaehq) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      aegu.n(this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehr
 * JD-Core Version:    0.7.0.1
 */