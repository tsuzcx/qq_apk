import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class aitf
  implements EIPCResultCallback
{
  public aitf(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    boolean bool1 = paramEIPCResult.getBoolean("isOpen");
    boolean bool2 = paramEIPCResult.getBoolean("display", false);
    this.a.a(bool2, bool1, ApolloGameActivity.a(this.a).mTempAIOUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aitf
 * JD-Core Version:    0.7.0.1
 */