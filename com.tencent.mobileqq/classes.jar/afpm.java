import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetMomentListCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.GetMomentListCallback;
import java.util.List;

public class afpm
  implements NearbyMomentProtocol.GetMomentListCallback
{
  public afpm(NearbyMomentManager paramNearbyMomentManager, NearbyMomentManager.GetMomentListCallback paramGetMomentListCallback) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.post(new afpn(this, paramList, paramBoolean1, paramBoolean2, paramInt), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afpm
 * JD-Core Version:    0.7.0.1
 */