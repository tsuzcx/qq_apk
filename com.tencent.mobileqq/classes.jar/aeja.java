import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aeja
  implements Runnable
{
  public aeja(VideoFeedsUploader paramVideoFeedsUploader, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult != null) {
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsUploader", 2, "upload result: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a());
      }
    }
    for (;;)
    {
      synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
      {
        PublishManager.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
        ??? = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
        ??? = VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult, (PublishVideoEntry)???);
        ((PublishVideoEntry)???).setStatus(1001);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int == 0)
        {
          ((PublishVideoEntry)???).publishState = 0;
          PublishManager.a((PublishVideoEntry)???);
          PublishManager.a((PublishVideoEntry)???);
          if (QLog.isColorLevel()) {
            QLog.i("VideoFeedsUploader arendgx", 2, "updatePublishVideo called");
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.e = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.c);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.d > 0L) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.f = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.d);
          }
          ??? = new VideoFeedsUploader.UploadInfo(VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader));
          VideoFeedsUploader.UploadResult localUploadResult = new VideoFeedsUploader.UploadResult(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
          ThreadManager.getUIHandler().post(new aejb(this, (VideoFeedsUploader.UploadInfo)???, localUploadResult));
          VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader).a();
          VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader).a();
          VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader, false);
          return;
        }
      }
      ((PublishVideoEntry)???).publishState = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeja
 * JD-Core Version:    0.7.0.1
 */