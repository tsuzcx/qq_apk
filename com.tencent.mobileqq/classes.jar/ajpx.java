import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class ajpx
  implements View.OnClickListener
{
  public ajpx(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    ReciteFragment.a(this.a);
    BeginnerGuideFragment.b(this.a.getActivity(), null, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */