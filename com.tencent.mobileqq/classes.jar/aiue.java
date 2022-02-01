import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aiue
{
  private static aiub a(aiuc paramaiuc)
  {
    if ((paramaiuc == null) || (paramaiuc.jdField_a_of_type_JavaLangString == null)) {
      return null;
    }
    if (paramaiuc.jdField_a_of_type_JavaLangString.equalsIgnoreCase("redpacket_id001")) {
      return new aitz(paramaiuc);
    }
    return new aiub(paramaiuc);
  }
  
  private static aiub a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject2 = paramJSONObject.optString("scene", "");
    String str3 = paramJSONObject.optString("title", "");
    String str4 = paramJSONObject.optString("sceneId", "");
    String str5 = paramJSONObject.optString("kvo", "");
    String str1 = paramJSONObject.optString("startDate", "");
    String str2 = paramJSONObject.optString("expiryDate", "");
    int i = paramJSONObject.optInt("switch");
    Object localObject1 = paramJSONObject.optJSONArray("keywords");
    aiuc localaiuc = new aiuc();
    localaiuc.jdField_a_of_type_Int = i;
    localaiuc.jdField_a_of_type_JavaLangString = str4;
    localaiuc.c = ((String)localObject2);
    localaiuc.jdField_b_of_type_JavaLangString = str3;
    localaiuc.d = str5;
    if ((!bhsr.a(str1)) && (!bhsr.a(str2))) {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    }
    try
    {
      localaiuc.jdField_a_of_type_JavaUtilDate = ((SimpleDateFormat)localObject2).parse(str1);
      localaiuc.jdField_b_of_type_JavaUtilDate = ((SimpleDateFormat)localObject2).parse(str2);
      if (localObject1 != null)
      {
        localaiuc.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          str1 = ((JSONArray)localObject1).optString(i);
          if (!bhsr.a(str1)) {
            localaiuc.jdField_a_of_type_JavaUtilList.add(str1);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ScenesRecommendUtils", 2, "parse invalidTime failed!", localException);
      }
      localObject1 = a(localaiuc);
      if (localObject1 == null) {
        return null;
      }
      if (!paramJSONObject.has("extra")) {}
    }
    try
    {
      ((aiub)localObject1).a(paramJSONObject.getJSONObject("extra"));
      return new aiub(localaiuc);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).getString("SCENESRECOMMEND_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static List<aiub> a(String paramString)
  {
    Object localObject1;
    if (bhsr.a(paramString)) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("ScenesRecommendUtils", 2, "parseJson  strJson = " + paramString);
      }
      localArrayList = new ArrayList();
      try
      {
        Object localObject2 = new JSONObject(paramString);
        localObject1 = localArrayList;
        if (!((JSONObject)localObject2).has("scenes")) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("scenes");
        int i = 0;
        for (;;)
        {
          localObject1 = localArrayList;
          if (i >= ((JSONArray)localObject2).length()) {
            break;
          }
          localObject1 = a(((JSONArray)localObject2).getJSONObject(i));
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        QLog.e("ScenesRecommendUtils", 2, "parseJson has exception strJson = " + paramString, localJSONException);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).edit();
    localEditor.putString("SCENESRECOMMEND_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiue
 * JD-Core Version:    0.7.0.1
 */