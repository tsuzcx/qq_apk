import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.IFetchFeedListener;

public class aevm
  implements CsTask.OnCsError
{
  public aevm(ImageFeedsUploader paramImageFeedsUploader, ImageFeedsUploader.IFetchFeedListener paramIFetchFeedListener, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener.a("");
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).jdField_a_of_type_Int = -1004;
      ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader, ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevm
 * JD-Core Version:    0.7.0.1
 */