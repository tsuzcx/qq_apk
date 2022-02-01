import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alqg
  extends alqi
{
  public alqg(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anzj.a(2131696567);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof alqg))
    {
      paramObject = (alqg)paramObject;
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
    }
    for (parambfoy = paramObject;; parambfoy = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(bfoy.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return parambfoy;
      paramObject = new alqg(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqg
 * JD-Core Version:    0.7.0.1
 */