import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class alde
  implements EIPCResultCallback
{
  public alde(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    boolean bool1 = paramEIPCResult.getBoolean("isOpen");
    boolean bool2 = paramEIPCResult.getBoolean("display", false);
    this.a.a(bool2, bool1, ApolloGameActivity.a(this.a).mTempAIOUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */