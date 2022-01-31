import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;

public class akuh
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e = 2000;
  int f;
  int g;
  int h;
  int i;
  
  public akuh(SwiftFloatViewUI paramSwiftFloatViewUI, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView)
    {
      int j;
      int k;
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
          j = (int)paramMotionEvent.getRawX();
          this.jdField_a_of_type_Int = j;
          this.c = j;
          j = (int)paramMotionEvent.getRawY();
          this.jdField_b_of_type_Int = j;
          this.d = j;
          return true;
        } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
        j = (int)paramMotionEvent.getRawX() - this.jdField_a_of_type_Int;
        k = (int)paramMotionEvent.getRawY() - this.jdField_b_of_type_Int;
        this.e = (paramView.getLeft() + j);
        this.f = (paramView.getTop() + k);
        this.g = (j + paramView.getRight());
        this.h = (paramView.getBottom() + k);
        if (this.e < 0)
        {
          this.e = 0;
          this.g = (this.e + paramView.getWidth());
          label195:
          if (this.f >= 0) {
            break label406;
          }
          this.f = 0;
          this.h = (this.f + paramView.getHeight());
        }
        for (;;)
        {
          paramView.layout(this.e, this.f, this.g, this.h);
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
          this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
          if ((this.jdField_a_of_type_Boolean) || ((Math.abs(paramMotionEvent.getRawX() - this.c) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.d) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
          this.jdField_a_of_type_Boolean = true;
          return true;
          if (this.g <= this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int) {
            break label195;
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int;
          this.e = (this.g - paramView.getWidth());
          break label195;
          label406:
          if (this.h > this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int)
          {
            this.h = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int;
            this.f = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int - paramView.getHeight());
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, false);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(0);
        j = paramView.getTop();
        k = paramView.getWidth() / 2;
        if (this.e + k < this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int / 2) {
          if (Build.VERSION.SDK_INT < 11) {}
        }
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.setRotationY(180.0F);
            paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = (k + this.e);
            paramView.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingBottom());
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.c + "", "", "", "");
            return true;
          }
          catch (Throwable paramView)
          {
            QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramView);
            continue;
          }
          if (Build.VERSION.SDK_INT >= 11) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.setRotationY(0.0F);
            paramMotionEvent = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (k + (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int - paramView.getRight()));
            paramMotionEvent.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setLayoutParams(paramMotionEvent);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingBottom());
          }
          catch (Throwable paramMotionEvent)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramMotionEvent);
            }
          }
        }
      }
      this.i = Math.min(this.e, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int - this.g);
      if (this.i == this.e)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, -this.e, 0.0F, 0.0F);
        this.e = 0;
        this.g = (this.e + paramView.getWidth());
      }
      for (;;)
      {
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new akui(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        return true;
        paramMotionEvent = new TranslateAnimation(0.0F, this.i, 0.0F, 0.0F);
        this.g = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int;
        this.e = (this.g - paramView.getWidth());
      }
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
      return true;
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akuh
 * JD-Core Version:    0.7.0.1
 */