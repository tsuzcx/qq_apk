import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class akbi
{
  private static ConcurrentHashMap<String, akbi> d = new ConcurrentHashMap();
  private MsgLruCache a;
  protected ConcurrentHashMap<String, Object> a;
  private ConcurrentHashMap<String, List<MessageRecord>> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<MessageRecord>> c = new ConcurrentHashMap();
  
  private akbi()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache = new MsgLruCache();
  }
  
  public static akbi a(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = "null";
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        str = paramString;
      }
    }
    paramString = (akbi)d.get(str);
    if (paramString == null) {
      synchronized (d)
      {
        if (!d.containsKey(str))
        {
          paramString = new akbi();
          d.put(str, paramString);
          return paramString;
        }
        paramString = (akbi)d.get(str);
      }
    }
    return paramString;
  }
  
  public static void a(String arg0)
  {
    String str = ???;
    if (??? == null)
    {
      ??? = "null";
      str = ???;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        str = ???;
      }
    }
    synchronized (d)
    {
      if (d.containsKey(str)) {
        ((akbi)d.remove(str)).a().destroy();
      }
      return;
    }
  }
  
  public MsgLruCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache;
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = akbm.a(???, paramInt);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  public ConcurrentHashMap<String, List<MessageRecord>> a()
  {
    if (akdn.a) {
      return this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache;
    }
    return this.b;
  }
  
  public ConcurrentHashMap<String, List<MessageRecord>> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbi
 * JD-Core Version:    0.7.0.1
 */