import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import java.util.ArrayList;
import java.util.Map;

public class acyi
  implements View.OnClickListener
{
  public acyi(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardTroopListFragment.a(this.a).values()));
    this.a.getActivity().setResult(0, paramView);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyi
 * JD-Core Version:    0.7.0.1
 */