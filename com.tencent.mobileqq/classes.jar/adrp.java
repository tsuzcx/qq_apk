import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class adrp
  extends ClickableSpan
{
  adrp(adqw paramadqw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bfpc.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131720376);
      paramView.c(2131690596);
      paramView.a(new adrq(this));
      paramView.a(new adrr(this, paramView));
      paramView.show();
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */