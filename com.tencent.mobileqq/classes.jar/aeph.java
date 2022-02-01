import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;

public class aeph
  extends ClickableSpan
{
  public aeph(TroopRequestActivity paramTroopRequestActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    bdvm.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeph
 * JD-Core Version:    0.7.0.1
 */