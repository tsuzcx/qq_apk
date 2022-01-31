import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class afhe
  implements ActionSheet.OnDismissListener
{
  public afhe(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhe
 * JD-Core Version:    0.7.0.1
 */