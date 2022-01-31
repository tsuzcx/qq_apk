import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class aixx
  implements EIPCResultCallback
{
  public aixx(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "get_open_key_back");
      }
      paramEIPCResult = paramEIPCResult.data.getString("respData");
      ApolloGameInterfaceProxy.a(this.a, "cs.on_get_open_key.local", paramEIPCResult);
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixx
 * JD-Core Version:    0.7.0.1
 */