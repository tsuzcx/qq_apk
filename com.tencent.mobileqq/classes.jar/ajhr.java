import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.util.InputMethodUtil;

public class ajhr
  implements View.OnClickListener
{
  public ajhr(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    SubmitHomeWorkFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhr
 * JD-Core Version:    0.7.0.1
 */