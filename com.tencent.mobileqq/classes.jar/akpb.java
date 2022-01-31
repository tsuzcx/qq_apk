import com.tencent.mobileqq.intervideo.now.NowUtil;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akpb
  implements DownloadListener
{
  public akpb(DownloadCenterImpl paramDownloadCenterImpl) {}
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(paramDownloadInfo);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(paramString1, paramString2);
    }
  }
  
  public void a(List paramList)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(paramList);
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).b(paramDownloadInfo);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).b(paramString1, paramString2);
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (NowUtil.a(paramDownloadInfo.k, paramDownloadInfo.b, paramDownloadInfo.d))
    {
      if (!NowUtil.b().equals(paramDownloadInfo.k))
      {
        NowUtil.a(paramDownloadInfo.k);
        paramDownloadInfo.k = NowUtil.b();
      }
      DownloadManager.a().e(paramDownloadInfo);
    }
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).c(paramDownloadInfo);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).c(paramString1, paramString2);
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).d(paramDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akpb
 * JD-Core Version:    0.7.0.1
 */