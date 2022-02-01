import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;

public class acor
{
  public static final Pattern a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  
  private URLDrawable a(Context paramContext, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources();
    localURLDrawableOptions.mLoadingDrawable = paramContext.getDrawable(2130845481);
    localURLDrawableOptions.mFailedDrawable = paramContext.getDrawable(2130845481);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = afur.a(50.0F, paramContext);
    paramString.setTag(bgey.b(i, i, afur.a(12.0F, paramContext)));
    paramString.setDecodeHandler(bgey.c);
    return paramString;
  }
  
  private boolean a(acoe paramacoe)
  {
    paramacoe = paramacoe.a();
    return (paramacoe.productType == 12) || (paramacoe.productType == 19);
  }
  
  public int a(GdtAd paramGdtAd, Activity paramActivity)
  {
    try
    {
      AdClickUtil.Params localParams = new AdClickUtil.Params();
      localParams.activity = new WeakReference(paramActivity);
      localParams.ad = paramGdtAd;
      localParams.extrasForIntent = new Bundle();
      localParams.extrasForIntent.putString("big_brother_source_key", "biz_src_ads");
      int i = AdClickUtil.getActionAboutApp(localParams, -2147483648);
      return i;
    }
    catch (Exception paramGdtAd)
    {
      QLog.e("GdtMvElementsHelper", 1, "doOpenMain", paramGdtAd);
    }
    return -2147483648;
  }
  
  public Drawable a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData == null) || (TextUtils.isEmpty(paramGdtMotiveVideoPageData.bannerLogo))) {
      return paramContext.getResources().getDrawable(2130845481);
    }
    return a(paramContext, paramGdtMotiveVideoPageData.bannerLogo);
  }
  
  public String a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      QLog.i("GdtMvElementsHelper", 1, "getRefId activity == null");
      paramActivity = null;
    }
    String str1;
    do
    {
      return paramActivity;
      String str2 = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        QLog.i("GdtMvElementsHelper", 1, "getRefId refId is empty");
        str1 = paramActivity.getIntent().getStringExtra("big_brother_source_key");
      }
      paramActivity = str1;
    } while (!TextUtils.isEmpty(str1));
    QLog.i("GdtMvElementsHelper", 1, "getRefId key is empty");
    return str1;
  }
  
  public String a(Context paramContext, acoe paramacoe)
  {
    String str2 = anni.a(2131703993);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramacoe.a();
    Object localObject = paramacoe.a();
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (!((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get().isEmpty())
      {
        str2 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get(0)).txt.get();
        localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).app_info.app_package_name.get();
        if (TextUtils.isEmpty(str2)) {
          break label138;
        }
        str1 = str2;
        if (a(paramacoe))
        {
          str1 = str2;
          if (nxw.a(paramContext, (String)localObject))
          {
            if (!localGdtMotiveVideoPageData.isStyleC()) {
              break label132;
            }
            str1 = anni.a(2131703988);
          }
        }
      }
    }
    return str1;
    label132:
    return anni.a(2131703989);
    label138:
    if (a(paramacoe))
    {
      if (nxw.a(paramContext, (String)localObject)) {
        return anni.a(2131703990);
      }
      return anni.a(2131703992);
    }
    return anni.a(2131703994);
  }
  
  public String a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData == null) || (TextUtils.isEmpty(paramGdtMotiveVideoPageData.bannerImgName))) {
      return "";
    }
    return paramGdtMotiveVideoPageData.bannerImgName;
  }
  
  public void a(Activity paramActivity, GdtAd paramGdtAd)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("big_brother_source_key", "biz_src_ads");
      localBundle.putString("big_brother_ref_source_key", a(paramActivity));
      paramActivity = AdAppUtil.launch(paramActivity, paramGdtAd.getAppPackageName(), localBundle);
      paramGdtAd = new StringBuffer("doOpenMain result = ");
      if (paramActivity == null) {
        paramGdtAd.append("null");
      }
      for (;;)
      {
        QLog.i("GdtMvElementsHelper", 1, paramGdtAd.toString());
        return;
        paramGdtAd.append(paramActivity.getErrorCode());
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("GdtMvElementsHelper", 1, "doOpenMain", paramActivity);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = Uri.parse(paramString);
        paramString = ((Uri)localObject2).getPath();
        Object localObject1 = a.matcher(paramString);
        if (!((Matcher)localObject1).matches())
        {
          QLog.i("GdtMvElementsHelper", 1, "callJs !matcher.matches()");
          return;
        }
        paramString = ((Matcher)localObject1).group(1);
        localObject1 = ((Matcher)localObject1).group(3);
        Object localObject3 = ((Uri)localObject2).getQueryParameter("q");
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("action", paramString);
        ((JSONObject)localObject2).put("data", localJSONObject);
        ((JSONObject)localObject2).put("code", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramString = new JSONObject((String)localObject3).optString("bridgeName");
          if (!TextUtils.isEmpty(paramString))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("callbackid", localObject1);
            ((JSONObject)localObject3).put("status", 0);
            ((JSONObject)localObject3).put("data", ((JSONObject)localObject2).toString());
            ((JSONObject)localObject3).put("keep", 1);
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append(paramString).append("(").append(((JSONObject)localObject3).toString()).append(")");
            QLog.i("GdtMvElementsHelper", 1, "callJs script: " + ((StringBuffer)localObject1).toString());
            paramWebView.evaluateJavascript(((StringBuffer)localObject1).toString(), new acos(this));
            return;
          }
        }
      }
      catch (Exception paramWebView)
      {
        QLog.e("GdtMvElementsHelper", 1, "doOpenMain", paramWebView);
        return;
      }
      paramString = "bridge.callback";
    }
  }
  
  public void b(Activity paramActivity, GdtAd paramGdtAd)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("big_brother_source_key", "biz_src_ads");
      localBundle.putString("big_brother_ref_source_key", a(paramActivity));
      AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
      localParams.deeplink = paramGdtAd.getAppDeeplink();
      localParams.addflags = 268435456;
      localParams.extrasForIntent = localBundle;
      paramActivity = AdAppDeeplinkLauncher.launch(paramActivity, localParams);
      paramGdtAd = new StringBuffer("doOpenDeepLink result = ");
      if ((paramActivity != null) && (paramActivity.isSuccess())) {
        paramGdtAd.append("isSuccess");
      }
      for (;;)
      {
        QLog.i("GdtMvElementsHelper", 1, paramGdtAd.toString());
        return;
        paramGdtAd.append("failed");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.i("GdtMvElementsHelper", 1, "doOpenMain", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acor
 * JD-Core Version:    0.7.0.1
 */