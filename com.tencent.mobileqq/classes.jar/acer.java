import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class acer
{
  public static JSONArray a(String paramString)
  {
    try
    {
      String str1 = BaseApplicationImpl.sApplication.getSharedPreferences("sp_name_wadl", 4).getString(paramString, "");
      bize.c("GameCenterSpUtils", "readAppidArrayOutAccount key:" + paramString + ",jsonStr:" + str1);
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      for (;;)
      {
        bize.a("GameCenterSpUtils", "readAppidArrayOutAccount key:" + paramString + " exception", localThrowable);
        str2 = null;
      }
      try
      {
        paramString = new JSONArray(str2);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("sp_name_wadl", 4);
    localObject = localSharedPreferences.getString(paramString2, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    bize.c("GameCenterSpUtils", "deleteAppidOutAccount gameAppid:" + paramString1 + ",gameVersion:" + paramInt + ",key:" + paramString2);
    try
    {
      localJSONArray = new JSONArray((String)localObject);
      j = localJSONArray.length();
      i = 0;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int j;
        int i;
        JSONObject localJSONObject;
        String str;
        int k;
        bize.a("GameCenterSpUtils", "deleteAppidOutAccount exception", paramString1);
        paramString1 = (String)localObject;
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        str = localJSONObject.optString("appid");
        k = localJSONObject.optInt("version_code");
        if ((paramString1.equals(str)) && (paramInt == k)) {
          return false;
        }
      }
    }
    else
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("version_code", paramInt);
      localJSONArray.put(localJSONObject);
      paramString1 = localJSONArray.toString();
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString(paramString2, paramString1);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean b(String paramString1, int paramInt, String paramString2)
  {
    bize.c("GameCenterSpUtils", "addAppidOutAccount gameAppid:" + paramString1 + ",gameVersion:" + paramInt + ",key:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("sp_name_wadl", 4);
    str1 = localSharedPreferences.getString(paramString2, "");
    bize.c("GameCenterSpUtils", "addAppidOutAccount jsonStr=" + str1);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        localObject = new JSONArray();
        j = ((JSONArray)localObject).length();
        i = 0;
      }
      catch (Throwable paramString1)
      {
        Object localObject;
        int j;
        int i;
        JSONObject localJSONObject;
        String str2;
        int k;
        bize.a("GameCenterSpUtils", "addAppidOutAccount exception", paramString1);
        paramString1 = str1;
        continue;
        i += 1;
        continue;
      }
      if (i >= j) {
        continue;
      }
      localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      if (localJSONObject == null) {
        continue;
      }
      str2 = localJSONObject.optString("appid");
      k = localJSONObject.optInt("version_code");
      if ((!paramString1.equals(str2)) || (paramInt != k)) {
        continue;
      }
      return false;
      localObject = new JSONArray(str1);
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("appid", paramString1);
    localJSONObject.put("version_code", paramInt);
    ((JSONArray)localObject).put(localJSONObject);
    paramString1 = ((JSONArray)localObject).toString();
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(paramString2, paramString1);
    return ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acer
 * JD-Core Version:    0.7.0.1
 */