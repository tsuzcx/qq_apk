import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;

public class aeft
  implements View.OnClickListener
{
  public aeft(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void onClick(View paramView)
  {
    SelectLocationFragment.a(this.a).setVisibility(8);
    SelectLocationFragment.a(this.a).setText("");
    SelectLocationFragment.a(this.a).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeft
 * JD-Core Version:    0.7.0.1
 */