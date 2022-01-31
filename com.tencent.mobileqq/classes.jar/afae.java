import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorAdapter.ChildItemHolder;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;

public class afae
  implements View.OnClickListener
{
  public afae(NearbyVisitorListActivity paramNearbyVisitorListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof NearbyVisitorAdapter.ChildItemHolder))
    {
      paramView = (NearbyVisitorAdapter.ChildItemHolder)paramView.getTag();
      NearbyMineHelper.a(this.a.a, this.a, paramView.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afae
 * JD-Core Version:    0.7.0.1
 */