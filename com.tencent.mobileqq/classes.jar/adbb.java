import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReportScoreReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReqBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ExtraParam;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ReportItem;

public class adbb
  extends adae
{
  public static final String a;
  private final String b = "OidbSvc.0xb85";
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + adbb.class.getSimpleName();
  }
  
  private void a(JSONObject paramJSONObject, adaa paramadaa)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".getRankingList", 2, "params = " + paramJSONObject);
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    int j = paramJSONObject.optInt("topCount", 10);
    String str = paramJSONObject.optString("rankKey", "");
    int k = paramJSONObject.optInt("rankValueType", 0);
    int m = paramJSONObject.optInt("rankOrderType", 0);
    if (i <= 0)
    {
      addh.a(paramadaa, -100, "rankingID must be bigger than 0");
      return;
    }
    Object localObject = (adbk)this.jdField_a_of_type_Adad.a(adbk.class, false);
    if (localObject == null)
    {
      addh.a(paramadaa, -10, "internal error, try again.");
      return;
    }
    Oidb_0xb85.ReqBody localReqBody = new Oidb_0xb85.ReqBody();
    localObject = ((adbk)localObject).a();
    localReqBody.appid.set(Integer.valueOf(this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString).intValue());
    localReqBody.service_id.set(this.jdField_a_of_type_Adad.jdField_a_of_type_Int);
    localReqBody.openid.set(((adbn)localObject).jdField_a_of_type_JavaLangString);
    localReqBody.openkey.set(((adbn)localObject).b);
    Oidb_0xb85.GetRankListReqBody localGetRankListReqBody = new Oidb_0xb85.GetRankListReqBody();
    localGetRankListReqBody.ranklist_id.set(i);
    localGetRankListReqBody.top_count.set(j);
    if (!TextUtils.isEmpty(str)) {
      localGetRankListReqBody.rank_key.set(str);
    }
    localGetRankListReqBody.rank_value_type.set(k);
    localGetRankListReqBody.rank_order_type.set(m);
    localReqBody.get_ranklist_req.set(localGetRankListReqBody);
    ntb.a(BaseApplicationImpl.getApplication().getRuntime(), new adbc(this, (adbn)localObject, paramJSONObject, paramadaa), localReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 2, null, 0L);
  }
  
  private void b(JSONObject paramJSONObject, adaa paramadaa)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".reportScore", 2, "params = " + paramJSONObject);
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("scoreList");
    if (i <= 0)
    {
      addh.a(paramadaa, -100, "rankingID 没有传或者值小于等于0");
      return;
    }
    Object localObject1 = (adbk)this.jdField_a_of_type_Adad.a(adbk.class, false);
    if (localObject1 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "reportScore, getAPIModule UserInfoModule return null");
      return;
    }
    Oidb_0xb85.ReqBody localReqBody = new Oidb_0xb85.ReqBody();
    localObject1 = ((adbk)localObject1).a();
    localReqBody.appid.set(Integer.valueOf(this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString).intValue());
    localReqBody.service_id.set(this.jdField_a_of_type_Adad.jdField_a_of_type_Int);
    localReqBody.openid.set(((adbn)localObject1).jdField_a_of_type_JavaLangString);
    localReqBody.openkey.set(((adbn)localObject1).b);
    Oidb_0xb85.ReportScoreReqBody localReportScoreReqBody = new Oidb_0xb85.ReportScoreReqBody();
    localReportScoreReqBody.ranklist_id.set(i);
    try
    {
      int k = localJSONArray.length();
      i = 0;
      while (i < k)
      {
        Object localObject2 = localJSONArray.getJSONObject(i);
        ranklist_comm.ReportItem localReportItem = new ranklist_comm.ReportItem();
        localReportItem.openid.set(((JSONObject)localObject2).getString("openid"));
        localReportItem.score.set(((JSONObject)localObject2).getInt("score"));
        localObject2 = ((JSONObject)localObject2).optJSONArray("extraList");
        if (localObject2 != null)
        {
          int j = 0;
          int m = ((JSONArray)localObject2).length();
          while (j < m)
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            ranklist_comm.ExtraParam localExtraParam = new ranklist_comm.ExtraParam();
            localExtraParam.param_key.set(localJSONObject.getString("key"));
            localExtraParam.param_value.set(localJSONObject.getInt("value"));
            localExtraParam.param_type.set(localJSONObject.getInt("type"));
            localReportItem.rpt_extra_param.add(localExtraParam);
            j += 1;
          }
        }
        localReportScoreReqBody.rpt_report_item.add(localReportItem);
        i += 1;
      }
      localReqBody.report_score_req.set(localReportScoreReqBody);
    }
    catch (Exception paramJSONObject)
    {
      addh.a(paramadaa, -101, "参数处理错误, 是否是类型不对? 查看一下文档吧. \nerrorMsg: " + paramJSONObject.getMessage());
      return;
    }
    ntb.a(BaseApplicationImpl.getApplication().getRuntime(), new adbd(this, (adbn)localObject1, paramJSONObject, paramadaa), localReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 1, null, 0L);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 8: 
      a(paramJSONObject, paramadaa);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramadaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbb
 * JD-Core Version:    0.7.0.1
 */