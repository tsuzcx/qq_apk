import android.app.Activity;
import com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aapb
  implements aane
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  
  public aapb(GdtDemoMvFragment paramGdtDemoMvFragment, Activity paramActivity)
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
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtDemoMvFragment.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtDemoMvFragment, paramGdtAd);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "demo数据构造成功", 0).a();
    QLog.i("GdtMotiveVideoAd", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    aana.a().a(paramGdtAd.getAd());
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, aand paramaand)
  {
    QLog.e("GdtMotiveVideoAd", 1, "onAdFailedToLoad " + paramaand.a());
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtMotiveVideoAd", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtMotiveVideoAd", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtMotiveVideoAd", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */