import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class akkr
  extends akkm
{
  public akkr(QQAppInterface paramQQAppInterface, akkq paramakkq, Class<? extends auko> paramClass)
  {
    super(paramQQAppInterface, paramakkq, paramClass);
  }
  
  protected void a()
  {
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = localaukp.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        auko localauko = (auko)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localauko), localauko);
      }
    }
    localaukp.a();
  }
  
  public void a(auko paramauko, int paramInt, akks paramakks)
  {
    String str = a(paramauko);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramauko);
    if (paramauko.getStatus() == 1000)
    {
      this.a.a(paramauko, 0, paramInt, paramakks);
      return;
    }
    this.a.a(paramauko, 1, paramInt, paramakks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkr
 * JD-Core Version:    0.7.0.1
 */