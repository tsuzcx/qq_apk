import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.ark.ArkAiBubbleView;
import com.tencent.mobileqq.ark.ArkAiScrollBar;

public class aayr
  implements Runnable
{
  public aayr(ArkAiBubbleView paramArkAiBubbleView) {}
  
  public void run()
  {
    ViewParent localViewParent = this.a.jdField_a_of_type_AndroidViewView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(this.a.jdField_a_of_type_AndroidViewView);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayr
 * JD-Core Version:    0.7.0.1
 */