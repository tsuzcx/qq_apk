import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

class ajcl
  implements View.OnClickListener
{
  ajcl(ajbm paramajbm, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajbm.a(this.jdField_a_of_type_Ajbm), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(ajbm.a(this.jdField_a_of_type_Ajbm), bdox.a(ajbm.a(this.jdField_a_of_type_Ajbm), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    ajbm.a(this.jdField_a_of_type_Ajbm).obtainMessage(12).sendToTarget();
    azmj.b(ajbm.a(this.jdField_a_of_type_Ajbm).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcl
 * JD-Core Version:    0.7.0.1
 */