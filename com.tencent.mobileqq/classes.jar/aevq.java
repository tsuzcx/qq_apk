import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener;

public class aevq
  implements Runnable
{
  public aevq(ImageFeedsUploader paramImageFeedsUploader, PicFeedUploadInfo paramPicFeedUploadInfo) {}
  
  public void run()
  {
    if (ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader) != null) {
      ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevq
 * JD-Core Version:    0.7.0.1
 */