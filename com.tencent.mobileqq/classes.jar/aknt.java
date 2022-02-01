import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class aknt
  extends aknz
{
  public aknt(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public Object a(int paramInt, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = null;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramQQAppInterface = aowk.a((MessageForArkApp)paramMessageRecord);
    }
    if ((paramObject instanceof aknt))
    {
      paramObject = (aknt)paramObject;
      if (paramQQAppInterface != null) {
        paramObject.a(paramQQAppInterface);
      }
      paramObject.jdField_a_of_type_Bdyj.a(parambdyi.jdField_a_of_type_Bdyj);
      return paramObject;
    }
    paramObject = BaseApplication.getContext();
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      paramObject = new aknt(paramObject, paramQQAppInterface);
      paramObject.jdField_a_of_type_Bdyj = new bdyj(parambdyi.jdField_a_of_type_Bdyj);
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
 * Qualified Name:     aknt
 * JD-Core Version:    0.7.0.1
 */