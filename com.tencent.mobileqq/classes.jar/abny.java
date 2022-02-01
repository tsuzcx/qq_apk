import android.app.Activity;
import com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class abny
  implements abla
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  
  public abny(GdtDemoMvFragment paramGdtDemoMvFragment, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void onAdClicked(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void onAdClosed(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void onAdFailedToLoad(com.tencent.gdtad.api.GdtAd paramGdtAd, abkz paramabkz)
  {
    QLog.e("GdtDemoMvFragment", 1, "onAdFailedToLoad " + paramabkz.a());
  }
  
  public void onAdImpression(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void onAdLoaded(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtDemoMvFragment.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtDemoMvFragment, paramGdtAd);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "demo数据构造成功", 0).a();
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    abkw.a().a(paramGdtAd.getAd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abny
 * JD-Core Version:    0.7.0.1
 */