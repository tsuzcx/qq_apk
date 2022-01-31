import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;

class aewh
  implements Runnable
{
  aewh(aewg paramaewg, VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.jdField_a_of_type_Aewg.a.a.getManager(262);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int == 0)) {
      localNearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.e);
    }
    for (;;)
    {
      if (VideoFeedsUploader.a(this.jdField_a_of_type_Aewg.a) != null) {
        VideoFeedsUploader.a(this.jdField_a_of_type_Aewg.a).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      }
      return;
      localNearbyMomentManager.d(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewh
 * JD-Core Version:    0.7.0.1
 */