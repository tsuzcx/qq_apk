import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.RefreshCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetMomentListCallback;
import java.util.List;

public class afkn
  implements NearbyMomentManager.GetMomentListCallback
{
  public afkn(NearbyMomentFragment paramNearbyMomentFragment, NearbyMomentManager paramNearbyMomentManager, NearbyMomentFragment.RefreshCallback paramRefreshCallback) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).clear();
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment).addAll(paramList);
    if (NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager.a(new afko(this, paramList, paramBoolean1, paramBoolean2, paramInt));
      return;
    }
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramList);
    NearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment, paramBoolean1, paramBoolean2, paramInt, paramList, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$RefreshCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkn
 * JD-Core Version:    0.7.0.1
 */