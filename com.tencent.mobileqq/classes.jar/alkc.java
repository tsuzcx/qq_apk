import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class alkc
{
  private static File jdField_a_of_type_JavaIoFile;
  public int a;
  public long a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<WeakReference<alke>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, axsp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(ajed.aU + "head/");; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "_dynamic");
      return;
    }
  }
  
  public alkc(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    c();
  }
  
  public static File a(String paramString)
  {
    paramString = a(paramString);
    return new File(jdField_a_of_type_JavaIoFile, paramString);
  }
  
  public static String a(String paramString)
  {
    return "cache_" + Utils.Crc64String(paramString) + ".mp4";
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long > 86400000L) || (l - this.jdField_a_of_type_Long < 0L)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      alkb localalkb = ((alkl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(180)).a();
      if (this.jdField_a_of_type_Int + 1 > localalkb.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "isLoadCountSatisfy not satisfy.");
        }
        return false;
      }
      return true;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    return a(paramString).getAbsolutePath();
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).getString("dynamic_load_count_one_day", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if ((localObject == null) || (localObject.length != 2)) {}
    }
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(localObject[0]).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 86400000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
    }
    ThreadManager.executeOnFileThread(new DynamicAvatarDownloadManager.2(this, l));
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      axsp localaxsp = (axsp)((Iterator)localObject).next();
      if ((localaxsp != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localaxsp);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(alke paramalke)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != paramalke)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramalke));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          axsp localaxsp = (axsp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localaxsp != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localaxsp);
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ??? = a(paramString);
    Iterator localIterator;
    WeakReference localWeakReference;
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((alke)localWeakReference.get()).a(paramString, true, true);
            }
          }
        }
      }
      return true;
    }
    if ((!badq.h(BaseApplicationImpl.getContext())) && (!a()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((alke)localWeakReference.get()).a(paramString, false, false);
            }
          }
        }
      }
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "url:" + paramString + " has contains");
      }
      return false;
    }
    ??? = new axro();
    ((axro)???).jdField_a_of_type_Axrt = new alkd(this);
    ((axro)???).jdField_a_of_type_JavaLangString = paramString;
    ((axro)???).jdField_a_of_type_Int = 0;
    ((axro)???).jdField_c_of_type_JavaLangString = a(paramString).getPath();
    ((axro)???).jdField_c_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a((axsp)???);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, ???);
      QLog.i("Q.dynamicAvatar", 2, "startDownloadDynamicAvatar, url: " + paramString + ", uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    return false;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void b(alke paramalke)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramalke)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkc
 * JD-Core Version:    0.7.0.1
 */