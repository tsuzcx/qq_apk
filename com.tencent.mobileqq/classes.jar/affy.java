import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;

public class affy
  implements View.OnClickListener
{
  public affy(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a.onBackEvent())
    {
      this.a.a.finish();
      this.a.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affy
 * JD-Core Version:    0.7.0.1
 */