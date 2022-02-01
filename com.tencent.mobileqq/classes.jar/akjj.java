import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjj
  implements View.OnClickListener
{
  akjj(akho paramakho, aiho paramaiho) {}
  
  public void onClick(View paramView)
  {
    bcef.b(akho.a(this.jdField_a_of_type_Akho).app, "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent;
    if (localBaseActivity != null)
    {
      if (!URLUtil.isValidUrl(this.jdField_a_of_type_Aiho.a)) {
        break label151;
      }
      localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Aiho.a);
      localIntent.putExtra("hideRightButton", true);
      localBaseActivity.startActivity(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_Akho.a(9, 0);
      bcef.a(akho.a(this.jdField_a_of_type_Akho).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label151:
      localIntent = new Intent(localBaseActivity, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      localBaseActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjj
 * JD-Core Version:    0.7.0.1
 */