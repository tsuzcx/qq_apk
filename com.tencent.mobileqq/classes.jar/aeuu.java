import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;

public class aeuu
  implements Runnable
{
  public aeuu(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).showSoftInput(this.a.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeuu
 * JD-Core Version:    0.7.0.1
 */