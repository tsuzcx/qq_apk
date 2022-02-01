import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aczg
  extends aczc
{
  private boolean a;
  private String c;
  private String d;
  
  public aczg(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public String a()
  {
    String str = super.a();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("patchUrl", this.b);
      ((JSONObject)localObject).put("patchSize", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("driverVersion", this.c);
      ((JSONObject)localObject).put("previousPatch", this.d);
      ((JSONObject)localObject).put("isDelayLoad", this.jdField_a_of_type_Boolean);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchSize", 0);
    this.c = paramJSONObject.optString("driverVersion", null);
    this.d = paramJSONObject.optString("previousPatch", null);
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isDelayLoad", false);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(this.c))
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig isValidConfig driverVersion is null");
      return false;
    }
    return super.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aczg
 * JD-Core Version:    0.7.0.1
 */