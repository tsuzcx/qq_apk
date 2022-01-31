import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class afkc
  implements Runnable
{
  afkc(afkb paramafkb, VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    int i = 0;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo != null)
    {
      ConnectNearbyProcService.a(4155, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a), NearbyMomentFailedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult) });
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a == 0)) {
        break label252;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, "发表失败，请重试", 1).a();
      QLog.i("NearbyMomentFailedAdapter", 1, "upload failed, errMsg=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.i + "code=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a);
      j = 0;
      label126:
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label294;
      }
    }
    label287:
    label294:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      label185:
      NowVideoReporter localNowVideoReporter;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.f % 1000L > 500L) {
          i = (int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.f / 1000 + 1;
        }
      }
      else
      {
        localNowVideoReporter = new NowVideoReporter().h("video_public").i("re_republic").a(String.valueOf(i)).d("5").c("1");
        if (j == 0) {
          break label287;
        }
      }
      for (String str = "1";; str = "2")
      {
        localNowVideoReporter.e(str).b((QQAppInterface)localObject);
        return;
        QLog.i("NearbyMomentFailedAdapter", 1, "mVideoUploadListener, sendIPCMessage failed, info == null");
        break;
        label252:
        QQToast.a(BaseApplicationImpl.getContext(), 2, "发表成功", 1).a();
        j = 1;
        break label126;
        i = (int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.f / 1000;
        break label185;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkc
 * JD-Core Version:    0.7.0.1
 */