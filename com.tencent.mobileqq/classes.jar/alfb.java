import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class alfb
  extends aleq
{
  public alfb(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anni.a(2131697707);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof alfb))
    {
      paramObject = (alfb)paramObject;
      paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
      return paramObject;
    }
    paramObject = new alfb(BaseApplication.getContext());
    paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfb
 * JD-Core Version:    0.7.0.1
 */