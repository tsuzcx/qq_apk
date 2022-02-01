import android.util.Pair;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abjn
  implements IAdDownloader.Callback, DownloadListener
{
  private WeakReference<AdAppDownloadManager> a;
  
  public AdAppDownloadManager a()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      return (AdAppDownloadManager)this.a.get();
    }
    return null;
  }
  
  public void a(AdAppDownloadManager paramAdAppDownloadManager)
  {
    this.a = new WeakReference(paramAdAppDownloadManager);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = bhyo.a().c(paramString2);
    if ((this.a != null) && (this.a.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(6, 0, new Pair(paramString2.d, paramString2.e), paramString1);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(4, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(5, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(3, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(2, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1) {}
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((this.a == null) || (this.a.get() == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      DownloadInfo localDownloadInfo;
      if (paramList.hasNext())
      {
        localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo != null) {}
      }
      else
      {
        if ((localArrayList2.size() == 0) || (localArrayList1.size() == 0)) {
          break;
        }
        ((AdAppDownloadManager)this.a.get()).onDownloadProgressUpdate(localArrayList1, localArrayList2);
        return;
      }
      localArrayList2.add(new Pair(localDownloadInfo.d, localDownloadInfo.e));
      localArrayList1.add(localDownloadInfo);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    paramString2 = bhyo.a().c(paramString2);
    if ((this.a != null) && (this.a.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(7, 0, new Pair(paramString2.d, paramString2.e), paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjn
 * JD-Core Version:    0.7.0.1
 */