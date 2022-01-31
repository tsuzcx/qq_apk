import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aeis
  implements Runnable
{
  aeis(aeiq paramaeiq, VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a == 0))
    {
      new NowVideoReporter().h("video_public").i("public_suc").d(SmallVideoCameraCaptureFragment.a).a(1).b(this.jdField_a_of_type_Aeiq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QQToast.a(BaseApplicationImpl.getContext(), 2, "发表成功", 1).a();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aeiq.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi != null) && (this.jdField_a_of_type_Aeiq.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a() == null)) {}
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 1, "发表失败，请重试", 1).a();
      QLog.i("VideoFeedsManager", 1, "upload failed, errMsg=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.i + "code=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a);
      new NowVideoReporter().h("video_public").i("public_fail").d(SmallVideoCameraCaptureFragment.a).a(1).b(this.jdField_a_of_type_Aeiq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeis
 * JD-Core Version:    0.7.0.1
 */