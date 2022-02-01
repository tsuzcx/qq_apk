import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class ahen
  extends ClickableSpan
{
  ahen(ahed paramahed) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = blir.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131718782);
      paramView.c(2131690580);
      paramView.a(new aheo(this));
      paramView.a(new ahep(this, paramView));
      paramView.show();
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahen
 * JD-Core Version:    0.7.0.1
 */