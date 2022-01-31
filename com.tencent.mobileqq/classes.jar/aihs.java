import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class aihs
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  public aihs(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void a()
  {
    if (RedBagVideoManager.a(this.a) == null) {
      RedBagVideoManager.a(this.a, new Handler());
    }
    RedBagVideoManager.a(this.a).postDelayed(new aiht(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aihs
 * JD-Core Version:    0.7.0.1
 */