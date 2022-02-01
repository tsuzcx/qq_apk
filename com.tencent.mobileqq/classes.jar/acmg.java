import com.tencent.common.app.BaseApplicationImpl;

class acmg
  implements aclw
{
  acmg(acme paramacme) {}
  
  public void a(aclt paramaclt)
  {
    acqy.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramaclt.a, paramaclt.b, paramaclt.c }));
    acrl.a(BaseApplicationImpl.getApplication(), acme.a(acme.a()), 0, -2147483648);
  }
  
  public void a(aclt paramaclt, int paramInt)
  {
    acqy.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramaclt.a, paramaclt.b, paramaclt.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(aclt paramaclt, int paramInt1, int paramInt2)
  {
    acqy.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramaclt.a, paramaclt.b, paramaclt.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    acrl.a(BaseApplicationImpl.getApplication(), acme.a(acme.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmg
 * JD-Core Version:    0.7.0.1
 */