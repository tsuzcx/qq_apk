import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aisv
  implements aism, aisq
{
  private static int jdField_a_of_type_Int;
  private aisd jdField_a_of_type_Aisd;
  private CopyOnWriteArrayList<aisk> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int;
  private CopyOnWriteArrayList<aisr> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public aisv(aisd paramaisd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_Aisd = paramaisd;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
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
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, "[clear]");
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
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      QLog.w("cmshow_scripted_SpriteDrawerInfoTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
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
    QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    aisk localaisk = a(paramInt1);
    if (localaisk == null) {
      return;
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
    if ((paramaisk == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_Aisd == null))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoTaskHandler", 1, "[addTask], fail. null param");
      return;
    }
    paramaisk.jdField_b_of_type_Int = 1;
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    paramaisk.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramaisk);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramaisk.jdField_a_of_type_Int) });
    }
    a(null);
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
  
  public boolean a(aisk paramaisk)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aisd == null) || (!this.jdField_a_of_type_Aisd.c()))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoTaskHandler", 1, "surfaceview is NOT ready.");
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
        QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localaisk.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localaisk.f) });
      }
    } while (localaisk.jdField_a_of_type_Aisn == null);
    localaisk.jdField_a_of_type_Aisn.b(localaisk);
    return true;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    aisk localaisk = a(paramInt);
    if (localaisk == null) {
      return;
    }
    localaisk.jdField_b_of_type_Int = 3;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisv
 * JD-Core Version:    0.7.0.1
 */