import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.IFetchFeedListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_write.AddFeedRsp;

public class aevn
  implements CsTask.Callback
{
  public aevn(ImageFeedsUploader paramImageFeedsUploader, ImageFeedsUploader.IFetchFeedListener paramIFetchFeedListener, PicFeedUploadInfo paramPicFeedUploadInfo, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ilive_feeds_write.AddFeedRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.ret.get() != 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener.a("");
        }
      }
      while (this.jdField_a_of_type_Int == 3)
      {
        ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).jdField_a_of_type_Int = paramBundle.ret.get();
        ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader, ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener.a(new String(paramBundle.feed_id.get().toByteArray()));
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.feedId = new String(paramBundle.feed_id.get().toByteArray());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$IFetchFeedListener.a("");
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader).jdField_a_of_type_Int = -1005;
        ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader, ImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevn
 * JD-Core Version:    0.7.0.1
 */