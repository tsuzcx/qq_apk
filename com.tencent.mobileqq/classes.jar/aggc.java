import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aggc
{
  private long jdField_a_of_type_Long;
  private aggv jdField_a_of_type_Aggv = new aggv();
  private ArrayList<aghm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public aggv a()
  {
    return this.jdField_a_of_type_Aggv;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      aghm localaghm = (aghm)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localaghm != null)
      {
        if (localaghm.a > 0) {
          return String.valueOf(localaghm.a());
        }
        return String.valueOf(localaghm.b());
      }
    }
    return "";
  }
  
  public ArrayList<aghm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(aghm paramaghm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramaghm == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Aggv.a(paramaghm);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaghm);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramaghm.a();
  }
  
  public void a(List<aghm> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          aghm localaghm = (aghm)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Aggv.a(localaghm);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localaghm.a() + l;
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
 * Qualified Name:     aggc
 * JD-Core Version:    0.7.0.1
 */