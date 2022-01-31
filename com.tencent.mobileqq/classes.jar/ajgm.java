import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class ajgm
{
  private ajfi jdField_a_of_type_Ajfi;
  private ajgb jdField_a_of_type_Ajgb;
  private ajgf jdField_a_of_type_Ajgf;
  private CopyOnWriteArrayList<ajgd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ajgm(ajgf paramajgf, ajfi paramajfi, ajgb paramajgb)
  {
    this.jdField_a_of_type_Ajfi = paramajfi;
    this.jdField_a_of_type_Ajgf = paramajgf;
    this.jdField_a_of_type_Ajgb = paramajgb;
  }
  
  public ajgd a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajgd localajgd = (ajgd)localIterator.next();
      if (localajgd.b() == paramInt) {
        return localajgd;
      }
    }
    return null;
  }
  
  public ajgd a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajgf == null) {
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
        localObject = new ajge(paramInt1, paramInt2, this.jdField_a_of_type_Ajgf, this.jdField_a_of_type_Ajgb);
      }
    }
    while ((localObject != null) && (((ajgd)localObject).a()))
    {
      ((ajgd)localObject).d();
      ((ajgd)localObject).a(this.jdField_a_of_type_Ajfi);
      ((ajgd)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new ajgc(paramInt1, this.jdField_a_of_type_Ajgf, this.jdField_a_of_type_Ajgb);
      continue;
      localObject = new ajgc(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Ajgf, this.jdField_a_of_type_Ajgb);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajgf == null) {
      return;
    }
    if (this.jdField_a_of_type_Ajgf.a() == null)
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
      ((ajgd)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgm
 * JD-Core Version:    0.7.0.1
 */