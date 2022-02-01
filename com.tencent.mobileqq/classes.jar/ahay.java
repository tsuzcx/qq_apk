import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.qphone.base.util.BaseApplication;

class ahay
  extends ClickableSpan
{
  ahay(ahax paramahax, MessageForAutoReply paramMessageForAutoReply, ahtx paramahtx) {}
  
  public void onClick(@NonNull View paramView)
  {
    ahax.a(this.jdField_a_of_type_Ahax, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForAutoReply);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForAutoReply.senderuin.equals(this.jdField_a_of_type_Ahax.a.getCurrentAccountUin()))
    {
      paramTextPaint.setColor(this.jdField_a_of_type_Ahtx.d.getCurrentTextColor());
      paramTextPaint.setUnderlineText(true);
      return;
    }
    paramTextPaint.setColor(BaseApplication.context.getResources().getColor(2131167008));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahay
 * JD-Core Version:    0.7.0.1
 */