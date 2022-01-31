import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.SearchArkBabyQInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aawq
  implements BusinessObserver
{
  aawq(aawp paramaawp, ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramInt = 0;
    paramObject = (String)paramObject;
    int i;
    Object localObject;
    String str;
    ArkMessageServerLogic.SearchArkBabyQInfo localSearchArkBabyQInfo;
    if ((paramBoolean) && (!TextUtils.isEmpty(paramObject)))
    {
      try
      {
        paramObject = new JSONObject(paramObject);
        if (paramObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent onUpdate, invalid reply string");
          if (this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler == null) {
            break label624;
          }
          this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangObject, null, false);
          return;
        }
        i = paramObject.optInt("ret", -1);
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("sendBabyQTextIntent onUpdate, server reply %d", new Object[] { Integer.valueOf(i) }));
          if ((i == 1) && (this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler == null)) {
            break label624;
          }
          this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangObject, null, false);
          return;
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      localObject = paramObject.optJSONObject("data");
      if (localObject == null)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent onUpdate, 'data' is null");
        if (this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler == null) {
          break label624;
        }
        this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangObject, null, false);
        return;
      }
      str = ((JSONObject)localObject).optString("desc");
      paramObject = ((JSONObject)localObject).optJSONArray("apps");
      if ((paramObject == null) || (paramObject.length() <= 0))
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, 'apps' is null");
        if (this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler == null) {
          break label624;
        }
        this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangObject, null, false);
        return;
      }
      localSearchArkBabyQInfo = new ArkMessageServerLogic.SearchArkBabyQInfo();
      localSearchArkBabyQInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localSearchArkBabyQInfo.b = str;
      localSearchArkBabyQInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", 1);
      localSearchArkBabyQInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("msgId");
      i = paramObject.length();
    }
    for (;;)
    {
      if (paramInt < i)
      {
        JSONObject localJSONObject2 = paramObject.optJSONObject(paramInt);
        if (localJSONObject2 == null) {
          break label625;
        }
        localObject = new ArkAiInfo();
        ((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString = localJSONObject2.optString("name");
        if (TextUtils.isEmpty(((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString)) {
          break label625;
        }
        str = localJSONObject2.optString("intent");
        if (TextUtils.isEmpty(str)) {
          break label625;
        }
        ((ArkAiInfo)localObject).i = localJSONObject2.optString("extra");
        ((ArkAiInfo)localObject).jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject2 = localJSONObject2.optJSONObject("meta");
        if (localJSONObject2 == null) {
          break label625;
        }
        localJSONObject1.put(str, localJSONObject2);
        ((ArkAiInfo)localObject).f = localJSONObject1.toString();
        this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.a(((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString, str, 4, new aawr(this, (ArkAiInfo)localObject, localSearchArkBabyQInfo, paramInt, i));
        break label625;
        if (this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler != null) {
          this.jdField_a_of_type_Aawp.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawp.a.jdField_a_of_type_JavaLangObject, null, true);
        }
      }
      label624:
      return;
      label625:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawq
 * JD-Core Version:    0.7.0.1
 */