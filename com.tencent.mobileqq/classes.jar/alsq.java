import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class alsq
  implements INetInfoHandler
{
  public alsq(ArkAppCenter paramArkAppCenter) {}
  
  public void onNetMobile2None()
  {
    ArkAppCenter.a(this.a, 1, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 1, 2);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 2, 1);
  }
  
  public void onNetWifi2None()
  {
    ArkAppCenter.a(this.a, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsq
 * JD-Core Version:    0.7.0.1
 */