import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.AppGuideTipsConfig;

class aect
  implements View.OnClickListener
{
  aect(aecs paramaecs, AppGuideTipsConfig paramAppGuideTipsConfig) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Aecs.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.tipsUrl);
    this.jdField_a_of_type_Aecs.a.startActivity(paramView);
    axqw.b(null, "dc00898", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aect
 * JD-Core Version:    0.7.0.1
 */