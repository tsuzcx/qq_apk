import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class ad
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ad(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (!LiteActivity.a(this.a)) && (!azmk.b()))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ad
 * JD-Core Version:    0.7.0.1
 */