import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class alcq
  implements AdapterView.OnItemClickListener
{
  alcq(alcm paramalcm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = alcm.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    alcm.a(this.a).setSelection(paramInt);
    paramAdapterView = alcm.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    alcm.a(this.a, paramInt);
    alcm.a(this.a, true);
    if ((alcm.a(this.a) != null) && (alcm.a(this.a).size() > 0) && (alcm.a(this.a).size() > alcm.a(this.a)))
    {
      paramAdapterView = (aldn)alcm.a(this.a).get(alcm.a(this.a));
      if (paramAdapterView != null) {
        alep.a(null, paramAdapterView.a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alcq
 * JD-Core Version:    0.7.0.1
 */