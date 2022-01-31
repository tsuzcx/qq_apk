import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.qphone.base.util.QLog;

public class aewi
  implements CsTask.OnCsError
{
  public aewi(VideoFeedsUploader paramVideoFeedsUploader, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader).jdField_a_of_type_Int = -1004;
    VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader).c = paramInt;
    if (this.jdField_a_of_type_Int < 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsUploader", 2, "step1_uploadPreparing, retry send " + this.jdField_a_of_type_Int);
      }
      VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader, this.jdField_a_of_type_Int + 1);
      return;
    }
    VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader, VideoFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewi
 * JD-Core Version:    0.7.0.1
 */