import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import org.json.JSONObject;

public final class abqj
  implements abqx
{
  private static GdtAd a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.hasExtra("gdt_ad")) {
      return null;
    }
    return (GdtAd)paramIntent.getParcelableExtra("gdt_ad");
  }
  
  private static JSONObject a(GdtAd paramGdtAd)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramGdtAd != null) {}
    for (;;)
    {
      try
      {
        boolean bool = paramGdtAd.isValid();
        if (bool) {
          continue;
        }
      }
      catch (Throwable paramGdtAd)
      {
        Object localObject;
        abrl.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramGdtAd);
        continue;
      }
      if (localJSONObject.length() <= 0) {
        break label98;
      }
      return localJSONObject;
      localObject = abrk.a(paramGdtAd.info);
      if ((localObject != null) && (!JSONObject.NULL.equals(localObject))) {
        localJSONObject.put("adInfo", localObject.toString());
      }
      paramGdtAd = paramGdtAd.getCanvasForXiJingOffline();
      if (!TextUtils.isEmpty(paramGdtAd)) {
        localJSONObject.put("canvasJson", paramGdtAd);
      }
    }
    label98:
    return null;
  }
  
  private static GdtAd b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (!paramIntent.hasExtra("data"));
        paramIntent = paramIntent.getSerializableExtra("data");
      } while ((paramIntent == null) || (!(paramIntent instanceof GdtVideoCeilingData)));
      paramIntent = (GdtVideoCeilingData)GdtVideoCeilingData.class.cast(paramIntent);
    } while (paramIntent == null);
    return paramIntent.getAd();
  }
  
  private static GdtAd c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (!paramIntent.hasExtra("data"));
        paramIntent = paramIntent.getSerializableExtra("data");
      } while ((paramIntent == null) || (!(paramIntent instanceof GdtImaxData)));
      paramIntent = (GdtImaxData)GdtImaxData.class.cast(paramIntent);
    } while (paramIntent == null);
    return paramIntent.getAd();
  }
  
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    Object localObject2 = null;
    long l1 = System.currentTimeMillis();
    if (paramabqc != null) {}
    for (Activity localActivity = paramabqc.a(); (paramabqc == null) || (localActivity == null); localActivity = null)
    {
      abrl.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    GdtAd localGdtAd = a(localActivity.getIntent());
    paramVarArgs = a(localGdtAd);
    if ((paramVarArgs != null) && (!JSONObject.NULL.equals(paramVarArgs)) && (paramVarArgs.length() > 0)) {}
    for (;;)
    {
      Object localObject1;
      if (paramVarArgs != null)
      {
        localObject1 = paramVarArgs;
        if (!JSONObject.NULL.equals(paramVarArgs)) {}
      }
      else
      {
        localObject1 = new JSONObject();
      }
      abrl.b("GdtCanvasJSONJsCallHandler", String.format("handleJsCallRequest adInfo:%b canvasJson:%b", new Object[] { Boolean.valueOf(((JSONObject)localObject1).has("adInfo")), Boolean.valueOf(((JSONObject)localObject1).has("canvasJson")) }));
      try
      {
        paramabqc.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
        long l2 = System.currentTimeMillis();
        paramString = localObject2;
        if (paramabqc != null) {
          paramString = paramabqc.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "getCanvasJson", paramString, localGdtAd, l2 - l1);
        return true;
        localGdtAd = b(localActivity.getIntent());
        localObject1 = a(localGdtAd);
        if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1)))
        {
          paramVarArgs = (String[])localObject1;
          if (((JSONObject)localObject1).length() > 0) {
            continue;
          }
        }
        localGdtAd = c(localActivity.getIntent());
        paramVarArgs = a(localGdtAd);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          abrl.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqj
 * JD-Core Version:    0.7.0.1
 */