import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class agyo
  implements View.OnClickListener
{
  agyo(agxq paramagxq, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (agxq.a(this.jdField_a_of_type_Agxq) != null)
    {
      paramView = agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(1134042);
      agxq.a(this.jdField_a_of_type_Agxq).sendMessage(paramView);
    }
    paramView = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(agxq.a(this.jdField_a_of_type_Agxq).getApplicationContext(), paramView);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        agxq.a(this.jdField_a_of_type_Agxq).startActivity(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyo
 * JD-Core Version:    0.7.0.1
 */