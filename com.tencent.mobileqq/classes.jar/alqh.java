import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class alqh
  extends alqi
{
  public alqh(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anzj.a(2131696569);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof alqh))
    {
      paramObject = (alqh)paramObject;
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
    }
    paramObject = new alqh(BaseApplication.getContext());
    paramObject.a(paramMessageRecord.senderuin);
    paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqh
 * JD-Core Version:    0.7.0.1
 */