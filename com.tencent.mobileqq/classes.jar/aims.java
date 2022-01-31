import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.mobileqq.troop.createNewTroop.TroopCateListProvider.TroopCateInfo;

public class aims
  implements View.OnClickListener
{
  public aims(CateListAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopCateListProvider.TroopCateInfo)paramView.getTag();
    if (paramView.b == 1)
    {
      this.a.a.a.a(paramView.a, null);
      return;
    }
    this.a.a.a.a(paramView.d, paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aims
 * JD-Core Version:    0.7.0.1
 */