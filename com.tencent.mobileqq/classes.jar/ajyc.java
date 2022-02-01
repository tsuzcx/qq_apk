import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class ajyc
  extends blgm
{
  public ajyc(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(true);
    EmoticonGroupStoreFragment.a(this.a, false);
    this.a.titleRoot.removeView(EmoticonGroupStoreFragment.a(this.a));
    this.a.titleRoot.removeView(EmoticonGroupStoreFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyc
 * JD-Core Version:    0.7.0.1
 */