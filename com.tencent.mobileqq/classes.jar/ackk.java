import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.statistics.AdRelationTargetMatch;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.gdtad.aditem.GdtPreLoader.2;
import com.tencent.gdtad.aditem.GdtPreLoader.3;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class ackk
{
  private static volatile ackk a;
  
  public static ackk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ackk();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      acqy.d("GdtPreLoader", "dealAdReltargetMatch error params error");
      return;
    }
    AdRelationTargetMatch.handle(new WeakReference(localBaseApplication), paramGdtAd);
  }
  
  private void c(GdtAd paramGdtAd)
  {
    int i = 0;
    AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    if (!AdCanvas.INSTANCE.isEnable(BaseApplicationImpl.getContext())) {}
    do
    {
      do
      {
        return;
      } while ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (TextUtils.isEmpty(paramGdtAd.getCanvas())));
      if ((paramGdtAd.isWebXiJing()) || (paramGdtAd.isAppXiJing()) || (paramGdtAd.isAppXiJingDefault())) {
        i = 1;
      }
    } while (i == 0);
    try
    {
      Object localObject = new JSONObject(paramGdtAd.getCanvas());
      String str = ((JSONObject)localObject).optString("canvas_json_key");
      localObject = ((JSONObject)localObject).optString("canvas_json_url");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, str, false))))
      {
        AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, str, (String)localObject);
        return;
      }
    }
    catch (JSONException paramGdtAd)
    {
      acqy.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
      return;
    }
    acqy.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
  }
  
  private void d(GdtAd paramGdtAd)
  {
    if (!AdOffline.INSTANCE.isEnable(BaseApplicationImpl.getContext())) {}
    do
    {
      do
      {
        return;
      } while ((paramGdtAd == null) || (!paramGdtAd.isValid()) || ((!paramGdtAd.isAppXiJingOffline()) && (!paramGdtAd.isWebXiJingOffline())));
      AdThreadManager.INSTANCE.post(new GdtPreLoader.2(this, paramGdtAd), 5);
      AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    } while (!TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), false)));
    AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), paramGdtAd.getJSONUrlForXiJingOffline());
  }
  
  private void e(GdtAd paramGdtAd)
  {
    acqy.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: ad = [" + paramGdtAd + "]");
    if (!paramGdtAd.isVideoSplice()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.3(this, paramGdtAd));
  }
  
  private void f(GdtAd paramGdtAd)
  {
    acsb.a().a(BaseApplicationImpl.getContext(), null);
    if ((paramGdtAd != null) && (paramGdtAd.isInterstitial())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = acmb.a().a(BaseApplicationImpl.getContext());
      acqy.b("GdtPreLoader", String.format("preDownloadInterstitialAfterAdLoaded isInterstitial:%b isEnabled:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      if ((bool1) && (bool2)) {
        acme.a().b(BaseApplicationImpl.getContext());
      }
      return;
    }
  }
  
  public void a(GdtAd paramGdtAd)
  {
    acqy.b("GdtPreLoader", "preLoadAfterAdLoaded");
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    e(paramGdtAd);
    c(paramGdtAd);
    d(paramGdtAd);
    f(paramGdtAd);
    b(paramGdtAd);
    AdReporterForAnalysis.reportForPreload(BaseApplicationImpl.getContext(), paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackk
 * JD-Core Version:    0.7.0.1
 */