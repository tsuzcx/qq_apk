import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;

public class ahei
  implements View.OnTouchListener
{
  public ahei(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 2) && ((this.a.a == null) || (this.a.a.getCount() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahei
 * JD-Core Version:    0.7.0.1
 */