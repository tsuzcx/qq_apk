import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aawa
  extends aavz
{
  private int b;
  
  public aawa(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    String str = super.a();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("patch7zUrl", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("patchSize", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("patch7zSize", this.jdField_b_of_type_Int);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtGeN writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchName", null);
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("patch7zUrl", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchSize", 0);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("patch7zSize", 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aawa
 * JD-Core Version:    0.7.0.1
 */