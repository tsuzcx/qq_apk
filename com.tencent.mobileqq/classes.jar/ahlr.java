import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class ahlr
  implements View.OnClickListener
{
  ahlr(ahkf paramahkf) {}
  
  public void onClick(View paramView)
  {
    paramView = (axuh)paramView.getTag();
    if (paramView != null) {
      paramView.jdField_a_of_type_Bbds.b();
    }
    try
    {
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        axqw.b(ahkf.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        paramView = new amox(ahkf.a(this.a).getApplicationContext(), ando.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     ahlr
 * JD-Core Version:    0.7.0.1
 */