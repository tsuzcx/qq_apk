import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;

public class abut
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public abut() {}
  
  public abut(SharedPreferences paramSharedPreferences, String paramString)
  {
    String str1 = a("ver", paramString);
    String str2 = a("system", paramString);
    String str3 = a("driver", paramString);
    String str4 = a("url", paramString);
    String str5 = a("type", paramString);
    String str6 = a("status", paramString);
    String str7 = a("previousPatch", paramString);
    String str8 = a("enabled", paramString);
    this.b = paramSharedPreferences.getString(str1, "");
    this.c = paramSharedPreferences.getString(str2, "");
    this.d = paramSharedPreferences.getString(str3, "");
    this.e = paramSharedPreferences.getString(str4, "");
    this.f = paramSharedPreferences.getString(str5, "");
    this.g = paramSharedPreferences.getString(str6, "");
    this.k = paramSharedPreferences.getString(str7, "").trim();
    this.a = paramString;
    this.h = paramSharedPreferences.getString(str8, "").trim();
  }
  
  public static abut a(JSONObject paramJSONObject)
  {
    abut localabut = new abut();
    try
    {
      localabut.a = paramJSONObject.getString("name").trim();
      localabut.b = paramJSONObject.getString("ver").trim();
      localabut.c = paramJSONObject.getString("system").trim();
      localabut.d = paramJSONObject.getString("driver").trim();
      localabut.e = paramJSONObject.getString("url").trim();
      localabut.f = paramJSONObject.getString("type").trim();
      localabut.h = paramJSONObject.getString("enabled").trim();
      localabut.k = paramJSONObject.optString("previousPatch", "").trim();
      return localabut;
    }
    catch (Exception paramJSONObject)
    {
      abui.a("PatchInfo", "Parse PatchInfo from JSON exception " + paramJSONObject);
    }
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.a);
      localJSONObject.put("ver", this.b);
      localJSONObject.put("system", this.c);
      localJSONObject.put("driver", this.d);
      localJSONObject.put("url", this.e);
      localJSONObject.put("type", this.f);
      localJSONObject.put("enabled", this.h);
      localJSONObject.put("previousPatch", this.k);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      abui.a("PatchInfo", "Get JSON String failed " + localJSONException);
    }
    return new JSONObject();
  }
  
  public void a(SharedPreferences.Editor paramEditor)
  {
    String str1 = a("ver", this.a);
    String str2 = a("system", this.a);
    String str3 = a("driver", this.a);
    String str4 = a("url", this.a);
    String str5 = a("type", this.a);
    String str6 = a("status", this.a);
    String str7 = a("previousPatch", this.a);
    String str8 = a("enabled", this.a);
    paramEditor.remove(str1);
    paramEditor.remove(str2);
    paramEditor.remove(str3);
    paramEditor.remove(str4);
    paramEditor.remove(str5);
    paramEditor.remove(str6);
    paramEditor.remove(str7);
    paramEditor.remove(str8);
    paramEditor.commit();
  }
  
  public boolean a()
  {
    return this.h.equals("true");
  }
  
  public void b(SharedPreferences.Editor paramEditor)
  {
    String str1 = a("ver", this.a);
    String str2 = a("system", this.a);
    String str3 = a("driver", this.a);
    String str4 = a("url", this.a);
    String str5 = a("type", this.a);
    String str6 = a("status", this.a);
    String str7 = a("previousPatch", this.a);
    String str8 = a("enabled", this.a);
    paramEditor.putString(str1, this.b);
    paramEditor.putString(str2, this.c);
    paramEditor.putString(str3, this.d);
    paramEditor.putString(str4, this.e);
    paramEditor.putString(str5, this.f);
    paramEditor.putString(str6, this.g);
    paramEditor.putString(str7, this.k);
    paramEditor.putString(str8, this.h);
    paramEditor.commit();
  }
  
  public boolean b()
  {
    return abuv.a(this.c);
  }
  
  public String toString()
  {
    return "I'm Patch " + this.a + "," + this.h + "," + this.f + "," + this.e + "," + this.j + "," + this.k + "," + this.i + "," + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abut
 * JD-Core Version:    0.7.0.1
 */