import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class ajgo
{
  private ajfk jdField_a_of_type_Ajfk;
  private ajgd jdField_a_of_type_Ajgd;
  private ajgh jdField_a_of_type_Ajgh;
  private CopyOnWriteArrayList<ajgf> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ajgo(ajgh paramajgh, ajfk paramajfk, ajgd paramajgd)
  {
    this.jdField_a_of_type_Ajfk = paramajfk;
    this.jdField_a_of_type_Ajgh = paramajgh;
    this.jdField_a_of_type_Ajgd = paramajgd;
  }
  
  public ajgf a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajgf localajgf = (ajgf)localIterator.next();
      if (localajgf.b() == paramInt) {
        return localajgf;
      }
    }
    return null;
  }
  
  public ajgf a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajgh == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("CmShow_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      default: 
        localObject = new ajgg(paramInt1, paramInt2, this.jdField_a_of_type_Ajgh, this.jdField_a_of_type_Ajgd);
      }
    }
    while ((localObject != null) && (((ajgf)localObject).a()))
    {
      ((ajgf)localObject).d();
      ((ajgf)localObject).a(this.jdField_a_of_type_Ajfk);
      ((ajgf)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new ajge(paramInt1, this.jdField_a_of_type_Ajgh, this.jdField_a_of_type_Ajgd);
      continue;
      localObject = new ajge(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Ajgh, this.jdField_a_of_type_Ajgd);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajgh == null) {
      return;
    }
    if (this.jdField_a_of_type_Ajgh.a() == null)
    {
      QLog.w("CmShow_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
      return;
    }
    a(100, -1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ajgf)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgo
 * JD-Core Version:    0.7.0.1
 */