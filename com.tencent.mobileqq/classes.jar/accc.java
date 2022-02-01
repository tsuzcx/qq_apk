import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class accc
{
  private static volatile accc jdField_a_of_type_Accc;
  private volatile acbu jdField_a_of_type_Acbu;
  private accd jdField_a_of_type_Accd = new accd();
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private accc(acbu paramacbu)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Acbu = paramacbu;
  }
  
  public static accc a()
  {
    if (jdField_a_of_type_Accc == null) {}
    try
    {
      if (jdField_a_of_type_Accc == null)
      {
        acbu localacbu = new acbu();
        localacbu.a = "com.tencent.tangram.interstitial";
        localacbu.b = "Index";
        localacbu.c = "1.0.0.1";
        jdField_a_of_type_Accc = new accc(localacbu);
      }
      return jdField_a_of_type_Accc;
    }
    finally {}
  }
  
  public acbu a()
  {
    return this.jdField_a_of_type_Acbu;
  }
  
  public accd a()
  {
    return this.jdField_a_of_type_Accd;
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
    acho.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Accc)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    AdIPCManager.INSTANCE.register("ipc_interstitial_close", new accb());
    AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new acci());
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      acho.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
      acho.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
 * Qualified Name:     accc
 * JD-Core Version:    0.7.0.1
 */