import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alad
  implements View.OnClickListener
{
  alad(akyh paramakyh, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = new Intent(akyh.a(this.jdField_a_of_type_Akyh), QQBrowserDelegationActivity.class);
    localIntent.putExtra("injectrecommend", true);
    akyh.a(this.jdField_a_of_type_Akyh).startActivity(localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString));
    bcst.a(akyh.a(this.jdField_a_of_type_Akyh).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alad
 * JD-Core Version:    0.7.0.1
 */