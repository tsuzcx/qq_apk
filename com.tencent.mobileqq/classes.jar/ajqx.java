import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajqx
{
  private static boolean a;
  private static boolean b;
  
  public static int a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("lastshowtime_weak", 0);
  }
  
  public static long a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("lastundealmsgseq", 0L);
  }
  
  private static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "notify_redpoint" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static List<Integer> a()
  {
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    if (localSharedPreferences == null) {
      return localArrayList;
    }
    localArrayList.add(0, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_year", 0)));
    localArrayList.add(1, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_day", 0)));
    localArrayList.add(2, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_weak", 0)));
    return localArrayList;
  }
  
  public static void a()
  {
    new ArrayList();
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((QQAppInterface)localObject1).a().a(antf.N, 0, null);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    long l1 = a();
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (!(localObject2 instanceof MessageForSystemMsg)) {
        break label170;
      }
      localObject2 = ((MessageForSystemMsg)localObject2).getSystemMsg();
      if ((localObject2 == null) || (!((structmsg.StructMsg)localObject2).msg.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject2).msg.get()).sub_type.get() != 1)) {
        break label170;
      }
      long l2 = ((structmsg.StructMsg)localObject2).msg_seq.get();
      if (l2 <= l1) {
        break label170;
      }
      l1 = l2;
    }
    label170:
    for (;;)
    {
      break;
      a(l1);
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneweak", paramInt).apply();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt("lastshowtime_year", paramInt1).apply();
      localSharedPreferences.edit().putInt("lastshowtime_day", paramInt2).apply();
      localSharedPreferences.edit().putInt("lastshowtime_weak", paramInt3).apply();
    }
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("lastundealmsgseq", paramLong).apply();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    arbc localarbc = (arbc)aran.a().a(634);
    if (localarbc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "troopNotificationConfig is null" });
      }
      return false;
    }
    if (!localarbc.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "isGlobalOpen is false");
      }
      return false;
    }
    if ((paramInt < localarbc.c) || (localarbc.c == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "undealMsgCount =", Integer.valueOf(paramInt), "todoGroupVerifyMsgLevel =", Integer.valueOf(localarbc.c) });
      }
      return false;
    }
    if (a()) {
      return true;
    }
    Calendar.getInstance();
    List localList = a();
    int j;
    int i;
    if (localList != null)
    {
      j = ((Integer)localList.get(0)).intValue();
      i = ((Integer)localList.get(1)).intValue();
      paramInt = ((Integer)localList.get(2)).intValue();
    }
    for (;;)
    {
      if ((1 != j) || (3 != paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Year is changed, The time update" });
        }
        a(0);
        b(0);
        a(1, 6, 3);
      }
      while ((System.currentTimeMillis() - b()) / 1000L < localarbc.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "The TimeIntervel is  little" });
        }
        return false;
        if (6 != i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Day is changed, The day update" });
          }
          b(0);
          a(1, 6, 3);
        }
      }
      if ((1 == j) && (6 == i) && (b() >= localarbc.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneDay =", Integer.valueOf(b()), "totalRemindCntOfOneDay =", Integer.valueOf(localarbc.b) });
        }
        return false;
      }
      if ((1 == j) && (3 == paramInt) && (a() >= localarbc.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneWeak =", Integer.valueOf(b()), "totalRemindCntOfOneWeak =", Integer.valueOf(localarbc.jdField_a_of_type_Int) });
        }
        return false;
      }
      return true;
      paramInt = 0;
      i = 0;
      j = 0;
    }
  }
  
  public static int b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("remindcntofoneday", 0);
  }
  
  public static long b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("intervelshowtime", 0L);
  }
  
  public static void b(int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneday", paramInt).apply();
    }
  }
  
  public static void b(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("intervelshowtime", paramLong).apply();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static int c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return 0;
    }
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((QQAppInterface)localObject).a().a(antf.N, 0, null);
    long l = a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg_seq.get() > l)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    return localArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqx
 * JD-Core Version:    0.7.0.1
 */