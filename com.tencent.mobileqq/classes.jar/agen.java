import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class agen
  implements begw
{
  agen(agem paramagem, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Agem.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Agem.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Agem.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Begr.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Agem.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Agem.jdField_a_of_type_AndroidAppActivity).requestPermissions(new ageo(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          agem.a(this.jdField_a_of_type_Agem);
        }
      }
      else
      {
        agem.a(this.jdField_a_of_type_Agem);
        continue;
        ageu.b(this.jdField_a_of_type_Agem.jdField_a_of_type_AndroidAppActivity, ageu.d(this.jdField_a_of_type_Agem.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agen
 * JD-Core Version:    0.7.0.1
 */