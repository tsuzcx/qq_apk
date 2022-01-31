import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.canvasJson.AdCanvasJsonManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.gdtad.aditem.GdtPreLoader.2;
import org.json.JSONException;
import org.json.JSONObject;

public final class aail
{
  private static volatile aail a;
  
  public static aail a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aail();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (TextUtils.isEmpty(paramGdtAd.getCanvas()))) {}
    for (;;)
    {
      return;
      int i = paramGdtAd.getDestType();
      int j = paramGdtAd.getProductType();
      if (((i == 4) && (j == 1000)) || (paramGdtAd.isAppXiJing()) || (paramGdtAd.isAppXiJingDefault())) {}
      for (i = 1; i != 0; i = 0) {
        try
        {
          Object localObject = new JSONObject(paramGdtAd.getCanvas());
          String str = ((JSONObject)localObject).optString("canvas_json_key");
          localObject = ((JSONObject)localObject).optString("canvas_json_url");
          if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label147;
          }
          AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, str, (String)localObject);
          return;
        }
        catch (JSONException paramGdtAd)
        {
          aanp.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
          return;
        }
      }
    }
    label147:
    aanp.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
  }
  
  private void c(GdtAd paramGdtAd)
  {
    aanp.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: ad = [" + paramGdtAd + "]");
    if (!paramGdtAd.isVideoSplice()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.2(this, paramGdtAd));
  }
  
  private void d(GdtAd paramGdtAd)
  {
    aaos.a().a(BaseApplicationImpl.getContext(), null);
    if ((paramGdtAd != null) && (paramGdtAd.isInterstitial())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = aakb.a().a(BaseApplicationImpl.getContext());
      aanp.b("GdtPreLoader", String.format("preDownloadInterstitialAfterAdLoaded isInterstitial:%b isEnabled:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      if ((bool1) && (bool2)) {
        aake.a().b(BaseApplicationImpl.getContext());
      }
      return;
    }
  }
  
  public void a(GdtAd paramGdtAd)
  {
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    c(paramGdtAd);
    b(paramGdtAd);
    d(paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aail
 * JD-Core Version:    0.7.0.1
 */