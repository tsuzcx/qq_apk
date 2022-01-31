import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class aicb
  implements View.OnTouchListener
{
  public aicb(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.x();
      paramView = this.a.o;
      this.a.a("Clk_find", paramView, "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicb
 * JD-Core Version:    0.7.0.1
 */