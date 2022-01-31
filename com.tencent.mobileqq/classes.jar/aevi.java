import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aevi
  implements ImageFeedsUploader.UploadListener
{
  public aevi(ImageFeedsUploader paramImageFeedsUploader) {}
  
  public void a(PicFeedUploadInfo paramPicFeedUploadInfo)
  {
    ImageFeedsUploader.a(this.a).a("上传中", true);
    if (paramPicFeedUploadInfo == null) {
      QLog.i("ImageFeedsUploader", 1, "onResult UploadInfo == null");
    }
  }
  
  public void a(PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (paramPicFeedUploadInfo == null)
    {
      QLog.i("ImageFeedsUploader", 1, "onResult UploadInfo == null");
      return;
    }
    QLog.i("ImageFeedsUploader", 1, "onResult:" + paramPicFeedUploadInfo);
    if (QLog.isColorLevel()) {
      QLog.i("ImageFeedsUploader", 2, "onResult:" + Log.getStackTraceString(new Throwable()));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramUploadResult.a, ImageFeedsUploader.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPicFeedUploadInfo, paramUploadResult));
    ThreadManager.getUIHandler().post(new aevk(this, paramPicFeedUploadInfo, paramUploadResult));
  }
  
  public void b(PicFeedUploadInfo paramPicFeedUploadInfo)
  {
    ThreadManager.getUIHandler().post(new aevj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevi
 * JD-Core Version:    0.7.0.1
 */