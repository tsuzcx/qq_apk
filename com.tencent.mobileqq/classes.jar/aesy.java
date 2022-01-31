import android.view.View;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.widget.ItemClickHelper;
import java.util.List;

public class aesy
  extends ItemClickHelper
{
  public aesy(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void a(int paramInt, View paramView)
  {
    SelectLocationFragment.a(this.a, paramInt);
    SelectLocationFragment.b(this.a, (LocationInfo)SelectLocationFragment.a(this.a).a().get(SelectLocationFragment.b(this.a)));
    SelectLocationFragment.a(this.a, SelectLocationFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesy
 * JD-Core Version:    0.7.0.1
 */