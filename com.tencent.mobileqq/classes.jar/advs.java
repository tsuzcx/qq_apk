import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;

public class advs
  implements Runnable
{
  public advs(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment.webloading", 2, "startWebSoRequest, url=" + this.a.c);
    }
    WebSoService.a().a(this.a.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */