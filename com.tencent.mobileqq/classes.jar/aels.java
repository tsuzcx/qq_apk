import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.activity.Now;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aels
  implements View.OnClickListener
{
  public aels(Now paramNow) {}
  
  public void onClick(View paramView)
  {
    if (Now.a(this.a) != null) {
      Now.a(this.a).m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aels
 * JD-Core Version:    0.7.0.1
 */