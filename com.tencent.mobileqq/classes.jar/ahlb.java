import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ahlb
  implements View.OnClickListener
{
  ahlb(ahkd paramahkd, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (ahkd.a(this.jdField_a_of_type_Ahkd) != null)
    {
      paramView = ahkd.a(this.jdField_a_of_type_Ahkd).obtainMessage(1134042);
      ahkd.a(this.jdField_a_of_type_Ahkd).sendMessage(paramView);
    }
    paramView = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd).getApplicationContext(), paramView);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(paramView);
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
 * Qualified Name:     ahlb
 * JD-Core Version:    0.7.0.1
 */