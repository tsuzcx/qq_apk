import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class abmm
{
  private static volatile abmm jdField_a_of_type_Abmm;
  private volatile abme jdField_a_of_type_Abme;
  private abmn jdField_a_of_type_Abmn = new abmn();
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private abmm(abme paramabme)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Abme = paramabme;
  }
  
  public static abmm a()
  {
    if (jdField_a_of_type_Abmm == null) {}
    try
    {
      if (jdField_a_of_type_Abmm == null)
      {
        abme localabme = new abme();
        localabme.a = "com.tencent.tangram.interstitial";
        localabme.b = "Index";
        localabme.c = "1.0.0.1";
        jdField_a_of_type_Abmm = new abmm(localabme);
      }
      return jdField_a_of_type_Abmm;
    }
    finally {}
  }
  
  public abme a()
  {
    return this.jdField_a_of_type_Abme;
  }
  
  public abmn a()
  {
    return this.jdField_a_of_type_Abmn;
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
    abrl.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Abmm)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    AdIPCManager.INSTANCE.register("ipc_interstitial_close", new abml());
    AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new abms());
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      abrl.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
      abrl.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmm
 * JD-Core Version:    0.7.0.1
 */