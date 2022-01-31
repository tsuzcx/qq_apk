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

class aapj
{
  private static aapl a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    aapl localaapl = new aapl(null);
    localaapl.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localaapl.method = "POST";
    localaapl.contentType = "application/json";
    localaapl.connectTimeoutMillis = 5000;
    localaapl.readTimeoutMillis = 5000;
    localaapl.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localaapl;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      aanp.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      aapl localaapl;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          aanp.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localaapl = a(paramContext, paramGdtAd, paramAdFormData);
        if (localaapl != null) {}
      }
      else
      {
        aanp.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localaapl);
      a(paramGdtAd, paramAdFormData, localaapl);
      if ((localaapl.isSuccess()) && (localaapl.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, aapl paramaapl)
  {
    if ((paramaapl == null) || (!paramaapl.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      aanp.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramaapl.responseData, "UTF-8"));
      paramaapl.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      aanp.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramaapl.a + " message:" + str);
      if (paramaapl.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      aanp.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      aanp.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      aanp.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = aapp.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      aanp.d("GdtFormPrefetchTokenUtil", "getRequestData error");
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
        aanp.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        aanp.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapj
 * JD-Core Version:    0.7.0.1
 */