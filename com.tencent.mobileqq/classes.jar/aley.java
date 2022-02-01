import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class aley
  extends aleq
{
  public int c;
  
  public aley(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = anni.a(2131714357);
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof aley)) && (((aley)paramObject).c == 0))
    {
      paramObject = (aley)paramObject;
      paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
      return paramObject;
    }
    paramObject = new aley(BaseApplication.getContext(), 0);
    paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aley
 * JD-Core Version:    0.7.0.1
 */