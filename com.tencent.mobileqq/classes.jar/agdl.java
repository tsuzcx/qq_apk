import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class agdl
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  protected agdl(agdk paramagdk) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      this.a.a();
      return true;
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84))
    {
      if (paramKeyEvent.getAction() == 1) {
        this.a.a();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */