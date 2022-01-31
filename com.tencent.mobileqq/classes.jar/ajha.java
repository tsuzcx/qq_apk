import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

class ajha
  implements View.OnClickListener
{
  ajha(ajgb paramajgb, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(ajgb.a(this.jdField_a_of_type_Ajgb), bdtg.a(ajgb.a(this.jdField_a_of_type_Ajgb), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    ajgb.a(this.jdField_a_of_type_Ajgb).obtainMessage(12).sendToTarget();
    azqs.b(ajgb.a(this.jdField_a_of_type_Ajgb).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajha
 * JD-Core Version:    0.7.0.1
 */