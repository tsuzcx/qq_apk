import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aaog
{
  private static final aaoi jdField_a_of_type_Aaoi = new aaoi(null);
  private CopyOnWriteArrayList<aany> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static aaog a()
  {
    return (aaog)jdField_a_of_type_Aaoi.getInstance();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aany)localIterator.next()).b();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aany)localIterator.next()).a(paramLong);
      }
    }
  }
  
  public void a(aany paramaany)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaany);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aany)localIterator.next()).a();
      }
    }
  }
  
  public void b(aany paramaany)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaany);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaog
 * JD-Core Version:    0.7.0.1
 */