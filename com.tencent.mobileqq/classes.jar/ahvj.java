import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class ahvj
  implements View.OnClickListener
{
  public ahvj(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    HistorySearchEntryModel.a(this.a).a(this.a.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvj
 * JD-Core Version:    0.7.0.1
 */