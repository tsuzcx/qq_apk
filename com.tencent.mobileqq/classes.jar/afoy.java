import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.RefreshCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetMomentListCallback;
import java.util.List;

public class afoy
  implements NearbyMomentManager.GetMomentListCallback
{
  public afoy(NearbyMomentFragment paramNearbyMomentFragment, NearbyMomentFragment.RefreshCallback paramRefreshCallback) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).clear();
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).addAll(paramList);
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramList);
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramBoolean1, paramBoolean2, paramInt, paramList, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$RefreshCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afoy
 * JD-Core Version:    0.7.0.1
 */