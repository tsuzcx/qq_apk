import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aler
  extends aleq
{
  public aler(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("[" + anni.a(2131696556) + "]");
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)bcwd.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof aler))
      {
        paramObject = (aler)paramObject;
        paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
      }
      for (parambepr = paramObject;; parambepr = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          parambepr.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        }
        return parambepr;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new aler(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aler
 * JD-Core Version:    0.7.0.1
 */