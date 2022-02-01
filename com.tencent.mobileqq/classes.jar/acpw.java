import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import org.json.JSONObject;

public final class acpw
  implements acqj
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
        acqy.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramGdtAd);
        continue;
      }
      if (localJSONObject.length() <= 0) {
        break label98;
      }
      return localJSONObject;
      localObject = acqx.a(paramGdtAd.info);
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
  
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    if (paramacpp != null) {}
    for (Activity localActivity = paramacpp.a(); (paramacpp == null) || (localActivity == null); localActivity = null)
    {
      acqy.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    GdtAd localGdtAd = a(localActivity.getIntent());
    paramVarArgs = a(localGdtAd);
    if ((paramVarArgs != null) && (!JSONObject.NULL.equals(paramVarArgs)) && (paramVarArgs.length() > 0))
    {
      if ((paramVarArgs != null) && (!JSONObject.NULL.equals(paramVarArgs))) {
        break label292;
      }
      paramVarArgs = new JSONObject();
    }
    label292:
    for (;;)
    {
      for (;;)
      {
        acqy.b("GdtCanvasJSONJsCallHandler", String.format("handleJsCallRequest adInfo:%b canvasJson:%b", new Object[] { Boolean.valueOf(paramVarArgs.has("adInfo")), Boolean.valueOf(paramVarArgs.has("canvasJson")) }));
        long l2 = System.currentTimeMillis();
        try
        {
          paramacpp.callJs(paramString, new String[] { paramVarArgs.toString() });
          long l3 = System.currentTimeMillis() - l1;
          AdOffline.INSTANCE.reportOnGetCanvasJson(localActivity, localGdtAd, paramVarArgs.has("canvasJson"), l3, l2 - l1);
          if (paramacpp != null)
          {
            paramacpp = paramacpp.a();
            AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "getCanvasJson", paramacpp, localGdtAd, l3);
            return true;
            localGdtAd = b(localActivity.getIntent());
            JSONObject localJSONObject = a(localGdtAd);
            if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
            {
              paramVarArgs = localJSONObject;
              if (localJSONObject.length() > 0) {
                break;
              }
            }
            localGdtAd = c(localActivity.getIntent());
            paramVarArgs = a(localGdtAd);
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            acqy.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramString);
            continue;
            paramacpp = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpw
 * JD-Core Version:    0.7.0.1
 */