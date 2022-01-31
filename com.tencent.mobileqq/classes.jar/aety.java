import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class aety
  implements ActionSheet.OnDismissListener
{
  public aety(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aety
 * JD-Core Version:    0.7.0.1
 */