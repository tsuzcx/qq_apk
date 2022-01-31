import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class aghc
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private aghc(aggw paramaggw) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      bool1 = bool2;
      if (paramKeyEvent.getAction() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "on delete, start: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() + ", end: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() + ", span: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372739));
        }
        if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() != 0) || (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() != 0)) {
          break label243;
        }
        bool1 = bool2;
        if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372739) != null)
        {
          paramKeyEvent = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundDrawables();
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131372739, null);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(actj.a(36.0F, paramView.getResources()));
          this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
          bool1 = true;
        }
      }
    }
    label243:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372739) == null);
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT < 21);
      bool1 = bool2;
    } while (actj.a(36.0F, paramView.getResources()) != this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMinHeight());
    paramInt = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredHeight();
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghc
 * JD-Core Version:    0.7.0.1
 */