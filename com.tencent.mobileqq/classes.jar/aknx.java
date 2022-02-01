import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aknx
  extends aknz
{
  public aknx(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = amtj.a(2131696708);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aknx))
    {
      paramObject = (aknx)paramObject;
      paramObject.jdField_a_of_type_Bdyj.a(parambdyi.jdField_a_of_type_Bdyj);
    }
    for (parambdyi = paramObject;; parambdyi = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(bdyi.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return parambdyi;
      paramObject = new aknx(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.jdField_a_of_type_Bdyj = new bdyj(parambdyi.jdField_a_of_type_Bdyj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknx
 * JD-Core Version:    0.7.0.1
 */