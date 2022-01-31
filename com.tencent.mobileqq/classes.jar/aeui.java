import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.ViewHolder;

public class aeui
  implements View.OnClickListener
{
  public aeui(NearbyFragmentEnterAdapter paramNearbyFragmentEnterAdapter) {}
  
  public void onClick(View paramView)
  {
    NearbyFragmentEnterAdapter.ViewHolder localViewHolder = (NearbyFragmentEnterAdapter.ViewHolder)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localViewHolder.a, localViewHolder.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeui
 * JD-Core Version:    0.7.0.1
 */