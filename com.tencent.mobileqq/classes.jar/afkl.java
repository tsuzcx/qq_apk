import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetLocalUnPiblishListCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter;
import java.util.ArrayList;
import java.util.List;

class afkl
  implements NearbyMomentManager.GetLocalUnPiblishListCallback
{
  afkl(afkj paramafkj) {}
  
  public void a(List paramList)
  {
    NearbyMomentFragment.b(this.a.a).clear();
    NearbyMomentFragment.b(this.a.a).addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(NearbyMomentFragment.b(this.a.a));
    localArrayList.addAll(NearbyMomentFragment.a(this.a.a));
    NearbyMomentFragment.a(this.a.a).a(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    this.a.a.b();
    NearbyMomentFragment.a(this.a.a, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkl
 * JD-Core Version:    0.7.0.1
 */