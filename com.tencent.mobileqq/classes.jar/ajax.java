import android.widget.ListView;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.mobileqq.troop.createNewTroop.SubCateListView.OnToggleSubListListener;

public class ajax
  implements SubCateListView.OnToggleSubListListener
{
  public ajax(CateListAdapter.ViewHolder paramViewHolder) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt > 0)) {
      this.a.a.a.a.smoothScrollBy(paramInt, 200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajax
 * JD-Core Version:    0.7.0.1
 */