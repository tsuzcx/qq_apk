import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.activity.Now;

public class admd
  implements View.OnClickListener
{
  public admd(Now paramNow) {}
  
  public void onClick(View paramView)
  {
    if (Now.a(this.a) != null) {
      Now.a(this.a).m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admd
 * JD-Core Version:    0.7.0.1
 */