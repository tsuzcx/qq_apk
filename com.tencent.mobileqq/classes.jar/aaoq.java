import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForInterstitial;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class aaoq
{
  private static volatile aaoq jdField_a_of_type_Aaoq;
  private volatile aaoi jdField_a_of_type_Aaoi;
  private aaor jdField_a_of_type_Aaor = new aaor();
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private aaoq(aaoi paramaaoi)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_Aaoi = paramaaoi;
  }
  
  public static aaoq a()
  {
    if (jdField_a_of_type_Aaoq == null) {}
    try
    {
      if (jdField_a_of_type_Aaoq == null)
      {
        aaoi localaaoi = new aaoi();
        localaaoi.a = "com.tencent.tangram.interstitial";
        localaaoi.b = "Index";
        localaaoi.c = "1.0.0.1";
        jdField_a_of_type_Aaoq = new aaoq(localaaoi);
      }
      return jdField_a_of_type_Aaoq;
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
      aase.b("GdtInterstitialManager", String.format("getTimeoutMillis %d", new Object[] { Long.valueOf(l) }));
      return l;
      if (paramContext.settingsForInterstitial.timeoutMillis > 0) {
        l = paramContext.settingsForInterstitial.timeoutMillis;
      }
    }
  }
  
  public aaoi a()
  {
    return this.jdField_a_of_type_Aaoi;
  }
  
  public aaor a()
  {
    return this.jdField_a_of_type_Aaor;
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
    aase.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Aaoq)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    aaqp.a().a("ipc_interstitial_close", new aaop());
    aaqp.a().a("ipc_interstitial_predownload", new aaow());
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext == null) {}
    for (boolean bool = false;; bool = paramContext.settingsForInterstitial.enablePreDownload)
    {
      aase.b("GdtInterstitialManager", String.format("isPreDownloadEnabled %b", new Object[] { Boolean.valueOf(bool) }));
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
      aase.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
      aase.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
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
 * Qualified Name:     aaoq
 * JD-Core Version:    0.7.0.1
 */