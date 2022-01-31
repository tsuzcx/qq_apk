import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class ahqk
  extends ahpt
{
  public ahqk(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = String.format(paramContext.getString(2131697678), new Object[] { ajya.a(2131715728) });
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_Long = paramArrayOfByte.getLong("uniseq");
      this.jdField_b_of_type_Long = paramArrayOfByte.getLong("shmsgseq");
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      if (this.jdField_a_of_type_Azmm == null) {
        this.jdField_a_of_type_Azmm = new azmm();
      }
      this.jdField_a_of_type_Azmm.a(paramArrayOfByte.getString("messageNavInfo"));
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
      if (this.jdField_a_of_type_Azmm != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Azmm.a());
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
 * Qualified Name:     ahqk
 * JD-Core Version:    0.7.0.1
 */