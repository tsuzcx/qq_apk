import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class aebm
  implements INetInfoHandler
{
  ImaxAdVideoPreloadManager a;
  
  public aebm(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager1, ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager2)
  {
    this.a = paramImaxAdVideoPreloadManager2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    ImaxAdUtil.b("onNetMobile2None");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ImaxAdUtil.b("onNetMobile2Wifi");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ImaxAdUtil.b("onNetNone2Mobile");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ImaxAdUtil.b("onNetNone2Wifi");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ImaxAdUtil.b("onNetWifi2Mobile");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    ImaxAdUtil.b("onNetWifi2None");
    if (this.a != null) {
      ImaxAdVideoPreloadManager.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebm
 * JD-Core Version:    0.7.0.1
 */