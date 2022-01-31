import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajhd
  implements View.OnClickListener
{
  ajhd(ajgb paramajgb, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (ajgb.a(this.jdField_a_of_type_Ajgb) != null)
    {
      paramView = ajgb.a(this.jdField_a_of_type_Ajgb).obtainMessage(30);
      ajgb.a(this.jdField_a_of_type_Ajgb).sendMessageDelayed(paramView, 2500L);
    }
    paramView = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb).getApplicationContext(), paramView);
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
        ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(paramView);
      }
      azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
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
 * Qualified Name:     ajhd
 * JD-Core Version:    0.7.0.1
 */