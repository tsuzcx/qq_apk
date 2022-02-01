import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aciy
  implements DownloadListener
{
  aciy(acix paramacix) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((acix.a(this.a) == null) || (acix.a(this.a).getAppId() == null) || (acix.a(this.a).getAppPackageName() == null) || (!acix.a(this.a).getAppId().equals(paramString1)) || (!acix.a(this.a).getAppPackageName().equals(paramString2)))
    {
      acho.d("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = acix.a(this.a, paramString2);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      acho.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
      if ((acix.a(this.a).containsKey(paramDownloadInfo.c)) && (acix.a(this.a).get(paramDownloadInfo.c) != null))
      {
        acie.a((Ad)acix.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
    } while (!acix.a(this.a, paramDownloadInfo, acix.a(this.a)));
    acie.a(acix.a(this.a), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      acho.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
      if ((acix.a(this.a).containsKey(paramDownloadInfo.c)) && (acix.a(this.a).get(paramDownloadInfo.c) != null))
      {
        acie.a((Ad)acix.a(this.a).get(paramDownloadInfo.c), 273);
        acix.b(this.a).put(paramDownloadInfo.c, acix.a(this.a).get(paramDownloadInfo.c));
        return;
      }
    } while (!acix.a(this.a, paramDownloadInfo, acix.a(this.a)));
    acie.a(acix.a(this.a), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      acho.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.c)))
        {
          acho.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
          if ((acix.b(this.a).containsKey(localDownloadInfo.c)) && (acix.b(this.a).get(localDownloadInfo.c) != null))
          {
            acie.a((Ad)acix.b(this.a).get(localDownloadInfo.c), 271);
            acix.b(this.a).remove(localDownloadInfo.c);
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    installSucceed(paramString1, paramString2);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciy
 * JD-Core Version:    0.7.0.1
 */