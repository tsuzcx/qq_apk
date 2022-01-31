import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aggf
{
  private static volatile aggf a;
  private static volatile int c;
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public HashMap<String, LocalMediaInfo> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<Integer> b;
  public HashMap<String, LocalMediaInfo> b;
  public boolean b;
  public String c;
  public ArrayList<String> c;
  public HashMap<String, PicInfo> c;
  public boolean c;
  private boolean d;
  
  private aggf()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Int = ((int)axwv.a());
  }
  
  public static aggf a()
  {
    return a(false);
  }
  
  public static aggf a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_Aggf = new aggf();
      return jdField_a_of_type_Aggf;
    }
    if (jdField_a_of_type_Aggf == null) {}
    try
    {
      if (jdField_a_of_type_Aggf == null) {
        jdField_a_of_type_Aggf = new aggf();
      }
      return jdField_a_of_type_Aggf;
    }
    finally {}
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (baaf.a((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) != 1) {
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
      jdField_c_of_type_Int += 1;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.d;
  }
  
  public void b()
  {
    try
    {
      jdField_c_of_type_Int -= 1;
      if (jdField_c_of_type_Int == 0) {
        jdField_a_of_type_Aggf = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggf
 * JD-Core Version:    0.7.0.1
 */