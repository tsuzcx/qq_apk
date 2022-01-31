import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class akyo
{
  public long a;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  public String a;
  public HashMap<Integer, String> a;
  private final TreeMap<Integer, akyp> jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  public boolean a;
  public long b;
  public String b;
  public long c = 0L;
  
  public akyo()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ArCloudConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public TreeMap<Integer, akyp> a()
  {
    return this.jdField_a_of_type_JavaUtilTreeMap;
  }
  
  public String toString()
  {
    String str = "id[" + this.jdField_a_of_type_JavaLangString + "], recoglizeMask[" + this.c + "]";
    Object localObject = str;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        akyp localakyp = (akyp)((Iterator)localObject).next();
        str = str + "\n" + localakyp;
      }
      localObject = str + ", begin[" + this.jdField_a_of_type_Long + "], end[" + this.jdField_b_of_type_Long + "], title[" + this.jdField_b_of_type_JavaLangString + "], tips[" + this.jdField_a_of_type_JavaUtilHashMap.size() + "]";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyo
 * JD-Core Version:    0.7.0.1
 */