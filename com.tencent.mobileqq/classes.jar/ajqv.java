import android.view.KeyEvent;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout.DispatchKeyEventListener;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;

public class ajqv
  implements MyLinearLayout.DispatchKeyEventListener
{
  public ajqv(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.b))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqv
 * JD-Core Version:    0.7.0.1
 */