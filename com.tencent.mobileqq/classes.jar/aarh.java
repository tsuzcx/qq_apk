import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class aarh
  implements View.OnClickListener
{
  aarh(aarc paramaarc) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aarc.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(aarc.a(this.a))))
      {
        urx localurx = (urx)aarc.jdField_a_of_type_JavaUtilHashMap.get(aarc.a(this.a));
        if (localurx != null) {
          if (localurx.b() == 3)
          {
            localurx.a();
            this.a.b();
            localurx.a(4);
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            aarc.jdField_a_of_type_JavaUtilHashMap.remove(aarc.a(this.a));
          }
          else if (localurx.b() == 0)
          {
            nuz.a(localActivity.getApplicationContext(), aarc.a(this.a), localurx.f, localurx.a, localurx);
            localurx.a(1);
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
 * Qualified Name:     aarh
 * JD-Core Version:    0.7.0.1
 */