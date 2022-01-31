import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.RedPacketPopFragment;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

public class airs
  implements OnCompositionLoadedListener
{
  public airs(RedPacketPopFragment paramRedPacketPopFragment, ImageView paramImageView) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airs
 * JD-Core Version:    0.7.0.1
 */