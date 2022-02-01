import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class ai
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ai(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (!LiteActivity.a(this.a)) && (!bbyp.b()))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.7.0.1
 */