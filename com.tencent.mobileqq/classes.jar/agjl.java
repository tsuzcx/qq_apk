import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agjl
  implements OnCompositionLoadedListener
{
  public agjl(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setImagesAssetsFolder(ScanTorchActivity.d(this.a));
    localLottieDrawable.setImageAssetDelegate(new agjm(this));
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    ScanTorchActivity.a(this.a, localLottieDrawable);
    ScanTorchActivity.a(this.a).setImageDrawable(localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjl
 * JD-Core Version:    0.7.0.1
 */