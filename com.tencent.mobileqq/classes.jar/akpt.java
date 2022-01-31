import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akpt
{
  private static boolean a;
  private static boolean b;
  
  public static void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramMessageRecord.istroop));
    axrl.a(BaseApplication.getContext()).a(null, "actInvalidMessageRecord", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString)
  {
    if (!a)
    {
      a = true;
      c("reportSaveInvalidUserError");
      axps.a(new RuntimeException(), paramString);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramInt == 1008) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = ((ajxn)paramQQAppInterface.getManager(51)).c(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
        return true;
      }
    }
    return false;
  }
  
  public static void b(String paramString)
  {
    if (!b)
    {
      b = true;
      c("reportInvalidRefredshLastMsg");
      axps.a(new RuntimeException(), paramString);
    }
  }
  
  public static void c(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(512);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append("\n");
      i += 1;
    }
    QLog.i(paramString, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpt
 * JD-Core Version:    0.7.0.1
 */