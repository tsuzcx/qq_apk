import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class aacp
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private aacq jdField_a_of_type_Aacq;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aacq != null) {
      this.jdField_a_of_type_Aacq.a(this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int != -2147483648)
    {
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacp
 * JD-Core Version:    0.7.0.1
 */