import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.util.InputMethodUtil;

public class ajhe
  implements View.OnClickListener
{
  public ajhe(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    this.a.getActivity().doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhe
 * JD-Core Version:    0.7.0.1
 */