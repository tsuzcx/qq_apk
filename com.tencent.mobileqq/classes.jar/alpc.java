import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class alpc
  implements ark.ModuleCallbackWrapper
{
  public static boolean a;
  protected long a;
  protected ark.Application a;
  public String a;
  HashMap<Long, ark.VariantWrapper> a;
  protected Map<String, Set<alpd>> a;
  protected long b;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  protected alpc(ark.Application paramApplication, long paramLong)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentArkArk$Application = paramApplication;
    this.jdField_a_of_type_JavaLangString = paramApplication.GetSpecific("appName");
    this.c = paramApplication.GetSpecific("appPath");
    this.jdField_b_of_type_JavaLangString = paramApplication.GetID();
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void Destruct()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  long a(ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
      return 0L;
    }
    this.jdField_b_of_type_Long += 1L;
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = 1L;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_b_of_type_Long), paramVariantWrapper);
    return this.jdField_b_of_type_Long;
  }
  
  public ark.VariantWrapper a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    return localVariantWrapper;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject != null) {
        break label118;
      }
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    label118:
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      paramString.add(new alpd(this, paramLong1, paramLong2));
      return;
    }
  }
  
  public void a(List<alqy> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        alqy localalqy = (alqy)paramList.next();
        a(localalqy.jdField_a_of_type_JavaLangString, localalqy.jdField_a_of_type_Long, localalqy.jdField_b_of_type_Long);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        alpd localalpd = (alpd)((Iterator)localObject).next();
        if (!localalpd.a())
        {
          QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", new Object[] { paramString, localalpd.toString() }));
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public ark.VariantWrapper b(long paramLong)
  {
    return (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alpc
 * JD-Core Version:    0.7.0.1
 */