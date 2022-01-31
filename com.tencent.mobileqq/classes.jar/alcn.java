import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class alcn
{
  private albj jdField_a_of_type_Albj;
  private alcc jdField_a_of_type_Alcc;
  private alcg jdField_a_of_type_Alcg;
  private CopyOnWriteArrayList<alce> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public alcn(alcg paramalcg, albj paramalbj, alcc paramalcc)
  {
    this.jdField_a_of_type_Albj = paramalbj;
    this.jdField_a_of_type_Alcg = paramalcg;
    this.jdField_a_of_type_Alcc = paramalcc;
  }
  
  public alce a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      alce localalce = (alce)localIterator.next();
      if (localalce.b() == paramInt) {
        return localalce;
      }
    }
    return null;
  }
  
  public alce a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Alcg == null) {
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
        localObject = new alcf(paramInt1, paramInt2, this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alcc);
      }
    }
    while ((localObject != null) && (((alce)localObject).a()))
    {
      ((alce)localObject).d();
      ((alce)localObject).a(this.jdField_a_of_type_Albj);
      ((alce)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new alcd(paramInt1, this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alcc);
      continue;
      localObject = new alcd(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alcc);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alcg == null) {
      return;
    }
    if (this.jdField_a_of_type_Alcg.a() == null)
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
      ((alce)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcn
 * JD-Core Version:    0.7.0.1
 */