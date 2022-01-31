import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ajiq
{
  public int a;
  public long a;
  public String a;
  public final HashMap<Integer, ajis> a;
  public final List<ajis> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<ajir> b;
  public long c;
  public String c;
  public List<ajir> c;
  public String d;
  public String e;
  
  public ajiq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 999999) {
      return String.valueOf(999999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt > 99999) {
      return String.valueOf(99999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt > 9999) {
      return String.valueOf(9999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    label40:
    ajir localajir;
    ajis localajis;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localajir = (ajir)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localajir.jdField_a_of_type_Long))))
        {
          if (localajir.jdField_a_of_type_Short > 4) {
            break label165;
          }
          localajis = (ajis)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if (localajis != null)
          {
            localajis.c += 1;
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(localajir);
      break label40;
      break;
      label165:
      localajis = (ajis)this.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(localajir.jdField_a_of_type_Short));
      if (localajis != null)
      {
        localajis.c += localajir.f;
        this.jdField_b_of_type_Int += localajir.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajiq
 * JD-Core Version:    0.7.0.1
 */