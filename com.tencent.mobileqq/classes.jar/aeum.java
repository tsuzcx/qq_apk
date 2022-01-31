import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class aeum
  implements Runnable
{
  public aeum(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void run()
  {
    int i = this.a.i.getTop();
    int j = (int)(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a * 20.0F);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeum
 * JD-Core Version:    0.7.0.1
 */