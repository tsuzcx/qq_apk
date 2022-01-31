import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.widget.ActionSheet;

public class afkc
  implements View.OnClickListener
{
  public afkc(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.a.a);
    paramView.a(2131432537, 1);
    paramView.c(2131433029);
    paramView.a(new afkd(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkc
 * JD-Core Version:    0.7.0.1
 */