import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyx
  implements View.OnClickListener
{
  public adyx(Conversation paramConversation) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b.performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyx
 * JD-Core Version:    0.7.0.1
 */