import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class akxw
  implements EIPCResultCallback
{
  akxw(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("respData");
    akwd.a().callbackFromRequest(this.a, 0, "cs.check_pubAccount_state.local", paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxw
 * JD-Core Version:    0.7.0.1
 */