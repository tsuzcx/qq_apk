import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class aaaf
{
  private List<aaai> jdField_a_of_type_JavaUtilList;
  private Map<String, aaah> jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private WeakReference<aaaj> jdField_a_of_type_MqqUtilWeakReference;
  private AtomicInteger b;
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.b = new AtomicInteger(0);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aaai localaaai = (aaai)localIterator.next();
      aaae.a(localaaai.jdField_a_of_type_Zzy).a(localaaai.jdField_a_of_type_JavaLangString, new aaag(this, localaaai, i));
    }
  }
  
  public void a(aaai paramaaai)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaaai);
  }
  
  public void a(aaaj paramaaaj)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaaaj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaf
 * JD-Core Version:    0.7.0.1
 */