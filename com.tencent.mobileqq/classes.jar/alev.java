import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alev
  implements View.OnClickListener
{
  alev(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bdno)paramView.getTag();
    if (localObject != null) {
      ((bdno)localObject).jdField_a_of_type_Bheh.k();
    }
    try
    {
      if (!TextUtils.isEmpty(((bdno)localObject).jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(((bdno)localObject).jdField_a_of_type_JavaLangString);
        bdla.b(aldh.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        localObject = new aqwm(aldh.a(this.a).getApplicationContext(), arph.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((aqwm)localObject).b();
          ((aqwm)localObject).c();
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
 * Qualified Name:     alev
 * JD-Core Version:    0.7.0.1
 */