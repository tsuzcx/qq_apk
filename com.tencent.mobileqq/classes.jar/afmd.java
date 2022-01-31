import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class afmd
  implements ActionSheet.OnDismissListener
{
  public afmd(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afmd
 * JD-Core Version:    0.7.0.1
 */