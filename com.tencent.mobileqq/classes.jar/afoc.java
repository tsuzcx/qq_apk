import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class afoc
  extends ClickableSpan
{
  afoc(afnq paramafnq) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bhuf.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720910);
      paramView.c(2131690648);
      paramView.a(new afod(this));
      paramView.a(new afoe(this, paramView));
      paramView.show();
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afoc
 * JD-Core Version:    0.7.0.1
 */