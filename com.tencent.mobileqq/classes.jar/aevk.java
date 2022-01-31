import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aevk
  implements Runnable
{
  aevk(aevi paramaevi, PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.uploadStatus == 3)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, "发表成功", 1).a();
      new NowVideoReporter().h("video_public").i("public_suc").d(SmallVideoCameraCaptureFragment.a).a(2).b(this.jdField_a_of_type_Aevi.a.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, "发表失败，请重试", 1).a();
    QLog.i("ImageFeedsUploader", 1, "upload failed, errMsg=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.i + "code=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a);
    new NowVideoReporter().h("video_public").i("public_fail").d(SmallVideoCameraCaptureFragment.a).a(2).b(this.jdField_a_of_type_Aevi.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevk
 * JD-Core Version:    0.7.0.1
 */