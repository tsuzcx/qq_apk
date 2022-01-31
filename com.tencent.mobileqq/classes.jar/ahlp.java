import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class ahlp
  implements View.OnClickListener
{
  ahlp(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    paramView = (axuj)paramView.getTag();
    if (paramView != null) {
      paramView.jdField_a_of_type_Bbeg.b();
    }
    try
    {
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        axqy.b(ahkd.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        paramView = new amow(ahkd.a(this.a).getApplicationContext(), andt.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     ahlp
 * JD-Core Version:    0.7.0.1
 */