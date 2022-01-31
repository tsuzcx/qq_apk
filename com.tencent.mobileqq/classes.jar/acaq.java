import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import java.util.List;

public class acaq
  implements AdapterView.OnItemClickListener
{
  public acaq(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ResultRecord)SelectedAndSearchBar.a(this.a).get(paramInt);
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).a(paramAdapterView);
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acaq
 * JD-Core Version:    0.7.0.1
 */