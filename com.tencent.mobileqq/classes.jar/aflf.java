import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class aflf
  implements Runnable
{
  public aflf(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void run()
  {
    int i = this.a.h.getTop();
    int j = (int)(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a * 20.0F);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflf
 * JD-Core Version:    0.7.0.1
 */