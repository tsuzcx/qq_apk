import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class alqr
  extends alqb
  implements Cloneable
{
  public int c;
  
  public alqr(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = anzj.a(2131718711);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = anzj.a(2131718712);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 29)
    {
      parambfoy = new alqr(BaseApplication.getContext(), false);
      parambfoy.c = 1;
      return parambfoy;
    }
    if ((paramObject instanceof alqr))
    {
      paramObject = (alqr)paramObject;
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
    }
    paramObject = new alqr(BaseApplication.getContext(), false);
    paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(alqr.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getInt("ctl_flag");
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
    if (QLog.isColorLevel()) {
      QLog.d(alqr.class.getSimpleName(), 2, "serialize");
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
 * Qualified Name:     alqr
 * JD-Core Version:    0.7.0.1
 */