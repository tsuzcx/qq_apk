import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alqj
  extends alqi
{
  public alqj(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("[" + anzj.a(2131696599) + "]");
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)bdow.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof alqj))
      {
        paramObject = (alqj)paramObject;
        paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      }
      for (parambfoy = paramObject;; parambfoy = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          parambfoy.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        }
        return parambfoy;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new alqj(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqj
 * JD-Core Version:    0.7.0.1
 */