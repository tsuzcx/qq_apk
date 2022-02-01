import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajdn
  implements View.OnClickListener
{
  ajdn(ajdm paramajdm) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a.b.performLongClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdn
 * JD-Core Version:    0.7.0.1
 */