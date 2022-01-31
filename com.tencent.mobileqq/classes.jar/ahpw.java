import org.json.JSONException;
import org.json.JSONObject;

public class ahpw
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  
  public JSONObject a()
  {
    try
    {
      localJSONObject = new JSONObject();
      localJSONException1.printStackTrace();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localJSONObject.put("entryID", this.jdField_a_of_type_Int);
        localJSONObject.put("redDotVersion", this.jdField_b_of_type_Int);
        localJSONObject.put("showRedDot", this.jdField_a_of_type_Boolean);
        localJSONObject.put("userCanceled", this.jdField_b_of_type_Boolean);
        localJSONObject.put("lastCancelTime", this.jdField_a_of_type_Long);
        return localJSONObject;
      }
      catch (JSONException localJSONException2)
      {
        JSONObject localJSONObject;
        break label68;
      }
      localJSONException1 = localJSONException1;
      localJSONObject = null;
    }
    label68:
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("entryID");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion");
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot");
      this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("userCanceled");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("lastCancelTime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpw
 * JD-Core Version:    0.7.0.1
 */