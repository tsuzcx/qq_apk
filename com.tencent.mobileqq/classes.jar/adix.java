import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.MainFragment;

public class adix
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adix
 * JD-Core Version:    0.7.0.1
 */