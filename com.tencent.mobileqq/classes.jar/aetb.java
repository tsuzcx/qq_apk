import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;

public class aetb
  implements View.OnFocusChangeListener
{
  public aetb(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      SelectLocationFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetb
 * JD-Core Version:    0.7.0.1
 */