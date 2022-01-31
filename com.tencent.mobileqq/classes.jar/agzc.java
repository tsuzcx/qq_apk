import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class agzc
  implements View.OnClickListener
{
  agzc(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    paramView = (awuf)paramView.getTag();
    if (paramView != null) {
      paramView.jdField_a_of_type_Bacn.b();
    }
    try
    {
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        awqx.b(agxq.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        paramView = new alzh(agxq.a(this.a).getApplicationContext(), amnh.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzc
 * JD-Core Version:    0.7.0.1
 */