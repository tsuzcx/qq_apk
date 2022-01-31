import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hiar.AREnginesSelector;
import com.huawei.hiar.AREnginesSelector.AREnginesAvaliblity;
import com.huawei.hiar.AREnginesSelector.AREnginesType;
import com.huawei.hiar.exceptions.ARUnSupportedConfigurationException;
import com.huawei.hiar.exceptions.ARUnavailableClientSdkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableServiceApkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableServiceNotInstalledException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;
import com.tencent.qphone.base.util.QLog;

public class alfg
  implements alfd
{
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        if ((AREnginesSelector.checkAllAvailableEngines(paramActivity).ordinal() & AREnginesSelector.AREnginesAvaliblity.HWAR_ENGINE_SUPPORTED.ordinal()) == 0) {
          continue;
        }
        AREnginesSelector.setAREngine(AREnginesSelector.AREnginesType.HWAR_ENGINE);
        int i = alfh.a[com.huawei.hiar.AREnginesApk.requestInstall(paramActivity, false).ordinal()];
        switch (i)
        {
        default: 
          paramActivity = null;
        }
      }
      catch (ARUnavailableServiceNotInstalledException paramActivity)
      {
        Object localObject2;
        localObject1 = "Please install HuaweiARService.apk";
        continue;
        paramActivity = "This device does not support Huawei AR Engine ";
        continue;
      }
      catch (ARUnavailableServiceApkTooOldException paramActivity)
      {
        localObject1 = "Please update HuaweiARService.apk";
        continue;
      }
      catch (ARUnavailableClientSdkTooOldException paramActivity)
      {
        localObject1 = "Please update this app";
        continue;
      }
      catch (ARUnavailableDeviceNotCompatibleException paramActivity)
      {
        localObject1 = "This device does not support Huawei AR Engine ";
        continue;
      }
      catch (ARUnavailableEmuiNotCompatibleException paramActivity)
      {
        localObject1 = "Please update EMUI version";
        continue;
      }
      catch (ARUnavailableUserDeclinedInstallationException paramActivity)
      {
        localObject1 = "Please agree to install!";
        continue;
      }
      catch (ARUnSupportedConfigurationException paramActivity)
      {
        localObject1 = "The configuration is not supported by the device!";
        continue;
      }
      catch (Exception paramActivity)
      {
        Object localObject1 = "exception throwed";
        continue;
      }
      localObject2 = null;
      localObject1 = paramActivity;
      paramActivity = localObject2;
      if (localObject1 == null) {
        break label174;
      }
      QLog.e("HuaweiArCoreAbilityManager", 2, "CheckHuaWeiARCoreReady hasException msg = message", paramActivity);
      return false;
      QLog.d("HuaweiArCoreAbilityManager", 2, "INSTALL_REQUESTED ");
      return false;
      QLog.d("HuaweiArCoreAbilityManager", 2, "INSTALLED ");
    }
    label174:
    return true;
  }
  
  public alfe a()
  {
    return new alfi();
  }
  
  public boolean a()
  {
    return (("" + Build.MANUFACTURER).equalsIgnoreCase("HUAWEI")) && (akyq.a());
  }
  
  public boolean a(Activity paramActivity)
  {
    return (Build.VERSION.SDK_INT >= 23) && (b(paramActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfg
 * JD-Core Version:    0.7.0.1
 */