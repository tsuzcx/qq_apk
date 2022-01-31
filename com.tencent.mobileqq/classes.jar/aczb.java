import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.ThumbEventCallback;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager;

public class aczb
  implements HttpThumbDownloader.ThumbEventCallback
{
  public aczb(ThumbDownloadManager paramThumbDownloadManager) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, long paramLong)
  {
    ThumbDownloadManager.c(this.a, paramString1);
    ThumbDownloadManager.a(this.a).a().a(paramBoolean, 60, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString2, paramString1 });
    ThumbDownloadManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aczb
 * JD-Core Version:    0.7.0.1
 */