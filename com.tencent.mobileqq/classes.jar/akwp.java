import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class akwp
{
  private akwl jdField_a_of_type_Akwl;
  private akwu jdField_a_of_type_Akwu;
  private CopyOnWriteArrayList<akwd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public akwp(akwl paramakwl, akwu paramakwu)
  {
    this.jdField_a_of_type_Akwu = paramakwu;
    this.jdField_a_of_type_Akwl = paramakwl;
  }
  
  public akwd a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      akwd localakwd = (akwd)localIterator.next();
      if (localakwd.b() == paramInt) {
        return localakwd;
      }
    }
    return null;
  }
  
  public akwd a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akwl == null) {
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
    for (localObject = new akwj(paramInt1, paramInt2, this.jdField_a_of_type_Akwl); (localObject != null) && (((akwd)localObject).a()); localObject = new akwc(paramInt1, this.jdField_a_of_type_Akwl))
    {
      ((akwd)localObject).d();
      ((akwd)localObject).a(this.jdField_a_of_type_Akwu);
      ((akwd)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akwl == null) {}
    akwd localakwd;
    do
    {
      return;
      if (this.jdField_a_of_type_Akwl.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localakwd = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localakwd == null) || (!(localakwd instanceof akwc)) || ((akwc)localakwd != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((akwd)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwp
 * JD-Core Version:    0.7.0.1
 */