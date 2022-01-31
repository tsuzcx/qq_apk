import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ajpq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ajpq(QQCustomDialog paramQQCustomDialog, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      boolean bool1 = QQText.a(this.jdField_a_of_type_JavaLangString);
      boolean bool2 = QQText.b(this.jdField_a_of_type_JavaLangString);
      if ((!bool1) && (!bool2))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.setText(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajpq
 * JD-Core Version:    0.7.0.1
 */