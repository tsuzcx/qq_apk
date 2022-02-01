import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class agyk
  implements EIPCResultCallback
{
  agyk(agyh paramagyh) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      agyh.r(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyk
 * JD-Core Version:    0.7.0.1
 */