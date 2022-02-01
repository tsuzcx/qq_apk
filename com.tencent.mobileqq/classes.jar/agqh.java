import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;

class agqh
  extends ClickableSpan
{
  agqh(agqd paramagqd, MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence) {}
  
  public void onClick(View paramView)
  {
    if (agix.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.cancelLongPress();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(this.jdField_a_of_type_JavaLangCharSequence);
      agix.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
      agqd.a(this.jdField_a_of_type_Agqd, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Agqd.a.getResources().getColor(2131165775));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqh
 * JD-Core Version:    0.7.0.1
 */