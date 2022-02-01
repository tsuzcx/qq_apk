import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class akjh
  implements View.OnClickListener
{
  akjh(akho paramakho, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(akho.a(this.jdField_a_of_type_Akho), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(akho.a(this.jdField_a_of_type_Akho), bgev.a(akho.a(this.jdField_a_of_type_Akho), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, localIntent, true, -1);
    akho.a(this.jdField_a_of_type_Akho).obtainMessage(12).sendToTarget();
    bcef.b(akho.a(this.jdField_a_of_type_Akho).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    bcef.a(akho.a(this.jdField_a_of_type_Akho).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjh
 * JD-Core Version:    0.7.0.1
 */