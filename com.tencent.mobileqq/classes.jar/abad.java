import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abad
  implements View.OnClickListener
{
  abad(abac paramabac, String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Abac.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)localAppInterface).reportClickEvent("dc00899", "grp_lbs", "", "hot_create", "clk_create", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abad
 * JD-Core Version:    0.7.0.1
 */