import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.campuscircle.CampusCircleManager;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicPublisher;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicReq;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.PicInfo;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.TopicPublishSession;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class abpj
  implements Runnable
{
  CampusCircleManager.PicInfo jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo;
  
  public abpj(CampusCircleManager.CampusTopicPublisher paramCampusTopicPublisher, CampusCircleManager.PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo = paramPicInfo;
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.a()) || (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "UploadPicRunnable.run, check wrong");
      }
      return;
    }
    CampusCircleManager.CampusTopicReq localCampusTopicReq = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
    CompressInfo localCompressInfo = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo.path, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.c = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo.md5;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.b = 54;
    localTransferRequest.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long;
    if (!StringUtil.a(localCompressInfo.e)) {}
    for (localTransferRequest.i = localCompressInfo.e;; localTransferRequest.i = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo.path)
    {
      if (localCampusTopicReq.currSendState != 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a.a().a(CampusCircleManager.CampusTopicPublisher.a(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher));
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a.a().a(localTransferRequest);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CampusCircleManager", 2, "Publisher.uploadPhoto(), destpath=" + localCompressInfo.e + ",sessionID=" + this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long + ",currSendState=" + localCampusTopicReq.currSendState + this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$PicInfo.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpj
 * JD-Core Version:    0.7.0.1
 */