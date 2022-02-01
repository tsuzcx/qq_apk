import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class alqc
  extends alqi
{
  public alqc(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = null;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramQQAppInterface = aqcz.a((MessageForArkApp)paramMessageRecord);
    }
    if ((paramObject instanceof alqc))
    {
      paramObject = (alqc)paramObject;
      if (paramQQAppInterface != null) {
        paramObject.a(paramQQAppInterface);
      }
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
    }
    paramObject = BaseApplication.getContext();
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      paramObject = new alqc(paramObject, paramQQAppInterface);
      paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
      paramQQAppInterface = "";
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = '[' + paramString + ']')
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.b = this.jdField_a_of_type_JavaLangString;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqc
 * JD-Core Version:    0.7.0.1
 */