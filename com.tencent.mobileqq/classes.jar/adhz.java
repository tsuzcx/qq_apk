import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class adhz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  adhz(adhw paramadhw) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getLineCount() > 3) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) && (!axmv.b()))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhz
 * JD-Core Version:    0.7.0.1
 */