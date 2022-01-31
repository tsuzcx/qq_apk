import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class ahhq
{
  private static ahhq jdField_a_of_type_Ahhq;
  private ahhs jdField_a_of_type_Ahhs = new ahhs(this, null);
  private ahhu jdField_a_of_type_Ahhu;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new ahhr(this));
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  private ahhq(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Ahhs);
    }
  }
  
  public static ahhq a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_Ahhq == null) {
      jdField_a_of_type_Ahhq = new ahhq(paramAppInterface);
    }
    return jdField_a_of_type_Ahhq;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Ahhq != null)
    {
      jdField_a_of_type_Ahhq.b();
      jdField_a_of_type_Ahhq = null;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = 4;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ho.class);
    localNewIntent.putExtra("key_latitude", paramDouble1);
    localNewIntent.putExtra("key_longitude", paramDouble2);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("key_lbs_template_cookie", paramInt);
    switch (badq.a(BaseApplicationImpl.getApplication().getBaseContext()))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localNewIntent.putExtra("key_lbs_template_network_type", i);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LBSDetetor", 2, "getLBSTemplateIds. req:" + paramInt + " netType:" + i + " latitude:" + paramDouble1 + " longitude:" + paramDouble2);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private void a(boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "callback. isSuccess: " + paramBoolean + " cookie: " + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    if (this.jdField_a_of_type_Ahhu != null)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList(1);
      }
      this.jdField_a_of_type_Ahhu.a(paramInt, paramBoolean, (ArrayList)localObject);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "destroy");
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Ahhs);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    }
    this.jdField_a_of_type_Ahhu = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  @TargetApi(19)
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        Object localObject = BaseApplicationImpl.getApplication().getBaseContext();
        AppOpsManager localAppOpsManager = (AppOpsManager)((Context)localObject).getSystemService("appops");
        localObject = ((Context)localObject).getApplicationInfo();
        int i = localAppOpsManager.checkOpNoThrow("android:fine_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        int j = localAppOpsManager.checkOpNoThrow("android:coarse_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        if ((i == 0) && (j == 0))
        {
          bool1 = true;
          bool2 = bool1;
        }
      }
      catch (Exception localException1)
      {
        boolean bool1 = true;
        boolean bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSDetetor", 2, "something wrong:" + localException1.toString());
        bool2 = bool1;
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("LBSDetetor", 2, "check permission by AppOpsManager:" + bool1);
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LBSDetetor", 2, "startCheckPermissionAndDetetLocation. hasPermission:" + bool2);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
        if (bool2)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, 30000L);
          SosoInterface.a(new ahht(this, 0, true, true, 30000L, false, false, "NewFlowCameraActivity", paramInt));
        }
        if (this.jdField_a_of_type_Ahhu != null) {
          this.jdField_a_of_type_Ahhu.a(paramInt, bool2);
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool1 = false;
    }
  }
  
  public void a(ahhu paramahhu)
  {
    this.jdField_a_of_type_Ahhu = paramahhu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhq
 * JD-Core Version:    0.7.0.1
 */