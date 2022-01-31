import android.widget.ListView;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.mobileqq.troop.createNewTroop.SubCateListView.OnToggleSubListListener;

public class ajga
  implements SubCateListView.OnToggleSubListListener
{
  public ajga(CateListAdapter.ViewHolder paramViewHolder) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt > 0)) {
      this.a.a.a.a.smoothScrollBy(paramInt, 200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajga
 * JD-Core Version:    0.7.0.1
 */