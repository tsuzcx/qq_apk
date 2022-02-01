import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;

public class acfx
  implements acaq
{
  public acfx(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acho.b("GdtBannerFragmentForJS", String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, acap paramacap)
  {
    acho.d("GdtBannerFragmentForJS", "onAdFailedToLoad " + paramacap.a());
    Toast.makeText(BaseApplicationImpl.getContext(), "onAdFailedToLoad " + paramacap.a(), 0).show();
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acho.b("GdtBannerFragmentForJS", String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acho.b("GdtBannerFragmentForJS", String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    acho.b("GdtBannerFragmentForJS", String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
    this.a.a.removeView(GdtBannerFragmentForJS.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfx
 * JD-Core Version:    0.7.0.1
 */