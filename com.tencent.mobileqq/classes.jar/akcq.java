import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.JumpAction;

public class akcq
  implements View.OnClickListener
{
  public akcq(JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    JumpAction.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcq
 * JD-Core Version:    0.7.0.1
 */