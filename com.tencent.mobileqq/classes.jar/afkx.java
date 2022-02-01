import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afkx
{
  private long jdField_a_of_type_Long;
  private aflq jdField_a_of_type_Aflq = new aflq();
  private ArrayList<afmh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public aflq a()
  {
    return this.jdField_a_of_type_Aflq;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      afmh localafmh = (afmh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localafmh != null)
      {
        if (localafmh.a > 0) {
          return String.valueOf(localafmh.a());
        }
        return String.valueOf(localafmh.b());
      }
    }
    return "";
  }
  
  public ArrayList<afmh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(afmh paramafmh, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramafmh == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Aflq.a(paramafmh);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramafmh);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramafmh.a();
  }
  
  public void a(List<afmh> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l;
    if (paramList != null)
    {
      l = 0L;
      if ((paramBoolean1) || (paramBoolean2))
      {
        Iterator localIterator = paramList.iterator();
        l = 0L;
        if (localIterator.hasNext())
        {
          afmh localafmh = (afmh)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Aflq.a(localafmh);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localafmh.a() + l;
        }
      }
    }
    label103:
    for (;;)
    {
      break;
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (paramBoolean2) {
        this.jdField_a_of_type_Long = (l + this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkx
 * JD-Core Version:    0.7.0.1
 */