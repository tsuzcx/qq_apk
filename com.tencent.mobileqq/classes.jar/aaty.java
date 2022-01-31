import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aaty
{
  private static aaua a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    aaua localaaua = new aaua(null);
    localaaua.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localaaua.method = "POST";
    localaaua.contentType = "application/json";
    localaaua.connectTimeoutMillis = 5000;
    localaaua.readTimeoutMillis = 5000;
    localaaua.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localaaua;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      aase.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      aaua localaaua;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          aase.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localaaua = a(paramContext, paramGdtAd, paramAdFormData);
        if (localaaua != null) {}
      }
      else
      {
        aase.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localaaua);
      a(paramGdtAd, paramAdFormData, localaaua);
      if ((localaaua.isSuccess()) && (localaaua.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, aaua paramaaua)
  {
    if ((paramaaua == null) || (!paramaaua.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      aase.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramaaua.responseData, "UTF-8"));
      paramaaua.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      aase.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramaaua.a + " message:" + str);
      if (paramaaua.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      aase.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      aase.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      aase.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = aaue.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      aase.d("GdtFormPrefetchTokenUtil", "getRequestData error");
      return null;
    }
    paramContext = AdCanvasDataBuilderV2.build(paramContext, paramGdtAd);
    long l;
    if (paramContext != null) {
      if (!paramContext.isValid()) {
        l = -2147483648L;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = new JSONObject();
        if (l != -2147483648L) {
          paramContext.put("pageId", l);
        }
        paramContext.put("traceId", paramGdtAd.getTraceId());
        paramContext.put("formId", paramAdFormData.formId);
        paramContext.put("formValue", localJSONArray.toString());
        paramContext = paramContext.toString().getBytes("UTF-8");
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        aase.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        aase.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaty
 * JD-Core Version:    0.7.0.1
 */