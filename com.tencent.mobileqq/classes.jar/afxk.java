import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.qphone.base.util.BaseApplication;

class afxk
  extends ClickableSpan
{
  afxk(afxj paramafxj, MessageForAutoReply paramMessageForAutoReply, agql paramagql) {}
  
  public void onClick(@NonNull View paramView)
  {
    afxj.a(this.jdField_a_of_type_Afxj, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForAutoReply);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForAutoReply.senderuin.equals(this.jdField_a_of_type_Afxj.a.getCurrentAccountUin()))
    {
      paramTextPaint.setColor(this.jdField_a_of_type_Agql.d.getCurrentTextColor());
      paramTextPaint.setUnderlineText(true);
      return;
    }
    paramTextPaint.setColor(BaseApplication.context.getResources().getColor(2131167030));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxk
 * JD-Core Version:    0.7.0.1
 */