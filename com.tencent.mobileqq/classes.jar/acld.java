import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.web.GdtLandingPageReport.1;
import com.tencent.gdtad.web.GdtLandingPageReport.2;
import com.tencent.open.base.http.HttpBaseUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class acld
  implements aclj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acll jdField_a_of_type_Acll;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public acld(acll paramacll)
  {
    if (paramacll == null) {
      return;
    }
    acho.a("GdtLandingPageReport", " GdtLandingPageReport");
    this.jdField_a_of_type_Acll = paramacll;
  }
  
  private String a(long paramLong, String paramString1, String paramString2)
  {
    acho.a("GdtLandingPageReport", " getScript== start ");
    Object localObject2 = "";
    if (this.jdField_a_of_type_Acll != null) {
      localObject2 = aclb.a().a(this.jdField_a_of_type_Acll.a());
    }
    acho.a("GdtLandingPageReport", " getScript==" + (String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      acho.a("GdtLandingPageReport", " getScript pagePerformance is close");
      paramString1 = "";
    }
    do
    {
      return paramString1;
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(String.valueOf(paramLong))) {
        localObject1 = ((String)localObject2).replaceAll("__CLICK_TIME__", String.valueOf(paramLong));
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramString1)) {
        localObject2 = ((String)localObject1).replaceAll("__TRACE_ID__", paramString1);
      }
      paramString1 = (String)localObject2;
    } while (TextUtils.isEmpty(paramString2));
    return ((String)localObject2).replaceAll("__NET_LOG_REQ_ID__", paramString2);
  }
  
  private String a(String paramString)
  {
    String str2 = "";
    if (this.jdField_a_of_type_Acll != null) {}
    for (Activity localActivity = this.jdField_a_of_type_Acll.a();; localActivity = null)
    {
      String str1 = str2;
      if (localActivity != null)
      {
        str1 = str2;
        if (localActivity.getIntent() != null) {
          str1 = localActivity.getIntent().getStringExtra(paramString);
        }
      }
      Log.i("GdtLandingPageReport", "name = " + paramString + ", s = " + str1);
      return str1;
    }
  }
  
  private void a(CustomWebView paramCustomWebView, acli paramacli)
  {
    if (paramCustomWebView == null)
    {
      acho.d("GdtLandingPageReport", " webviewCheckPerformanceFuncExist webview is null");
      return;
    }
    a(paramCustomWebView, "typeof __TG_GET_PAGE_PERFORMANCE__ === \"function\"", 3, new aclg(this, paramacli));
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString)
  {
    if (!aclb.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) {
      return;
    }
    if (paramCustomWebView == null)
    {
      acho.d("GdtLandingPageReport", " webviewInjectScript webview is null");
      return;
    }
    AdThreadManager.INSTANCE.post(new GdtLandingPageReport.1(this, paramString, paramCustomWebView), 3);
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString, int paramInt, acli paramacli)
  {
    if ((paramCustomWebView == null) || (TextUtils.isEmpty(paramString))) {
      acho.a("GdtLandingPageReport", " injectScript webview or script is null");
    }
    while (!aclb.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) {
      return;
    }
    long l = System.currentTimeMillis();
    acho.a("GdtLandingPageReport", " injectScript scene: " + paramInt + " 注入JS.");
    a(new GdtLandingPageReport.2(this, paramString, paramCustomWebView, paramInt, l, paramacli));
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    if (paramCustomWebView == null)
    {
      acho.d("GdtLandingPageReport", " webviewSupplyInject webview is null");
      return;
    }
    a(paramCustomWebView, new aclh(this, paramCustomWebView, paramString2));
  }
  
  static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    AdThreadManager.INSTANCE.post(paramRunnable, 0);
  }
  
  private void a(String paramString)
  {
    acho.a("GdtLandingPageReport", " report");
    try
    {
      paramString = new JSONObject(paramString);
      acho.a("GdtLandingPageReport", " performanceJson: " + paramString);
      b(paramString.getJSONArray("event_report"));
      a(paramString.getJSONArray("rpt_report"));
      return;
    }
    catch (Exception paramString)
    {
      acho.d("GdtLandingPageReport", " report.", paramString);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    acho.a("GdtLandingPageReport", " rptBatchReport: " + paramJSONArray);
    if (JSONObject.NULL.equals(paramJSONArray)) {
      acho.d("GdtLandingPageReport", " rptBatchReport data is null");
    }
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = new JSONArray();
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject1).put(paramJSONArray.get(i));
          Object localObject2;
          if (((JSONArray)localObject1).length() < 20)
          {
            localObject2 = localObject1;
            if (i != j - 1) {}
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("Postbody", ((JSONArray)localObject1).toString());
            ((Bundle)localObject2).putString("Referer", "h5.gdt.qq.com");
            HttpBaseUtil.a("https://rpt.gdt.qq.com/batch_landing_page", "POST", (Bundle)localObject2, null);
            localObject2 = new JSONArray();
          }
          i += 1;
          localObject1 = localObject2;
        }
        return;
      }
      catch (Exception paramJSONArray)
      {
        acho.d("GdtLandingPageReport", " rptBatchReport exception.", paramJSONArray);
      }
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    acho.a("GdtLandingPageReport", " eventReport: " + paramJSONArray);
    if (JSONObject.NULL.equals(paramJSONArray))
    {
      acho.d("GdtLandingPageReport", " eventReport data is null");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramJSONArray.length();
        i = 0;
        if (i >= j) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        int k = localJSONObject.getInt("eventId");
        long l = localJSONObject.optLong("duration");
        if (k != -2147483648) {
          a(k, l);
        }
      }
      catch (Exception paramJSONArray)
      {
        acho.d("GdtLandingPageReport", " eventReport exception.", paramJSONArray);
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    c();
    a(1500000);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (!aclb.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) {
      return;
    }
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramInt, localgdt_analysis_event);
    localgdt_analysis_event.duration = paramLong;
    AdAnalysisEvent localAdAnalysisEvent = new AdAnalysisEvent(localgdt_analysis_event, 102);
    acho.a("GdtLandingPageReport", "reportEvent eventId =" + paramInt + "duration =" + localgdt_analysis_event.duration);
    AdAnalysis.INSTANCE.handleAsync(this.jdField_a_of_type_JavaLangRefWeakReference, localAdAnalysisEvent);
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    a(1500001);
    a(paramCustomWebView, "");
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    paramMap = a("GdtWebReportQQ_ACTION_URL");
    String str = a("GdtWebReportQQ_TRACE_ID");
    if ((TextUtils.isEmpty(paramMap)) || (TextUtils.isEmpty(str))) {
      Log.i("GdtLandingPageReport", "ljh, empty traceURL or traceID");
    }
    do
    {
      return false;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acll != null) && (this.jdField_a_of_type_Acll.a() != null) && (paramLong == 8589934593L))
      {
        a((CustomWebView)this.jdField_a_of_type_Acll.a().get(), a("GdtWebReportQQ_TRACE_ID"), "");
        this.jdField_a_of_type_Boolean = true;
      }
      acho.a("GdtLandingPageReport", " handleEvent url = " + paramString + "==type ==" + paramLong);
      if ((aclm.a(paramString)) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_Int = 1;
        a(1500009);
      }
    } while ((this.jdField_a_of_type_Int != 1) || (paramLong != 8589934593L) || (aclm.a(paramString)));
    a(1500010);
    this.jdField_a_of_type_Int = 2;
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Acll != null) && (this.jdField_a_of_type_Acll.a() != null)) {
      b((CustomWebView)this.jdField_a_of_type_Acll.a().get());
    }
  }
  
  public void b(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null)
    {
      acho.d("GdtLandingPageReport", " webviewGetPerformanceResult webview is null");
      return;
    }
    acho.a("GdtLandingPageReport", " webviewGetPerformanceResult");
    a(paramCustomWebView, "__TG_GET_PAGE_PERFORMANCE__()", 2, new aclf(this));
  }
  
  public void c()
  {
    acho.a("GdtLandingPageReport", " init");
    if ((this.jdField_a_of_type_Acll != null) && (this.jdField_a_of_type_Acll.a() != null))
    {
      acho.a("GdtLandingPageReport", " init success");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_Acll.a());
      this.jdField_a_of_type_Long = this.jdField_a_of_type_Acll.a().getIntent().getLongExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acld
 * JD-Core Version:    0.7.0.1
 */