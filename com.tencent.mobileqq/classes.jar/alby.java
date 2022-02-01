import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class alby
  extends ClickableSpan
{
  alby(alcb paramalcb, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Alcb.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alby
 * JD-Core Version:    0.7.0.1
 */