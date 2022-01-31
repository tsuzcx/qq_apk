import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.DeleteFeedCallback;

public class aflg
  implements NearbyMomentProtocol.DeleteFeedCallback
{
  public aflg(NearbyMomentManager paramNearbyMomentManager, NearbyMomentManager.DeleteFeedCallback paramDeleteFeedCallback) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager.a(paramString, false);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$DeleteFeedCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$DeleteFeedCallback.a(paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflg
 * JD-Core Version:    0.7.0.1
 */