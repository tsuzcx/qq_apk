import android.os.Bundle;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import java.lang.ref.WeakReference;

public final class aaka
  implements aamg
{
  public aami a(aamh paramaamh)
  {
    String str2 = null;
    aami localaami = new aami();
    if (paramaamh == null) {
      if (paramaamh == null) {
        break label179;
      }
    }
    label179:
    for (String str1 = paramaamh.a();; str1 = null)
    {
      if (paramaamh != null) {
        str2 = paramaamh.b();
      }
      aanp.b("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localaami.a) }));
      return localaami;
      if ((!paramaamh.a()) || (paramaamh.a == null)) {
        break;
      }
      str1 = paramaamh.a.getString("TRACE_ID");
      if (paramaamh.a == null) {
        break;
      }
      WeakReference localWeakReference = aakb.a().a(str1);
      if ((localWeakReference == null) || (localWeakReference.get() == null)) {
        break;
      }
      aakc.c(BaseApplicationImpl.getContext(), ((GdtInterstitialFragment)localWeakReference.get()).a(), ((GdtInterstitialFragment)localWeakReference.get()).a());
      localaami.a = true;
      AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialAd.IPCHandlerForClose.1(this, str1), 0, 2000L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaka
 * JD-Core Version:    0.7.0.1
 */