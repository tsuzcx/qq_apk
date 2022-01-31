import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class aksq
{
  private static String jdField_a_of_type_JavaLangString = "en-release.zip";
  private aksp jdField_a_of_type_Aksp;
  private akst jdField_a_of_type_Akst;
  
  public static aksq a()
  {
    return aksr.a();
  }
  
  private static String a()
  {
    File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/multi_language");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  private void a(Context paramContext, String paramString)
  {
    long l;
    String str;
    if (!new File(paramString).exists())
    {
      QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLanguage need unzip:", jdField_a_of_type_JavaLangString });
      l = System.currentTimeMillis();
      paramString = "language" + File.separator + jdField_a_of_type_JavaLangString;
      str = a() + jdField_a_of_type_JavaLangString;
      bbdx.a(paramContext, paramString, str);
    }
    try
    {
      nav.a(new File(str), a());
      if (QLog.isColorLevel()) {
        QLog.e("MultiLanguageEngine", 2, new Object[] { "copy and unzip success! cost:", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
    try
    {
      long l = System.currentTimeMillis();
      AssetManager localAssetManager = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Object localObject = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(localAssetManager, new Object[] { paramString });
      Resources localResources = new Resources(localAssetManager, this.jdField_a_of_type_Akst.b().getDisplayMetrics(), this.jdField_a_of_type_Akst.b().getConfiguration());
      localObject = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (paramContext != null) {}
      for (paramContext = paramContext.packageName;; paramContext = (Context)localObject)
      {
        this.jdField_a_of_type_Akst.a(localResources, paramContext);
        QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLangPkg:", localAssetManager.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return true;
        QLog.d("MultiLanguageEngine", 1, "pkgInfo is null");
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QLog.d("MultiLanguageEngine", 1, paramContext, new Object[0]);
    }
  }
  
  private void e(Context paramContext)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = Class.forName("android.app.ContextImpl");
      Object localObject2 = ((Class)localObject1).getDeclaredField("mResources");
      ((Field)localObject2).setAccessible(true);
      Object localObject3 = ((Field)localObject2).get(paramContext);
      ((Field)localObject2).set(paramContext, this.jdField_a_of_type_Aksp);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate ContextImpl resources:", this.jdField_a_of_type_Aksp.toString(), " ,old:", localObject3.toString() });
      localObject1 = ((Class)localObject1).getDeclaredField("mPackageInfo");
      ((Field)localObject1).setAccessible(true);
      paramContext = ((Field)localObject1).get(paramContext);
      localObject1 = Class.forName("android.app.LoadedApk").getDeclaredField("mResources");
      ((Field)localObject1).setAccessible(true);
      localObject2 = ((Field)localObject1).get(paramContext);
      ((Field)localObject1).set(paramContext, this.jdField_a_of_type_Aksp);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate LoadedApk resources:", this.jdField_a_of_type_Aksp.toString(), " ,old:", localObject2.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (ajzt.a()) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      LayoutInflater.from(paramActivity).setFactory2(new akss(paramActivity));
    } while (!QLog.isColorLevel());
    QLog.d("MultiLanguageEngine", 2, new Object[] { "register cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(Context paramContext)
  {
    boolean bool = false;
    if (!ajzt.a()) {
      bool = true;
    }
    QLog.d("MultiLanguageEngine", 1, new Object[] { "initAndDelegate:", Boolean.valueOf(bool), ", context:", paramContext });
    if (paramContext == null) {}
    while (ajzt.a()) {
      return;
    }
    this.jdField_a_of_type_Akst = new akst(paramContext);
    this.jdField_a_of_type_Aksp = new aksp(this.jdField_a_of_type_Akst);
    e(paramContext);
  }
  
  public void b(Context paramContext)
  {
    if (ajzt.b()) {
      a(paramContext, a() + "en.lang");
    }
    while (this.jdField_a_of_type_Akst == null) {
      return;
    }
    this.jdField_a_of_type_Akst.a(null, null);
  }
  
  public void c(Context paramContext)
  {
    long l = System.currentTimeMillis();
    bbdx.a(a());
    b(paramContext);
    QLog.d("MultiLanguageEngine", 1, new Object[] { "update lang pkg! cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void d(Context paramContext)
  {
    a(paramContext, a() + "en.lang");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksq
 * JD-Core Version:    0.7.0.1
 */