import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.util.WeakHashMap;

class aesy
  implements OnCompositionLoadedListener
{
  aesy(aesv paramaesv) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      aesv.a(this.a).setComposition(paramLottieComposition);
      aesv.a(this.a).loop(false);
      aesv.a(this.a).setVisibility(0);
      aesv.a(this.a).playAnimation();
      return;
    }
    aesv.a(this.a).clear();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesy
 * JD-Core Version:    0.7.0.1
 */