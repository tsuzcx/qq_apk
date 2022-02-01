import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajxg
  implements View.OnClickListener
{
  public ajxg(Conversation paramConversation) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b.performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxg
 * JD-Core Version:    0.7.0.1
 */