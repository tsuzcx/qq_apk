import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aiee
  implements BusinessObserver
{
  aiee(aido paramaido, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_Aido.tag, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Aido.b(2131694983);
    }
    for (;;)
    {
      aido.c(this.jdField_a_of_type_Aido);
      if (aido.d(this.jdField_a_of_type_Aido) == 0) {
        this.jdField_a_of_type_Aido.b();
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
              QLog.d(this.jdField_a_of_type_Aido.tag, 2, "unfollow success");
            }
            aido.a(this.jdField_a_of_type_Aido, aido.a(this.jdField_a_of_type_Aido));
            olh.a(this.jdField_a_of_type_Aido.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_Aido.app, this.jdField_a_of_type_JavaLangString);
            ((bgiy)this.jdField_a_of_type_Aido.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_Aido.sessionInfo.curFriendUin);
            aido.b(this.jdField_a_of_type_Aido, false);
          }
          else
          {
            this.jdField_a_of_type_Aido.b(2131694983);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiee
 * JD-Core Version:    0.7.0.1
 */