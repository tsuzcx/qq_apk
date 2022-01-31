import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView;

public class aefn
  implements View.OnClickListener
{
  public aefn(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void onClick(View paramView)
  {
    if (SelectLocationFragment.a(this.a) != null) {
      SelectLocationFragment.a(this.a).smoothScrollToPosition(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefn
 * JD-Core Version:    0.7.0.1
 */