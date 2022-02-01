import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abvq
{
  private int jdField_a_of_type_Int;
  private abvl jdField_a_of_type_Abvl;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public abvq(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("enable", false);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchType", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchVersion", 0);
    this.b = paramJSONObject.optString("appVersion", null);
    this.c = paramJSONObject.optString("revision", null);
    paramJSONObject = paramJSONObject.optJSONArray("patchItemConfigs");
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (i < paramJSONObject.length())
        {
          abvl localabvl = abvl.a(this.jdField_a_of_type_JavaLangString, paramJSONObject.getJSONObject(i));
          if (localabvl != null) {
            this.jdField_a_of_type_Abvl = localabvl;
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PatchLogTag", 2, "PatchConfig readFromJsonString", paramJSONObject);
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abvl a()
  {
    return this.jdField_a_of_type_Abvl;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"94cf45ad".equals(this.c))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match expect: 94cf45ad");
      return false;
    }
    if ((TextUtils.isEmpty(this.b)) || (!this.b.equals(aqmy.a(paramContext) + "." + aqmy.a(paramContext))))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig app version not match expect: " + aqmy.a(paramContext) + "." + aqmy.a(paramContext));
      return false;
    }
    if ((this.jdField_a_of_type_Abvl == null) || (!this.jdField_a_of_type_Abvl.a(paramString)))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig patchItemConfig null or invalid");
      return false;
    }
    QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig return true");
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Abvl != null) {
      return this.jdField_a_of_type_Abvl.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Abvl != null) {
      return this.jdField_a_of_type_Abvl.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Abvl != null) && (this.jdField_a_of_type_Abvl.a());
  }
  
  public int c()
  {
    if ((!b()) && (PatchCommonUtil.isArtGeN()) && (this.jdField_a_of_type_Abvl != null)) {
      return ((abvm)this.jdField_a_of_type_Abvl).a();
    }
    return b();
  }
  
  public String c()
  {
    String str = b();
    if (b()) {}
    do
    {
      return str;
      if (PatchCommonUtil.isArtGeO()) {
        return "androidO7z_" + str;
      }
    } while (!PatchCommonUtil.isArtGeN());
    return "androidN7z_" + str;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Abvl != null) && (this.jdField_a_of_type_Abvl.b());
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Abvl != null) {
      return this.jdField_a_of_type_Abvl.b;
    }
    return null;
  }
  
  public String e()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("enable", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject2).put("patchType", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("patchVersion", this.jdField_a_of_type_Int);
      ((JSONObject)localObject2).put("appVersion", this.b);
      ((JSONObject)localObject2).put("revision", this.c);
      if (this.jdField_a_of_type_Abvl != null)
      {
        String str = this.jdField_a_of_type_Abvl.a();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(0, new JSONObject(str));
        ((JSONObject)localObject2).put("patchItemConfigs", localJSONArray);
      }
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PatchLogTag", 2, "PatchConfig writeToJsonString", localJSONException);
    }
    return localObject1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvq
 * JD-Core Version:    0.7.0.1
 */