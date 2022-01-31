import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajfd
{
  private ajez jdField_a_of_type_Ajez;
  private ajfi jdField_a_of_type_Ajfi;
  private CopyOnWriteArrayList<ajer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ajfd(ajez paramajez, ajfi paramajfi)
  {
    this.jdField_a_of_type_Ajfi = paramajfi;
    this.jdField_a_of_type_Ajez = paramajez;
  }
  
  public ajer a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajer localajer = (ajer)localIterator.next();
      if (localajer.b() == paramInt) {
        return localajer;
      }
    }
    return null;
  }
  
  public ajer a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajez == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      }
    }
    for (localObject = new ajex(paramInt1, paramInt2, this.jdField_a_of_type_Ajez); (localObject != null) && (((ajer)localObject).a()); localObject = new ajeq(paramInt1, this.jdField_a_of_type_Ajez))
    {
      ((ajer)localObject).d();
      ((ajer)localObject).a(this.jdField_a_of_type_Ajfi);
      ((ajer)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajez == null) {}
    ajer localajer;
    do
    {
      return;
      if (this.jdField_a_of_type_Ajez.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localajer = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localajer == null) || (!(localajer instanceof ajeq)) || ((ajeq)localajer != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ajer)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfd
 * JD-Core Version:    0.7.0.1
 */