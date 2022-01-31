import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.os.MqqHandler;

public class aisj
  implements aism, aisq
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aisd jdField_a_of_type_Aisd;
  private aiss jdField_a_of_type_Aiss;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpriteTaskHandler.1(this);
  private BlockingDeque<aisk> jdField_a_of_type_JavaUtilConcurrentBlockingDeque;
  private CopyOnWriteArrayList<aisk> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int;
  private CopyOnWriteArrayList<aisr> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public aisj(aisd paramaisd, aiss paramaiss)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_Aisd = paramaisd;
    this.jdField_a_of_type_Aiss = paramaiss;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque(50);
    jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public aisk a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    return (aisk)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public aisk a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisk localaisk = (aisk)localIterator.next();
      if (localaisk.jdField_a_of_type_Int == paramInt) {
        return localaisk;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public aisk a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisk localaisk = (aisk)localIterator.next();
      if (localaisk.jdField_a_of_type_Long == paramLong) {
        return localaisk;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  public aisk a(long paramLong, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      localObject = null;
    }
    aisk localaisk;
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localaisk = (aisk)((Iterator)localObject).next();
      } while ((localaisk == null) || (localaisk.jdField_a_of_type_Long != paramLong) || (paramInt != 2));
      localObject = localaisk;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localaisk.jdField_a_of_type_Int) });
    return localaisk;
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[clear]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Aisd != null)) {
      bajr.a(this.jdField_a_of_type_Aisd.a(), "cmshow", "Apollo", "play_times", ApolloUtil.b(this.jdField_a_of_type_Aisd.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_Aisd.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        aisk localaisk = (aisk)localIterator.next();
        if (localaisk.jdField_a_of_type_Int == paramInt)
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localaisk);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    aisk localaisk = a(paramInt1);
    if (localaisk == null) {
      return;
    }
    if (this.jdField_a_of_type_Aiss != null) {
      this.jdField_a_of_type_Aiss.a(localaisk, localaisk.jdField_a_of_type_Long, paramInt2);
    }
    localaisk.jdField_b_of_type_Int = 6;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisr localaisr = (aisr)localIterator.next();
      if (localaisr != null) {
        localaisr.a(localaisk, localaisk.jdField_a_of_type_Long, paramInt2);
      }
    }
    a(paramInt1);
  }
  
  public void a(aisk paramaisk)
  {
    if ((paramaisk == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_Aisd == null)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addTask], fail. null param");
    }
    do
    {
      return;
      if ((1 == this.jdField_a_of_type_Aisd.d) && (paramaisk.g != 1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramaisk);
        if ((this.jdField_a_of_type_Aiss instanceof SpriteUIHandler)) {
          ((SpriteUIHandler)this.jdField_a_of_type_Aiss).a(false, true, null);
        }
        localObject1 = this.jdField_a_of_type_Aisd.a();
        localObject2 = Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Aisd.jdField_a_of_type_Int));
        if (paramaisk.g == 2) {}
        for (paramaisk = "1";; paramaisk = "2")
        {
          bajr.a((AppInterface)localObject1, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject2, paramaisk });
          return;
        }
      }
      if (!a(paramaisk)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[addTask], same task. discard it.");
    return;
    Object localObject1 = a(paramaisk.jdField_a_of_type_Long, paramaisk.g);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.offerLast(paramaisk);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long > 500L) || (!a()))
      {
        paramaisk = (aisk)this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.pollLast();
        this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
        this.jdField_a_of_type_Long = l;
        if (paramaisk == null) {
          QLog.e("cmshow_scripted_SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
        }
      }
      else
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
      paramaisk.jdField_b_of_type_Int = 1;
      i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      paramaisk.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramaisk);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramaisk.jdField_a_of_type_Int) });
      }
      b((aisk)localObject1);
      return;
    }
    ((aisk)localObject1).jdField_b_of_type_Int = 5;
    Object localObject2 = this.jdField_a_of_type_Aisd.a();
    int i = ApolloUtil.b(this.jdField_a_of_type_Aisd.jdField_a_of_type_Int);
    String str = Integer.toString(paramaisk.f);
    if (paramaisk.jdField_a_of_type_Boolean) {}
    for (paramaisk = "0";; paramaisk = "1")
    {
      bajr.a((AppInterface)localObject2, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, paramaisk });
      break;
    }
  }
  
  public void a(aisr paramaisr)
  {
    if ((paramaisr != null) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaisr)) {
        QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaisr);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisk localaisk = (aisk)localIterator.next();
      if ((localaisk != null) && (localaisk.jdField_b_of_type_Int == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    aisk localaisk;
    do
    {
      return false;
      localaisk = a(paramLong);
    } while ((localaisk == null) || (localaisk.jdField_b_of_type_Int != 3));
    return true;
  }
  
  public boolean a(aisk paramaisk)
  {
    if (paramaisk == null) {
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisk localaisk = (aisk)localIterator.next();
      if ((localaisk != null) && (localaisk.jdField_a_of_type_Long == paramaisk.jdField_a_of_type_Long) && (localaisk.g != 2) && (localaisk.g != 3)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    aisk localaisk = a(paramInt);
    if (localaisk == null) {
      return;
    }
    localaisk.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_Aiss != null) {
      this.jdField_a_of_type_Aiss.a(localaisk, localaisk.jdField_a_of_type_Long);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      aisr localaisr = (aisr)localIterator.next();
      if (localaisr != null) {
        localaisr.a(localaisk, localaisk.jdField_a_of_type_Long);
      }
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public boolean b(aisk paramaisk)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aisd == null) || (!this.jdField_a_of_type_Aisd.c()))
    {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "surfaceview is NOT ready.");
      bool = false;
    }
    aisk localaisk;
    do
    {
      return bool;
      localaisk = paramaisk;
      if (paramaisk == null) {
        localaisk = a();
      }
      if ((localaisk == null) || (localaisk.jdField_b_of_type_Int == 2)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localaisk.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localaisk.f) });
      }
    } while (localaisk.jdField_a_of_type_Aisn == null);
    localaisk.jdField_a_of_type_Aisn.b(localaisk);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisj
 * JD-Core Version:    0.7.0.1
 */