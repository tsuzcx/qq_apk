import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

public class algu
  implements OnCompositionLoadedListener
{
  public algu(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    if (DrawRedpacketPannelPreviewFragment.d(this.a) != null) {
      DrawRedpacketPannelPreviewFragment.d(this.a).setImageDrawable(localLottieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algu
 * JD-Core Version:    0.7.0.1
 */