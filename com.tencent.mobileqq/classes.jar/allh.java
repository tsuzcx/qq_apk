import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class allh
  extends alkr
  implements Cloneable
{
  public int c;
  
  public allh(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = anvx.a(2131719354);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = anvx.a(2131719355);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 29)
    {
      parambffl = new allh(BaseApplication.getContext(), false);
      parambffl.c = 1;
      return parambffl;
    }
    if ((paramObject instanceof allh))
    {
      paramObject = (allh)paramObject;
      paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
      return paramObject;
    }
    paramObject = new allh(BaseApplication.getContext(), false);
    paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(allh.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getInt("ctl_flag");
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
    if (QLog.isColorLevel()) {
      QLog.d(allh.class.getSimpleName(), 2, "serialize");
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
 * Qualified Name:     allh
 * JD-Core Version:    0.7.0.1
 */