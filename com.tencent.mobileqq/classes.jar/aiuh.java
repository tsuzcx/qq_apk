import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class aiuh
  implements View.OnClickListener
{
  public aiuh(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    ReciteFragment.a(this.a);
    BeginnerGuideFragment.b(this.a.getActivity(), null, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiuh
 * JD-Core Version:    0.7.0.1
 */