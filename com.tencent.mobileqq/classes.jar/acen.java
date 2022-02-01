import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class acen
  implements DownloadListener
{
  private WeakReference<GdtMvDownloadBtnManager> a;
  
  public acen(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager)
  {
    this.a = new WeakReference(paramGdtMvDownloadBtnManager);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    acho.a("GdtMvDownloadBtnManager", "onDownloadCancel: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.d(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    acho.a("GdtMvDownloadBtnManager", "onDownloadFinish: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.c(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    acho.a("GdtMvDownloadBtnManager", "onDownloadPause: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    acho.a("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    acho.a("GdtMvDownloadBtnManager", "onDownloadWait: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.b(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.c(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acen
 * JD-Core Version:    0.7.0.1
 */