import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class afet
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  afet(afeq paramafeq) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getLineCount() > 3) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) && (!azmk.b()))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afet
 * JD-Core Version:    0.7.0.1
 */