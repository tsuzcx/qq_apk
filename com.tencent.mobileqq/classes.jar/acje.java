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

class acje
{
  private static acjg a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    acjg localacjg = new acjg(null);
    localacjg.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localacjg.method = "POST";
    localacjg.contentType = "application/json";
    localacjg.connectTimeoutMillis = 5000;
    localacjg.readTimeoutMillis = 5000;
    localacjg.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localacjg;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      acho.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      acjg localacjg;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          acho.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localacjg = a(paramContext, paramGdtAd, paramAdFormData);
        if (localacjg != null) {}
      }
      else
      {
        acho.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localacjg);
      a(paramGdtAd, paramAdFormData, localacjg);
      if ((localacjg.isSuccess()) && (localacjg.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, acjg paramacjg)
  {
    if ((paramacjg == null) || (!paramacjg.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      acho.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramacjg.responseData, "UTF-8"));
      paramacjg.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      acho.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramacjg.a + " message:" + str);
      if (paramacjg.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      acho.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      acho.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      acho.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = acjk.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      acho.d("GdtFormPrefetchTokenUtil", "getRequestData error");
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
        acho.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        acho.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acje
 * JD-Core Version:    0.7.0.1
 */