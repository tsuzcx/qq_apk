import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class aanr
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private aanr(BaseChatPie paramBaseChatPie) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "IME_ACTION_SEND");
      }
      this.a.aq();
      return true;
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 66)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramView = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, " sendOnEnterEnabled = " + this.a.m);
        }
        if ((this.a.m) && (paramView.length() > 0)) {
          this.a.c();
        }
      }
      if (this.a.m) {
        return true;
      }
    }
    else if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "on delete, start: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() + ", end: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() + ", span: " + this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372739));
      }
      if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372739) != null))
      {
        paramView = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundDrawables();
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(paramView[0], null, paramView[2], paramView[3]);
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131372739, null);
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
        this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
        this.a.b(2);
        axqy.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 1, "", "", "", "");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aanr
 * JD-Core Version:    0.7.0.1
 */