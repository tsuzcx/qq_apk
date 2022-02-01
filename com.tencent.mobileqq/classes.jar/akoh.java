import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class akoh
  extends aknz
{
  public int c;
  
  public akoh(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = amtj.a(2131714698);
  }
  
  public Object a(int paramInt, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof akoh)) && (((akoh)paramObject).c == 0))
    {
      paramObject = (akoh)paramObject;
      paramObject.jdField_a_of_type_Bdyj.a(parambdyi.jdField_a_of_type_Bdyj);
      return paramObject;
    }
    paramObject = new akoh(BaseApplication.getContext(), 0);
    paramObject.jdField_a_of_type_Bdyj = new bdyj(parambdyi.jdField_a_of_type_Bdyj);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoh
 * JD-Core Version:    0.7.0.1
 */