import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.QQBrowserSwipeLayout;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class abug
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public abug(QQBrowserSwipeLayout paramQQBrowserSwipeLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    boolean bool = false;
    if (QQBrowserSwipeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout) != null) {
      bool = QQBrowserSwipeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout, paramMotionEvent1);
    }
    if ((!QQBrowserSwipeLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout)) || (paramFloat1 < 200.0F)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((f1 < 0.0F) && (f2 < 0.5F) && (!bool))
    {
      if (!(QQBrowserSwipeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout) instanceof Activity)) {
        break label175;
      }
      QQBrowserSwipeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout, true);
      if (QQBrowserSwipeLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout) != null)
      {
        QQBrowserSwipeLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout).G();
        QQBrowserSwipeLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout);
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label175:
      if (QQBrowserSwipeLayout.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout) != null)
      {
        QQBrowserSwipeLayout.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout).G();
        QQBrowserSwipeLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserSwipeLayout);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abug
 * JD-Core Version:    0.7.0.1
 */