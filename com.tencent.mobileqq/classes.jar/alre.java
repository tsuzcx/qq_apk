import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class alre
  implements AdapterView.OnItemClickListener
{
  alre(alra paramalra) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = alra.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    alra.a(this.a).setSelection(paramInt);
    paramAdapterView = alra.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    alra.a(this.a, paramInt);
    alra.a(this.a, true);
    if ((alra.a(this.a) != null) && (alra.a(this.a).size() > 0) && (alra.a(this.a).size() > alra.a(this.a)))
    {
      paramAdapterView = (alsb)alra.a(this.a).get(alra.a(this.a));
      if (paramAdapterView != null) {
        altd.a(null, paramAdapterView.a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alre
 * JD-Core Version:    0.7.0.1
 */