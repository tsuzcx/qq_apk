import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class ajrb
  implements BusinessObserver
{
  public ajrb(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        if (paramInt == 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "commendTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_comment ok~~~");
          return;
        }
        paramBundle = new JSONObject(localWebSsoResponseBody.data.get());
        paramBundle = "commendTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_comment failed1, errorCode = " + paramInt + ", msg = " + paramBundle;
        if (QLog.isColorLevel()) {
          QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = "commendTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_comment failed4, msg = " + QLog.getStackTraceString(paramBundle);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle);
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, 32768, 1002);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(6003, false, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) });
      return;
      if (QLog.isColorLevel())
      {
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "commendTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_comment failed2, data is null !!!!");
        continue;
        paramBundle = "commendTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_comment failed3, isSuccess is " + paramBoolean;
        if (QLog.isColorLevel()) {
          QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle + paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrb
 * JD-Core Version:    0.7.0.1
 */