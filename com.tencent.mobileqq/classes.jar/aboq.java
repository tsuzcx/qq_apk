import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class aboq
{
  private MsgLruCache a;
  protected ConcurrentHashMap<String, Lock> a;
  private ConcurrentHashMap<String, List<MessageRecord>> b;
  
  public aboq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgPool", 2, "MsgPool() called " + this);
    }
    this.b = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache = new MsgLruCache(this);
  }
  
  public MsgLruCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache;
  }
  
  public Map<String, List<MessageRecord>> a()
  {
    return this.b;
  }
  
  public Lock a(String arg1, int paramInt)
  {
    String str = abot.a(???, paramInt);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new ReentrantLock());
      }
      return (Lock)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aboq
 * JD-Core Version:    0.7.0.1
 */