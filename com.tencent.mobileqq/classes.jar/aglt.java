import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aglt
  implements OnCompositionLoadedListener
{
  aglt(aglq paramaglq) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (aglq.a(this.a) == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      }
    }
    do
    {
      return;
      if (paramLottieComposition == null) {
        break;
      }
      aglq.a(this.a).setComposition(paramLottieComposition);
      aglq.a(this.a).loop(false);
      aglq.a(this.a).setVisibility(0);
      aglq.a(this.a).playAnimation();
    } while (!QLog.isColorLevel());
    QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream succ");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream composition null");
    }
    aglq.a(this.a).clear();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglt
 * JD-Core Version:    0.7.0.1
 */