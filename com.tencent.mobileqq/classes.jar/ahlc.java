import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

class ahlc
  implements View.OnClickListener
{
  ahlc(ahkd paramahkd, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(ahkd.a(this.jdField_a_of_type_Ahkd), bbqd.a(ahkd.a(this.jdField_a_of_type_Ahkd), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    ahkd.a(this.jdField_a_of_type_Ahkd).obtainMessage(12).sendToTarget();
    axqy.b(ahkd.a(this.jdField_a_of_type_Ahkd).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlc
 * JD-Core Version:    0.7.0.1
 */