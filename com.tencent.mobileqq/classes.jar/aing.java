import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;

public class aing
  implements AdapterView.OnItemClickListener
{
  public aing(NewTroopContactView paramNewTroopContactView) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((ResultRecord)paramView.getTag()).a;
    if (this.a.a(paramAdapterView))
    {
      NewTroopContactView.a(this.a, paramAdapterView);
      this.a.a.notifyDataSetChanged();
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aing
 * JD-Core Version:    0.7.0.1
 */