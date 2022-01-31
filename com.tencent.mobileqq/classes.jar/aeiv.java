import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.nearby.now.utils.IOUtils;
import java.io.File;
import mqq.os.MqqHandler;

public class aeiv
  implements Runnable
{
  public aeiv(VideoFeedsManager paramVideoFeedsManager, VideoFeedsUploader.UploadInfo paramUploadInfo) {}
  
  public void run()
  {
    String str = CommentsUtil.a(IOUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.d)));
    ThreadManager.getUIHandler().post(new aeiw(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeiv
 * JD-Core Version:    0.7.0.1
 */