import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class akks
  extends akkn
{
  public akks(QQAppInterface paramQQAppInterface, akkr paramakkr, Class<? extends aukm> paramClass)
  {
    super(paramQQAppInterface, paramakkr, paramClass);
  }
  
  protected void a()
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = localaukn.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aukm localaukm = (aukm)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localaukm), localaukm);
      }
    }
    localaukn.a();
  }
  
  public void a(aukm paramaukm, int paramInt, akkt paramakkt)
  {
    String str = a(paramaukm);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramaukm);
    if (paramaukm.getStatus() == 1000)
    {
      this.a.a(paramaukm, 0, paramInt, paramakkt);
      return;
    }
    this.a.a(paramaukm, 1, paramInt, paramakkt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akks
 * JD-Core Version:    0.7.0.1
 */