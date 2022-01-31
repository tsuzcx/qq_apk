import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aeiq
  implements VideoFeedsUploader.UploadListener
{
  public aeiq(VideoFeedsManager paramVideoFeedsManager) {}
  
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a("上传中", true);
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsManager:UploadVideo", 2, "onStart:" + paramUploadInfo);
    }
  }
  
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsManager:UploadVideo", 2, "onProcessing:" + paramInt);
    }
  }
  
  public void a(VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (paramUploadInfo == null) {
      QLog.i("VideoFeedsManager", 1, "onResult UploadInfo == null");
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramUploadResult.a, VideoFeedsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUploadInfo, paramUploadResult));
      ThreadManager.getUIHandler().post(new aeis(this, paramUploadInfo, paramUploadResult));
    } while (paramUploadInfo != null);
    QLog.i("VideoFeedsManager:UploadVideo", 1, "onResult:" + paramUploadInfo);
  }
  
  public void b(VideoFeedsUploader.UploadInfo paramUploadInfo)
  {
    ThreadManager.getUIHandler().post(new aeir(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeiq
 * JD-Core Version:    0.7.0.1
 */