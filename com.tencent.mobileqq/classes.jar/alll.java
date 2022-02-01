import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alll
  implements View.OnClickListener
{
  alll(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bdof)paramView.getTag();
    if (localObject != null) {
      ((bdof)localObject).jdField_a_of_type_Bhmr.k();
    }
    try
    {
      if (!TextUtils.isEmpty(((bdof)localObject).jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(((bdof)localObject).jdField_a_of_type_JavaLangString);
        bdll.b(aljw.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        localObject = new aqzy(aljw.a(this.a).getApplicationContext(), arry.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((aqzy)localObject).b();
          ((aqzy)localObject).c();
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
 * Qualified Name:     alll
 * JD-Core Version:    0.7.0.1
 */