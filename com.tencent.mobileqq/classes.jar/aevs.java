import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;

class aevs
  implements Runnable
{
  aevs(aevr paramaevr, PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.jdField_a_of_type_Aevr.a.a.getManager(262);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int == 0)) {
      localNearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.e);
    }
    for (;;)
    {
      if (ImageFeedsUploader.a(this.jdField_a_of_type_Aevr.a) != null) {
        ImageFeedsUploader.a(this.jdField_a_of_type_Aevr.a).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      }
      return;
      localNearbyMomentManager.d(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevs
 * JD-Core Version:    0.7.0.1
 */