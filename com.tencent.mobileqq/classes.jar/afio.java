import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class afio
  implements ActionSheet.OnDismissListener
{
  public afio(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditTribePanel.a(this.a, this.a.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afio
 * JD-Core Version:    0.7.0.1
 */