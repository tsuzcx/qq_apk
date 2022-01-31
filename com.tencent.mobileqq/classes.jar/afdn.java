import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.widget.ActionSheet;

public class afdn
  implements View.OnClickListener
{
  public afdn(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.a.a);
    paramView.a(2131432526, 1);
    paramView.c(2131433015);
    paramView.a(new afdo(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdn
 * JD-Core Version:    0.7.0.1
 */