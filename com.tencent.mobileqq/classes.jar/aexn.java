import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.util.WeakHashMap;

class aexn
  implements OnCompositionLoadedListener
{
  aexn(aexk paramaexk) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (aexk.a(this.a) == null) {
      return;
    }
    if (paramLottieComposition != null)
    {
      aexk.a(this.a).setComposition(paramLottieComposition);
      aexk.a(this.a).loop(false);
      aexk.a(this.a).setVisibility(0);
      aexk.a(this.a).playAnimation();
      return;
    }
    aexk.a(this.a).clear();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexn
 * JD-Core Version:    0.7.0.1
 */