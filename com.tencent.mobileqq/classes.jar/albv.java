import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class albv
{
  private static albv jdField_a_of_type_Albv;
  public int a;
  public String a;
  public AtomicInteger a;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public albv()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static albv a()
  {
    try
    {
      if (jdField_a_of_type_Albv == null) {
        jdField_a_of_type_Albv = new albv();
      }
      albv localalbv = jdField_a_of_type_Albv;
      return localalbv;
    }
    finally {}
  }
  
  public albv a(QQAppInterface paramQQAppInterface)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albv
 * JD-Core Version:    0.7.0.1
 */