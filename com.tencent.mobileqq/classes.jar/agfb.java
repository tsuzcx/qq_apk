import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class agfb
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  private static String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if ((paramMessageRecord.sb instanceof QQText)) {
        return ((QQText)paramMessageRecord.sb).mSource;
      }
      if ((paramMessageRecord.sb instanceof Spannable)) {
        return paramMessageRecord.sb.toString();
      }
    }
    else
    {
      if ((paramMessageRecord instanceof MessageForMixedMsg)) {
        return paramMessageRecord.msg;
      }
      if ((paramMessageRecord instanceof MessageForReplyText)) {
        return ((MessageForReplyText)paramMessageRecord).getSummaryMsg();
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramQQAppInterface, paramMessageRecord, paramInt, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    if (a(paramMessageRecord))
    {
      paramMessageRecord = a(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData  reportConfig -> " + jdField_a_of_type_JavaUtilHashMap);
      }
      if (!a(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData load config from QConfigManager");
        }
        WeakReference localWeakReference = new WeakReference(paramQQAppInterface);
        ThreadManager.getFileThreadHandler().post(new ECommerceDataReportUtil.1(paramQQAppInterface, localWeakReference, paramMessageRecord, paramInt, paramString));
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData hit cache");
    }
    b(paramQQAppInterface, paramMessageRecord, paramInt, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramQQAppInterface, (ChatMessage)paramList.next(), paramInt);
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (jdField_a_of_type_JavaUtilHashMap != null) && (!jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin()));
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ECommerceDataReportUtil", 2, "isMessageNeedReport : need -> " + bool);
      }
      return bool;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.contains(str))) {
        if ((paramInt != 5) || ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains(str))))
        {
          paramString1 = (String)localEntry.getValue();
          bdla.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, paramInt, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("ECommerceDataReportUtil", 2, "checkAndReport : doReport key -> " + str + ", type => " + paramInt + ", reportTag -> " + paramString1 + "， clickUrl -> " + paramString2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */