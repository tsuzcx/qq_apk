import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;

public class aeut
  implements View.OnClickListener
{
  public aeut(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SmallVideoSendFragment.a(this.a).getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeut
 * JD-Core Version:    0.7.0.1
 */