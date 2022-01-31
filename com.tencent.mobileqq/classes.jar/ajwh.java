import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class ajwh
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<ajwe> jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public ajwh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(atmp paramatmp)
  {
    for (;;)
    {
      atmr localatmr;
      ajwe localajwe;
      String str;
      ajwj localajwj;
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
          localatmr = paramatmp.a();
          ??? = localatmr;
          localObject2 = localatmr;
          localatmr.a();
          ??? = localatmr;
          localObject2 = localatmr;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramatmp)
        {
          localObject2 = ???;
          paramatmp.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramatmp.getMessage());
          if (??? == null) {
            break label477;
          }
          ((atmr)???).b();
          return;
          paramatmp = finally;
          throw paramatmp;
          ??? = localatmr;
          localObject2 = localatmr;
          paramatmp.a(localajwe.jdField_a_of_type_Atmo);
          if (localajwj == null) {
            continue;
          }
          ??? = localatmr;
          localObject2 = localatmr;
          localajwj.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localatmr;
        localObject2 = localatmr;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localatmr;
        localObject2 = localatmr;
        localajwe = (ajwe)((Iterator)localObject3).next();
        ??? = localatmr;
        localObject2 = localatmr;
        str = localajwe.jdField_a_of_type_Atmo.getTableName();
        ??? = localatmr;
        localObject2 = localatmr;
        localajwj = localajwe.jdField_a_of_type_Ajwj;
        ??? = localatmr;
        localObject2 = localatmr;
        if (QLog.isColorLevel())
        {
          ??? = localatmr;
          localObject2 = localatmr;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localajwe.jdField_a_of_type_Int);
        }
        ??? = localatmr;
        localObject2 = localatmr;
        switch (localajwe.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localatmr;
          localObject2 = localatmr;
          paramatmp.b(localajwe.jdField_a_of_type_Atmo);
          if (localajwj == null) {
            continue;
          }
          ??? = localatmr;
          localObject2 = localatmr;
          localajwj.a(str);
        }
      }
      label351:
      ??? = localatmr;
      label414:
      Object localObject2 = localatmr;
      paramatmp.b(localajwe.jdField_a_of_type_Atmo);
      if (localajwj != null)
      {
        ??? = localatmr;
        localObject2 = localatmr;
        localajwj.b(str, 1);
        continue;
        label456:
        ??? = localatmr;
        localObject2 = localatmr;
        localatmr.c();
        if (localatmr != null) {
          localatmr.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector<ajwe> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(atmo arg1, int paramInt1, int paramInt2, ajwj paramajwj)
  {
    paramajwj = new ajwe(???, paramInt1, paramInt2, paramajwj);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramajwj);
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
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localatmp);
    localatmp.a();
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
 * Qualified Name:     ajwh
 * JD-Core Version:    0.7.0.1
 */