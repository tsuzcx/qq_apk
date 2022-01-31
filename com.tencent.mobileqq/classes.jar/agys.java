import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class agys
  implements View.OnClickListener
{
  agys(agxq paramagxq, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (agxq.a(this.jdField_a_of_type_Agxq) != null)
    {
      paramView = agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(30);
      agxq.a(this.jdField_a_of_type_Agxq).sendMessageDelayed(paramView, 2500L);
    }
    paramView = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(agxq.a(this.jdField_a_of_type_Agxq).getApplicationContext(), paramView);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
        if (!TextUtils.isEmpty(str)) {
          paramView.putExtra("url", str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        paramView.putExtra("force_no_reload", true);
        agxq.a(this.jdField_a_of_type_Agxq).startActivity(paramView);
      }
      awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
      return;
    }
    catch (ClassNotFoundException paramView)
    {
      for (;;)
      {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agys
 * JD-Core Version:    0.7.0.1
 */