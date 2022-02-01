import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class alom
  implements BusinessObserver
{
  alom(alol paramalol, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean) + ", uin: " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    }
    if (!paramBoolean)
    {
      alol.a(this.jdField_a_of_type_Alol, 2131694659);
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
          alol.a(this.jdField_a_of_type_Alol, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
          ((bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
          alol.b(this.jdField_a_of_type_Alol, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      alol.a(this.jdField_a_of_type_Alol);
      return;
      alol.b(this.jdField_a_of_type_Alol, 2131694659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alom
 * JD-Core Version:    0.7.0.1
 */