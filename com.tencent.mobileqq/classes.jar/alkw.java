import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alkw
  extends alky
{
  public alkw(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anvx.a(2131696975);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof alkw))
    {
      paramObject = (alkw)paramObject;
      paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
    }
    for (parambffl = paramObject;; parambffl = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(bffl.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return parambffl;
      paramObject = new alkw(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkw
 * JD-Core Version:    0.7.0.1
 */