import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;

public class ageh
  implements INetInfoHandler
{
  private ageh(OlympicToolAppInterface paramOlympicToolAppInterface) {}
  
  public void onNetMobile2None()
  {
    if (OlympicToolAppInterface.i(this.a) != null) {
      OlympicToolAppInterface.j(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (OlympicToolAppInterface.g(this.a) != null) {
      OlympicToolAppInterface.h(this.a).onNetMobile2Wifi(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (OlympicToolAppInterface.a(this.a) != null) {
      OlympicToolAppInterface.b(this.a).onNetNone2Mobile(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (OlympicToolAppInterface.e(this.a) != null) {
      OlympicToolAppInterface.f(this.a).onNetNone2Wifi(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (OlympicToolAppInterface.c(this.a) != null) {
      OlympicToolAppInterface.d(this.a).onNetWifi2Mobile(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (OlympicToolAppInterface.k(this.a) != null) {
      OlympicToolAppInterface.l(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ageh
 * JD-Core Version:    0.7.0.1
 */