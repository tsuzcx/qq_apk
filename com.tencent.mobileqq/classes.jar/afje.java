import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.widget.NearbyFacePowerDialog;

class afje
  implements View.OnClickListener
{
  afje(afjc paramafjc, String paramString, NearbyFacePowerDialog paramNearbyFacePowerDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Afjc.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Afjc.a.a.startActivity(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyFacePowerDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afje
 * JD-Core Version:    0.7.0.1
 */