import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class aili
  implements bhqd
{
  aili(ailh paramailh, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Ailh.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Ailh.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Ailh.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhpy.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Ailh.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Ailh.jdField_a_of_type_AndroidAppActivity).requestPermissions(new ailj(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          ailh.a(this.jdField_a_of_type_Ailh);
        }
      }
      else
      {
        ailh.a(this.jdField_a_of_type_Ailh);
        continue;
        ailp.b(this.jdField_a_of_type_Ailh.jdField_a_of_type_AndroidAppActivity, ailp.d(this.jdField_a_of_type_Ailh.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aili
 * JD-Core Version:    0.7.0.1
 */