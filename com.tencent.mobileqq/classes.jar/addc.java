import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class addc
{
  private long jdField_a_of_type_Long;
  private addv jdField_a_of_type_Addv = new addv();
  private ArrayList<adem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public addv a()
  {
    return this.jdField_a_of_type_Addv;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      adem localadem = (adem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localadem != null)
      {
        if (localadem.a > 0) {
          return String.valueOf(localadem.a());
        }
        return String.valueOf(localadem.b());
      }
    }
    return "";
  }
  
  public ArrayList<adem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(adem paramadem, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramadem == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Addv.a(paramadem);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramadem);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramadem.a();
  }
  
  public void a(List<adem> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          adem localadem = (adem)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Addv.a(localadem);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localadem.a() + l;
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
 * Qualified Name:     addc
 * JD-Core Version:    0.7.0.1
 */