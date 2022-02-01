import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class akoa
  extends aknz
{
  public akoa(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("[" + amtj.a(2131696740) + "]");
  }
  
  public Object a(int paramInt, bdyi parambdyi, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)bchh.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof akoa))
      {
        paramObject = (akoa)paramObject;
        paramObject.jdField_a_of_type_Bdyj.a(parambdyi.jdField_a_of_type_Bdyj);
      }
      for (parambdyi = paramObject;; parambdyi = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          parambdyi.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        }
        return parambdyi;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new akoa(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Bdyj = new bdyj(parambdyi.jdField_a_of_type_Bdyj);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoa
 * JD-Core Version:    0.7.0.1
 */