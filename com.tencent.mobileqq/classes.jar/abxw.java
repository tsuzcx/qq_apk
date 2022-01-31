import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListRspBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.RspBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm.RankItem;

class abxw
  extends nac
{
  abxw(abxv paramabxv, abyh paramabyh, JSONObject paramJSONObject, abwu paramabwu) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(abxv.a, 2, "onResult appid=" + abxv.a(this.jdField_a_of_type_Abxv).a + ", openid=" + this.jdField_a_of_type_Abyh.a + ", openkey=" + this.jdField_a_of_type_Abyh.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      acab.a(this.jdField_a_of_type_Abwu, paramInt, "getRankingList result error, try again");
      return;
    }
    paramBundle = new Oidb_0xb85.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        label358:
        paramArrayOfByte = null;
        paramBundle.printStackTrace();
        continue;
        paramBundle.put("rankingList", localObject);
        Object localObject = new JSONObject();
        paramArrayOfByte = (ranklist_comm.RankItem)paramArrayOfByte.self_rank_item.get();
        ((JSONObject)localObject).put("nickName", paramArrayOfByte.nick.get());
        ((JSONObject)localObject).put("avatarUrl", paramArrayOfByte.figure.get());
        ((JSONObject)localObject).put("score", paramArrayOfByte.value.get());
        ((JSONObject)localObject).put("rank", paramArrayOfByte.rank.get());
        paramBundle.put("selfRank", localObject);
      }
      acab.a(this.jdField_a_of_type_Abwu, -1, "parse result error, try again");
    }
    if (paramArrayOfByte != null)
    {
      paramBundle = new JSONObject();
      try
      {
        localObject = new JSONArray();
        paramArrayOfByte = (Oidb_0xb85.GetRankListRspBody)paramArrayOfByte.get_ranklist_rsp.get();
        Iterator localIterator = paramArrayOfByte.rpt_rank_item.get().iterator();
        while (localIterator.hasNext())
        {
          ranklist_comm.RankItem localRankItem = (ranklist_comm.RankItem)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("nickName", localRankItem.nick.get());
            localJSONObject.put("avatarUrl", localRankItem.figure.get());
            localJSONObject.put("score", localRankItem.value.get());
            localJSONObject.put("rank", localRankItem.rank.get());
            ((JSONArray)localObject).put(localJSONObject);
          }
          catch (JSONException localJSONException) {}
          if (QLog.isColorLevel()) {
            QLog.e(abxv.a, 2, localJSONException.getMessage(), localJSONException);
          }
        }
        if (!QLog.isDevelopLevel()) {
          break label358;
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e(abxv.a, 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
        }
      }
      QLog.i(abxv.a, 2, "result is, " + paramBundle.toString());
      acab.a(this.jdField_a_of_type_Abwu, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxw
 * JD-Core Version:    0.7.0.1
 */