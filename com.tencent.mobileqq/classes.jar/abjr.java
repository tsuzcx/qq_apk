import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class abjr
  extends AnimateUtils.AnimationAdapter
{
  public abjr(ConversationPullDownActiveBase paramConversationPullDownActiveBase) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abjr
 * JD-Core Version:    0.7.0.1
 */