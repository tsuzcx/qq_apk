import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjk
  implements View.OnClickListener
{
  akjk(akho paramakho, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = new Intent(akho.a(this.jdField_a_of_type_Akho), QQBrowserDelegationActivity.class);
    localIntent.putExtra("injectrecommend", true);
    akho.a(this.jdField_a_of_type_Akho).startActivity(localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString));
    bcef.a(akho.a(this.jdField_a_of_type_Akho).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjk
 * JD-Core Version:    0.7.0.1
 */