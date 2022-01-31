import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class aepx
  implements View.OnClickListener
{
  public aepx(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d("正在导入...");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.a.app.a(60));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepx
 * JD-Core Version:    0.7.0.1
 */