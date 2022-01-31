import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

public class agxb
  implements OnCompositionLoadedListener
{
  public agxb(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    this.a.d.setImageDrawable(localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agxb
 * JD-Core Version:    0.7.0.1
 */