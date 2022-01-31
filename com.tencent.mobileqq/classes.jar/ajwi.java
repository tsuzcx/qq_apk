import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ajwi
  extends ajwd
{
  public ajwi(QQAppInterface paramQQAppInterface, ajwh paramajwh, Class<? extends atmo> paramClass)
  {
    super(paramQQAppInterface, paramajwh, paramClass);
  }
  
  protected void a()
  {
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = localatmp.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        atmo localatmo = (atmo)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localatmo), localatmo);
      }
    }
    localatmp.a();
  }
  
  public void a(atmo paramatmo, int paramInt, ajwj paramajwj)
  {
    String str = a(paramatmo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramatmo);
    if (paramatmo.getStatus() == 1000)
    {
      this.a.a(paramatmo, 0, paramInt, paramajwj);
      return;
    }
    this.a.a(paramatmo, 1, paramInt, paramajwj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwi
 * JD-Core Version:    0.7.0.1
 */