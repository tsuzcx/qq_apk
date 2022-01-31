import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

public class aebo
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private aebo(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.a(this.a))
    {
      String str = ImaxAdVideoPreloadManager.a(paramString1);
      ImaxAdUtil.b("onComplete path:" + str);
      ImaxAdUtil.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      ImaxAdVideoPreloadManager.a(this.a, paramString1);
      paramString2 = new File(ImaxAdVideoPreloadManager.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      ImaxAdVideoPreloadManager.b(this.a, paramString1);
      ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.a(this.a));
      ImaxAdVideoPreloadManager.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebo
 * JD-Core Version:    0.7.0.1
 */