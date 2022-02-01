import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;

class ahkj
  extends ClickableSpan
{
  ahkj(ahkf paramahkf, MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence) {}
  
  public void onClick(View paramView)
  {
    if (ahcz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.cancelLongPress();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(this.jdField_a_of_type_JavaLangCharSequence);
      ahcz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
      ahkf.a(this.jdField_a_of_type_Ahkf, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Ahkf.a.getResources().getColor(2131165765));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */