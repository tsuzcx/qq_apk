import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class abcp
  extends AnimateUtils.AnimationAdapter
{
  public abcp(ConversationPullDownActiveBase paramConversationPullDownActiveBase) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcp
 * JD-Core Version:    0.7.0.1
 */