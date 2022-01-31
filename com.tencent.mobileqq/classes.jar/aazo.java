import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ark.ArkAiScrollBar;

public class aazo
  implements Runnable
{
  public aazo(ArkAiScrollBar paramArkAiScrollBar) {}
  
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
 * Qualified Name:     aazo
 * JD-Core Version:    0.7.0.1
 */