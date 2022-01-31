import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ajhr
  implements View.OnClickListener
{
  ajhr(ajgb paramajgb, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    paramView = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb), QQBrowserDelegationActivity.class);
    paramView.putExtra("injectrecommend", true);
    ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
    azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhr
 * JD-Core Version:    0.7.0.1
 */