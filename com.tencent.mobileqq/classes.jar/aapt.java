import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aapt
  implements BusinessObserver
{
  aapt(aaps paramaaps, ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramInt = 0;
    paramObject = (String)paramObject;
    int i;
    Object localObject;
    ArkMessageServerLogic.ArkPassiveSearchInfo localArkPassiveSearchInfo;
    if ((paramBoolean) && (!TextUtils.isEmpty(paramObject)))
    {
      try
      {
        paramObject = new JSONObject(paramObject);
        if (paramObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent onUpdate, invalid reply string");
          if (this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler == null) {
            break label680;
          }
          this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangObject, null);
          return;
        }
        i = paramObject.optInt("ret", -1);
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("sendPassiveSearchTextIntent onUpdate, server reply %d", new Object[] { Integer.valueOf(i) }));
          if ((i == 1) && (this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler == null)) {
            break label680;
          }
          this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangObject, null);
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
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent onUpdate, 'data' is null");
        if (this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler == null) {
          break label680;
        }
        this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangObject, null);
        return;
      }
      paramObject = ((JSONObject)localObject).optJSONArray("apps");
      if ((paramObject == null) || (paramObject.length() <= 0))
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, 'apps' is null");
        if (this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler == null) {
          break label680;
        }
        this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangObject, null);
        return;
      }
      localArkPassiveSearchInfo = new ArkMessageServerLogic.ArkPassiveSearchInfo();
      localArkPassiveSearchInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localArkPassiveSearchInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", 2);
      localArkPassiveSearchInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("msgId");
      i = paramObject.length();
    }
    for (;;)
    {
      if (paramInt < i)
      {
        JSONObject localJSONObject2 = paramObject.optJSONObject(paramInt);
        if (localJSONObject2 == null) {
          break label681;
        }
        localObject = new ArkAiInfo();
        ((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString = localJSONObject2.optString("name");
        if (TextUtils.isEmpty(((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString)) {
          break label681;
        }
        String str1 = localJSONObject2.optString("intent");
        if (TextUtils.isEmpty(str1)) {
          break label681;
        }
        ((ArkAiInfo)localObject).h = str1;
        ((ArkAiInfo)localObject).i = localJSONObject2.optString("extra");
        ((ArkAiInfo)localObject).jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject2 = localJSONObject2.optJSONObject("meta");
        if (localJSONObject2 == null) {
          break label681;
        }
        Iterator localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          String str3 = localJSONObject2.optString(str2);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            ((ArkAiInfo)localObject).jdField_a_of_type_JavaUtilLinkedHashMap.put(str2, str3);
          }
        }
        localJSONObject1.put(str1, localJSONObject2);
        ((ArkAiInfo)localObject).f = localJSONObject1.toString();
        this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr.a(((ArkAiInfo)localObject).jdField_a_of_type_JavaLangString, str1, 2, new aapu(this, (ArkAiInfo)localObject, localArkPassiveSearchInfo, paramInt, i));
        break label681;
        if (this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler != null) {
          this.jdField_a_of_type_Aaps.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaps.a.jdField_a_of_type_JavaLangObject, null);
        }
      }
      label680:
      return;
      label681:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */