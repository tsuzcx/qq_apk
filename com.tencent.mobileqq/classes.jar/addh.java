import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.memory.leakdetect.LeakInspector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONException;

public class addh
  extends adcg
  implements adbz, Application.ActivityLifecycleCallbacks
{
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  IInspectorListener jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener = new addg();
  
  public addh()
  {
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this);
  }
  
  public static void a()
  {
    if ((new File(bhgg.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_02")).exists()) || (new File(bhgg.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists()) || (10 == BaseApplicationImpl.sProcessId)) {}
    for (jdField_a_of_type_Boolean = false; new File(bhgg.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists(); jdField_a_of_type_Boolean = true)
    {
      b = false;
      return;
    }
    b = true;
  }
  
  public DumpResult a(String paramString, adcb paramadcb)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      paramString = LeakInspector.dumpMemory(paramString, true, new addi(this, paramadcb));
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "", paramString);
    }
    return new DumpResult();
  }
  
  public void a(long paramLong, String paramString)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      LeakInspector.report(paramLong, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig)
  {
    if (((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) && (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true))) {}
  }
  
  public void a(Object paramObject, String paramString)
  {
    if (e())
    {
      LeakInspector.startInspect(paramObject, paramString);
      return;
    }
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "startInspect failedNoStart");
  }
  
  protected void b()
  {
    a();
    LeakInspector.setKeepUuidWhenLeak(true);
    com.tencent.qapmsdk.memory.MemoryLeakMonitor.enableFragmentInspect = false;
    QAPM.setProperty(107, this.jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener);
  }
  
  public String c()
  {
    return "leak";
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    try
    {
      adcs.a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onActivityDestroyed ", paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addh
 * JD-Core Version:    0.7.0.1
 */