import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.ReportContext;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class abwy
  extends anus
{
  private abww jdField_a_of_type_Abww;
  private abwx jdField_a_of_type_Abwx;
  private bdzk jdField_a_of_type_Bdzk;
  private volatile boolean jdField_a_of_type_Boolean;
  private bdzk jdField_b_of_type_Bdzk;
  private volatile boolean jdField_b_of_type_Boolean;
  private bdzk c;
  
  public abwy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, abww paramabww)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Abww = paramabww;
    this.jdField_a_of_type_Abwx = new abwx(paramQQAppInterface, paramProxyManager, paramabww);
    this.jdField_a_of_type_Bdzk = new bdzk(paramQQAppInterface, paramProxyManager, paramabww);
    this.jdField_b_of_type_Bdzk = new bdzk(paramQQAppInterface, paramProxyManager, paramabww);
    this.c = new bdzk(paramQQAppInterface, paramProxyManager, paramabww);
  }
  
  public abwx a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_Abwx;
    case 1: 
      return this.jdField_a_of_type_Bdzk;
    case 3000: 
      return this.jdField_b_of_type_Bdzk;
    }
    return this.c;
  }
  
  protected void a()
  {
    int j = 0;
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      long l1;
      List localList1;
      StatisticCollector.ReportContext localReportContext1;
      int k;
      int i;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_Bdzk.a();
          this.jdField_b_of_type_Bdzk.a();
          this.jdField_a_of_type_Abwx.a();
          this.c.a();
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().getRecentList(true);
          if (localList1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
          }
          localReportContext1 = new StatisticCollector.ReportContext();
          localReportContext1.MAINTHREAD_TAG = 0;
          localReportContext1.OPTTYPE_TAG = "select";
          localReportContext1.OPTSCENE_TAG = "launch";
          l2 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 15)) {
          break label469;
        }
        QLog.d("Q.msg.BaseMsgProxyContainer", 1, new Object[] { "INIT cost: ", Long.valueOf(System.currentTimeMillis() - l2), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          break;
        }
      }
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_ProxyInitTime", l2 - l1 + "");
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_InitMsgNum", i + "");
      this.jdField_a_of_type_Boolean = true;
      Object localObject1;
      if ((localReportContext1.OPTCOUNT_TAG != 0) && (StatisticCollector.SQLite3OptimizeReport()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localReportContext1.MAINTHREAD_TAG));
        ((HashMap)localObject1).put("param_OptType", localReportContext1.OPTTYPE_TAG);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localReportContext1.OPTTOTALCOST_TAG));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localReportContext1.OPTCOUNT_TAG));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localReportContext1.OPTMSGCOUNT_TAG));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localReportContext1.OPTONECOST_TAG));
        ((HashMap)localObject1).put("param_OptScene", localReportContext1.OPTSCENE_TAG);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, localReportContext1.OPTMSGCOUNT_TAG, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label469:
      if (((RecentUser)localList1.get(k)).getType() != 6000)
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(((RecentUser)localList1.get(k)).uin))) {
          bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Abww.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        try
        {
          List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localReportContext2);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            this.jdField_a_of_type_Abww.b().put(abwz.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType()), localList2);
            int m = localList2.size();
            j += 1;
            i += m;
            try
            {
              ((Lock)localObject1).unlock();
            }
            catch (Exception localException1) {}
            continue;
          }
        }
        finally
        {
          localException1.unlock();
        }
      }
      else
      {
        k += 1;
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bdzk.b();
    this.jdField_b_of_type_Bdzk.b();
    this.jdField_a_of_type_Abwx.b();
    this.c.b();
  }
  
  public void c()
  {
    int j = 0;
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      List localList1;
      StatisticCollector.ReportContext localReportContext1;
      long l;
      Object localObject1;
      try
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMsgProxyContainer", 2, "init_lazy");
          }
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().getRecentList(true);
          if (localList1 == null) {
            return;
          }
          localReportContext1 = new StatisticCollector.ReportContext();
          localReportContext1.MAINTHREAD_TAG = 0;
          localReportContext1.OPTTYPE_TAG = "select";
          localReportContext1.OPTSCENE_TAG = "launch";
          l = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 40)) {
          break label352;
        }
        QLog.d("Q.msg.BaseMsgProxyContainer", 1, new Object[] { "INIT_LAZY cost: ", Long.valueOf(System.currentTimeMillis() - l), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException)
      {
        int m;
        continue;
      }
      this.jdField_b_of_type_Boolean = true;
      if ((localReportContext1.OPTCOUNT_TAG != 0) && (StatisticCollector.SQLite3OptimizeReport()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localReportContext1.MAINTHREAD_TAG));
        ((HashMap)localObject1).put("param_OptType", localReportContext1.OPTTYPE_TAG);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localReportContext1.OPTTOTALCOST_TAG));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localReportContext1.OPTCOUNT_TAG));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localReportContext1.OPTMSGCOUNT_TAG));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localReportContext1.OPTONECOST_TAG));
        ((HashMap)localObject1).put("param_OptScene", localReportContext1.OPTSCENE_TAG);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, localReportContext1.OPTMSGCOUNT_TAG, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label352:
      if (((RecentUser)localList1.get(k)).getType() == 6000)
      {
        m = i;
        i = j;
        j = m;
      }
      else
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(((RecentUser)localList1.get(k)).uin))) {
          bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Abww.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        for (;;)
        {
          try
          {
            List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localReportContext2);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              this.jdField_a_of_type_Abww.b().put(abwz.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType()), localList2);
              int n = localList2.size();
              m = j + 1;
              j = i + n;
              i = m;
            }
          }
          finally
          {
            ((Lock)localObject1).unlock();
          }
          m = i;
          i = j;
          j = m;
          continue;
          return;
        }
      }
      m = k + 1;
      int k = j;
      j = i;
      int i = k;
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwy
 * JD-Core Version:    0.7.0.1
 */