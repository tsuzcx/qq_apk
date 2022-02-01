import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class acwg
  extends aomz
{
  private acwe jdField_a_of_type_Acwe;
  private acwf jdField_a_of_type_Acwf;
  private beqt jdField_a_of_type_Beqt;
  private volatile boolean jdField_a_of_type_Boolean;
  private beqt jdField_b_of_type_Beqt;
  private volatile boolean jdField_b_of_type_Boolean;
  private beqt c;
  
  public acwg(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, acwe paramacwe)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Acwe = paramacwe;
    this.jdField_a_of_type_Acwf = new acwf(paramQQAppInterface, paramProxyManager, paramacwe);
    this.jdField_a_of_type_Beqt = new beqt(paramQQAppInterface, paramProxyManager, paramacwe);
    this.jdField_b_of_type_Beqt = new beqt(paramQQAppInterface, paramProxyManager, paramacwe);
    this.c = new beqt(paramQQAppInterface, paramProxyManager, paramacwe);
  }
  
  public acwf a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_Acwf;
    case 1: 
      return this.jdField_a_of_type_Beqt;
    case 3000: 
      return this.jdField_b_of_type_Beqt;
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
      bctq localbctq1;
      int k;
      int i;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_Beqt.a();
          this.jdField_b_of_type_Beqt.a();
          this.jdField_a_of_type_Acwf.a();
          this.c.a();
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().getRecentList(true);
          if (localList1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
          }
          localbctq1 = new bctq();
          localbctq1.jdField_a_of_type_Int = 0;
          localbctq1.jdField_a_of_type_JavaLangString = "select";
          localbctq1.jdField_b_of_type_JavaLangString = "launch";
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
      if ((localbctq1.jdField_b_of_type_Int != 0) && (bctj.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localbctq1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localbctq1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localbctq1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localbctq1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localbctq1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localbctq1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localbctq1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        bctj.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localbctq1.c, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label469:
      if (((RecentUser)localList1.get(k)).getType() != 6000)
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (anhk.N.equals(((RecentUser)localList1.get(k)).uin))) {
          bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Acwe.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        try
        {
          List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localbctq2);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            this.jdField_a_of_type_Acwe.b().put(acwh.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType()), localList2);
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
    this.jdField_a_of_type_Beqt.b();
    this.jdField_b_of_type_Beqt.b();
    this.jdField_a_of_type_Acwf.b();
    this.c.b();
  }
  
  public void c()
  {
    int j = 0;
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      List localList1;
      bctq localbctq1;
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
          localbctq1 = new bctq();
          localbctq1.jdField_a_of_type_Int = 0;
          localbctq1.jdField_a_of_type_JavaLangString = "select";
          localbctq1.jdField_b_of_type_JavaLangString = "launch";
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
      if ((localbctq1.jdField_b_of_type_Int != 0) && (bctj.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localbctq1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localbctq1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localbctq1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localbctq1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localbctq1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localbctq1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localbctq1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        bctj.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localbctq1.c, 0L, (HashMap)localObject1, null, false);
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
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (anhk.N.equals(((RecentUser)localList1.get(k)).uin))) {
          bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Acwe.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        for (;;)
        {
          try
          {
            List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localbctq2);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              this.jdField_a_of_type_Acwe.b().put(acwh.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType()), localList2);
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
 * Qualified Name:     acwg
 * JD-Core Version:    0.7.0.1
 */