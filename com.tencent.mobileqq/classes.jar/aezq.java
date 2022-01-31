import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aezq
{
  private long jdField_a_of_type_Long;
  private afaj jdField_a_of_type_Afaj = new afaj();
  private ArrayList<afba> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public afaj a()
  {
    return this.jdField_a_of_type_Afaj;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      afba localafba = (afba)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localafba != null)
      {
        if (localafba.a > 0) {
          return String.valueOf(localafba.a());
        }
        return String.valueOf(localafba.b());
      }
    }
    return "";
  }
  
  public ArrayList<afba> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(afba paramafba, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramafba == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Afaj.a(paramafba);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramafba);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramafba.a();
  }
  
  public void a(List<afba> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          afba localafba = (afba)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Afaj.a(localafba);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localafba.a() + l;
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
 * Qualified Name:     aezq
 * JD-Core Version:    0.7.0.1
 */