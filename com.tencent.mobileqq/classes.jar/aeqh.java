import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.widget.ActionSheet;

public class aeqh
  implements View.OnClickListener
{
  public aeqh(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.a.a);
    paramView.a(2131432509, 1);
    paramView.c(2131432998);
    paramView.a(new aeqi(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqh
 * JD-Core Version:    0.7.0.1
 */