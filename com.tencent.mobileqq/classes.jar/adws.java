import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class adws
  implements EIPCResultCallback
{
  adws(adwr paramadwr) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      advv.n(this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adws
 * JD-Core Version:    0.7.0.1
 */