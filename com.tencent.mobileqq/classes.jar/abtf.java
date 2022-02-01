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

class abtf
{
  private static abth a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    abth localabth = new abth(null);
    localabth.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localabth.method = "POST";
    localabth.contentType = "application/json";
    localabth.connectTimeoutMillis = 5000;
    localabth.readTimeoutMillis = 5000;
    localabth.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return localabth;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      abrl.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      abth localabth;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          abrl.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localabth = a(paramContext, paramGdtAd, paramAdFormData);
        if (localabth != null) {}
      }
      else
      {
        abrl.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localabth);
      a(paramGdtAd, paramAdFormData, localabth);
      if ((localabth.isSuccess()) && (localabth.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, abth paramabth)
  {
    if ((paramabth == null) || (!paramabth.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      abrl.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramabth.responseData, "UTF-8"));
      paramabth.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      abrl.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramabth.a + " message:" + str);
      if (paramabth.a == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      abrl.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      abrl.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      abrl.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = abtl.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      abrl.d("GdtFormPrefetchTokenUtil", "getRequestData error");
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
        abrl.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        abrl.d("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtf
 * JD-Core Version:    0.7.0.1
 */