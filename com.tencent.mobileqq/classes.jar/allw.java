import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class allw
{
  public static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    Iterator localIterator = allv.a(paramQQAppInterface).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (paramMessage == null) {
        break label63;
      }
      i = bapk.a(paramQQAppInterface, localRecentUser.uin, localRecentUser.type, i, null).a() + i;
    }
    label63:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static long a()
  {
    return a().getLong("filter_msg_time", 0L);
  }
  
  private static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "file_filter_msg" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgBoxUtil", 2, "saveUpdateTime() called with: updateTime = [" + paramLong + "]");
    }
    a().edit().putLong("filter_msg_time", paramLong).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allw
 * JD-Core Version:    0.7.0.1
 */