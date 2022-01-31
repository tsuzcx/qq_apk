import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class akrn
{
  private int jdField_a_of_type_Int;
  private akrq jdField_a_of_type_Akrq;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, akrp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public akrn(akrq paramakrq)
  {
    this.jdField_a_of_type_Akrq = paramakrq;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_Int;
    case 2: 
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_c_of_type_Int;
  }
  
  private String a()
  {
    return azaa.a(ayog.jdField_a_of_type_JavaLangString);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_JavaLangString;
    case 2: 
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      arrayOfFile = paramString.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
        if (QLog.isColorLevel()) {
          QLog.e("FileCleanManager", 2, "cacheFilesInfo no file");
        }
      }
    }
    label85:
    label92:
    while (!QLog.isColorLevel())
    {
      File localFile;
      for (;;)
      {
        File[] arrayOfFile;
        return;
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          localFile = arrayOfFile[i];
          if (!localFile.isDirectory()) {
            break label92;
          }
          a(localFile.getAbsolutePath(), paramInt);
          i += 1;
        }
      }
      int k = a(paramInt);
      paramString = localFile.getAbsolutePath();
      int m = paramString.length();
      akrp localakrp = new akrp();
      if (m > k) {}
      for (paramString = paramString.substring(k, m);; paramString = "")
      {
        localakrp.jdField_a_of_type_JavaLangString = paramString;
        localakrp.jdField_a_of_type_Long = localFile.length();
        localakrp.jdField_a_of_type_Int = paramInt;
        localakrp.jdField_b_of_type_Int = 0;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFile.getName(), localakrp);
        break label85;
      }
    }
    QLog.e("FileCleanManager", 2, "cacheFilesInfo file not exists");
  }
  
  private String b()
  {
    return ShortVideoUtils.b();
  }
  
  private String c()
  {
    return ajsf.bl;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Akrq != null) && (a()))
    {
      this.jdField_a_of_type_Akrq.a();
      if (QLog.isColorLevel()) {
        QLog.e("FileCleanManager", 2, "fileScanNotify onScanFinish");
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_b_of_type_JavaLangString = b();
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangString.length();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_JavaLangString.length();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void f()
  {
    a(this.jdField_b_of_type_JavaLangString, 2);
  }
  
  private void g()
  {
    a(this.jdField_c_of_type_JavaLangString, 3);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  public String a(akrp paramakrp)
  {
    if (paramakrp == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(paramakrp.jdField_a_of_type_Int));
    localStringBuffer.append(paramakrp.jdField_a_of_type_JavaLangString);
    return localStringBuffer.toString();
  }
  
  public ConcurrentHashMap<String, akrp> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    h();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    d();
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.1(this));
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.2(this));
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, akrp paramakrp)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramakrp != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramakrp);
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        bbdj.d((String)paramList.next());
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_Akrq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akrn
 * JD-Core Version:    0.7.0.1
 */