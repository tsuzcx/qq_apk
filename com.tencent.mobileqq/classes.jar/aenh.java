import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;

public class aenh
  implements View.OnClickListener
{
  public aenh(ActivateFriendView paramActivateFriendView) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActivateFriendViewItem)paramView;
    if (paramView.a)
    {
      ActivateFriendView.a(this.a);
      if (paramView.a) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (ActivateFriendView.a(this.a) != null) {
        ActivateFriendView.a(this.a).a(ActivateFriendView.c(this.a));
      }
      return;
      ActivateFriendView.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenh
 * JD-Core Version:    0.7.0.1
 */