import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class akkq
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<akkn> jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public akkq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(aukp paramaukp)
  {
    for (;;)
    {
      aukr localaukr;
      akkn localakkn;
      String str;
      akks localakks;
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
          localaukr = paramaukp.a();
          ??? = localaukr;
          localObject2 = localaukr;
          localaukr.a();
          ??? = localaukr;
          localObject2 = localaukr;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramaukp)
        {
          localObject2 = ???;
          paramaukp.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramaukp.getMessage());
          if (??? == null) {
            break label477;
          }
          ((aukr)???).b();
          return;
          paramaukp = finally;
          throw paramaukp;
          ??? = localaukr;
          localObject2 = localaukr;
          paramaukp.a(localakkn.jdField_a_of_type_Auko);
          if (localakks == null) {
            continue;
          }
          ??? = localaukr;
          localObject2 = localaukr;
          localakks.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localaukr;
        localObject2 = localaukr;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localaukr;
        localObject2 = localaukr;
        localakkn = (akkn)((Iterator)localObject3).next();
        ??? = localaukr;
        localObject2 = localaukr;
        str = localakkn.jdField_a_of_type_Auko.getTableName();
        ??? = localaukr;
        localObject2 = localaukr;
        localakks = localakkn.jdField_a_of_type_Akks;
        ??? = localaukr;
        localObject2 = localaukr;
        if (QLog.isColorLevel())
        {
          ??? = localaukr;
          localObject2 = localaukr;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localakkn.jdField_a_of_type_Int);
        }
        ??? = localaukr;
        localObject2 = localaukr;
        switch (localakkn.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localaukr;
          localObject2 = localaukr;
          paramaukp.b(localakkn.jdField_a_of_type_Auko);
          if (localakks == null) {
            continue;
          }
          ??? = localaukr;
          localObject2 = localaukr;
          localakks.a(str);
        }
      }
      label351:
      ??? = localaukr;
      label414:
      Object localObject2 = localaukr;
      paramaukp.b(localakkn.jdField_a_of_type_Auko);
      if (localakks != null)
      {
        ??? = localaukr;
        localObject2 = localaukr;
        localakks.b(str, 1);
        continue;
        label456:
        ??? = localaukr;
        localObject2 = localaukr;
        localaukr.c();
        if (localaukr != null) {
          localaukr.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector<akkn> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(auko arg1, int paramInt1, int paramInt2, akks paramakks)
  {
    paramakks = new akkn(???, paramInt1, paramInt2, paramakks);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramakks);
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
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localaukp);
    localaukp.a();
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
 * Qualified Name:     akkq
 * JD-Core Version:    0.7.0.1
 */