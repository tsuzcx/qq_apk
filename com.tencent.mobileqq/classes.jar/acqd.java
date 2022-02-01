import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForInterstitial;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public final class acqd
{
  private static volatile acqd jdField_a_of_type_Acqd;
  private volatile acpv jdField_a_of_type_Acpv;
  private acqe jdField_a_of_type_Acqe = new acqe();
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private acqd(acpv paramacpv)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Acpv = paramacpv;
  }
  
  public static acqd a()
  {
    if (jdField_a_of_type_Acqd == null) {}
    try
    {
      if (jdField_a_of_type_Acqd == null)
      {
        acpv localacpv = new acpv();
        localacpv.a = "com.tencent.tangram.interstitial";
        localacpv.b = "Index";
        localacpv.c = "1.0.0.1";
        jdField_a_of_type_Acqd = new acqd(localacpv);
      }
      return jdField_a_of_type_Acqd;
    }
    finally {}
  }
  
  public long a(Context paramContext)
  {
    long l = 10000L;
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (;;)
    {
      acvc.b("GdtInterstitialManager", String.format("getTimeoutMillis %d", new Object[] { Long.valueOf(l) }));
      return l;
      if (paramContext.settingsForInterstitial.timeoutMillis > 0) {
        l = paramContext.settingsForInterstitial.timeoutMillis;
      }
    }
  }
  
  public acpv a()
  {
    return this.jdField_a_of_type_Acpv;
  }
  
  public acqe a()
  {
    return this.jdField_a_of_type_Acqe;
  }
  
  public GdtAppReceiver a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return null;
    }
    return (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    acvc.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Acqd)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    AdIPCManager.INSTANCE.register("ipc_interstitial_close", new acqc());
    AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new acqj());
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (boolean bool = false;; bool = paramContext.settingsForInterstitial.enablePreDownload)
    {
      acvc.b("GdtInterstitialManager", String.format("isPreDownloadEnabled %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      acvc.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        bool = true;
      }
    }
  }
  
  public boolean a(String paramString, WeakReference<GdtInterstitialFragment> paramWeakReference)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      acvc.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        bool = false;
      } else if (paramWeakReference != null)
      {
        if (paramWeakReference.get() == null)
        {
          bool = false;
        }
        else
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramWeakReference);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean b(Context paramContext)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    boolean bool;
    if (localObject == null) {
      bool = false;
    }
    for (;;)
    {
      acvc.b("GdtInterstitialManager", String.format("canShowOnMainProcess %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null)
      {
        bool = false;
      }
      else
      {
        localObject = ((AppRuntime)localObject).getAccount();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          bool = false;
        }
        else
        {
          paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
          if (paramContext == null) {
            bool = false;
          } else {
            bool = AdABTest.isABTestByUIN((String)localObject, paramContext.settingsForInterstitial.abTestForProcess);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqd
 * JD-Core Version:    0.7.0.1
 */