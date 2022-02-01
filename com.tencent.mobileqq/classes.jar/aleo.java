import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aleo
  extends aleq
{
  public aleo(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anni.a(2131696524);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aleo))
    {
      paramObject = (aleo)paramObject;
      paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
    }
    for (parambepr = paramObject;; parambepr = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(bepr.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return parambepr;
      paramObject = new aleo(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */