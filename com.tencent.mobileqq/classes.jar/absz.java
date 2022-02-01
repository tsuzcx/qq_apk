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

public class absz
  implements DownloadListener
{
  absz(absy paramabsy) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((absy.a(this.a) == null) || (absy.a(this.a).getAppId() == null) || (absy.a(this.a).getAppPackageName() == null) || (!absy.a(this.a).getAppId().equals(paramString1)) || (!absy.a(this.a).getAppPackageName().equals(paramString2)))
    {
      abrl.d("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = absy.a(this.a, paramString2);
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
      abrl.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
      if ((absy.a(this.a).containsKey(paramDownloadInfo.c)) && (absy.a(this.a).get(paramDownloadInfo.c) != null))
      {
        absb.a((Ad)absy.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
    } while (!absy.a(this.a, paramDownloadInfo, absy.a(this.a)));
    absb.a(absy.a(this.a), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      abrl.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
      if ((absy.a(this.a).containsKey(paramDownloadInfo.c)) && (absy.a(this.a).get(paramDownloadInfo.c) != null))
      {
        absb.a((Ad)absy.a(this.a).get(paramDownloadInfo.c), 273);
        absy.b(this.a).put(paramDownloadInfo.c, absy.a(this.a).get(paramDownloadInfo.c));
        return;
      }
    } while (!absy.a(this.a, paramDownloadInfo, absy.a(this.a)));
    absb.a(absy.a(this.a), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      abrl.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.c)))
        {
          abrl.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
          if ((absy.b(this.a).containsKey(localDownloadInfo.c)) && (absy.b(this.a).get(localDownloadInfo.c) != null))
          {
            absb.a((Ad)absy.b(this.a).get(localDownloadInfo.c), 271);
            absy.b(this.a).remove(localDownloadInfo.c);
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
 * Qualified Name:     absz
 * JD-Core Version:    0.7.0.1
 */