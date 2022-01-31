import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class ajcy
  implements View.OnClickListener
{
  ajcy(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    paramView = (azqd)paramView.getTag();
    if (paramView != null) {
      paramView.jdField_a_of_type_Bddb.b();
    }
    try
    {
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        azmj.b(ajbm.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        paramView = new aofu(ajbm.a(this.a).getApplicationContext(), aova.jdField_a_of_type_JavaLangString);
        if (paramView != null)
        {
          paramView.b();
          paramView.c();
        }
        return;
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        int i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcy
 * JD-Core Version:    0.7.0.1
 */