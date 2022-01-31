import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class afjn
  extends ClickableSpan
{
  afjn(afjb paramafjb) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bhpy.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720898);
      paramView.c(2131690648);
      paramView.a(new afjo(this));
      paramView.a(new afjp(this, paramView));
      paramView.show();
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjn
 * JD-Core Version:    0.7.0.1
 */