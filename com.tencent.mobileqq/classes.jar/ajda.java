import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajda
  extends ProtoUtils.TroopProtocolObserver
{
  public ajda(TroopTopicMgr paramTroopTopicMgr, TroopTopicDetailInfo paramTroopTopicDetailInfo, MessageRecord paramMessageRecord) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    if (paramInt == 0) {
      if (paramArrayOfByte == null) {}
    }
    for (;;)
    {
      boolean bool;
      try
      {
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramArrayOfByte);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_post_extinfo, ret=" + paramInt + ", msg=" + ((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        }
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfo;
        if (paramArrayOfByte != null) {
          break label495;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForTroopTopic)) {
          continue;
        }
        paramArrayOfByte = TroopTopicDetailInfo.copyFrom((MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if (paramInt != 0) {
          continue;
        }
        localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        int i = ((JSONObject)localObject).getInt("retcode");
        paramInt = i;
        if (i == 0)
        {
          localObject = ((JSONObject)localObject).getJSONObject("result");
          paramArrayOfByte.mLikeNum = ((JSONObject)localObject).optInt("likes", 0);
          paramArrayOfByte.mCommentNum = ((JSONObject)localObject).optInt("commentnum", 0);
          paramArrayOfByte.mViewCommentUrl = ((JSONObject)localObject).optString("comment_url");
          if (((JSONObject)localObject).optInt("is_zan") != 1) {
            break label498;
          }
          bool = true;
          paramArrayOfByte.mIsZan = bool;
          paramBundle.putString("data", ((JSONObject)localObject).toString());
          long l1 = ((JSONObject)localObject).optLong("version");
          long l2 = ((JSONObject)localObject).optLong("msg_seq");
          if ((l1 <= 0L) || (l2 <= 0L)) {
            continue;
          }
          paramArrayOfByte.pVersion = l1;
          paramArrayOfByte.mOldVersion = l1;
          ThreadManager.post(new ajdb(this, paramArrayOfByte), 8, null, false);
          paramBundle.putParcelable("detailInfo", paramArrayOfByte);
          paramInt = i;
          if (QLog.isColorLevel())
          {
            QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_post_extinfo success");
            paramInt = i;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, parse error", paramArrayOfByte);
        paramInt = 9992;
        continue;
        paramArrayOfByte.mLikeNum = 0;
        paramArrayOfByte.mCommentNum = 0;
        ThreadManager.post(new ajdc(this, paramArrayOfByte), 8, null, false);
        continue;
      }
      paramBundle.putInt("ret", paramInt);
      paramArrayOfByte = TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr);
      if (paramInt == 0)
      {
        bool = true;
        paramArrayOfByte.notifyObservers(TroopTopicObserver.class, 1, bool, paramBundle);
        return;
        paramArrayOfByte = new TroopTopicDetailInfo();
        paramArrayOfByte.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
        paramArrayOfByte.msgSeq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_post_extinfo. pVersion is zero. return");
        return;
        if (QLog.isColorLevel())
        {
          QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, no data");
          break label504;
          if (QLog.isColorLevel()) {
            QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "receive cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content, not success");
          }
          paramInt = 9992;
          continue;
        }
      }
      else
      {
        bool = false;
        continue;
        label495:
        continue;
        label498:
        bool = false;
        continue;
      }
      label504:
      paramInt = 9991;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */