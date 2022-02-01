import org.json.JSONObject;

public class ajlk
{
  public int a;
  public short a;
  public short b;
  
  public JSONObject a()
  {
    try
    {
      localJSONObject = new JSONObject();
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localJSONObject.put("entryId", this.jdField_a_of_type_Int);
        localJSONObject.put("flagId", this.jdField_a_of_type_Short);
        localJSONObject.put("flagValue", this.b);
        return localJSONObject;
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        break label46;
      }
      localException1 = localException1;
      localJSONObject = null;
    }
    label46:
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("entryId");
      this.jdField_a_of_type_Short = ((short)paramJSONObject.optInt("flagId"));
      this.b = ((short)paramJSONObject.optInt("flagValue"));
    }
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_Short != 0) && (this.b == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlk
 * JD-Core Version:    0.7.0.1
 */