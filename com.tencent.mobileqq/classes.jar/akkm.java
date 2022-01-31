import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class akkm
{
  protected akkq a;
  public QQAppInterface a;
  protected Class<? extends auko> a;
  protected ArrayList<akkp> a;
  public ConcurrentHashMap<String, auko> a;
  
  public akkm(QQAppInterface paramQQAppInterface, akkq paramakkq, Class<? extends auko> paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akkq = paramakkq;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public auko a(String paramString)
  {
    return (auko)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(auko paramauko)
  {
    return Long.toString(paramauko.getId());
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((akkp)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(auko paramauko)
  {
    a(paramauko, 0, null);
  }
  
  public abstract void a(auko paramauko, int paramInt, akks paramakks);
  
  protected abstract void b();
  
  public void b(auko paramauko)
  {
    b(paramauko, 0, null);
  }
  
  public void b(auko paramauko, int paramInt, akks paramakks)
  {
    String str = a(paramauko);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramauko);
    if (paramauko.getStatus() == 1000)
    {
      this.jdField_a_of_type_Akkq.a(paramauko, 0, paramInt, paramakks);
      return;
    }
    this.jdField_a_of_type_Akkq.a(paramauko, 1, paramInt, paramakks);
  }
  
  public void c(auko paramauko)
  {
    c(paramauko, 0, null);
  }
  
  public void c(auko paramauko, int paramInt, akks paramakks)
  {
    String str = a(paramauko);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_Akkq.a(paramauko, 2, paramInt, paramakks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkm
 * JD-Core Version:    0.7.0.1
 */