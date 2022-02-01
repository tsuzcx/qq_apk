import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class aabv
  implements View.OnClickListener
{
  aabv(aabq paramaabq) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aabq.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(aabq.a(this.a))))
      {
        uea localuea = (uea)aabq.jdField_a_of_type_JavaUtilHashMap.get(aabq.a(this.a));
        if (localuea != null) {
          if (localuea.b() == 3)
          {
            localuea.a();
            this.a.b();
            localuea.a(4);
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            aabq.jdField_a_of_type_JavaUtilHashMap.remove(aabq.a(this.a));
          }
          else if (localuea.b() == 0)
          {
            nny.a(localActivity.getApplicationContext(), aabq.a(this.a), localuea.f, localuea.a, localuea);
            localuea.a(1);
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
 * Qualified Name:     aabv
 * JD-Core Version:    0.7.0.1
 */