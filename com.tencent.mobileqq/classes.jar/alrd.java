import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class alrd
  implements AdapterView.OnItemClickListener
{
  alrd(alqz paramalqz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = alqz.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    alqz.a(this.a).setSelection(paramInt);
    paramAdapterView = alqz.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    alqz.a(this.a, paramInt);
    alqz.a(this.a, true);
    if ((alqz.a(this.a) != null) && (alqz.a(this.a).size() > 0) && (alqz.a(this.a).size() > alqz.a(this.a)))
    {
      paramAdapterView = (alsa)alqz.a(this.a).get(alqz.a(this.a));
      if (paramAdapterView != null) {
        altc.a(null, paramAdapterView.a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrd
 * JD-Core Version:    0.7.0.1
 */