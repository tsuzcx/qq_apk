import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;

public class aeho
  implements Runnable
{
  public aeho(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).showSoftInput(this.a.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeho
 * JD-Core Version:    0.7.0.1
 */