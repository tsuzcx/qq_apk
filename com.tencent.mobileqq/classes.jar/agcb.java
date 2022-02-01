import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agcb
{
  private long jdField_a_of_type_Long;
  private agcu jdField_a_of_type_Agcu = new agcu();
  private ArrayList<agdl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public agcu a()
  {
    return this.jdField_a_of_type_Agcu;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      agdl localagdl = (agdl)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localagdl != null)
      {
        if (localagdl.a > 0) {
          return String.valueOf(localagdl.a());
        }
        return String.valueOf(localagdl.b());
      }
    }
    return "";
  }
  
  public ArrayList<agdl> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(agdl paramagdl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramagdl == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Agcu.a(paramagdl);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramagdl);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramagdl.a();
  }
  
  public void a(List<agdl> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          agdl localagdl = (agdl)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Agcu.a(localagdl);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localagdl.a() + l;
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
 * Qualified Name:     agcb
 * JD-Core Version:    0.7.0.1
 */