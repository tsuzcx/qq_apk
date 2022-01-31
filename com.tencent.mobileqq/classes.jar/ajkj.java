import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class ajkj
{
  private static ajkj jdField_a_of_type_Ajkj;
  public int a;
  public String a;
  public AtomicInteger a;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public ajkj()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static ajkj a()
  {
    try
    {
      if (jdField_a_of_type_Ajkj == null) {
        jdField_a_of_type_Ajkj = new ajkj();
      }
      ajkj localajkj = jdField_a_of_type_Ajkj;
      return localajkj;
    }
    finally {}
  }
  
  public ajkj a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[setAppInterface] app:" + paramQQAppInterface);
    }
    return this;
  }
  
  public ReentrantLock a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[getLock].");
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "create lock.");
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
      }
      ReentrantLock localReentrantLock = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
      return localReentrantLock;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[onDestroy]");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkj
 * JD-Core Version:    0.7.0.1
 */