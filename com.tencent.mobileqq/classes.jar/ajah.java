import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class ajah
  extends ClickableSpan
{
  ajah(ajak paramajak, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ajak.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajah
 * JD-Core Version:    0.7.0.1
 */