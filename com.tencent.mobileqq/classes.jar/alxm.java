import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class alxm
  implements acjr
{
  alxm(alxh paramalxh, String paramString, long paramLong) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    alxh.a(this.jdField_a_of_type_Alxh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onPermission(int paramInt)
  {
    alxh.a(this.jdField_a_of_type_Alxh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    for (;;)
    {
      JSONObject localJSONObject1;
      Object localObject1;
      Object localObject2;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("ret", 0);
        if ("cs.get_user_info.local".equals(this.jdField_a_of_type_JavaLangString))
        {
          localObject1 = alvx.a(alxh.a(this.jdField_a_of_type_Alxh));
          if (localObject1 == null)
          {
            QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + alxh.a(this.jdField_a_of_type_Alxh));
            return;
          }
          localObject1 = ((alxy)localObject1).a();
          localObject2 = new aluj(paramJSONObject.optString("avatarUrl"), paramJSONObject.optString("nickName"), ((CmGameInitParams)localObject1).openId);
          alxh.a(this.jdField_a_of_type_Alxh).put(((CmGameInitParams)localObject1).openId, localObject2);
          localJSONObject1.put("gender", paramJSONObject.optString("gender", ""));
          localJSONObject1.put("city", paramJSONObject.optString("city", ""));
          localJSONObject1.put("province", paramJSONObject.optString("province", ""));
          localJSONObject1.put("country", paramJSONObject.optString("country", ""));
          localJSONObject1.put("openid", ((CmGameInitParams)localObject1).openId);
          if (QLog.isColorLevel()) {}
          paramJSONObject = alvx.a();
          if (paramJSONObject == null) {
            break;
          }
          paramJSONObject.callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, localJSONObject1.toString());
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
        return;
      }
      if ("cs.get_app_friends.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        paramJSONObject = paramJSONObject.optJSONArray("appfriends");
        if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
        {
          localObject1 = new JSONArray();
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            localObject2 = paramJSONObject.getJSONObject(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("openid", ((JSONObject)localObject2).optString("openid"));
            Object localObject3 = ((JSONObject)localObject2).optString("openid");
            localObject3 = new aluj(((JSONObject)localObject2).optString("avatarUrl"), ((JSONObject)localObject2).optString("nickName"), (String)localObject3);
            alxh.a(this.jdField_a_of_type_Alxh).put(((JSONObject)localObject2).optString("openid"), localObject3);
            ((JSONArray)localObject1).put(localJSONObject2);
            i += 1;
          }
          localJSONObject1.put("friendsInfo", localObject1);
        }
      }
      else if ("cs.get_city.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        localJSONObject1.put("nation", paramJSONObject.optString("nation", ""));
        localJSONObject1.put("province", paramJSONObject.optString("province", ""));
        localJSONObject1.put("city", paramJSONObject.optString("city", ""));
        localJSONObject1.put("district", paramJSONObject.optString("district", ""));
      }
      else if ("cs.get_location.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        localJSONObject1.put("latitude", paramJSONObject.optString("latitude", ""));
        localJSONObject1.put("longitude", paramJSONObject.optString("longitude", ""));
        localJSONObject1.put("speed", paramJSONObject.optString("speed", ""));
        localJSONObject1.put("accuracy", paramJSONObject.optString("accuracy", ""));
        localJSONObject1.put("altitude", paramJSONObject.optString("altitude", ""));
        localJSONObject1.put("verticalAccuracy", paramJSONObject.optString("verticalAccuracy", ""));
        localJSONObject1.put("horizontalAccuracy", paramJSONObject.optString("horizontalAccuracy", ""));
      }
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxm
 * JD-Core Version:    0.7.0.1
 */