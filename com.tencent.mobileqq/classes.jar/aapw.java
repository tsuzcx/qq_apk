import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.List;

public class aapw
  implements bfoj
{
  private WeakReference<GdtMvDownloadBtnManager> a;
  
  public aapw(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager)
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
    aase.a("GdtMvDownloadBtnManager", "onDownloadCancel: ");
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
    aase.a("GdtMvDownloadBtnManager", "onDownloadFinish: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.c(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    aase.a("GdtMvDownloadBtnManager", "onDownloadPause: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    aase.a("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.a.get();
    if (localGdtMvDownloadBtnManager != null) {
      localGdtMvDownloadBtnManager.a(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    aase.a("GdtMvDownloadBtnManager", "onDownloadWait: ");
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
 * Qualified Name:     aapw
 * JD-Core Version:    0.7.0.1
 */