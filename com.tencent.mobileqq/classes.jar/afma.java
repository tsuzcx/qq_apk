import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import mqq.os.MqqHandler;

public final class afma
  implements VideoFeedsUploader.UploadListener
{
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo) {}
  
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo, int paramInt) {}
  
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    ThreadManager.getUIHandler().post(new afmb(this, paramUploadInfo, paramUploadResult));
  }
  
  public void b(VideoFeedsUploader.UploadInfo paramUploadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afma
 * JD-Core Version:    0.7.0.1
 */