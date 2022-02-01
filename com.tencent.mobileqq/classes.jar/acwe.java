import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

public class acwe
{
  protected ConcurrentHashMap<String, Lock> a;
  private ConcurrentHashMap<String, List<MessageRecord>> b;
  private ConcurrentHashMap<String, List<MessageRecord>> c;
  
  public acwe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgPool", 2, "MsgPool() called " + this);
    }
    this.c = new ConcurrentHashMap();
    this.a = new ConcurrentHashMap();
    this.b = a();
  }
  
  public Map<String, List<MessageRecord>> a()
  {
    return this.c;
  }
  
  @NotNull
  protected ConcurrentHashMap<String, List<MessageRecord>> a()
  {
    return new ConcurrentHashMap();
  }
  
  public Lock a(String paramString)
  {
    if (!this.a.containsKey(paramString)) {}
    synchronized (this.a)
    {
      if (!this.a.containsKey(paramString)) {
        this.a.put(paramString, new ReentrantLock());
      }
      return (Lock)this.a.get(paramString);
    }
  }
  
  public Lock a(String paramString, int paramInt)
  {
    return a(acwh.a(paramString, paramInt));
  }
  
  public ConcurrentHashMap<String, List<MessageRecord>> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwe
 * JD-Core Version:    0.7.0.1
 */