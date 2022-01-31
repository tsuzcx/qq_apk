import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class almq
{
  public double a;
  public int a;
  public almn a;
  @Deprecated
  public alny a;
  public String a;
  public ArrayList<almn> a;
  public HashMap<String, alnx> a;
  public HashSet<String> a;
  public boolean a;
  public int[] a;
  public int b;
  public almn b;
  public ArrayList<Integer> b;
  public HashMap<String, alnp> b;
  public boolean b;
  public int c;
  public almn c;
  public ArrayList<String> c;
  public int d;
  public almn d;
  public int e;
  public almn e;
  public int f = -1;
  public almn f;
  public int g = 2;
  
  public almq(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = new File(paramFile, paramString);
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      bool1 = bool2;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.list();
        bool1 = bool2;
        if (paramFile != null)
        {
          bool1 = bool2;
          if (paramFile.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    if (a()) {
      return ((Integer)this.b.get(this.e)).intValue();
    }
    return -1;
  }
  
  public void a()
  {
    if (a())
    {
      this.e = ((this.e + 1) % this.b.size());
      if (QLog.isColorLevel()) {
        QLog.i("BubbleConfig", 2, "now change bubble sub id: " + this.b.get(this.e));
      }
      return;
    }
    this.e = 0;
  }
  
  public boolean a()
  {
    return (this.b != null) && (this.b.size() > 0);
  }
  
  public boolean a(int paramInt)
  {
    return (this.b != null) && (this.b.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean a(File paramFile)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      if (a(paramFile, (String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((this.c != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((String)localIterator.next()).toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[ bubbleId=" + this.jdField_a_of_type_Int).append(",");
    localStringBuffer.append("name=" + this.jdField_a_of_type_JavaLangString).append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     almq
 * JD-Core Version:    0.7.0.1
 */