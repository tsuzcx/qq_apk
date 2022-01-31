import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aesj
  implements BusinessObserver
{
  aesj(aert paramaert, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_Aert.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Aert.B(2131695569);
    }
    for (;;)
    {
      aert.c(this.jdField_a_of_type_Aert);
      if (aert.d(this.jdField_a_of_type_Aert) == 0) {
        this.jdField_a_of_type_Aert.bp();
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
              QLog.d(this.jdField_a_of_type_Aert.jdField_a_of_type_JavaLangString, 2, "unfollow success");
            }
            aert.a(this.jdField_a_of_type_Aert, aert.a(this.jdField_a_of_type_Aert));
            nol.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            ((bajo)this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            aert.b(this.jdField_a_of_type_Aert, false);
          }
          else
          {
            this.jdField_a_of_type_Aert.B(2131695569);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesj
 * JD-Core Version:    0.7.0.1
 */