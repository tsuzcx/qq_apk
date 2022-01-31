import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ajgu
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  
  private ajgu(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewView = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ajgv(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams());
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    int j;
    int k;
    if (i != this.jdField_a_of_type_Int)
    {
      j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      k = j - i;
      if (k <= j / 4) {
        break label58;
      }
    }
    label58:
    for (this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = (j - k);; this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = j)
    {
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    new ajgu(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgu
 * JD-Core Version:    0.7.0.1
 */