import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class akgr
  implements bkhw
{
  akgr(akgq paramakgq, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Akgq.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_Akgq.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_Akgq.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bkho.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_Akgq.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.jdField_a_of_type_Akgq.jdField_a_of_type_AndroidAppActivity).requestPermissions(new akgs(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          akgq.a(this.jdField_a_of_type_Akgq);
        }
      }
      else
      {
        akgq.a(this.jdField_a_of_type_Akgq);
        continue;
        akgy.b(this.jdField_a_of_type_Akgq.jdField_a_of_type_AndroidAppActivity, akgy.d(this.jdField_a_of_type_Akgq.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgr
 * JD-Core Version:    0.7.0.1
 */