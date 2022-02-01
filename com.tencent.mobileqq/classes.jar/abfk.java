import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class abfk
  implements View.OnClickListener
{
  abfk(abff paramabff) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((abff.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(abff.a(this.a))))
      {
        txl localtxl = (txl)abff.jdField_a_of_type_JavaUtilHashMap.get(abff.a(this.a));
        if (localtxl != null) {
          if (localtxl.b() == 3)
          {
            localtxl.a();
            this.a.b();
            localtxl.a(4);
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            abff.jdField_a_of_type_JavaUtilHashMap.remove(abff.a(this.a));
          }
          else if (localtxl.b() == 0)
          {
            nmj.a(localActivity.getApplicationContext(), abff.a(this.a), localtxl.f, localtxl.a, localtxl);
            localtxl.a(1);
            if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
            }
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfk
 * JD-Core Version:    0.7.0.1
 */