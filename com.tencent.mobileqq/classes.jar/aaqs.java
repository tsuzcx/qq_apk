import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class aaqs
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private aaqt jdField_a_of_type_Aaqt;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private String jdField_a_of_type_JavaLangString;
  
  public aaqs(String paramString, int paramInt, aaqt paramaaqt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aaqt = paramaaqt;
  }
  
  public aaqs(String paramString, ColorStateList paramColorStateList, aaqt paramaaqt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_Aaqt = paramaaqt;
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Aaqt != null)) {
      this.jdField_a_of_type_Aaqt.a(this.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */