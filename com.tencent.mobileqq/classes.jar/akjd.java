import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjd
  implements View.OnClickListener
{
  akjd(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bcgq)paramView.getTag();
    if (localObject != null) {
      ((bcgq)localObject).jdField_a_of_type_Bfvp.k();
    }
    try
    {
      if (!TextUtils.isEmpty(((bcgq)localObject).jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(((bcgq)localObject).jdField_a_of_type_JavaLangString);
        bcef.b(akho.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        localObject = new aptj(akho.a(this.a).getApplicationContext(), aqlw.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((aptj)localObject).b();
          ((aptj)localObject).c();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        int i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjd
 * JD-Core Version:    0.7.0.1
 */