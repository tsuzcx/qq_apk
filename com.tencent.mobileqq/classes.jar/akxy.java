import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class akxy
{
  private akwu jdField_a_of_type_Akwu;
  private akxn jdField_a_of_type_Akxn;
  private akxr jdField_a_of_type_Akxr;
  private CopyOnWriteArrayList<akxp> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public akxy(akxr paramakxr, akwu paramakwu, akxn paramakxn)
  {
    this.jdField_a_of_type_Akwu = paramakwu;
    this.jdField_a_of_type_Akxr = paramakxr;
    this.jdField_a_of_type_Akxn = paramakxn;
  }
  
  public akxp a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      akxp localakxp = (akxp)localIterator.next();
      if (localakxp.b() == paramInt) {
        return localakxp;
      }
    }
    return null;
  }
  
  public akxp a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akxr == null) {
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
        localObject = new akxq(paramInt1, paramInt2, this.jdField_a_of_type_Akxr, this.jdField_a_of_type_Akxn);
      }
    }
    while ((localObject != null) && (((akxp)localObject).a()))
    {
      ((akxp)localObject).d();
      ((akxp)localObject).a(this.jdField_a_of_type_Akwu);
      ((akxp)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new akxo(paramInt1, this.jdField_a_of_type_Akxr, this.jdField_a_of_type_Akxn);
      continue;
      localObject = new akxo(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Akxr, this.jdField_a_of_type_Akxn);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akxr == null) {
      return;
    }
    if (this.jdField_a_of_type_Akxr.a() == null)
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
      ((akxp)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxy
 * JD-Core Version:    0.7.0.1
 */