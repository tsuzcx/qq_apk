import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajco
  implements View.OnClickListener
{
  ajco(ajbm paramajbm, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (ajbm.a(this.jdField_a_of_type_Ajbm) != null)
    {
      paramView = ajbm.a(this.jdField_a_of_type_Ajbm).obtainMessage(30);
      ajbm.a(this.jdField_a_of_type_Ajbm).sendMessageDelayed(paramView, 2500L);
    }
    paramView = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(ajbm.a(this.jdField_a_of_type_Ajbm).getApplicationContext(), paramView);
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
        ajbm.a(this.jdField_a_of_type_Ajbm).startActivity(paramView);
      }
      azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajco
 * JD-Core Version:    0.7.0.1
 */