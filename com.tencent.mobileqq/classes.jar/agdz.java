import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.WeakHashMap;

class agdz
  implements OnCompositionLoadedListener
{
  agdz(agdw paramagdw) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (agdw.a(this.a) == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      }
    }
    do
    {
      return;
      if (paramLottieComposition == null) {
        break;
      }
      agdw.a(this.a).setComposition(paramLottieComposition);
      agdw.a(this.a).loop(false);
      agdw.a(this.a).setVisibility(0);
      agdw.a(this.a).playAnimation();
    } while (!QLog.isColorLevel());
    QLog.d("TroopEggLottieAnimView", 2, "playNextAnim fromInputStream succ");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEggLottieAnimView", 2, "playNextAnim fromInputStream composition null");
    }
    agdw.a(this.a).clear();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdz
 * JD-Core Version:    0.7.0.1
 */