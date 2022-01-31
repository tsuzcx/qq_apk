import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adcz
{
  private long jdField_a_of_type_Long;
  private adds jdField_a_of_type_Adds = new adds();
  private ArrayList<adej> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public adds a()
  {
    return this.jdField_a_of_type_Adds;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      adej localadej = (adej)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localadej != null)
      {
        if (localadej.a > 0) {
          return String.valueOf(localadej.a());
        }
        return String.valueOf(localadej.b());
      }
    }
    return "";
  }
  
  public ArrayList<adej> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(adej paramadej, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramadej == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.jdField_a_of_type_Adds.a(paramadej);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramadej);
    } while (!paramBoolean2);
    this.jdField_a_of_type_Long += paramadej.a();
  }
  
  public void a(List<adej> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
          adej localadej = (adej)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_Adds.a(localadej);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localadej.a() + l;
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
 * Qualified Name:     adcz
 * JD-Core Version:    0.7.0.1
 */