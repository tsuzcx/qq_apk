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

public class acsm
  implements DownloadListener
{
  acsm(acsl paramacsl) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((acsl.a(this.a) == null) || (acsl.a(this.a).getAppId() == null) || (acsl.a(this.a).getAppPackageName() == null) || (!acsl.a(this.a).getAppId().equals(paramString1)) || (!acsl.a(this.a).getAppPackageName().equals(paramString2)))
    {
      acqy.d("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = acsl.a(this.a, paramString2);
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
      acqy.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
      if ((acsl.a(this.a).containsKey(paramDownloadInfo.c)) && (acsl.a(this.a).get(paramDownloadInfo.c) != null))
      {
        acrm.a((Ad)acsl.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
    } while (!acsl.a(this.a, paramDownloadInfo, acsl.a(this.a)));
    acrm.a(acsl.a(this.a), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      acqy.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
      if ((acsl.a(this.a).containsKey(paramDownloadInfo.c)) && (acsl.a(this.a).get(paramDownloadInfo.c) != null))
      {
        acrm.a((Ad)acsl.a(this.a).get(paramDownloadInfo.c), 273);
        acsl.b(this.a).put(paramDownloadInfo.c, acsl.a(this.a).get(paramDownloadInfo.c));
        return;
      }
    } while (!acsl.a(this.a, paramDownloadInfo, acsl.a(this.a)));
    acrm.a(acsl.a(this.a), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      acqy.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.c)))
        {
          acqy.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
          if ((acsl.b(this.a).containsKey(localDownloadInfo.c)) && (acsl.b(this.a).get(localDownloadInfo.c) != null))
          {
            acrm.a((Ad)acsl.b(this.a).get(localDownloadInfo.c), 271);
            acsl.b(this.a).remove(localDownloadInfo.c);
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
 * Qualified Name:     acsm
 * JD-Core Version:    0.7.0.1
 */