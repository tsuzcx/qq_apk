import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class airu
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    ajom.a("onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    ajom.a("onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airu
 * JD-Core Version:    0.7.0.1
 */