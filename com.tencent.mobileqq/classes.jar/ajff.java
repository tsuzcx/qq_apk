import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajff
{
  private ajfb jdField_a_of_type_Ajfb;
  private ajfk jdField_a_of_type_Ajfk;
  private CopyOnWriteArrayList<ajet> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ajff(ajfb paramajfb, ajfk paramajfk)
  {
    this.jdField_a_of_type_Ajfk = paramajfk;
    this.jdField_a_of_type_Ajfb = paramajfb;
  }
  
  public ajet a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajet localajet = (ajet)localIterator.next();
      if (localajet.b() == paramInt) {
        return localajet;
      }
    }
    return null;
  }
  
  public ajet a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajfb == null) {
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
    for (localObject = new ajez(paramInt1, paramInt2, this.jdField_a_of_type_Ajfb); (localObject != null) && (((ajet)localObject).a()); localObject = new ajes(paramInt1, this.jdField_a_of_type_Ajfb))
    {
      ((ajet)localObject).d();
      ((ajet)localObject).a(this.jdField_a_of_type_Ajfk);
      ((ajet)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajfb == null) {}
    ajet localajet;
    do
    {
      return;
      if (this.jdField_a_of_type_Ajfb.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localajet = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localajet == null) || (!(localajet instanceof ajes)) || ((ajes)localajet != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ajet)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajff
 * JD-Core Version:    0.7.0.1
 */