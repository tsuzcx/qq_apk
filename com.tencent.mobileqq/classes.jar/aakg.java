import com.tencent.common.app.BaseApplicationImpl;

class aakg
  implements aajw
{
  aakg(aake paramaake) {}
  
  public void a(aajt paramaajt)
  {
    aanp.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramaajt.a, paramaajt.b, paramaajt.c }));
    aaoc.a(BaseApplicationImpl.getApplication(), aake.a(aake.a()), 0, -2147483648);
  }
  
  public void a(aajt paramaajt, int paramInt)
  {
    aanp.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramaajt.a, paramaajt.b, paramaajt.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(aajt paramaajt, int paramInt1, int paramInt2)
  {
    aanp.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramaajt.a, paramaajt.b, paramaajt.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    aaoc.a(BaseApplicationImpl.getApplication(), aake.a(aake.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakg
 * JD-Core Version:    0.7.0.1
 */