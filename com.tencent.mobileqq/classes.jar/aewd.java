import com.tencent.mobileqq.nearby.now.model.NowPublishParam;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.send.uploader.WordsCheck.OnResultListener;

public class aewd
  implements WordsCheck.OnResultListener
{
  public aewd(VideoFeedsManager paramVideoFeedsManager, NowPublishParam paramNowPublishParam) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam);
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt)
  {
    VideoFeedsUploader.UploadResult localUploadResult = new VideoFeedsUploader.UploadResult();
    localUploadResult.i = "文字包含敏感词！";
    localUploadResult.a = -109;
    VideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager).a(new VideoFeedsUploader.UploadInfo(), localUploadResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewd
 * JD-Core Version:    0.7.0.1
 */