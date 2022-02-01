import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class allg
  extends alky
{
  public int c;
  
  public allg(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = anvx.a(2131715046);
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof allg)) && (((allg)paramObject).c == 0))
    {
      paramObject = (allg)paramObject;
      paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
      return paramObject;
    }
    paramObject = new allg(BaseApplication.getContext(), 0);
    paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */