import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ambz
  extends alzl<amca>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    if (b) {
      return a;
    }
    b = true;
    a = f();
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean f()
  {
    amca localamca2 = (amca)alzw.a().a(531);
    amca localamca1 = localamca2;
    if (localamca2 == null)
    {
      localamca2 = new amca();
      localamca1 = localamca2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localamca1 = localamca2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localamca1);
    }
    return localamca1.a();
  }
  
  public int a()
  {
    return 531;
  }
  
  @NonNull
  public amca a(int paramInt)
  {
    return new amca();
  }
  
  @Nullable
  public amca a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfalzs[0].a);
      }
      return amca.a(paramArrayOfalzs[0].a);
    }
    return new amca();
  }
  
  public Class<amca> a()
  {
    return amca.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amca paramamca)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramamca);
    }
    if (paramamca != null) {
      a = paramamca.a();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambz
 * JD-Core Version:    0.7.0.1
 */