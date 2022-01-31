import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class afju
  extends ClickableSpan
{
  afju(afjb paramafjb) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bhpy.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720912);
      paramView.c(2131690648);
      paramView.a(new afjv(this));
      paramView.a(new afjw(this, paramView));
      paramView.show();
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afju
 * JD-Core Version:    0.7.0.1
 */