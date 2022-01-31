import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class agpk
  implements BusinessObserver
{
  agpk(agot paramagot, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_Agot.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Agot.B(2131695727);
    }
    for (;;)
    {
      agot.c(this.jdField_a_of_type_Agot);
      if (agot.d(this.jdField_a_of_type_Agot) == 0) {
        this.jdField_a_of_type_Agot.bs();
      }
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_Agot.jdField_a_of_type_JavaLangString, 2, "unfollow success");
            }
            agot.a(this.jdField_a_of_type_Agot, agot.a(this.jdField_a_of_type_Agot));
            nrt.a(this.jdField_a_of_type_Agot.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_Agot.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            ((bcic)this.jdField_a_of_type_Agot.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_Agot.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            agot.b(this.jdField_a_of_type_Agot, false);
          }
          else
          {
            this.jdField_a_of_type_Agot.B(2131695727);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpk
 * JD-Core Version:    0.7.0.1
 */