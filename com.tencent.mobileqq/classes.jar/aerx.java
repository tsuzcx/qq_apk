import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.widget.ActionSheet;

public class aerx
  implements View.OnClickListener
{
  public aerx(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.a.a);
    paramView.a(2131432509, 1);
    paramView.c(2131432998);
    paramView.a(new aery(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aerx
 * JD-Core Version:    0.7.0.1
 */