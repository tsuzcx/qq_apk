import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class afdf
  implements View.OnClickListener
{
  public afdf(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdf
 * JD-Core Version:    0.7.0.1
 */