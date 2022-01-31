import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class abos
  extends amiz
{
  private aboq jdField_a_of_type_Aboq;
  private abor jdField_a_of_type_Abor;
  private bblz jdField_a_of_type_Bblz;
  private volatile boolean jdField_a_of_type_Boolean;
  private bblz jdField_b_of_type_Bblz;
  private volatile boolean jdField_b_of_type_Boolean;
  private bblz c;
  
  public abos(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, aboq paramaboq)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Aboq = paramaboq;
    this.jdField_a_of_type_Abor = new abor(paramQQAppInterface, paramProxyManager, paramaboq);
    this.jdField_a_of_type_Bblz = new bblz(paramQQAppInterface, paramProxyManager, paramaboq);
    this.jdField_b_of_type_Bblz = new bblz(paramQQAppInterface, paramProxyManager, paramaboq);
    this.c = new bblz(paramQQAppInterface, paramProxyManager, paramaboq);
  }
  
  public abor a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_Abor;
    case 1: 
      return this.jdField_a_of_type_Bblz;
    case 3000: 
      return this.jdField_b_of_type_Bblz;
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
      aznf localaznf1;
      int k;
      int i;
      long l3;
      Object localObject1;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_Bblz.a();
          this.jdField_b_of_type_Bblz.a();
          this.jdField_a_of_type_Abor.a();
          this.c.a();
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().a(true);
          if (localList1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
          }
          localaznf1 = new aznf();
          localaznf1.jdField_a_of_type_Int = 0;
          localaznf1.jdField_a_of_type_JavaLangString = "select";
          localaznf1.jdField_b_of_type_JavaLangString = "launch";
          l2 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 15)) {
          break label492;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.BaseMsgProxyContainer_" + MsgLruCache.TAG, 1, new Object[] { "INIT cost: ", Long.valueOf(l3 - l2), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          break;
        }
      }
      long l2 = System.currentTimeMillis();
      bhof.a().a("MSG_ProxyInitTime", l2 - l1 + "");
      bhof.a().a("MSG_InitMsgNum", i + "");
      this.jdField_a_of_type_Boolean = true;
      if ((localaznf1.jdField_b_of_type_Int != 0) && (azmz.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localaznf1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localaznf1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localaznf1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localaznf1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localaznf1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localaznf1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localaznf1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(alxk.jdField_a_of_type_Boolean));
        azmz.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localaznf1.c, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label492:
      if (((RecentUser)localList1.get(k)).getType() != 6000)
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (aljq.N.equals(((RecentUser)localList1.get(k)).uin))) {
          baba.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Aboq.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        try
        {
          List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localaznf2);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            this.jdField_a_of_type_Aboq.a().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
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
    this.jdField_a_of_type_Bblz.b();
    this.jdField_b_of_type_Bblz.b();
    this.jdField_a_of_type_Abor.b();
    this.c.b();
    this.jdField_a_of_type_Aboq.a().destroy();
  }
  
  public void c()
  {
    int j = 0;
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      List localList1;
      aznf localaznf1;
      long l1;
      long l2;
      try
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMsgProxyContainer", 2, "init_lazy");
          }
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().a(true);
          if (localList1 == null) {
            return;
          }
          localaznf1 = new aznf();
          localaznf1.jdField_a_of_type_Int = 0;
          localaznf1.jdField_a_of_type_JavaLangString = "select";
          localaznf1.jdField_b_of_type_JavaLangString = "launch";
          l1 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 40)) {
          break label375;
        }
        l2 = System.currentTimeMillis();
        QLog.d("Q.msg.BaseMsgProxyContainer_" + MsgLruCache.TAG, 1, new Object[] { "INIT_LAZY cost: ", Long.valueOf(l2 - l1), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException)
      {
        int m;
        continue;
      }
      this.jdField_b_of_type_Boolean = true;
      Object localObject1;
      if ((localaznf1.jdField_b_of_type_Int != 0) && (azmz.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localaznf1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localaznf1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localaznf1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localaznf1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localaznf1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localaznf1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localaznf1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(alxk.jdField_a_of_type_Boolean));
        azmz.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localaznf1.c, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label375:
      if (((RecentUser)localList1.get(k)).getType() == 6000)
      {
        m = i;
        i = j;
        j = m;
      }
      else
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (aljq.N.equals(((RecentUser)localList1.get(k)).uin))) {
          baba.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Aboq.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        for (;;)
        {
          try
          {
            List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localaznf2);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              this.jdField_a_of_type_Aboq.a().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
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
 * Qualified Name:     abos
 * JD-Core Version:    0.7.0.1
 */