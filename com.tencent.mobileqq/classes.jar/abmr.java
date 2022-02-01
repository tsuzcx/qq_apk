import com.tencent.common.app.BaseApplicationImpl;

class abmr
  implements abmh
{
  abmr(abmp paramabmp) {}
  
  public void a(abme paramabme)
  {
    abrl.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramabme.a, paramabme.b, paramabme.c }));
    absa.a(BaseApplicationImpl.getApplication(), abmp.a(abmp.a()), 0, -2147483648);
  }
  
  public void a(abme paramabme, int paramInt)
  {
    abrl.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramabme.a, paramabme.b, paramabme.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(abme paramabme, int paramInt1, int paramInt2)
  {
    abrl.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramabme.a, paramabme.b, paramabme.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    absa.a(BaseApplicationImpl.getApplication(), abmp.a(abmp.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmr
 * JD-Core Version:    0.7.0.1
 */