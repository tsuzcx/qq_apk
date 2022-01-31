import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class afmy
  implements ActionSheet.OnDismissListener
{
  public afmy(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditTribePanel.a(this.a, this.a.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afmy
 * JD-Core Version:    0.7.0.1
 */