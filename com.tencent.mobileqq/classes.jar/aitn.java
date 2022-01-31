import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.util.InputMethodUtil;

public class aitn
  implements View.OnClickListener
{
  public aitn(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    SubmitHomeWorkFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aitn
 * JD-Core Version:    0.7.0.1
 */