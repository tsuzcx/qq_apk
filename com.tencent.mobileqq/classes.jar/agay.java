import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class agay
  implements View.OnTouchListener
{
  public agay(VisitorsActivity paramVisitorsActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(127);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        this.a.b.setAlpha(127);
        continue;
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          this.a.b.setAlpha(255);
        }
        bdll.b(this.a.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
        paramView = new Intent(this.a, LikeRankingListActivity.class);
        this.a.startActivity(paramView);
        this.a.d.setVisibility(8);
        this.a.f.clearAnimation();
        this.a.c = 0;
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        continue;
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          this.a.b.setAlpha(255);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agay
 * JD-Core Version:    0.7.0.1
 */