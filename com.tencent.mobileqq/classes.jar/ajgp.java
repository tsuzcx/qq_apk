import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ajgp
  implements INetInfoHandler
{
  ajgp(ajgm paramajgm) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.c();
  }
  
  public void onNetWifi2None()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajgp
 * JD-Core Version:    0.7.0.1
 */