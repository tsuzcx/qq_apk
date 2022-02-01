package mqq.observer;

import android.os.Bundle;
import mqq.app.Constants.Action;
import protocol.KQQConfig.GetResourceRespV2;

public class ServerConfigObserver
  implements Constants.Action, BusinessObserver
{
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2) {}
  
  public void onGetServerTime(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1018) {
      return;
    }
    onGetPluginConfig(paramBoolean, paramBundle.getInt("iPluginType"), (GetResourceRespV2)paramBundle.getSerializable("jce"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.observer.ServerConfigObserver
 * JD-Core Version:    0.7.0.1
 */