import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class agqj
  implements bfph
{
  agqj(agqi paramagqi, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Agqi.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Agqi.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Agqi.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bfpc.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Agqi.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Agqi.jdField_a_of_type_AndroidAppActivity).requestPermissions(new agqk(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          agqi.a(this.jdField_a_of_type_Agqi);
        }
      }
      else
      {
        agqi.a(this.jdField_a_of_type_Agqi);
        continue;
        agqq.b(this.jdField_a_of_type_Agqi.jdField_a_of_type_AndroidAppActivity, agqq.d(this.jdField_a_of_type_Agqi.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqj
 * JD-Core Version:    0.7.0.1
 */