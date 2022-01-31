import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.NowPublishParam;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import java.util.ArrayList;
import java.util.List;

public class aeit
  implements Runnable
{
  public aeit(VideoFeedsManager paramVideoFeedsManager, NowPublishParam paramNowPublishParam) {}
  
  public void run()
  {
    VideoFeedsUploader.UploadInfo localUploadInfo = new VideoFeedsUploader.UploadInfo();
    localUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a());
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a.getCurrentAccountUin(), 4).getString("nick", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a.getCurrentNickname();
    }
    localUploadInfo.o = str1;
    localUploadInfo.g = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a;
    localUploadInfo.c = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a.getLongAccountUin();
    localUploadInfo.j = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a.getLongAccountUin();
    localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = VideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager).a();
    localUploadInfo.f = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a().l;
    localUploadInfo.b = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a().b;
    if (localUploadInfo.jdField_a_of_type_JavaUtilList == null) {
      localUploadInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a() != null) {
      localUploadInfo.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.a());
    }
    localUploadInfo.d = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelNowPublishParam.b;
    VideoFeedsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager, localUploadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeit
 * JD-Core Version:    0.7.0.1
 */