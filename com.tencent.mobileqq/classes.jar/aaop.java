import android.os.Bundle;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import java.lang.ref.WeakReference;

public final class aaop
  implements aaqv
{
  public aaqx a(aaqw paramaaqw)
  {
    String str2 = null;
    aaqx localaaqx = new aaqx();
    if (paramaaqw == null) {
      if (paramaaqw == null) {
        break label179;
      }
    }
    label179:
    for (String str1 = paramaaqw.a();; str1 = null)
    {
      if (paramaaqw != null) {
        str2 = paramaaqw.b();
      }
      aase.b("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localaaqx.a) }));
      return localaaqx;
      if ((!paramaaqw.a()) || (paramaaqw.a == null)) {
        break;
      }
      str1 = paramaaqw.a.getString("TRACE_ID");
      if (paramaaqw.a == null) {
        break;
      }
      WeakReference localWeakReference = aaoq.a().a(str1);
      if ((localWeakReference == null) || (localWeakReference.get() == null)) {
        break;
      }
      aaor.c(BaseApplicationImpl.getContext(), ((GdtInterstitialFragment)localWeakReference.get()).a(), ((GdtInterstitialFragment)localWeakReference.get()).a());
      localaaqx.a = true;
      AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialAd.IPCHandlerForClose.1(this, str1), 0, 2000L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaop
 * JD-Core Version:    0.7.0.1
 */