import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class agql
  implements bfoq
{
  agql(agqk paramagqk, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Agqk.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Agqk.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Agqk.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bfol.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Agqk.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Agqk.jdField_a_of_type_AndroidAppActivity).requestPermissions(new agqm(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          agqk.a(this.jdField_a_of_type_Agqk);
        }
      }
      else
      {
        agqk.a(this.jdField_a_of_type_Agqk);
        continue;
        agqs.b(this.jdField_a_of_type_Agqk.jdField_a_of_type_AndroidAppActivity, agqs.d(this.jdField_a_of_type_Agqk.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agql
 * JD-Core Version:    0.7.0.1
 */