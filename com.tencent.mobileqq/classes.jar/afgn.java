import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class afgn
  implements View.OnClickListener
{
  public afgn(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0) == 1)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(2131437724);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
    }
    this.a.b();
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(2131437724);
      return;
    }
    if (this.a.a())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(2131437725);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgn
 * JD-Core Version:    0.7.0.1
 */