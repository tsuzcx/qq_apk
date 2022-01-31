import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.AppGuideTipsConfig;

class aecr
  implements View.OnClickListener
{
  aecr(aecq paramaecq, AppGuideTipsConfig paramAppGuideTipsConfig) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Aecq.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.tipsUrl);
    this.jdField_a_of_type_Aecq.a.startActivity(paramView);
    axqy.b(null, "dc00898", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecr
 * JD-Core Version:    0.7.0.1
 */