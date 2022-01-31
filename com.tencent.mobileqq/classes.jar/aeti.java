import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class aeti
  implements ActionSheet.OnDismissListener
{
  public aeti(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onDismiss()
  {
    NearbyProfileEditPanel.a(this.a, this.a.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeti
 * JD-Core Version:    0.7.0.1
 */