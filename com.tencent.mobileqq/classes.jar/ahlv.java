import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ahlv
  implements View.OnClickListener
{
  ahlv(ahkf paramahkf, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    paramView = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf), QQBrowserDelegationActivity.class);
    paramView.putExtra("injectrecommend", true);
    ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
    axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlv
 * JD-Core Version:    0.7.0.1
 */