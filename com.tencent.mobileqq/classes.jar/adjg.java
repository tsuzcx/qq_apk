import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

public class adjg
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private adjg(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
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
      ReportController.b(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", ImaxAdVideoPreloadManager.a(this.a).mVideoVid, String.valueOf(ImaxAdVideoPreloadManager.a(this.a).mSource));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjg
 * JD-Core Version:    0.7.0.1
 */