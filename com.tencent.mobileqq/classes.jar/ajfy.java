import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ajfy
  implements BusinessObserver
{
  ajfy(ajfx paramajfx, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean) + ", uin: " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
    }
    if (!paramBoolean)
    {
      ajfx.a(this.jdField_a_of_type_Ajfx, 2131695727);
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
          ajfx.a(this.jdField_a_of_type_Ajfx, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
          ((bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
          ajfx.b(this.jdField_a_of_type_Ajfx, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      ajfx.a(this.jdField_a_of_type_Ajfx);
      return;
      ajfx.b(this.jdField_a_of_type_Ajfx, 2131695727);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */