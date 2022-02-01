import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class alqy
  extends alqb
{
  public alqy(Context paramContext) {}
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return null;
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
      if (this.jdField_a_of_type_Bfoz == null) {
        this.jdField_a_of_type_Bfoz = new bfoz();
      }
      this.jdField_a_of_type_Bfoz.a(paramArrayOfByte.getString("messageNavInfo"));
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
      if (this.jdField_a_of_type_Bfoz != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Bfoz.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqy
 * JD-Core Version:    0.7.0.1
 */