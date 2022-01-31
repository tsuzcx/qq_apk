import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class afgx
  implements Runnable
{
  public afgx(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void run()
  {
    NearbyProfileEditPanel.a(this.a, (PicInfo)this.a.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (NearbyProfileEditPanel.a(this.a) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(NearbyProfileEditPanel.a(this.a).c, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.a(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.a = true;
      localTransferRequest.i = localCompressInfo.e;
      localTransferRequest.b = 8;
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(localTransferRequest);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new afgy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgx
 * JD-Core Version:    0.7.0.1
 */