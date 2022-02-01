import com.tencent.common.app.BaseApplicationImpl;

class acch
  implements acbx
{
  acch(accf paramaccf) {}
  
  public void a(acbu paramacbu)
  {
    acho.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramacbu.a, paramacbu.b, paramacbu.c }));
    acid.a(BaseApplicationImpl.getApplication(), accf.a(accf.a()), 0, -2147483648);
  }
  
  public void a(acbu paramacbu, int paramInt)
  {
    acho.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramacbu.a, paramacbu.b, paramacbu.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(acbu paramacbu, int paramInt1, int paramInt2)
  {
    acho.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramacbu.a, paramacbu.b, paramacbu.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    acid.a(BaseApplicationImpl.getApplication(), accf.a(accf.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acch
 * JD-Core Version:    0.7.0.1
 */