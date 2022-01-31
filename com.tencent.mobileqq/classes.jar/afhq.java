import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class afhq
  implements View.OnClickListener
{
  public afhq(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    if (i >= NearbyPeopleProfileActivity.c)
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131437403), 0).a();
      return;
    }
    NearbyProfileEditTribePanel.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhq
 * JD-Core Version:    0.7.0.1
 */