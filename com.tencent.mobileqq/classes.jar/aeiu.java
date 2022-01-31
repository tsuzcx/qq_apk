import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;

public class aeiu
  extends SosoInterface.OnLocationListener
{
  public aeiu(VideoFeedsManager paramVideoFeedsManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, VideoFeedsUploader.UploadInfo paramUploadInfo)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null)
    {
      paramSosoLbsInfo = new VideoFeedsUploader.UploadResult();
      paramSosoLbsInfo.i = "定位失败！";
      paramSosoLbsInfo.a = -108;
      VideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager).a(new VideoFeedsUploader.UploadInfo(), paramSosoLbsInfo);
      return;
    }
    LocationInfo localLocationInfo = new LocationInfo();
    localLocationInfo.init("" + paramSosoLbsInfo.a.jdField_b_of_type_Double, "" + paramSosoLbsInfo.a.jdField_a_of_type_Double, paramSosoLbsInfo.a.e, paramSosoLbsInfo.a.jdField_a_of_type_JavaLangString);
    localLocationInfo.setAddress(paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString);
    VideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo, localLocationInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeiu
 * JD-Core Version:    0.7.0.1
 */