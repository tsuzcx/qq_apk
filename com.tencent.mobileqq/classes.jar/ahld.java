import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ahld
  implements View.OnClickListener
{
  ahld(ahkf paramahkf, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (ahkf.a(this.jdField_a_of_type_Ahkf) != null)
    {
      paramView = ahkf.a(this.jdField_a_of_type_Ahkf).obtainMessage(1134042);
      ahkf.a(this.jdField_a_of_type_Ahkf).sendMessage(paramView);
    }
    paramView = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf).getApplicationContext(), paramView);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(paramView);
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
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */