import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.1;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.2;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.3;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class ajqj
  implements bapx
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected BaseApplicationImpl a;
  private String jdField_a_of_type_JavaLangString;
  protected HashMap<Integer, String> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private int c;
  
  public ajqj(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Int = 0;
    this.b = paramInt;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
        if (localAppRuntime != null) {
          this.jdField_a_of_type_JavaLangString = String.valueOf(localAppRuntime.getLongAccountUin());
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RDBaseDataManager", 2, "get uin exception:" + this.jdField_a_of_type_JavaLangString);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RDBaseDataManager", 2, "init uin:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new File(paramString);
          if (!paramString.exists())
          {
            paramString.mkdirs();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("RDBaseDataManagerdownloading", 2, "makedir execption: " + paramString);
      }
    }
  }
  
  private boolean a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
        return false;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      int i = 0;
      boolean bool1 = true;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = bdcs.d((String)localEntry.getValue());
        i += 1;
        boolean bool2 = a(0, ((Integer)localEntry.getKey()).intValue(), str, i, this.jdField_a_of_type_JavaUtilHashMap.size());
        bool1 = bool2;
        if (!bool2) {
          bool1 = bool2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "initFromAsset: " + bool1);
      }
      return bool1;
    }
    finally {}
  }
  
  private boolean a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if (paramInt3 == 1) {
      a(paramInt1, paramInt4);
    }
    boolean bool = a(paramInt1, paramInt2, paramString);
    if (paramInt3 == paramInt4) {
      b(paramInt1, paramInt4);
    }
    return bool;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_c_of_type_Int != 0) {
        return;
      }
      this.jdField_c_of_type_Int = 1;
      a();
      c();
      this.jdField_c_of_type_Int = 2;
      if (QLog.isColorLevel())
      {
        QLog.d("RDBaseDataManager", 2, "RDBaseDataManager init end, configType :" + this.b);
        return;
      }
    }
    finally {}
  }
  
  private boolean b()
  {
    try
    {
      this.jdField_a_of_type_Int = ajql.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.b, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "local sp config version is : " + this.jdField_a_of_type_Int);
      }
      boolean bool = ajql.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.b, this.jdField_a_of_type_JavaLangString, new ajqk(this));
      if (!bool)
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
      }
      return bool;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      if (!b()) {
        a();
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null)) {
      return -1;
    }
    a(paramString2);
    ajpz localajpz = new ajpz();
    localajpz.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localajpz.b = paramString4;
    localajpz.jdField_a_of_type_JavaLangString = paramString3;
    try
    {
      paramString3 = new baps();
      paramString3.jdField_a_of_type_JavaLangString = paramString1;
      paramString3.jdField_a_of_type_Int = 0;
      paramString3.jdField_c_of_type_JavaLangString = paramString2;
      paramString3.a(localajpz);
      paramString3.jdField_a_of_type_Bapx = this;
      paramString3.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      lel.a().a(paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "startDownload, url: " + paramString1 + " ; path:" + paramString2);
      }
      return localajpz.jdField_a_of_type_Int;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        localajpz.jdField_a_of_type_Int = -1;
        QLog.e("RDBaseDataManager", 2, "startDownload, url: " + paramString1 + " ; path:" + paramString2);
        QLog.i("RDBaseDataManager", 2, "exception: " + paramString3.toString());
      }
    }
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RDBaseDataManager", 2, "init begin, state:" + this.jdField_c_of_type_Int + " configType :" + this.b + " baccountdependent:" + false);
    }
    if (this.jdField_c_of_type_Int != 0) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new RDBaseDataManager.1(this));
      return;
    }
    b();
  }
  
  public abstract boolean a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public void onResp(baqw parambaqw)
  {
    int j = 0;
    if ((parambaqw == null) || (parambaqw.jdField_a_of_type_Baqv == null))
    {
      QLog.e("RDBaseDataManager", 2, "onResp  param error!");
      return;
    }
    ajpz localajpz = (ajpz)parambaqw.jdField_a_of_type_Baqv.a();
    if (QLog.isColorLevel()) {
      QLog.i("RDBaseDataManager", 2, "onResp  ID:" + localajpz.jdField_a_of_type_Int + "  result:" + parambaqw.jdField_a_of_type_Int);
    }
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      ThreadManager.getUIHandler().post(new RDBaseDataManager.2(this, localajpz));
      return;
    }
    int i;
    if (!TextUtils.isEmpty(parambaqw.jdField_a_of_type_Baqv.jdField_c_of_type_JavaLangString))
    {
      i = j;
      if (!TextUtils.isEmpty(localajpz.jdField_a_of_type_JavaLangString))
      {
        String str = bdcs.c(parambaqw.jdField_a_of_type_Baqv.jdField_c_of_type_JavaLangString);
        if (localajpz.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)) {
          i = j;
        }
      }
      else
      {
        j = i;
        if (TextUtils.isEmpty(localajpz.b)) {}
      }
    }
    for (;;)
    {
      try
      {
        bdcs.a(parambaqw.jdField_a_of_type_Baqv.jdField_c_of_type_JavaLangString, localajpz.b, false);
        j = i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("RDBaseDataManager", 2, "unzip file exception:" + localException);
        j = i;
        continue;
      }
      ThreadManager.getUIHandler().post(new RDBaseDataManager.3(this, localajpz, j, parambaqw));
      return;
      i = 1;
      break;
      j = 1;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (parambaqv == null) {
      return;
    }
    parambaqv = (ajpz)parambaqv.a();
    ThreadManager.getUIHandler().post(new RDBaseDataManager.4(this, parambaqv, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqj
 * JD-Core Version:    0.7.0.1
 */