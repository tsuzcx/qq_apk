import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aadv
  implements View.OnClickListener
{
  public aadv(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!bgnt.g(this.a.getContext())) {
      QQToast.a(this.a.getContext(), anni.a(2131693951), 0).a();
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadv
 * JD-Core Version:    0.7.0.1
 */