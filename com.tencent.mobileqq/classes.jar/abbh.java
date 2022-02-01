import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class abbh
  implements View.OnClickListener
{
  abbh(abbc paramabbc) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((abbc.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(abbc.a(this.a))))
      {
        txj localtxj = (txj)abbc.jdField_a_of_type_JavaUtilHashMap.get(abbc.a(this.a));
        if (localtxj != null) {
          if (localtxj.b() == 3)
          {
            localtxj.a();
            this.a.b();
            localtxj.a(4);
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            abbc.jdField_a_of_type_JavaUtilHashMap.remove(abbc.a(this.a));
          }
          else if (localtxj.b() == 0)
          {
            nko.a(localActivity.getApplicationContext(), abbc.a(this.a), localtxj.f, localtxj.a, localtxj);
            localtxj.a(1);
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
 * Qualified Name:     abbh
 * JD-Core Version:    0.7.0.1
 */