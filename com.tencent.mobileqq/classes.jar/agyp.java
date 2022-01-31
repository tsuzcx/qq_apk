import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

class agyp
  implements View.OnClickListener
{
  agyp(agxq paramagxq, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(agxq.a(this.jdField_a_of_type_Agxq), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(agxq.a(this.jdField_a_of_type_Agxq), bant.a(agxq.a(this.jdField_a_of_type_Agxq), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(12).sendToTarget();
    awqx.b(agxq.a(this.jdField_a_of_type_Agxq).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyp
 * JD-Core Version:    0.7.0.1
 */