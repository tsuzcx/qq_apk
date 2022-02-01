import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class akoo
  extends akns
  implements Cloneable
{
  private String d;
  
  public akoo(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = amtj.a(2131698750);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof akoo))
    {
      paramObject = (akoo)paramObject;
      paramObject.jdField_a_of_type_Bdyj.a(parambdyi.jdField_a_of_type_Bdyj);
      return paramObject;
    }
    paramObject = new akoo(BaseApplication.getContext());
    paramObject.a(paramMessageRecord.senderuin);
    paramObject.jdField_a_of_type_Bdyj = new bdyj(parambdyi.jdField_a_of_type_Bdyj);
    return paramObject;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_a_of_type_Int = paramArrayOfByte.getInt("time");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getString("messageNavInfo");
      this.d = paramArrayOfByte.getString("senderUin");
      if ((this.c != null) && (this.c.length() != 0)) {
        this.jdField_a_of_type_Bdyj.a(this.c);
      }
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
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("time", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      localJSONObject.put("senderUin", this.d);
      if (this.jdField_a_of_type_Bdyj != null) {
        this.c = this.jdField_a_of_type_Bdyj.a();
      }
      localJSONObject.put("messageNavInfo", this.c);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoo
 * JD-Core Version:    0.7.0.1
 */