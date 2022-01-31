import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class agzg
  implements View.OnClickListener
{
  agzg(agxq paramagxq, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.jdField_a_of_type_JavaLangString);
    }
    paramView = new Intent(agxq.a(this.jdField_a_of_type_Agxq), QQBrowserDelegationActivity.class);
    paramView.putExtra("injectrecommend", true);
    agxq.a(this.jdField_a_of_type_Agxq).startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
    awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzg
 * JD-Core Version:    0.7.0.1
 */