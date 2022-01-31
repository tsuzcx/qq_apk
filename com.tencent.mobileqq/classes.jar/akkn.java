import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class akkn
{
  protected akkr a;
  public QQAppInterface a;
  protected Class<? extends aukm> a;
  protected ArrayList<akkq> a;
  public ConcurrentHashMap<String, aukm> a;
  
  public akkn(QQAppInterface paramQQAppInterface, akkr paramakkr, Class<? extends aukm> paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akkr = paramakkr;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public aukm a(String paramString)
  {
    return (aukm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(aukm paramaukm)
  {
    return Long.toString(paramaukm.getId());
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((akkq)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(aukm paramaukm)
  {
    a(paramaukm, 0, null);
  }
  
  public abstract void a(aukm paramaukm, int paramInt, akkt paramakkt);
  
  protected abstract void b();
  
  public void b(aukm paramaukm)
  {
    b(paramaukm, 0, null);
  }
  
  public void b(aukm paramaukm, int paramInt, akkt paramakkt)
  {
    String str = a(paramaukm);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramaukm);
    if (paramaukm.getStatus() == 1000)
    {
      this.jdField_a_of_type_Akkr.a(paramaukm, 0, paramInt, paramakkt);
      return;
    }
    this.jdField_a_of_type_Akkr.a(paramaukm, 1, paramInt, paramakkt);
  }
  
  public void c(aukm paramaukm)
  {
    c(paramaukm, 0, null);
  }
  
  public void c(aukm paramaukm, int paramInt, akkt paramakkt)
  {
    String str = a(paramaukm);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_Akkr.a(paramaukm, 2, paramInt, paramakkt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkn
 * JD-Core Version:    0.7.0.1
 */