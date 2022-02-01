import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class acit
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<String> jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  
  public acit(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public acit a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= 40))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public acit a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.c)) && ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0))) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        long l = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilList.add(String.valueOf(l));
        this.jdField_a_of_type_JavaUtilList.add("1");
        this.jdField_a_of_type_JavaUtilList.add("8.4.5");
        this.jdField_a_of_type_JavaUtilList.add("");
        this.jdField_a_of_type_JavaUtilList.add("2");
        this.jdField_a_of_type_JavaUtilList.add(Build.BRAND);
        int j = nnr.a();
        if (j >= 0)
        {
          i = j;
          if (j < antf.c.length)
          {
            this.jdField_a_of_type_JavaUtilList.add(antf.c[i]);
            Object localObject2 = "";
            Object localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
            {
              BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
              localObject1 = localObject2;
              if (localBaseApplication != null)
              {
                localObject1 = localBaseApplication.getResources().getDisplayMetrics();
                localObject1 = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
              }
            }
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            this.jdField_a_of_type_JavaUtilList.add("0");
            this.jdField_a_of_type_JavaUtilList.add("0");
            this.jdField_a_of_type_JavaUtilList.add("1");
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_JavaUtilList.add(this.b);
            this.jdField_a_of_type_JavaUtilList.add("0");
            this.jdField_a_of_type_JavaUtilList.add(this.c);
            a(14, Build.MODEL);
            a(15, Build.VERSION.RELEASE);
            if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
            {
              i = 1;
              if (i <= 40)
              {
                localObject1 = String.valueOf(i);
                localObject2 = this.jdField_a_of_type_JavaUtilList;
                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
                  break label495;
                }
                localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
                ((List)localObject2).add(localObject1);
                i += 1;
                continue;
              }
            }
            bmbt.a(null, "dc00087", this.jdField_a_of_type_JavaUtilList);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      int i = 0;
      continue;
      label495:
      String str = "";
    }
  }
  
  public acit b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public acit c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public acit d(String paramString)
  {
    return a(4, paramString);
  }
  
  public acit e(String paramString)
  {
    return a(1, paramString);
  }
  
  public acit f(String paramString)
  {
    return a(11, paramString);
  }
  
  public acit g(String paramString)
  {
    return a(12, paramString);
  }
  
  public acit h(String paramString)
  {
    return a(35, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acit
 * JD-Core Version:    0.7.0.1
 */