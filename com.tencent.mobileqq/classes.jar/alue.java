import org.json.JSONException;
import org.json.JSONObject;

public class alue
{
  public int a;
  public long a;
  public int b;
  public long b;
  public long c;
  
  public alue()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static alue a(String paramString)
  {
    alue localalue = new alue();
    try
    {
      paramString = new JSONObject(paramString);
      localalue.jdField_a_of_type_Int = paramString.optInt("version", -1);
      localalue.jdField_a_of_type_Long = paramString.optLong("showDate", 0L);
      localalue.jdField_b_of_type_Long = paramString.optInt("leftShowNum", 0);
      localalue.jdField_b_of_type_Int = paramString.optInt("showCountEveryDay", 0);
      localalue.c = paramString.optInt("leftLoginNum", 0);
      return localalue;
    }
    catch (Exception paramString)
    {
      localalue.jdField_a_of_type_Int = -1;
    }
    return localalue;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.jdField_a_of_type_Int);
      localJSONObject.put("showDate", this.jdField_a_of_type_Long);
      localJSONObject.put("leftShowNum", this.jdField_b_of_type_Long);
      localJSONObject.put("showCountEveryDay", this.jdField_b_of_type_Int);
      localJSONObject.put("leftLoginNum", this.c);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MobileUnityVersionInfo [version=" + this.jdField_a_of_type_Int + ", showDate=" + this.jdField_a_of_type_Long + ", leftShowNum=" + this.jdField_b_of_type_Long + ", leftLoginNum = " + this.c + ", showCountEveryDay=" + this.jdField_b_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alue
 * JD-Core Version:    0.7.0.1
 */