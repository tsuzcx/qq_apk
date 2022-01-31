import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class abth
  extends amno
{
  private abtf jdField_a_of_type_Abtf;
  private abtg jdField_a_of_type_Abtg;
  private bbqi jdField_a_of_type_Bbqi;
  private volatile boolean jdField_a_of_type_Boolean;
  private bbqi jdField_b_of_type_Bbqi;
  private volatile boolean jdField_b_of_type_Boolean;
  private bbqi c;
  
  public abth(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, abtf paramabtf)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Abtf = paramabtf;
    this.jdField_a_of_type_Abtg = new abtg(paramQQAppInterface, paramProxyManager, paramabtf);
    this.jdField_a_of_type_Bbqi = new bbqi(paramQQAppInterface, paramProxyManager, paramabtf);
    this.jdField_b_of_type_Bbqi = new bbqi(paramQQAppInterface, paramProxyManager, paramabtf);
    this.c = new bbqi(paramQQAppInterface, paramProxyManager, paramabtf);
  }
  
  public abtg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_Abtg;
    case 1: 
      return this.jdField_a_of_type_Bbqi;
    case 3000: 
      return this.jdField_b_of_type_Bbqi;
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
      azro localazro1;
      int k;
      int i;
      long l3;
      Object localObject1;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_Bbqi.a();
          this.jdField_b_of_type_Bbqi.a();
          this.jdField_a_of_type_Abtg.a();
          this.c.a();
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().a(true);
          if (localList1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
          }
          localazro1 = new azro();
          localazro1.jdField_a_of_type_Int = 0;
          localazro1.jdField_a_of_type_JavaLangString = "select";
          localazro1.jdField_b_of_type_JavaLangString = "launch";
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
      bhsm.a().a("MSG_ProxyInitTime", l2 - l1 + "");
      bhsm.a().a("MSG_InitMsgNum", i + "");
      this.jdField_a_of_type_Boolean = true;
      if ((localazro1.jdField_b_of_type_Int != 0) && (azri.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localazro1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localazro1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localazro1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localazro1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localazro1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localazro1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localazro1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(ambz.jdField_a_of_type_Boolean));
        azri.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localazro1.c, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label492:
      if (((RecentUser)localList1.get(k)).getType() != 6000)
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (alof.N.equals(((RecentUser)localList1.get(k)).uin))) {
          bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Abtf.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        try
        {
          List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localazro2);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            this.jdField_a_of_type_Abtf.a().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
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
    this.jdField_a_of_type_Bbqi.b();
    this.jdField_b_of_type_Bbqi.b();
    this.jdField_a_of_type_Abtg.b();
    this.c.b();
    this.jdField_a_of_type_Abtf.a().destroy();
  }
  
  public void c()
  {
    int j = 0;
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      List localList1;
      azro localazro1;
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
          localazro1 = new azro();
          localazro1.jdField_a_of_type_Int = 0;
          localazro1.jdField_a_of_type_JavaLangString = "select";
          localazro1.jdField_b_of_type_JavaLangString = "launch";
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
      if ((localazro1.jdField_b_of_type_Int != 0) && (azri.a()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(localazro1.jdField_a_of_type_Int));
        ((HashMap)localObject1).put("param_OptType", localazro1.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(localazro1.jdField_a_of_type_Long));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(localazro1.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(localazro1.c));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(localazro1.jdField_b_of_type_Long));
        ((HashMap)localObject1).put("param_OptScene", localazro1.jdField_b_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(ambz.jdField_a_of_type_Boolean));
        azri.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localazro1.c, 0L, (HashMap)localObject1, null, false);
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
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (alof.N.equals(((RecentUser)localList1.get(k)).uin))) {
          bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Abtf.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        for (;;)
        {
          try
          {
            List localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localazro2);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              this.jdField_a_of_type_Abtf.a().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
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
 * Qualified Name:     abth
 * JD-Core Version:    0.7.0.1
 */