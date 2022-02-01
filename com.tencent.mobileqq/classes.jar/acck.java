import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.gdtad.api.interstitial.GdtInterstitialView.2;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class acck
  implements acas
{
  private ArkView a;
  
  public acck(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    this.a = a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus);
  }
  
  private static ArkView a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    WeakReference localWeakReference1 = new WeakReference(paramContext);
    WeakReference localWeakReference2 = new WeakReference(paramGdtInterstitialStatus);
    if (paramGdtInterstitialParams != null) {
      paramGdtInterstitialStatus = paramGdtInterstitialParams.a();
    }
    for (;;)
    {
      try
      {
        localacbu = accc.a().a();
        str = a(paramContext, paramGdtInterstitialParams);
        acho.b("GdtInterstitialView", String.format("load appName:%s view:%s minver:%s", new Object[] { localacbu.a, localacbu.b, localacbu.c }));
        l = System.currentTimeMillis();
        paramContext = new ArkView(paramContext, null);
        if (paramGdtInterstitialParams == null) {}
      }
      catch (Throwable paramGdtInterstitialStatus)
      {
        acbu localacbu;
        String str;
        long l;
        paramContext = null;
      }
      try
      {
        if ((paramGdtInterstitialParams.c >= 0) && (paramGdtInterstitialParams.d >= 0))
        {
          ArkAppInfo.Size localSize = new ArkAppInfo.Size(paramGdtInterstitialParams.c, paramGdtInterstitialParams.d);
          paramContext.setSize(localSize, localSize, localSize);
        }
        paramContext.setBorderType(0);
        paramContext.load(localacbu.a, localacbu.b, localacbu.c, str, null, new accl(l, paramGdtInterstitialStatus, localWeakReference2, localWeakReference1, paramGdtInterstitialParams));
        if (localWeakReference2.get() != null) {
          acid.a((Context)localWeakReference1.get(), paramGdtInterstitialParams, (GdtInterstitialStatus)localWeakReference2.get());
        }
        return paramContext;
      }
      catch (Throwable paramGdtInterstitialStatus)
      {
        break label222;
      }
      paramGdtInterstitialStatus = null;
      continue;
      label222:
      AdLog.e("GdtInterstitialView", "createView", paramGdtInterstitialStatus);
    }
  }
  
  private static String a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    if ((paramGdtInterstitialParams == null) || (!paramGdtInterstitialParams.b()))
    {
      acho.d("GdtInterstitialView", "getMetaData error");
      return null;
    }
    String str;
    if (paramGdtInterstitialParams.b == 1) {
      str = "vertical";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str))
      {
        acho.d("GdtInterstitialView", "getMetaData error");
        return null;
        if ((paramGdtInterstitialParams.b == 0) || (paramGdtInterstitialParams.b == 8)) {
          str = "horizontal";
        }
      }
      else
      {
        int i = AdUIUtils.px2dp(paramContext, paramGdtInterstitialParams.c);
        int j = AdUIUtils.px2dp(paramContext, paramGdtInterstitialParams.d);
        acho.b("GdtInterstitialView", String.format("getMetaData width:%d height:%d ptWidth:%d ptHeight:%d", new Object[] { Integer.valueOf(paramGdtInterstitialParams.c), Integer.valueOf(paramGdtInterstitialParams.d), Integer.valueOf(i), Integer.valueOf(j) }));
        try
        {
          paramContext = new JSONObject();
          paramContext.put("style", paramGdtInterstitialParams.jdField_a_of_type_Int);
          paramContext.put("screenType", str);
          paramGdtInterstitialParams = achn.a(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.info);
          if ((paramGdtInterstitialParams != null) && (!JSONObject.NULL.equals(paramGdtInterstitialParams))) {
            paramContext.put("adInfo", paramGdtInterstitialParams);
          }
          paramContext.put("viewWidth", i);
          paramContext.put("viewHeight", j);
          paramGdtInterstitialParams = new JSONObject();
          paramGdtInterstitialParams.put("gdt", paramContext);
          paramContext = paramGdtInterstitialParams.toString();
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          acho.d("GdtInterstitialView", "getMetaData", paramContext);
          return null;
        }
      }
      str = null;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialView.2(paramString, paramInt1, paramInt2), 0);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    acho.b("GdtInterstitialView", "pause");
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void b(Context paramContext)
  {
    acho.b("GdtInterstitialView", "resume");
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void c(Context paramContext)
  {
    acho.b("GdtInterstitialView", "destroy");
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acck
 * JD-Core Version:    0.7.0.1
 */