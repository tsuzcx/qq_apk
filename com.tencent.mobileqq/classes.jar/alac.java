import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class alac
{
  public int a;
  public long a;
  public String a;
  public final HashMap<Integer, alae> a;
  public final List<alae> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<alad> b;
  public long c;
  public String c;
  public List<alad> c;
  public String d;
  public String e;
  
  public alac()
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
    alad localalad;
    alae localalae;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localalad = (alad)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localalad.jdField_a_of_type_Long))))
        {
          if (localalad.jdField_a_of_type_Short > 4) {
            break label165;
          }
          localalae = (alae)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if (localalae != null)
          {
            localalae.c += 1;
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
      this.c.add(localalad);
      break label40;
      break;
      label165:
      localalae = (alae)this.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(localalad.jdField_a_of_type_Short));
      if (localalae != null)
      {
        localalae.c += localalad.f;
        this.jdField_b_of_type_Int += localalad.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alac
 * JD-Core Version:    0.7.0.1
 */