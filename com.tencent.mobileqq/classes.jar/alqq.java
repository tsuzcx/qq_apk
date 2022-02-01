import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class alqq
  extends alqi
{
  public int c;
  
  public alqq(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = anzj.a(2131714466);
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof alqq)) && (((alqq)paramObject).c == 0))
    {
      paramObject = (alqq)paramObject;
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
    }
    paramObject = new alqq(BaseApplication.getContext(), 0);
    paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqq
 * JD-Core Version:    0.7.0.1
 */