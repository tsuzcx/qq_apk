import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class airw
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    ajoo.a("onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    ajoo.a("onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airw
 * JD-Core Version:    0.7.0.1
 */