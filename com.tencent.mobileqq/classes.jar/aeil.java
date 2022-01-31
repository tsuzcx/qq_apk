import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aeil
  implements Runnable
{
  public aeil(ImageFeedsUploader paramImageFeedsUploader, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    PicFeedUploadInfo localPicFeedUploadInfo = ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader);
    int i;
    VideoFeedsUploader.UploadResult localUploadResult;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int == 0)
    {
      i = 3;
      localPicFeedUploadInfo.uploadStatus = i;
      localPicFeedUploadInfo = new PicFeedUploadInfo(ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader));
      localPicFeedUploadInfo.anchorUin = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader.a.getLongAccountUin();
      localUploadResult = new VideoFeedsUploader.UploadResult(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
    }
    for (;;)
    {
      synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
      {
        PublishManager.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
        ??? = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
        ??? = ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult, (PublishVideoEntry)???);
        ((PublishVideoEntry)???).setStatus(1001);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int == 0)
        {
          ((PublishVideoEntry)???).publishState = 0;
          PublishManager.a((PublishVideoEntry)???);
          PublishManager.a((PublishVideoEntry)???);
          ThreadManager.getUIHandler().post(new aeim(this, localPicFeedUploadInfo, localUploadResult));
          if (QLog.isColorLevel()) {
            QLog.i("ImageFeedsUploader", 2, "upload result: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a());
          }
          ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).reset();
          ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).a();
          return;
          i = 2;
        }
      }
      ((PublishVideoEntry)???).publishState = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeil
 * JD-Core Version:    0.7.0.1
 */