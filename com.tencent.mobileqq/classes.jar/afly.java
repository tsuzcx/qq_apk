import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import mqq.os.MqqHandler;

public final class afly
  implements ImageFeedsUploader.UploadListener
{
  public void a(PicFeedUploadInfo paramPicFeedUploadInfo) {}
  
  public void a(PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    ThreadManager.getUIHandler().post(new aflz(this, paramPicFeedUploadInfo, paramUploadResult));
  }
  
  public void b(PicFeedUploadInfo paramPicFeedUploadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afly
 * JD-Core Version:    0.7.0.1
 */