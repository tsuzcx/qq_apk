import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alkz
  extends alky
{
  public alkz(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("[" + anvx.a(2131697007) + "]");
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)bdof.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof alkz))
      {
        paramObject = (alkz)paramObject;
        paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
      }
      for (parambffl = paramObject;; parambffl = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          parambffl.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        }
        return parambffl;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new alkz(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkz
 * JD-Core Version:    0.7.0.1
 */