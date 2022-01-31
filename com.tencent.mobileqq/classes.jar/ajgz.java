import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajgz
  implements View.OnClickListener
{
  ajgz(ajgb paramajgb, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (ajgb.a(this.jdField_a_of_type_Ajgb) != null)
    {
      paramView = ajgb.a(this.jdField_a_of_type_Ajgb).obtainMessage(1134042);
      ajgb.a(this.jdField_a_of_type_Ajgb).sendMessage(paramView);
    }
    paramView = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb).getApplicationContext(), paramView);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(paramView);
      }
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
 * Qualified Name:     ajgz
 * JD-Core Version:    0.7.0.1
 */