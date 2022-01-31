import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetMomentListCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter;
import java.util.List;

public class aexj
  implements NearbyMomentManager.GetMomentListCallback
{
  public aexj(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.a, false);
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.a, paramBoolean2);
      if (paramBoolean2) {
        NearbyMomentFragment.a(this.a).setText("没有更多动态");
      }
      NearbyMomentFragment.a(this.a, paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = NearbyMomentFragment.a(this.a, paramList);
        NearbyMomentFragment.a(this.a).addAll(paramList);
        NearbyMomentFragment.a(this.a).b(paramList);
        NearbyMomentFragment.a(this.a, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexj
 * JD-Core Version:    0.7.0.1
 */