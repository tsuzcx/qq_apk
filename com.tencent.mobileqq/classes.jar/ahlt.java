import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ahlt
  implements View.OnClickListener
{
  ahlt(ahkd paramahkd, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    paramView = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd), QQBrowserDelegationActivity.class);
    paramView.putExtra("injectrecommend", true);
    ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
    axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlt
 * JD-Core Version:    0.7.0.1
 */