import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;

public class aeru
  implements View.OnTouchListener
{
  public aeru(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 2) && ((this.a.a == null) || (this.a.a.getCount() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aeru
 * JD-Core Version:    0.7.0.1
 */