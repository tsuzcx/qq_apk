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

class acss
{
  private static acsu a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    acsu localacsu = new acsu(null);
    localacsu.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localacsu.method = "POST";
    localacsu.contentType = "application/json";
    localacsu.connectTimeoutMillis = 5000;
    localacsu.readTimeoutMillis = 5000;
    localacsu.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localacsu;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      acqy.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      acsu localacsu;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          acqy.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localacsu = a(paramContext, paramGdtAd, paramAdFormData);
        if (localacsu != null) {}
      }
      else
      {
        acqy.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localacsu);
      a(paramGdtAd, paramAdFormData, localacsu);
      if ((localacsu.isSuccess()) && (localacsu.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, acsu paramacsu)
  {
    if ((paramacsu == null) || (!paramacsu.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      acqy.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramacsu.responseData, "UTF-8"));
      paramacsu.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      acqy.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramacsu.a + " message:" + str);
      if (paramacsu.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      acqy.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      acqy.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      acqy.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = acsy.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      acqy.d("GdtFormPrefetchTokenUtil", "getRequestData error");
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
        acqy.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        acqy.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acss
 * JD-Core Version:    0.7.0.1
 */