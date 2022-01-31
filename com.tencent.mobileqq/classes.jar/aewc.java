import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.qphone.base.util.QLog;

class aewc
  implements Runnable
{
  aewc(aewb paramaewb, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aewb.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.c = this.jdField_a_of_type_JavaLangString;
    if ((-1 == this.jdField_a_of_type_Aewb.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a(this.jdField_a_of_type_Aewb.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo)) && (QLog.isColorLevel())) {
      QLog.i("VideoFeedsManager", 2, "uploader is working, upload fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewc
 * JD-Core Version:    0.7.0.1
 */