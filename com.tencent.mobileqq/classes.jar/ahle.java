import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

class ahle
  implements View.OnClickListener
{
  ahle(ahkf paramahkf, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(ahkf.a(this.jdField_a_of_type_Ahkf), bbpp.a(ahkf.a(this.jdField_a_of_type_Ahkf), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    ahkf.a(this.jdField_a_of_type_Ahkf).obtainMessage(12).sendToTarget();
    axqw.b(ahkf.a(this.jdField_a_of_type_Ahkf).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahle
 * JD-Core Version:    0.7.0.1
 */