import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetLocalUnPiblishListCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afkg
  implements NearbyMomentManager.GetLocalUnPiblishListCallback
{
  public afkg(NearbyMomentFailedFragment paramNearbyMomentFailedFragment) {}
  
  public void a(List paramList)
  {
    if (NearbyMomentFailedFragment.a(this.a).isFinishing()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PublishableMomentInfo localPublishableMomentInfo = (PublishableMomentInfo)paramList.next();
      if ((localPublishableMomentInfo.a != null) && (localPublishableMomentInfo.a.publishState == 2)) {
        localArrayList.add(localPublishableMomentInfo);
      }
    }
    NearbyMomentFailedFragment.a(this.a).a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkg
 * JD-Core Version:    0.7.0.1
 */