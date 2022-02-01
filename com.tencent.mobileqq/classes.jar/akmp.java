import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public final class akmp
{
  private static SparseIntArray a = new akmq();
  
  private static int a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    int i = 0;
    if (paramRecentUser == null)
    {
      j = i;
      if (QLog.isDevelopLevel())
      {
        QLog.d("RecentReportHelper", 4, "getReportID: null RecentUser for " + paramRecentBaseData);
        j = i;
      }
      return j;
    }
    int j = a.get(paramRecentUser.getType());
    i = j;
    if (j == 0)
    {
      i = j;
      if (paramRecentUser.getType() == 1008)
      {
        if (!"2909288299".equals(paramRecentUser.uin)) {
          break label146;
        }
        i = 27;
      }
    }
    for (;;)
    {
      j = i;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("RecentReportHelper", 4, "getReportID:" + i + ", for uin:" + paramRecentUser.uin + " and type:" + paramRecentUser.getType());
      return i;
      label146:
      i = j;
      if ("2010741172".equals(paramRecentUser.uin)) {
        i = 28;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    int i = a(paramRecentBaseData, paramRecentUser);
    if (i > 0)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8006824", "0X8006824", 0, 0, "" + i, "", "", "");
      if ((a(paramRecentUser)) && (paramRecentBaseData.getUnreadNum() > 0)) {
        anxs.a(-1, "", "", 8);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, boolean paramBoolean)
  {
    int j = a(paramRecentBaseData, paramRecentUser);
    if (j > 0)
    {
      if (!paramBoolean) {
        break label88;
      }
      i = 1;
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8006821", "0X8006821", i, 0, "" + j, "", "", "");
      if (a(paramRecentUser)) {
        if (!paramBoolean) {
          break label94;
        }
      }
    }
    label88:
    label94:
    for (int i = 7;; i = 9)
    {
      anxs.a(-1, "", "", i);
      return;
      i = 0;
      break;
    }
  }
  
  private static boolean a(RecentUser paramRecentUser)
  {
    return (paramRecentUser != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7230));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    if (paramRecentBaseData.getUnreadNum() <= 0) {}
    int i;
    do
    {
      return;
      i = a(paramRecentBaseData, paramRecentUser);
    } while (i <= 0);
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8006823", "0X8006823", 0, 0, "" + i, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmp
 * JD-Core Version:    0.7.0.1
 */