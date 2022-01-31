import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ahqj
  extends ahpt
  implements Cloneable
{
  public int c;
  
  public ahqj(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131720284);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131720285);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahqj.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getInt("ctl_flag");
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
    if (QLog.isColorLevel()) {
      QLog.d(ahqj.class.getSimpleName(), 2, "serialize");
    }
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("remindText", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      localJSONObject.put("ctl_flag", this.c);
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
 * Qualified Name:     ahqj
 * JD-Core Version:    0.7.0.1
 */