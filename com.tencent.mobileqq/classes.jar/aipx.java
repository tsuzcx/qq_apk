import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class aipx
  implements bhuk
{
  aipx(aipw paramaipw, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Aipw.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Aipw.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Aipw.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhuf.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Aipw.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Aipw.jdField_a_of_type_AndroidAppActivity).requestPermissions(new aipy(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          aipw.a(this.jdField_a_of_type_Aipw);
        }
      }
      else
      {
        aipw.a(this.jdField_a_of_type_Aipw);
        continue;
        aiqe.b(this.jdField_a_of_type_Aipw.jdField_a_of_type_AndroidAppActivity, aiqe.d(this.jdField_a_of_type_Aipw.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipx
 * JD-Core Version:    0.7.0.1
 */