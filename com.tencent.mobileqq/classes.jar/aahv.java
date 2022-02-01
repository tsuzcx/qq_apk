import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aahv
  implements View.OnClickListener
{
  public aahv(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahv
 * JD-Core Version:    0.7.0.1
 */