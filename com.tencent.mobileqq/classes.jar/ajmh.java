import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ajmh
  extends ajlr
  implements Cloneable
{
  public int c;
  
  public ajmh(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131720832);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131720833);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ajmh.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getInt("ctl_flag");
      if (this.jdField_a_of_type_Bbpe == null) {
        this.jdField_a_of_type_Bbpe = new bbpe();
      }
      this.jdField_a_of_type_Bbpe.a(paramArrayOfByte.getString("messageNavInfo"));
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
      QLog.d(ajmh.class.getSimpleName(), 2, "serialize");
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
      if (this.jdField_a_of_type_Bbpe != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Bbpe.a());
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
 * Qualified Name:     ajmh
 * JD-Core Version:    0.7.0.1
 */