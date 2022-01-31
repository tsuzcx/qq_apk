import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aats
  implements bfoj
{
  aats(aatr paramaatr) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((aatr.a(this.a) == null) || (aatr.a(this.a).getAppId() == null) || (aatr.a(this.a).getAppPackageName() == null) || (!aatr.a(this.a).getAppId().equals(paramString1)) || (!aatr.a(this.a).getAppPackageName().equals(paramString2)))
    {
      aase.d("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = aatr.a(this.a, paramString2);
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
      aase.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
      if ((aatr.a(this.a).containsKey(paramDownloadInfo.c)) && (aatr.a(this.a).get(paramDownloadInfo.c) != null))
      {
        aass.a((Ad)aatr.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
    } while (!aatr.a(this.a, paramDownloadInfo, aatr.a(this.a)));
    aass.a(aatr.a(this.a), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      aase.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
      if ((aatr.a(this.a).containsKey(paramDownloadInfo.c)) && (aatr.a(this.a).get(paramDownloadInfo.c) != null))
      {
        aass.a((Ad)aatr.a(this.a).get(paramDownloadInfo.c), 273);
        aatr.b(this.a).put(paramDownloadInfo.c, aatr.a(this.a).get(paramDownloadInfo.c));
        return;
      }
    } while (!aatr.a(this.a, paramDownloadInfo, aatr.a(this.a)));
    aass.a(aatr.a(this.a), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      aase.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.c)))
        {
          aase.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
          if ((aatr.b(this.a).containsKey(localDownloadInfo.c)) && (aatr.b(this.a).get(localDownloadInfo.c) != null))
          {
            aass.a((Ad)aatr.b(this.a).get(localDownloadInfo.c), 271);
            aatr.b(this.a).remove(localDownloadInfo.c);
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
 * Qualified Name:     aats
 * JD-Core Version:    0.7.0.1
 */