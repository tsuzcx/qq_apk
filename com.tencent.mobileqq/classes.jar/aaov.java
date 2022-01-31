import com.tencent.common.app.BaseApplicationImpl;

class aaov
  implements aaol
{
  aaov(aaot paramaaot) {}
  
  public void a(aaoi paramaaoi)
  {
    aase.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramaaoi.a, paramaaoi.b, paramaaoi.c }));
    aasr.a(BaseApplicationImpl.getApplication(), aaot.a(aaot.a()), 0, -2147483648);
  }
  
  public void a(aaoi paramaaoi, int paramInt)
  {
    aase.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramaaoi.a, paramaaoi.b, paramaaoi.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(aaoi paramaaoi, int paramInt1, int paramInt2)
  {
    aase.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramaaoi.a, paramaaoi.b, paramaaoi.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    aasr.a(BaseApplicationImpl.getApplication(), aaot.a(aaot.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaov
 * JD-Core Version:    0.7.0.1
 */