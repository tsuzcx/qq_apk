import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;

public class actt
  implements acos
{
  public actt(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void onAdClicked(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acvc.b("GdtBannerFragmentForJS", String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void onAdClosed(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acvc.b("GdtBannerFragmentForJS", String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
    this.a.a.removeView(GdtBannerFragmentForJS.a(this.a).a());
  }
  
  public void onAdFailedToLoad(com.tencent.gdtad.api.GdtAd paramGdtAd, acor paramacor)
  {
    acvc.d("GdtBannerFragmentForJS", "onAdFailedToLoad " + paramacor.a());
    Toast.makeText(BaseApplicationImpl.getContext(), "onAdFailedToLoad " + paramacor.a(), 0).show();
  }
  
  public void onAdImpression(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acvc.b("GdtBannerFragmentForJS", String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void onAdLoaded(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acvc.b("GdtBannerFragmentForJS", String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actt
 * JD-Core Version:    0.7.0.1
 */