import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class agsb
{
  private static volatile agsb a;
  private static volatile int d;
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public HashMap<String, LocalMediaInfo> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public ArrayList<Integer> b;
  public HashMap<String, LocalMediaInfo> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<String> c = new ArrayList();
  public HashMap<String, PicInfo> c;
  public boolean c;
  public boolean d;
  private boolean e;
  
  private agsb()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Int = ((int)ayxc.a());
  }
  
  public static agsb a()
  {
    return a(false);
  }
  
  public static agsb a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_Agsb = new agsb();
      return jdField_a_of_type_Agsb;
    }
    if (jdField_a_of_type_Agsb == null) {}
    try
    {
      if (jdField_a_of_type_Agsb == null) {
        jdField_a_of_type_Agsb = new agsb();
      }
      return jdField_a_of_type_Agsb;
    }
    finally {}
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (bbbj.a((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) != 1) {
        break label57;
      }
      i += 1;
    }
    label57:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public void a()
  {
    try
    {
      jdField_d_of_type_Int += 1;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = true;
      bflj.a();
    }
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.e;
  }
  
  public void b()
  {
    try
    {
      jdField_d_of_type_Int -= 1;
      if (jdField_d_of_type_Int == 0) {
        jdField_a_of_type_Agsb = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (bbbj.a((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsb
 * JD-Core Version:    0.7.0.1
 */