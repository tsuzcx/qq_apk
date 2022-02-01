import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class aaqo
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private aaqp jdField_a_of_type_Aaqp;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private String jdField_a_of_type_JavaLangString;
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Aaqp != null)) {
      this.jdField_a_of_type_Aaqp.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int > 0) {
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      paramTextPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqo
 * JD-Core Version:    0.7.0.1
 */