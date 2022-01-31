import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.GroupListOpenFrame;

public class akml
  implements View.OnTouchListener
{
  public akml(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.a.c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akml
 * JD-Core Version:    0.7.0.1
 */