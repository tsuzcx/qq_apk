import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class allj
  extends alky
{
  public allj(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anvx.a(2131698221);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof allj))
    {
      paramObject = (allj)paramObject;
      paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
      return paramObject;
    }
    paramObject = new allj(BaseApplication.getContext());
    paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allj
 * JD-Core Version:    0.7.0.1
 */