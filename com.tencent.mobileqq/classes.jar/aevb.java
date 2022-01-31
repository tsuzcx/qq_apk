import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aevb
{
  private long jdField_a_of_type_Long;
  private aevu jdField_a_of_type_Aevu = new aevu();
  private ArrayList<aewl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public aevu a()
  {
    return this.jdField_a_of_type_Aevu;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      aewl localaewl = (aewl)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localaewl != null)
      {
        if (localaewl.a > 0) {
          return String.valueOf(localaewl.a());
        }
        return String.valueOf(localaewl.b());
      }
    }
    return "";
  }
  
  public ArrayList<aewl> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(aewl paramaewl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramaewl == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Aevu.a(paramaewl);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaewl);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramaewl.a();
  }
  
  public void a(List<aewl> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          aewl localaewl = (aewl)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Aevu.a(localaewl);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localaewl.a() + l;
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
 * Qualified Name:     aevb
 * JD-Core Version:    0.7.0.1
 */