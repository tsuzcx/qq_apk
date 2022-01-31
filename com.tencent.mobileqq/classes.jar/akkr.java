import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class akkr
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<akko> jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public akkr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(aukn paramaukn)
  {
    for (;;)
    {
      aukp localaukp;
      akko localakko;
      String str;
      akkt localakkt;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.jdField_a_of_type_JavaUtilVector.size());
        }
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Object localObject3 = (List)this.jdField_a_of_type_JavaUtilVector.clone();
        this.jdField_a_of_type_JavaUtilVector.clear();
        if (localObject3 == null) {
          break label477;
        }
        localObject2 = null;
        ??? = null;
        try
        {
          localaukp = paramaukn.a();
          ??? = localaukp;
          localObject2 = localaukp;
          localaukp.a();
          ??? = localaukp;
          localObject2 = localaukp;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramaukn)
        {
          localObject2 = ???;
          paramaukn.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramaukn.getMessage());
          if (??? == null) {
            break label477;
          }
          ((aukp)???).b();
          return;
          paramaukn = finally;
          throw paramaukn;
          ??? = localaukp;
          localObject2 = localaukp;
          paramaukn.a(localakko.jdField_a_of_type_Aukm);
          if (localakkt == null) {
            continue;
          }
          ??? = localaukp;
          localObject2 = localaukp;
          localakkt.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localaukp;
        localObject2 = localaukp;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localaukp;
        localObject2 = localaukp;
        localakko = (akko)((Iterator)localObject3).next();
        ??? = localaukp;
        localObject2 = localaukp;
        str = localakko.jdField_a_of_type_Aukm.getTableName();
        ??? = localaukp;
        localObject2 = localaukp;
        localakkt = localakko.jdField_a_of_type_Akkt;
        ??? = localaukp;
        localObject2 = localaukp;
        if (QLog.isColorLevel())
        {
          ??? = localaukp;
          localObject2 = localaukp;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localakko.jdField_a_of_type_Int);
        }
        ??? = localaukp;
        localObject2 = localaukp;
        switch (localakko.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localaukp;
          localObject2 = localaukp;
          paramaukn.b(localakko.jdField_a_of_type_Aukm);
          if (localakkt == null) {
            continue;
          }
          ??? = localaukp;
          localObject2 = localaukp;
          localakkt.a(str);
        }
      }
      label351:
      ??? = localaukp;
      label414:
      Object localObject2 = localaukp;
      paramaukn.b(localakko.jdField_a_of_type_Aukm);
      if (localakkt != null)
      {
        ??? = localaukp;
        localObject2 = localaukp;
        localakkt.b(str, 1);
        continue;
        label456:
        ??? = localaukp;
        localObject2 = localaukp;
        localaukp.c();
        if (localaukp != null) {
          localaukp.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector<akko> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(aukm arg1, int paramInt1, int paramInt2, akkt paramakkt)
  {
    paramakkt = new akko(???, paramInt1, paramInt2, paramakkt);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramakkt);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache", 2, "addQueue after destroy");
          }
          b();
          return;
        }
      }
      switch (paramInt2)
      {
      case 2: 
      default: 
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "transSaveToDatabase");
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localaukn);
    localaukn.a();
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkr
 * JD-Core Version:    0.7.0.1
 */