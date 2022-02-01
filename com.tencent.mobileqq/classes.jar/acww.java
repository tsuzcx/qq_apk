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

class acww
{
  private static acwy a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    acwy localacwy = new acwy(null);
    localacwy.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localacwy.method = "POST";
    localacwy.contentType = "application/json";
    localacwy.connectTimeoutMillis = 5000;
    localacwy.readTimeoutMillis = 5000;
    localacwy.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localacwy;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      acvc.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      acwy localacwy;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          acvc.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localacwy = a(paramContext, paramGdtAd, paramAdFormData);
        if (localacwy != null) {}
      }
      else
      {
        acvc.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localacwy);
      a(paramGdtAd, paramAdFormData, localacwy);
      if ((localacwy.isSuccess()) && (localacwy.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, acwy paramacwy)
  {
    if ((paramacwy == null) || (!paramacwy.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      acvc.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramacwy.responseData, "UTF-8"));
      paramacwy.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      acvc.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramacwy.a + " message:" + str);
      if (paramacwy.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      acvc.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      acvc.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      acvc.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = acxc.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      acvc.d("GdtFormPrefetchTokenUtil", "getRequestData error");
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
        acvc.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        acvc.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acww
 * JD-Core Version:    0.7.0.1
 */