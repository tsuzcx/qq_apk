import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class adrl
  extends ClickableSpan
{
  adrl(adqw paramadqw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bfpc.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720362);
      paramView.c(2131690596);
      paramView.a(new adrm(this));
      paramView.a(new adrn(this, paramView));
      paramView.show();
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrl
 * JD-Core Version:    0.7.0.1
 */