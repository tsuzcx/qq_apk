import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;

public class abqd
  implements abla
{
  public abqd(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void onAdClicked(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    abrl.b("GdtBannerFragmentForJS", String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void onAdClosed(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    abrl.b("GdtBannerFragmentForJS", String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
    this.a.a.removeView(GdtBannerFragmentForJS.a(this.a).a());
  }
  
  public void onAdFailedToLoad(com.tencent.gdtad.api.GdtAd paramGdtAd, abkz paramabkz)
  {
    abrl.d("GdtBannerFragmentForJS", "onAdFailedToLoad " + paramabkz.a());
    Toast.makeText(BaseApplicationImpl.getContext(), "onAdFailedToLoad " + paramabkz.a(), 0).show();
  }
  
  public void onAdImpression(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    abrl.b("GdtBannerFragmentForJS", String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void onAdLoaded(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    abrl.b("GdtBannerFragmentForJS", String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqd
 * JD-Core Version:    0.7.0.1
 */