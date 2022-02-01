import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class alez
  extends alej
  implements Cloneable
{
  public int c;
  
  public alez(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = anni.a(2131718575);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = anni.a(2131718576);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 29)
    {
      parambepr = new alez(BaseApplication.getContext(), false);
      parambepr.c = 1;
      return parambepr;
    }
    if ((paramObject instanceof alez))
    {
      paramObject = (alez)paramObject;
      paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
      return paramObject;
    }
    paramObject = new alez(BaseApplication.getContext(), false);
    paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alez.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getInt("ctl_flag");
      if (this.jdField_a_of_type_Beps == null) {
        this.jdField_a_of_type_Beps = new beps();
      }
      this.jdField_a_of_type_Beps.a(paramArrayOfByte.getString("messageNavInfo"));
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
      QLog.d(alez.class.getSimpleName(), 2, "serialize");
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
      if (this.jdField_a_of_type_Beps != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Beps.a());
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
 * Qualified Name:     alez
 * JD-Core Version:    0.7.0.1
 */