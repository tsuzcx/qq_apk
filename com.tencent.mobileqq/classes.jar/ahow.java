import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class ahow
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  public ahow(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void a()
  {
    if (RedBagVideoManager.a(this.a) == null) {
      RedBagVideoManager.a(this.a, new Handler());
    }
    RedBagVideoManager.a(this.a).postDelayed(new ahox(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahow
 * JD-Core Version:    0.7.0.1
 */