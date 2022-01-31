import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.DoLikeCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ajym
  extends ProtoUtils.TroopProtocolObserver
{
  public ajym(TroopTopicMgr paramTroopTopicMgr, TroopTopicMgr.DoLikeCallback paramDoLikeCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_topic.TroopTopicMgr", 2, "getSharePostInfo failed, data == null");
      }
      return;
    }
    int k = 0;
    int j = 0;
    paramBundle = null;
    paramInt = j;
    i = k;
    try
    {
      WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
      paramInt = j;
      i = k;
      localWebSsoResponseBody.mergeFrom(paramArrayOfByte);
      paramInt = j;
      i = k;
      j = localWebSsoResponseBody.ret.get();
      if (j != 0) {
        break label220;
      }
      paramInt = j;
      i = j;
      paramArrayOfByte = new JSONObject(localWebSsoResponseBody.data.get());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        i = paramInt;
        paramInt = i;
        paramArrayOfByte = paramBundle;
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.troop_topic.TroopTopicMgr", 2, "getSharePostInfo got InvalidProtocolBufferMicroException exception:" + localInvalidProtocolBufferMicroException.getMessage());
          paramInt = i;
          paramArrayOfByte = paramBundle;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramInt = i;
        paramArrayOfByte = paramBundle;
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.troop_topic.TroopTopicMgr", 2, "getSharePostInfo got JSONException exception:" + localJSONException.getMessage());
          paramInt = i;
          paramArrayOfByte = paramBundle;
          continue;
          paramArrayOfByte = null;
        }
      }
    }
    paramInt = j;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$DoLikeCallback.a(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajym
 * JD-Core Version:    0.7.0.1
 */