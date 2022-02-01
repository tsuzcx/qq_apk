import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class agor
{
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  protected String a;
  private final ArrayList<agov> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<agov> b = new ArrayList();
  private final ArrayList<agou> c = new ArrayList();
  
  public agor(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new agos(this, 3, true, true, paramLong, true, true, "ArkAppLocationManager");
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1 = bool2;
    if (localBaseActivity != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23) {
        if ((localBaseActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) || (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          break label68;
        }
      }
    }
    label68:
    for (bool1 = bool2;; bool1 = false)
    {
      ArkAppCenter.c("GetArkLocPermission", "CheckPermission is = " + bool1);
      return bool1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.b)
    {
      this.b.clear();
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(agou paramagou, boolean paramBoolean)
  {
    if (paramagou == null) {
      return;
    }
    synchronized (this.c)
    {
      this.c.add(paramagou);
      if (paramBoolean)
      {
        c();
        return;
      }
    }
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void a(agov paramagov)
  {
    if (paramagov == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramagov);
      c();
      return;
    }
  }
  
  public void b()
  {
    if ((this.b.size() == 0) && (this.c.size() == 0)) {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((agov)((Iterator)???).next()).a();
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void b(agov paramagov)
  {
    if (paramagov == null) {
      return;
    }
    synchronized (this.b)
    {
      this.b.add(paramagov);
      c();
      return;
    }
  }
  
  protected void c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!a())
    {
      localBaseActivity.requestPermissions(new agot(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    grant();
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    ArkAppCenter.c("GetArkLocPermission", "CheckPermission location is denied");
  }
  
  @QQPermissionGrant(1)
  @TargetApi(23)
  public void grant()
  {
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    ArkAppCenter.c("GetArkLocPermission", "CheckPermission location is granted ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agor
 * JD-Core Version:    0.7.0.1
 */