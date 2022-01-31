import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel;

public class afho
  implements ConditionSearchManager.IConfigListener
{
  public afho(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a();
    if (!paramBoolean) {
      this.a.b(this.a.getString(2131437318));
    }
    while ((this.a.e != 1) || (paramInt != 2)) {
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afho
 * JD-Core Version:    0.7.0.1
 */