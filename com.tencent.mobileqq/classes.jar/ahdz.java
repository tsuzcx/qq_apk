import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class ahdz
  extends ahdg
{
  public boolean a;
  
  public ahdz(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public ahdz(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131632198);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_Long = paramArrayOfByte.optLong("uniseq");
      this.jdField_b_of_type_Long = paramArrayOfByte.optLong("shmsgseq");
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.optString("content");
      this.jdField_b_of_type_Int = paramArrayOfByte.optInt("color");
      this.jdField_a_of_type_Boolean = paramArrayOfByte.optBoolean("isToAll");
      if (this.jdField_a_of_type_Aylu == null) {
        this.jdField_a_of_type_Aylu = new aylu();
      }
      this.jdField_a_of_type_Aylu.a(paramArrayOfByte.getString("messageNavInfo"));
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] a()
  {
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.jdField_a_of_type_Long);
      localJSONObject.put("shmsgseq", this.jdField_b_of_type_Long);
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      localJSONObject.put("isToAll", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Aylu != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Aylu.a());
      }
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahdz
 * JD-Core Version:    0.7.0.1
 */