import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

public class adjf
  implements TVK_ICacheMgr.IPreloadCallback
{
  private adjf(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.a(this.a))
    {
      ImaxAdUtil.b("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.a(this.a))
    {
      ImaxAdUtil.b("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = ImaxAdVideoPreloadManager.a(paramString1);
          ImaxAdUtil.b("onPreLoadSucess path:" + paramString2);
          ImaxAdVideoPreloadManager.a(this.a, paramString1);
          File localFile = new File(ImaxAdVideoPreloadManager.b(paramString1));
          if (localFile.exists()) {
            localFile.renameTo(new File(paramString2));
          }
          ImaxAdVideoPreloadManager.b(this.a, paramString1);
          ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.a(this.a));
          ReportController.b(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", ImaxAdVideoPreloadManager.a(this.a).mVideoVid, String.valueOf(ImaxAdVideoPreloadManager.a(this.a).mSource));
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.d("ImaxAdvertisement", 1, "onPreLoadSucess", paramString1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjf
 * JD-Core Version:    0.7.0.1
 */