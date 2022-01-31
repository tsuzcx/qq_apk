import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ServerCheckCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class aawk
  implements BusinessObserver
{
  aawk(aawj paramaawj, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    int i;
    label513:
    do
    {
      try
      {
        paramObject = (String)paramObject;
        if (TextUtils.isEmpty(paramObject))
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, sso req fail, req=%s", new Object[] { this.jdField_a_of_type_JavaLangString.toString() }));
          throw new Exception("sso req fail");
        }
      }
      catch (Exception paramObject)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, exception=%s", new Object[] { paramObject.getMessage() }));
        return;
      }
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, sso req result, req=%s", new Object[] { paramObject.toString() }));
      Object localObject1 = new JSONObject(paramObject);
      paramInt = ((JSONObject)localObject1).optInt("ret");
      if (paramInt != 0)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, ret != 0, ret=%d, req=%s", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString.toString() }));
        throw new Exception("ret value not 0");
      }
      paramObject = new ArrayList();
      localObject1 = ((JSONObject)((JSONObject)localObject1).opt("data")).getJSONArray("apps");
      if (localObject1 == null)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, apps is null", new Object[0]));
        throw new Exception("query fail");
      }
      i = ((JSONArray)localObject1).length();
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i) {
          break label513;
        }
        JSONObject localJSONObject = ((JSONArray)localObject1).optJSONObject(paramInt);
        String str1 = localJSONObject.optString("intent");
        String str2 = localJSONObject.optString("meta");
        String str3 = localJSONObject.optString("name");
        String str4 = localJSONObject.optString("rawMeta");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str4))) {
          break;
        }
        Object localObject2 = new JSONObject(str2);
        localJSONObject = new JSONObject(str4);
        Object localObject3 = ((JSONObject)localObject2).keys();
        Iterator localIterator = localJSONObject.keys();
        RecommendCommonMessage.ArkContextInfo localArkContextInfo = new RecommendCommonMessage.ArkContextInfo();
        localArkContextInfo.appName = str3;
        localArkContextInfo.context = str1;
        localArkContextInfo.meta = str2;
        localArkContextInfo.rawMeta = str4;
        while (((Iterator)localObject3).hasNext())
        {
          str1 = (String)((Iterator)localObject3).next();
          str2 = ((JSONObject)localObject2).getString(str1);
          localArkContextInfo.semantic.put(str1, str2);
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, success, realname=%s", new Object[] { str2 }));
        }
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject3 = localJSONObject.getString((String)localObject2);
          localArkContextInfo.rawSemantic.put(localObject2, localObject3);
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, success, name=%s", new Object[] { localObject3 }));
        }
        paramObject.add(localArkContextInfo);
        paramInt += 1;
      }
    } while (i <= 0);
    this.jdField_a_of_type_Aawj.a.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawk
 * JD-Core Version:    0.7.0.1
 */