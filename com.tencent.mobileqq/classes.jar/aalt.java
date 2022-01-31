import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ark.ArkAiScrollBar;

public class aalt
  implements Runnable
{
  public aalt(ArkAiScrollBar paramArkAiScrollBar) {}
  
  public void run()
  {
    int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalt
 * JD-Core Version:    0.7.0.1
 */