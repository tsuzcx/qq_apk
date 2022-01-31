import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acsj
{
  private long jdField_a_of_type_Long;
  private actc jdField_a_of_type_Actc = new actc();
  private ArrayList<actt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public actc a()
  {
    return this.jdField_a_of_type_Actc;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      actt localactt = (actt)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localactt != null)
      {
        if (localactt.a > 0) {
          return String.valueOf(localactt.a());
        }
        return String.valueOf(localactt.b());
      }
    }
    return "";
  }
  
  public ArrayList<actt> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(actt paramactt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramactt == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Actc.a(paramactt);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramactt);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramactt.a();
  }
  
  public void a(List<actt> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          actt localactt = (actt)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Actc.a(localactt);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localactt.a() + l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsj
 * JD-Core Version:    0.7.0.1
 */