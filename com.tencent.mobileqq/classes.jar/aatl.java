import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;

public class aatl
  implements View.OnClickListener
{
  public aatl(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.getActivity().isFinishing()) {
      ForwardTroopListFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aatl
 * JD-Core Version:    0.7.0.1
 */