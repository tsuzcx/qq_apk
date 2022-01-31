import org.json.JSONException;
import org.json.JSONObject;

public class ajhi
  extends ajhc
{
  private String d;
  
  public ajhi a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String a()
  {
    return this.d;
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
      this.d = paramArrayOfByte.getString("senderUin");
      if (this.jdField_a_of_type_Bbkv == null) {
        this.jdField_a_of_type_Bbkv = new bbkv();
      }
      this.jdField_a_of_type_Bbkv.a(paramArrayOfByte.getString("messageNavInfo"));
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
      localJSONObject.put("senderUin", this.d);
      if (this.jdField_a_of_type_Bbkv != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Bbkv.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhi
 * JD-Core Version:    0.7.0.1
 */