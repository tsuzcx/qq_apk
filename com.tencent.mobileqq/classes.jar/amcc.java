import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class amcc
{
  protected amcg a;
  public QQAppInterface a;
  protected Class<? extends awbv> a;
  protected ArrayList<amcf> a;
  public ConcurrentHashMap<String, awbv> a;
  
  public amcc(QQAppInterface paramQQAppInterface, amcg paramamcg, Class<? extends awbv> paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amcg = paramamcg;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public awbv a(String paramString)
  {
    return (awbv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(awbv paramawbv)
  {
    return Long.toString(paramawbv.getId());
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((amcf)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(awbv paramawbv)
  {
    a(paramawbv, 0, null);
  }
  
  public abstract void a(awbv paramawbv, int paramInt, amci paramamci);
  
  protected abstract void b();
  
  public void b(awbv paramawbv)
  {
    b(paramawbv, 0, null);
  }
  
  public void b(awbv paramawbv, int paramInt, amci paramamci)
  {
    String str = a(paramawbv);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramawbv);
    if (paramawbv.getStatus() == 1000)
    {
      this.jdField_a_of_type_Amcg.a(paramawbv, 0, paramInt, paramamci);
      return;
    }
    this.jdField_a_of_type_Amcg.a(paramawbv, 1, paramInt, paramamci);
  }
  
  public void c(awbv paramawbv)
  {
    c(paramawbv, 0, null);
  }
  
  public void c(awbv paramawbv, int paramInt, amci paramamci)
  {
    String str = a(paramawbv);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_Amcg.a(paramawbv, 2, paramInt, paramamci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcc
 * JD-Core Version:    0.7.0.1
 */