import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class adrn
  extends ClickableSpan
{
  adrn(adqy paramadqy) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bfol.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720351);
      paramView.c(2131690596);
      paramView.a(new adro(this));
      paramView.a(new adrp(this, paramView));
      paramView.show();
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrn
 * JD-Core Version:    0.7.0.1
 */