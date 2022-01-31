import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ahor
  implements BusinessObserver
{
  ahor(ahoq paramahoq, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean) + ", uin: " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
    }
    if (!paramBoolean)
    {
      ahoq.a(this.jdField_a_of_type_Ahoq, 2131695568);
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "unfollow success");
          }
          ahoq.a(this.jdField_a_of_type_Ahoq, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
          ((baja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
          ahoq.b(this.jdField_a_of_type_Ahoq, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      ahoq.a(this.jdField_a_of_type_Ahoq);
      return;
      ahoq.b(this.jdField_a_of_type_Ahoq, 2131695568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahor
 * JD-Core Version:    0.7.0.1
 */