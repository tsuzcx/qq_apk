import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel;

public class aepl
  implements ConditionSearchManager.IConfigListener
{
  public aepl(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a();
    if (!paramBoolean) {
      this.a.b(this.a.getString(2131437281));
    }
    while ((this.a.e != 1) || (paramInt != 2)) {
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepl
 * JD-Core Version:    0.7.0.1
 */