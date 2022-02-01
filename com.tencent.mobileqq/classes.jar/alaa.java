import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alaa
  implements View.OnClickListener
{
  alaa(akyh paramakyh, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(akyh.a(this.jdField_a_of_type_Akyh), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(akyh.a(this.jdField_a_of_type_Akyh), bgyg.a(akyh.a(this.jdField_a_of_type_Akyh), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, localIntent, true, -1);
    akyh.a(this.jdField_a_of_type_Akyh).obtainMessage(12).sendToTarget();
    bcst.b(akyh.a(this.jdField_a_of_type_Akyh).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    bcst.a(akyh.a(this.jdField_a_of_type_Akyh).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaa
 * JD-Core Version:    0.7.0.1
 */