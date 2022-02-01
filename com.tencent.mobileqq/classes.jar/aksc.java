import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class aksc
  implements bliz
{
  aksc(aksb paramaksb, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Aksb.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Aksb.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Aksb.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Aksb.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Aksb.jdField_a_of_type_AndroidAppActivity).requestPermissions(new aksd(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          aksb.a(this.jdField_a_of_type_Aksb);
        }
      }
      else
      {
        aksb.a(this.jdField_a_of_type_Aksb);
        continue;
        aksj.b(this.jdField_a_of_type_Aksb.jdField_a_of_type_AndroidAppActivity, aksj.d(this.jdField_a_of_type_Aksb.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksc
 * JD-Core Version:    0.7.0.1
 */