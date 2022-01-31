import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ajwd
{
  protected ajwh a;
  public QQAppInterface a;
  protected Class<? extends atmo> a;
  protected ArrayList<ajwg> a;
  public ConcurrentHashMap<String, atmo> a;
  
  public ajwd(QQAppInterface paramQQAppInterface, ajwh paramajwh, Class<? extends atmo> paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajwh = paramajwh;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public atmo a(String paramString)
  {
    return (atmo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(atmo paramatmo)
  {
    return Long.toString(paramatmo.getId());
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ajwg)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(atmo paramatmo)
  {
    a(paramatmo, 0, null);
  }
  
  public abstract void a(atmo paramatmo, int paramInt, ajwj paramajwj);
  
  protected abstract void b();
  
  public void b(atmo paramatmo)
  {
    b(paramatmo, 0, null);
  }
  
  public void b(atmo paramatmo, int paramInt, ajwj paramajwj)
  {
    String str = a(paramatmo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramatmo);
    if (paramatmo.getStatus() == 1000)
    {
      this.jdField_a_of_type_Ajwh.a(paramatmo, 0, paramInt, paramajwj);
      return;
    }
    this.jdField_a_of_type_Ajwh.a(paramatmo, 1, paramInt, paramajwj);
  }
  
  public void c(atmo paramatmo)
  {
    c(paramatmo, 0, null);
  }
  
  public void c(atmo paramatmo, int paramInt, ajwj paramajwj)
  {
    String str = a(paramatmo);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_Ajwh.a(paramatmo, 2, paramInt, paramajwj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwd
 * JD-Core Version:    0.7.0.1
 */