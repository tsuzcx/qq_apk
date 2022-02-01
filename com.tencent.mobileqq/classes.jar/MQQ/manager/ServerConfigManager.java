package mqq.manager;

import java.util.ArrayList;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.ReqUserInfo;

public abstract interface ServerConfigManager
  extends Manager
{
  public abstract void getPluginConfig(int paramInt1, ReqUserInfo paramReqUserInfo, ArrayList<GetResourceReqInfoV2> paramArrayList, ServerConfigObserver paramServerConfigObserver, int paramInt2);
  
  public abstract void getRichMediaServerList(int paramInt);
  
  public abstract String getServerConfig(String paramString, ServerConfigManager.ConfigType paramConfigType);
  
  public abstract void report(byte paramByte, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.manager.ServerConfigManager
 * JD-Core Version:    0.7.0.1
 */