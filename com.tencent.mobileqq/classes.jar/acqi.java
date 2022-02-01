import com.tencent.common.app.BaseApplicationImpl;

class acqi
  implements acpy
{
  acqi(acqg paramacqg) {}
  
  public void a(acpv paramacpv)
  {
    acvc.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramacpv.a, paramacpv.b, paramacpv.c }));
    acvp.a(BaseApplicationImpl.getApplication(), acqg.a(acqg.a()), 0, -2147483648);
  }
  
  public void a(acpv paramacpv, int paramInt)
  {
    acvc.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramacpv.a, paramacpv.b, paramacpv.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(acpv paramacpv, int paramInt1, int paramInt2)
  {
    acvc.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramacpv.a, paramacpv.b, paramacpv.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    acvp.a(BaseApplicationImpl.getApplication(), acqg.a(acqg.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqi
 * JD-Core Version:    0.7.0.1
 */