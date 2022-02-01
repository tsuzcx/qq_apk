import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aibu
  implements EIPCResultCallback
{
  aibu(aibr paramaibr) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      aibr.r(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibu
 * JD-Core Version:    0.7.0.1
 */