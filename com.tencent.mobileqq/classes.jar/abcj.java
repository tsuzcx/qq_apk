import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class abcj
{
  private static final abcl jdField_a_of_type_Abcl = new abcl(null);
  private CopyOnWriteArrayList<abcb> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static abcj a()
  {
    return (abcj)jdField_a_of_type_Abcl.getInstance();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((abcb)localIterator.next()).b();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((abcb)localIterator.next()).a(paramLong);
      }
    }
  }
  
  public void a(abcb paramabcb)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramabcb);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((abcb)localIterator.next()).a();
      }
    }
  }
  
  public void b(abcb paramabcb)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramabcb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcj
 * JD-Core Version:    0.7.0.1
 */