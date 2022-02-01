import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForWebView;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.settings.AdSettingsUtil.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.web.GdtLandingPageConfig.1;
import com.tencent.open.base.http.HttpBaseUtil;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public final class aclb
{
  private static aclb jdField_a_of_type_Aclb;
  private AdSettingsUtil.a jdField_a_of_type_ComTencentAdTangramSettingsAdSettingsUtil$a = new aclc(this, null);
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public static aclb a()
  {
    if (jdField_a_of_type_Aclb == null) {}
    try
    {
      if (jdField_a_of_type_Aclb == null) {
        jdField_a_of_type_Aclb = new aclb();
      }
      return jdField_a_of_type_Aclb;
    }
    finally {}
  }
  
  private String a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return "";
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } while (localObject == null);
    acho.d("GdtLandingPageConfiggetUin ==", ((AppRuntime)localObject).getAccount());
    return ((AppRuntime)localObject).getAccount();
  }
  
  private void a(WeakReference<Context> paramWeakReference)
  {
    acho.a("GdtLandingPageConfig", "loadLandingPageReportJsAsync isLoaded ==" + this.b);
    if (this.b) {
      return;
    }
    AdThreadManager.INSTANCE.post(new GdtLandingPageConfig.1(this, paramWeakReference), 4);
  }
  
  private void b(WeakReference<Context> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    for (;;)
    {
      return;
      acho.d("GdtLandingPageConfig", "isSupportNewLandingPageReport ==" + a(paramWeakReference));
      if (a(paramWeakReference))
      {
        Object localObject = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get()).settingsForWebView.jsUrlForPagePerformance;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          acho.d("GdtLandingPageConfig", "startLoad");
          this.b = true;
          Bundle localBundle = new Bundle();
          localBundle.putString("Referer", "h5.gdt.qq.com");
          try
          {
            localObject = HttpBaseUtil.a((String)localObject, "GET", localBundle, null).a;
            if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200)
            {
              localObject = HttpBaseUtil.a((HttpResponse)localObject);
              acho.a("GdtLandingPageConfig", "load resultStr =" + (String)localObject);
              if (paramWeakReference.get() != null)
              {
                paramWeakReference = ((Context)paramWeakReference.get()).getSharedPreferences("gdtLandingPageConfig", 4).edit();
                paramWeakReference.putString("landingpageScript", (String)localObject);
                paramWeakReference.commit();
                return;
              }
            }
          }
          catch (Exception paramWeakReference)
          {
            paramWeakReference.printStackTrace();
            acho.a("GdtLandingPageConfig", "writeFileException" + paramWeakReference.getMessage());
          }
        }
      }
    }
  }
  
  public String a(Context paramContext)
  {
    Object localObject;
    if (!a(new WeakReference(paramContext))) {
      localObject = "";
    }
    do
    {
      do
      {
        return localObject;
        localObject = "";
      } while (paramContext == null);
      paramContext = paramContext.getSharedPreferences("gdtLandingPageConfig", 4).getString("landingpageScript", "");
      acho.a("GdtLandingPageConfig", "sharedPreferences result ==" + paramContext);
      localObject = paramContext;
    } while (TextUtils.isEmpty(paramContext));
    return paramContext;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_Boolean = true;
    AdSettingsUtil.INSTANCE.addListener(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramSettingsAdSettingsUtil$a));
    a(new WeakReference(paramContext.getApplicationContext()));
  }
  
  public boolean a(WeakReference<Context> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
      return false;
    }
    paramWeakReference = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get());
    return (paramWeakReference != null) && (paramWeakReference.settingsForWebView != null) && (paramWeakReference.settingsForWebView.abTest != null) && (AdABTest.isABTestByUIN(a(), paramWeakReference.settingsForWebView.abTest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclb
 * JD-Core Version:    0.7.0.1
 */