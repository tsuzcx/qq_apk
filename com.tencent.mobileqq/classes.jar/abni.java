import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.MainFragment;

public class abni
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    MainFragment.b(true);
    paramView = (ViewGroup)paramView.getParent();
    if (!MainFragment.a()) {
      paramView.callOnClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abni
 * JD-Core Version:    0.7.0.1
 */