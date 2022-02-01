import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeur
  implements View.OnClickListener
{
  public aeur(ActivateFriendView paramActivateFriendView) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendViewItem localActivateFriendViewItem = (ActivateFriendViewItem)paramView;
    if (localActivateFriendViewItem.a)
    {
      ActivateFriendView.a(this.a);
      if (localActivateFriendViewItem.a) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      localActivateFriendViewItem.setChecked(bool);
      if (ActivateFriendView.a(this.a) != null) {
        ActivateFriendView.a(this.a).a(ActivateFriendView.c(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ActivateFriendView.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeur
 * JD-Core Version:    0.7.0.1
 */