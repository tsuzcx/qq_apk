import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akzw
  implements View.OnClickListener
{
  akzw(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bcvm)paramView.getTag();
    if (localObject != null) {
      ((bcvm)localObject).jdField_a_of_type_Bgmp.k();
    }
    try
    {
      if (!TextUtils.isEmpty(((bcvm)localObject).jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(((bcvm)localObject).jdField_a_of_type_JavaLangString);
        bcst.b(akyh.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        localObject = new aqkv(akyh.a(this.a).getApplicationContext(), arcj.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((aqkv)localObject).b();
          ((aqkv)localObject).c();
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
 * Qualified Name:     akzw
 * JD-Core Version:    0.7.0.1
 */