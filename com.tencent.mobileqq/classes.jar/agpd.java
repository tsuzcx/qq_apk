import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agpd
{
  private long jdField_a_of_type_Long;
  private agpw jdField_a_of_type_Agpw = new agpw();
  private ArrayList<agqn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public agpw a()
  {
    return this.jdField_a_of_type_Agpw;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      agqn localagqn = (agqn)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localagqn != null)
      {
        if (localagqn.a > 0) {
          return String.valueOf(localagqn.a());
        }
        return String.valueOf(localagqn.b());
      }
    }
    return "";
  }
  
  public ArrayList<agqn> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(agqn paramagqn, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramagqn == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Agpw.a(paramagqn);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramagqn);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramagqn.a();
  }
  
  public void a(List<agqn> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          agqn localagqn = (agqn)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Agpw.a(localagqn);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localagqn.a() + l;
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
 * Qualified Name:     agpd
 * JD-Core Version:    0.7.0.1
 */