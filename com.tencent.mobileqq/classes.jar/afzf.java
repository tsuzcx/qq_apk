import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.AppGuideTipsConfig;

class afzf
  implements View.OnClickListener
{
  afzf(afze paramafze, AppGuideTipsConfig paramAppGuideTipsConfig) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Afze.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.tipsUrl);
    this.jdField_a_of_type_Afze.a.startActivity(paramView);
    azmj.b(null, "dc00898", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig.opkey, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzf
 * JD-Core Version:    0.7.0.1
 */