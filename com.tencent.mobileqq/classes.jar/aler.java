import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aler
{
  public int a;
  public long a;
  public String a;
  public final HashMap<Integer, alet> a;
  public final List<alet> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<ales> b;
  public long c;
  public String c;
  public List<ales> c;
  public String d;
  public String e;
  
  public aler()
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
    ales localales;
    alet localalet;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localales = (ales)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localales.jdField_a_of_type_Long))))
        {
          if (localales.jdField_a_of_type_Short > 4) {
            break label165;
          }
          localalet = (alet)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if (localalet != null)
          {
            localalet.c += 1;
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
      this.c.add(localales);
      break label40;
      break;
      label165:
      localalet = (alet)this.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(localales.jdField_a_of_type_Short));
      if (localalet != null)
      {
        localalet.c += localales.f;
        this.jdField_b_of_type_Int += localales.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aler
 * JD-Core Version:    0.7.0.1
 */