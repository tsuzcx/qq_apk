import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.2;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.5;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.6;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class abmn
  implements aopx
{
  private static int a(int paramInt)
  {
    int j = 1;
    int i;
    if ((paramInt == 101) || (paramInt == 102) || (paramInt == 106)) {
      i = 4;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramInt == 103);
            i = j;
          } while (paramInt == 104);
          i = j;
        } while (paramInt == 105);
        i = j;
      } while (paramInt == 107);
      i = j;
    } while (paramInt == 108);
    abrl.d("GdtInterstitialNotifyReg", String.format("getError arkScriptError:%d not working", new Object[] { Integer.valueOf(paramInt) }));
    return 1;
  }
  
  private static int a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
        {
          int i = localJSONObject.getInt("reason");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtInterstitialNotifyReg", String.format("getReasonForClose params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
        {
          long l = localJSONObject.getLong("videopositionmillis");
          return l;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtInterstitialNotifyReg", String.format("getVideoPositionMillis params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648L;
  }
  
  private static GdtAd a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          localObject = ((JSONObject)localObject).getJSONObject("adInfo");
          if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
          {
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
            if (localObject != null)
            {
              localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
              boolean bool = ((GdtAd)localObject).isValid();
              if (bool) {
                return localObject;
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("getAd params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static JSONObject a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
        {
          localJSONObject = localJSONObject.getJSONObject("options");
          if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
          {
            localJSONObject = localJSONObject.getJSONObject("antiSpamParamsOnCGI");
            return localJSONObject;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("getAntiSpamParamsOnCGI params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_resume_event");
  }
  
  private static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString)
  {
    paramContext = new WeakReference(paramContext);
    ArkAppCenter.a().postToArkThread(new GdtInterstitialNotifyReg.1(paramGdtInterstitialParams, paramString, paramContext, paramGdtInterstitialStatus));
  }
  
  private boolean a(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      AdHttp.Params localParams = new AdHttp.Params();
      localParams.setUrl(paramString);
      localParams.method = "GET";
      if (!localParams.canSend()) {
        bool = false;
      } else {
        bool = AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.2(this, localParams), 4);
      }
    }
  }
  
  private static int b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
        {
          int i = localJSONObject.getInt("errCode");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtInterstitialNotifyReg", String.format("getError params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static String b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          localObject = ((JSONObject)localObject).getString("url");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtInterstitialNotifyReg", String.format("getUrl params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static WeakReference<GdtInterstitialFragment> b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (!paramString.isValid())) {}
    do
    {
      return null;
      paramString = paramString.getTraceId();
    } while (TextUtils.isEmpty(paramString));
    return abmm.a().a(paramString);
  }
  
  private static JSONObject b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
        {
          localJSONObject = localJSONObject.getJSONObject("options");
          if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
          {
            localJSONObject = localJSONObject.getJSONObject("antiSpamParamsOnReportServer");
            return localJSONObject;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("getAntiSpamParamsOnReportServer params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_pause_event");
  }
  
  private boolean b(String paramString)
  {
    WeakReference localWeakReference = b(paramString);
    boolean bool;
    if (localWeakReference != null) {
      if (localWeakReference.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("receiveClick %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      paramString = a(paramString);
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.3(this, localWeakReference, paramString), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private static String c(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          localObject = ((JSONObject)localObject).getString("key");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtInterstitialNotifyReg", String.format("getKey params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_destroy_event");
  }
  
  private boolean c(String paramString)
  {
    int i = a(paramString);
    long l = a(paramString);
    paramString = b(paramString);
    boolean bool;
    if (paramString != null) {
      if (paramString.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("receiveClose %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.4(this, paramString, i, l), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean d(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if (paramString != null) {
      if (paramString.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      abrl.b("GdtInterstitialNotifyReg", String.format("receiveLoaded %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.5(this, paramString), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean e(String paramString)
  {
    int i = b(paramString);
    int j = a(i);
    abrl.d("GdtInterstitialNotifyReg", String.format("receiveError error:%d arkScriptError:%d params:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramString }));
    if ((j != 4) && (j != 207)) {}
    do
    {
      return true;
      paramString = b(paramString);
    } while ((paramString == null) || (paramString.get() == null));
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.6(this, paramString, j, i), 0);
    return true;
  }
  
  private boolean f(String paramString)
  {
    String str = null;
    JSONObject localJSONObject = b(paramString);
    if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)) || (localJSONObject.length() <= 0))
    {
      abrl.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer error, antiSpamParams is null");
      return false;
    }
    paramString = b(paramString);
    if ((paramString != null) && (paramString.get() != null)) {}
    for (Object localObject = ((GdtInterstitialFragment)paramString.get()).a();; localObject = null)
    {
      paramString = str;
      if (localObject != null) {
        paramString = ((GdtInterstitialParams)localObject).a;
      }
      if ((paramString != null) && (!JSONObject.NULL.equals(paramString)) && (paramString.length() > 0)) {
        break;
      }
      abrl.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer error, antiSpamParamsFromPosition is null");
      return false;
    }
    abrl.b("GdtInterstitialNotifyReg", String.format("receiveReportForAntiSpamOnReportServer ark:%s position:%s", new Object[] { localJSONObject.toString(), paramString.toString() }));
    localObject = paramString.keys();
    while (((Iterator)localObject).hasNext()) {
      try
      {
        str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, paramString.get(str));
      }
      catch (Throwable localThrowable)
      {
        abrl.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer", localThrowable);
      }
    }
    abrz.b(localJSONObject);
    return true;
  }
  
  private boolean g(String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.7(this, paramString), 0);
    return true;
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    abrl.b("GdtInterstitialNotifyReg", String.format("notify appName:%s eventName:%s params:%s", new Object[] { paramString1, paramString2, paramString3 }));
    boolean bool;
    if (abmm.a().a().a.equals(paramString1)) {
      if ("interstitial_http_get_event".equals(paramString2)) {
        bool = a(paramString3);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = b(paramString3);
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break label291;
        }
        paramString3 = ((GdtInterstitialFragment)((WeakReference)localObject).get()).a();
        label99:
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break label296;
        }
      }
      label291:
      label296:
      for (Object localObject = ((GdtInterstitialFragment)((WeakReference)localObject).get()).a();; localObject = null)
      {
        absa.a(BaseApplicationImpl.getApplication(), paramString3, (GdtInterstitialStatus)localObject, paramString2, paramString1);
        return bool;
        if ("interstitial_jump_click_event".equals(paramString2))
        {
          bool = b(paramString3);
          i = 1;
          break;
        }
        if ("interstitial_close_click_event".equals(paramString2))
        {
          bool = c(paramString3);
          i = 1;
          break;
        }
        if ("interstitial_success_event".equals(paramString2))
        {
          bool = d(paramString3);
          i = 1;
          break;
        }
        if ("interstitial_error_event".equals(paramString2))
        {
          bool = e(paramString3);
          i = 1;
          break;
        }
        if ("interstitial_antispam_report_event".equals(paramString2))
        {
          bool = f(paramString3);
          break;
        }
        if (!"interstitial_report_event".equals(paramString2)) {
          break label302;
        }
        localObject = c(paramString3);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2 = (String)localObject;
        }
        bool = g(paramString3);
        i = 1;
        break;
        paramString3 = null;
        break label99;
      }
      label302:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmn
 * JD-Core Version:    0.7.0.1
 */