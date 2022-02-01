import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class allo
  extends alkr
{
  public allo(Context paramContext) {}
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
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
      if (this.jdField_a_of_type_Bffm == null) {
        this.jdField_a_of_type_Bffm = new bffm();
      }
      this.jdField_a_of_type_Bffm.a(paramArrayOfByte.getString("messageNavInfo"));
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
      if (this.jdField_a_of_type_Bffm != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Bffm.a());
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
 * Qualified Name:     allo
 * JD-Core Version:    0.7.0.1
 */