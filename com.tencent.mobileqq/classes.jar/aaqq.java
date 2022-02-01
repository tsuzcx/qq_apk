import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class aaqq
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private aaqr jdField_a_of_type_Aaqr;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aaqr != null) {
      this.jdField_a_of_type_Aaqr.a(this.jdField_a_of_type_JavaLangString, this.b);
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
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */