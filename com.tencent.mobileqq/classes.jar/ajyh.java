import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class ajyh
  implements BusinessObserver
{
  public ajyh(TroopTopicMgr paramTroopTopicMgr, TroopTopicDetailInfo paramTroopTopicDetailInfo, MessageForTroopTopic paramMessageForTroopTopic) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        int i = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, ret=" + i + ", msg=" + ((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        }
        paramInt = i;
        if (i == 0)
        {
          byte[] arrayOfByte = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get()).getJSONObject("result").getString("detail").getBytes();
          AbsStructMsg localAbsStructMsg = StructMsgFactory.a(arrayOfByte, 0);
          if (localAbsStructMsg == null) {
            continue;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfo;
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = TroopTopicDetailInfo.copyFrom(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic);
          }
          paramBundle.detailInfoData = arrayOfByte;
          paramBundle.detailStructMsg = localAbsStructMsg;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.b(paramBundle);
          ThreadManager.post(new ajyi(this, paramBundle), 8, null, false);
          localBundle.putParcelable("detailInfo", paramBundle);
          paramInt = i;
        }
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, parse error", paramBundle);
        paramInt = 9992;
        continue;
        paramBoolean = false;
        continue;
        paramInt = 9992;
        continue;
        paramInt = 9991;
        continue;
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isLoading = false;
      }
      localBundle.putInt("ret", paramInt);
      paramBundle = TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr);
      if (paramInt != 0) {
        continue;
      }
      paramBoolean = true;
      paramBundle.notifyObservers(TroopTopicObserver.class, 2, paramBoolean, localBundle);
      return;
      if (!QLog.isColorLevel()) {
        continue;
      }
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "fetchTopicDetail parse structmsg error");
      continue;
      if (!QLog.isColorLevel()) {
        continue;
      }
      QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, no data");
      continue;
      if (QLog.isColorLevel()) {
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, not success");
      }
      paramInt = 9992;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyh
 * JD-Core Version:    0.7.0.1
 */